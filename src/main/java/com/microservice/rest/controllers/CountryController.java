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

import com.microservice.dao.CountryDAO;
import com.microservice.entities.Plant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

 
@RestController
@PropertySource("classpath:config.properties")
@CrossOrigin
@RequestMapping(value="microservice/country")
public class CountryController {
	
	@Autowired
	CountryDAO countryDAO; 
	 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    
    @ApiOperation(value = "EnterpriseLevelCountries",notes = "This api is used to get all the countries under Enterprise", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	@RequestMapping(value = "/{enterpriseId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> getCountryName(@PathVariable String enterpriseId ) {
	     System.out.println("Fetching Catagory with id");
	     List<Plant> countryNames= countryDAO.getCountry(enterpriseId);
	     if (countryNames == null) {
	         return new ResponseEntity(countryNames,HttpStatus.NOT_FOUND);
	     }
	     return new ResponseEntity(countryNames,HttpStatus.OK);
	 }
    
}
