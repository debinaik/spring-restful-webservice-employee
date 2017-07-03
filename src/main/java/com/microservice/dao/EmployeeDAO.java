package com.microservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.microservice.DTO.EmployeeDTO;
import com.microservice.entities.Employee;


public interface EmployeeDAO {
	
	List<EmployeeDTO> getEmployeeList();
	EmployeeDTO getEmployeeByID(int id);
	String addEmployee(Employee employee);
	String removeEmployee(Employee employee);
}
