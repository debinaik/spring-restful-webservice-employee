package com.microservice.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.microservice.DTO.KPIDTO;
import com.microservice.DTO.PlantDTO;
import com.microservice.DTO.PlantGridDTO;
import com.microservice.DTO.PlantGridResponseDTO;
import com.microservice.dao.PlantDAO;
import com.microservice.entities.KPITrends;
import com.microservice.entities.Plant;

/**
 * 
 * @author 574990
 *
 */

@Component
public class PlantDAOImpl implements PlantDAO {

	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlantDTO> getAllPlants() {
		List<Plant> plants = entityManager.createQuery("from Plant").getResultList();
		if(plants != null && !plants.isEmpty()){
			return plantDTOReponse(plants);
		}
		return null;
	}
	
	private List<PlantDTO> plantDTOReponse(List<Plant> plants){
		List<PlantDTO> plantList = new ArrayList<PlantDTO>();		
		for (Plant plant : plants) {
			PlantDTO plantDto = new PlantDTO();
			List<KPIDTO> kpiDtoList = new ArrayList<KPIDTO>();
			plantDto.setPlantId(plant.getPlantId());
			plantDto.setPlantName(plant.getPlantName());
			plantDto.setPlantDescription(plant.getPlantDescription());
			plantDto.setPlantLatitude(plant.getPlantLatitude());
			plantDto.setPlantLongitude(plant.getPlantLongitude());
			plantDto.setStatus(plant.getStatus());
			plantDto.setAddressCountry(plant.getAddressCountry());
			plantDto.setAddressState(plant.getAddressState());
			plantDto.setSiteId(plant.getSite().getSiteId());			
			for (KPITrends kpiTrends : plant.getKpiTrends()) {
				KPIDTO kpi = new KPIDTO();
				kpi.setKpiName(kpiTrends.getParameter().getParamName());
				kpi.setKpiValue(kpiTrends.getKpiValue());
				kpi.setTimeStamp(kpiTrends.getTimeStamp());
				kpiDtoList.add(kpi);
			}
			plantDto.setKpi(kpiDtoList);
			plantList.add(plantDto);
		}
		return plantList;
	}

	@Override
	public PlantDTO getPlant(String plantId) throws DataAccessException{
		
		Plant plant = (Plant) entityManager.createQuery("from Plant where plantId=:plantId").setParameter("plantId",plantId).getSingleResult();
		PlantDTO plantDto = null;
		if(plant!=null){
			plantDto = new PlantDTO();
			plantDto.setPlantId(plant.getPlantId());
			plantDto.setPlantName(plant.getPlantName());
			plantDto.setPlantDescription(plant.getPlantDescription());
			plantDto.setPlantLatitude(plant.getPlantLatitude());
			plantDto.setPlantLongitude(plant.getPlantLongitude());
			plantDto.setStatus(plant.getStatus());
			plantDto.setAddressCountry(plant.getAddressCountry());
			plantDto.setAddressState(plant.getAddressState());
			plantDto.setSiteId(plant.getSite().getSiteId());	
			plantDto.setAddress(plant.getAddress());
		}
		
		return plantDto;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPlantsDropDown(String enterpriseId, String countryName, String stateName)
			throws DataAccessException {
		
		List<Object[]> resultSet=entityManager.createQuery("SELECT DISTINCT P.plantId,P.plantName FROM Enterprise E,Site S,Plant P WHERE E.enterpriseId=S.enterprise.enterpriseId and S.siteId = P.site.siteId and E.enterpriseId=:enterpriseId and P.addressCountry=:addressCountry and P.addressState=:addressState").
				setParameter("enterpriseId",enterpriseId).setParameter("addressCountry",countryName).setParameter("addressState",stateName).getResultList();
		
	//	SELECT DISTINCT(P.ADDRESS_COUNTRY) FROM ENTERPRISE E JOIN SITE S ON E.ENTERPRISE_ID = S.ENTERPRISE_ID JOIN PLANT P ON S.SITE_ID = P.SITE_ID WHERE E.ENTERPRISE_ID='ENT00000001';
	    if(resultSet!=null && resultSet.size()>0){		    	
	    	return resultSet;
	    }
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, PlantGridDTO> getPlantsKpis() throws DataAccessException {
		
		List<Plant> plants = entityManager.createQuery("from Plant").getResultList();
		if(plants != null && !plants.isEmpty()){
			return plantGridHMap(plants);
		}
		
		return null;
	}

	private HashMap<String, PlantGridDTO> plantGridHMap(List<Plant> plants) {
		HashMap<String, PlantGridDTO> plantGridHMap = new HashMap<String, PlantGridDTO>();
		for (Plant plant : plants) {
			PlantGridDTO plantGrid = new PlantGridDTO();
			plantGrid.setPlantName(plant.getPlantName());
			List<KPIDTO> kpiDtoList = new ArrayList<KPIDTO>();
			for (KPITrends kpiTrends : plant.getKpiTrends()) {
				KPIDTO kpi = new KPIDTO();
				kpi.setKpiName(kpiTrends.getParameter().getParamName());
				kpi.setKpiValue(kpiTrends.getKpiValue());
				kpiDtoList.add(kpi);
			}
			plantGrid.setKpiList(kpiDtoList);
			plantGridHMap.put(plant.getPlantId(),plantGrid);
		}
		return plantGridHMap;
	}	
	
	
}
