package com.microservice.services;

import java.util.List;

import com.microservice.DTO.PlantDTO;
import com.microservice.DTO.PlantDTOGridResponse;
import com.microservice.DTO.PlantDTOResposeDTO;
/**
 * 
 * @author 574990
 *
 */
import com.microservice.DTO.PlantDropDownDTO;
import com.microservice.exceptions.DataLayerException;
public interface PlantService {
	PlantDTOResposeDTO fetchAllPlants() throws Exception;
	
	PlantDTO fetchPlant(String plantId) throws Exception;
	
	List<PlantDropDownDTO> fetchPlants(String EnterpriseId,String CountryName,String StateName) throws DataLayerException;
	
	String fetchKpiForplants() throws DataLayerException;
}
