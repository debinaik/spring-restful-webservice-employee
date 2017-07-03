package com.microservice.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class EmployeeDTOResponse {
	
	List<EmployeeDTO> EmployeeDTOList;
	
	public EmployeeDTOResponse()
	{
		super();
	}

	public EmployeeDTOResponse(List<EmployeeDTO> employeeDTOList) {
		super();
		EmployeeDTOList = employeeDTOList;
	}

	public List<EmployeeDTO> getEmployeeDTOList() {
		return EmployeeDTOList;
	}

	public void setEmployeeDTOList(List<EmployeeDTO> employeeDTOList) {
		EmployeeDTOList = employeeDTOList;
	}
	
	

}
