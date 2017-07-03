package com.microservice.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.DTO.PlantDTO;
import com.microservice.DTO.PlantDTOResposeDTO;
import com.microservice.DTO.PlantDropDownDTO;
import com.microservice.exceptions.DataLayerException;
import com.microservice.services.PlantService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Plant Controller , handles the all plant related request
 *
 */
@RestController
@PropertySource("classpath:config.properties")
@CrossOrigin
@RequestMapping(value="microservice/plant")

public class PlantController {
	
	@Autowired
	private PlantService plantService;
	
	
	@SuppressWarnings({"rawtypes","unchecked" })
	
	@ApiOperation(value = "GetPlantsDropDown",notes = "This api is used to get all the plants for selected input", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	@RequestMapping(value = "/{categoryId}/{countryName}/{addressState}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<PlantDropDownDTO> getCountryName(@PathVariable String categoryId,@PathVariable String countryName,@PathVariable String addressState) {
	     List<PlantDropDownDTO> assetList = null;
		try {
			assetList = plantService.fetchPlants(categoryId,countryName,addressState);
		} catch (DataLayerException e) {
			e.printStackTrace();
			 return new ResponseEntity(assetList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     if (assetList == null) {
	         return new ResponseEntity(assetList,HttpStatus.NO_CONTENT);
	     }
	     return new ResponseEntity(assetList,HttpStatus.OK);
	 }
	
	@ApiOperation(value = "GetAllPlants",notes = "This api is used to get all the plants", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlantDTOResposeDTO> getAllPlants() {
		System.out.println("Executing Plant Controller ....");
		PlantDTOResposeDTO plantDetails = null;
		try {
			plantDetails = plantService.fetchAllPlants();
			if (plantDetails == null) {
		         System.out.println("No Plants Found");
		         return new ResponseEntity<PlantDTOResposeDTO>(plantDetails,HttpStatus.NO_CONTENT);
		     }
		    
		} catch (Exception e) {
			return new ResponseEntity<PlantDTOResposeDTO>(plantDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
		 return new ResponseEntity<PlantDTOResposeDTO>(plantDetails,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GetPlantsKpis",notes = "This api is used to get all the Kpis values for all plants", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="/grid",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllKpisForPlants() {
		String plantDetails = null;
		try {
			plantDetails = plantService.fetchKpiForplants();
			if (plantDetails == null) {
		         System.out.println("No Plants Found");
		         return new ResponseEntity<String>(plantDetails,HttpStatus.NO_CONTENT);
		     }
		    
		} catch (Exception e) {
			return new ResponseEntity<String>(plantDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
		 return new ResponseEntity<String>(plantDetails,HttpStatus.OK);
	}
	
	@ApiOperation(value = "GetPlant",notes = "This api is used to get Specific Plants", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="/{plantId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlantDTO> getPlantByPlantId(@PathVariable String plantId) {
		System.out.println("Executing Plant Controller ....");
		PlantDTO plantDetails = null;
		
			try {
				plantDetails = plantService.fetchPlant(plantId);
			} catch (DataLayerException e) {
				return new ResponseEntity<PlantDTO>(plantDetails,HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (plantDetails == null) {
		         System.out.println("No Plants Found");
		         return new ResponseEntity<PlantDTO>(plantDetails,HttpStatus.NO_CONTENT);
		     } 
	     
		 return new ResponseEntity<PlantDTO>(plantDetails,HttpStatus.OK);
	}
	
}
