package com.microservice.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.DTO.GeneratorConfigDTO;
import com.microservice.entities.GeneratorConfig;
import com.microservice.services.GeneratorConfigService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@PropertySource("classpath:config.properties")
@CrossOrigin
@RequestMapping(value="microservice/generatorConfig")
public class GeneratorConfigController {

	@Autowired
	private GeneratorConfigService generatorConfigService;
	
	@ApiOperation(value = "updateGeneratorConfig",notes = "This api is used to update power generator configuration", httpMethod = "POST")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="/updateGeneratorConfig",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateGeneratorConfig(@RequestBody GeneratorConfig generatorConfig) {
		System.out.println("Executing updateGeneratorConfig Controller ....");
		String updateGenConfigStatus = null;
		try {
			updateGenConfigStatus = generatorConfigService.updateGeneratorConfig(generatorConfig);
			if (updateGenConfigStatus == null) {
		         System.out.println("Power Generator-configuration update failed");
		         return new ResponseEntity<String>(updateGenConfigStatus,HttpStatus.NO_CONTENT);
		     }
		    
		} catch (Exception e) {
			return new ResponseEntity<String>(updateGenConfigStatus,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
		 return new ResponseEntity<String>(updateGenConfigStatus,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "fetchGeneratorConfig",notes = "This api is used to fetch power generator configuration based on plant name.", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="/fetchGeneratorConfig/{plantName}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GeneratorConfigDTO> fetchGeneratorConfig(@PathVariable String plantName) {
		System.out.println("Executing updateGeneratorConfig Controller ....");
		GeneratorConfigDTO generatorConfigDTO = null;
		try {
			generatorConfigDTO = generatorConfigService.fetchGeneratorConfig(plantName);
			if (generatorConfigDTO == null) {
		         System.out.println("Power Generator-configuration update failed");
		         return new ResponseEntity<GeneratorConfigDTO>(generatorConfigDTO,HttpStatus.NO_CONTENT);
		     }
		    
		} catch (Exception e) {
			return new ResponseEntity<GeneratorConfigDTO>(generatorConfigDTO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
		 return new ResponseEntity<GeneratorConfigDTO>(generatorConfigDTO,HttpStatus.OK);
	}
}
