package com.microservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.microservice.DTO.EmployeeDTO;
import com.microservice.DTO.EmployeeDTOResponse;
import com.microservice.DTO.PlantDTO;
import com.microservice.DTO.PlantDTOResposeDTO;
import com.microservice.dao.EmployeeDAO;
import com.microservice.entities.Employee;
import com.microservice.exceptions.DataLayerException;
import com.microservice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public EmployeeDTOResponse getEmployeeList() {
		List<EmployeeDTO> employeeDTOList = employeeDAO.getEmployeeList();
		if(!employeeDTOList.isEmpty()){
			EmployeeDTOResponse employeeDTOResponse = new EmployeeDTOResponse();
			employeeDTOResponse.setEmployeeDTOList(employeeDTOList);
			return employeeDTOResponse;
		}
		return null;	
	}

	@Override
	public EmployeeDTO getEmployeeByID(int id)  {
		EmployeeDTO employeeDTO = null;
		try{
			employeeDTO = employeeDAO.getEmployeeByID(id);
		}catch(DataAccessException e){
			try {
				throw new DataLayerException(e.getMessage());
			} catch (DataLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return employeeDTO;
		
	}

	@Override
	public String addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public String removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
