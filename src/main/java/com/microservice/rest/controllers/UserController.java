package com.microservice.rest.controllers;

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

import com.microservice.dao.UserServiceDAO;
import com.microservice.entities.UserDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping(value = "microservice/user")
public class UserController {

	@Autowired
	UserServiceDAO userService;  

	@ApiOperation(value = "ValidateUser",notes = "This api is used to validate the login user", httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")}) 
	@RequestMapping(value = "userName/{username}/password/{password}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> getUserName(@PathVariable("username") String username,@PathVariable("password") String password) {
		System.out.println("Fetching User with id " + username);
		UserDetails userDetails = userService.validateUser(username, password);
		if (userDetails == null) {
			System.out.println("User id and password not match");
			return new ResponseEntity<UserDetails>(userDetails,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
	}


}
