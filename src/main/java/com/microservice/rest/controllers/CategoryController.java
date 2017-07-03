package com.microservice.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.DTO.EnterpriseDTO;
import com.microservice.services.CategoryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
@RestController
@PropertySource("classpath:config.properties")
@CrossOrigin
@RequestMapping(value="microservice/enterprise")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;  
	 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    
    @ApiOperation(value = "GetAllEnterprises",notes = "This api is used to get all the Enterprises", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
    
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<EnterpriseDTO>> getCategoryList() {
	     List<EnterpriseDTO> categoryDetail = null;
	     try{
	    	 categoryDetail= categoryService.getAllCategories();
	     }catch(Exception e){
	    	 return new ResponseEntity(categoryDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	     if (categoryDetail == null) {
	         return new ResponseEntity(categoryDetail,HttpStatus.NO_CONTENT);
	     }
	     return new ResponseEntity(categoryDetail,HttpStatus.OK);
	 }
    
}
