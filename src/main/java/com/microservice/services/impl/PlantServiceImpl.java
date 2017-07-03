package com.microservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.DTO.KPIDTO;
import com.microservice.DTO.PlantDTO;
import com.microservice.DTO.PlantDTOGridResponse;
import com.microservice.DTO.PlantDTOResposeDTO;
import com.microservice.DTO.PlantDropDownDTO;
import com.microservice.DTO.PlantGridDTO;
import com.microservice.DTO.PlantGridResponseDTO;
import com.microservice.dao.PlantDAO;
import com.microservice.exceptions.DataLayerException;
import com.microservice.services.PlantService;
/**
 * 
 * @author 574990
 *
 */
@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	PlantDAO plantDao;

	@Override
	@Transactional
	public PlantDTOResposeDTO fetchAllPlants() throws Exception {
		List<PlantDTO> plantDtoList = plantDao.getAllPlants();
		if(!plantDtoList.isEmpty()){
			PlantDTOResposeDTO plantResposne = new PlantDTOResposeDTO();
			plantResposne.setPlants(plantDtoList);
			return plantResposne;
		}
		return null;	
	}

	@Override
	public PlantDTO fetchPlant(String plantId) throws DataLayerException  {

		PlantDTO plantDto = null;
		try{
			plantDto = plantDao.getPlant(plantId);
		}catch(DataAccessException e){
			throw new DataLayerException(e.getMessage());
		}

		return plantDto;
	}

	@Override
	public List<PlantDropDownDTO> fetchPlants(String EnterpriseId, String CountryName, String StateName) throws DataLayerException {
		
		List<PlantDropDownDTO> plantList = null;
		List<Object[]> plantDaoList = null;
		
		try{
			plantDaoList = plantDao.getPlantsDropDown(EnterpriseId, CountryName, StateName);
			if(plantDaoList!= null && !plantDaoList.isEmpty()){
				plantList =  new ArrayList<PlantDropDownDTO>();
				for (Object[] objectArr : plantDaoList) {
					String[] plantArr = Arrays.copyOf(objectArr, objectArr.length, String[].class);				
						PlantDropDownDTO plantDto = new PlantDropDownDTO();
						plantDto.setPlantId(plantArr[0]);
						plantDto.setPlantName(plantArr[1]);
						plantList.add(plantDto);					
					return plantList;
				}
			}
			
		}catch(DataAccessException e){
			throw new DataLayerException(e.getMessage());
		}
		return null;		
		
	}

	@Override
	public String fetchKpiForplants() throws DataLayerException {
		HashMap<String, PlantGridDTO> plantGridHMap = null;
		HashMap<String, List<PlantGridResponseDTO>> plantGridResponseHMap = null;
		HashSet<String> kpiNames = null;
		try{
			plantGridHMap = plantDao.getPlantsKpis();
			if(plantGridHMap != null && !plantGridHMap.isEmpty()){
				Collection<PlantGridDTO> plantGridValueList= plantGridHMap.values();
				kpiNames =  new HashSet<String>();
				// get the unique KPI Names 
				for (PlantGridDTO plantGridDTO : plantGridValueList) {
					for (KPIDTO kpidto : plantGridDTO.getKpiList()) {
						kpiNames.add(kpidto.getKpiName());
					}
				}
				
				plantGridResponseHMap = new HashMap<String, List<PlantGridResponseDTO>>();
				Iterator<String> itr = kpiNames.iterator();
				while(itr.hasNext()){
					String kpiName = itr.next();
					Set<Entry<String, PlantGridDTO>> entires = plantGridHMap.entrySet();
					for(Entry<String,PlantGridDTO> ent:entires){
			            PlantGridDTO plantGrid = ent.getValue();
			            for (KPIDTO kpi : plantGrid.getKpiList()) {
							if(kpi.getKpiName().equals(kpiName)){
								if(plantGridResponseHMap.containsKey(kpiName)){
									List<PlantGridResponseDTO> plantGridList = plantGridResponseHMap.get(kpiName);
									PlantGridResponseDTO plantGridRes = new PlantGridResponseDTO();
									plantGridRes.setKpiValue(kpi.getKpiValue());
									plantGridRes.setPlantName(plantGrid.getPlantName());
									plantGridList.add(plantGridRes);
									plantGridResponseHMap.put(kpiName,plantGridList);
								}else{
									List<PlantGridResponseDTO> plantGridList = new ArrayList<PlantGridResponseDTO>();
									PlantGridResponseDTO plantGridRes = new PlantGridResponseDTO();
									plantGridRes.setKpiValue(kpi.getKpiValue());
									plantGridRes.setPlantName(plantGrid.getPlantName());
									plantGridList.add(plantGridRes);
									plantGridResponseHMap.put(kpiName,plantGridList);
								}
							}
						}
			        }
			
				}
			}
			
			// making Response DTO object from plantGridResponseHMap
			ObjectMapper mapperObj = new ObjectMapper();
			String jsonResp = mapperObj.writeValueAsString(plantGridResponseHMap);
			//System.out.println("repsone is "+jsonResp);
			return jsonResp;
		}catch(DataAccessException e){
			throw new DataLayerException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
