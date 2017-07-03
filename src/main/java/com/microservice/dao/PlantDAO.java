package com.microservice.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.microservice.DTO.PlantDTO;
import com.microservice.DTO.PlantDTOGridResponse;
import com.microservice.DTO.PlantGridDTO;
import com.microservice.DTO.PlantGridResponseDTO;
import com.microservice.entities.Plant;

/**
 * 
 * @author 574990
 *
 */

public interface PlantDAO {
	
	List<PlantDTO> getAllPlants();
	
	PlantDTO getPlant(String plantId) throws DataAccessException;
	
	List<Object[]> getPlantsDropDown(String EnterpriseId,String CountryName,String StateName) throws DataAccessException;
	
	HashMap<String, PlantGridDTO> getPlantsKpis() throws DataAccessException;
}
