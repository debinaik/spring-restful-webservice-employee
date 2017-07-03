package com.microservice.services;

import com.microservice.DTO.EmployeeDTO;
import com.microservice.DTO.EmployeeDTOResponse;
import com.microservice.entities.Employee;

public interface EmployeeService {
	EmployeeDTOResponse getEmployeeList();
	EmployeeDTO getEmployeeByID(int id);
	String addEmployee(Employee employee);
	String removeEmployee(Employee employee);
}
