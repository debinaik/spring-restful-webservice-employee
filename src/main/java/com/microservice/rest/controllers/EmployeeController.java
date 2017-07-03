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

import com.microservice.DTO.EmployeeDTO;
import com.microservice.DTO.EmployeeDTOResponse;
import com.microservice.entities.Employee;
import com.microservice.services.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@PropertySource("classpath:config.properties")
@CrossOrigin
@RequestMapping(value="microservice/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@ApiOperation(value = "createEmployee",notes = "This api is used to createEmployee", httpMethod = "POST")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		System.out.println("Executing createEmployee Controller ....");
		String createEmployeeStatus = null;
		try {
			createEmployeeStatus = employeeService.addEmployee(employee);
			if (createEmployeeStatus == null) {
		         System.out.println("Employee creation failed");
		         return new ResponseEntity<String>(createEmployeeStatus,HttpStatus.NO_CONTENT);
		     }
		    
		} catch (Exception e) {
			return new ResponseEntity<String>(createEmployeeStatus,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
		 return new ResponseEntity<String>(createEmployeeStatus,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "fetchAllEmployees",notes = "This api is used to get all the Employees", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="/fetchAllEmployees",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTOResponse> fetchAllEmployees() {
		System.out.println("Executing employee Controller ....");
		EmployeeDTOResponse employeeDTOResponse = null;
		try {
			employeeDTOResponse = employeeService.getEmployeeList();
			if (employeeDTOResponse == null) {
		         System.out.println("No Plants Found");
		         return new ResponseEntity<EmployeeDTOResponse>(employeeDTOResponse,HttpStatus.NO_CONTENT);
		     }
		    
		} catch (Exception e) {
			return new ResponseEntity<EmployeeDTOResponse>(employeeDTOResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	     
		 return new ResponseEntity<EmployeeDTOResponse>(employeeDTOResponse,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "GetEmployee",notes = "This api is used to get Specific employee", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	
	
	@RequestMapping(value="getEmployeeById/{employeeId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String employeeId) {
		System.out.println("Executing Employee Controller ....");
		EmployeeDTO employeeDTO = null;
		
			try {
				employeeDTO = employeeService.getEmployeeByID(Integer.parseInt(employeeId));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (employeeDTO == null) {
		         System.out.println("No Plants Found");
		         return new ResponseEntity<EmployeeDTO>(employeeDTO,HttpStatus.NO_CONTENT);
		     } 
	     
		 return new ResponseEntity<EmployeeDTO>(employeeDTO,HttpStatus.OK);
	}
}
