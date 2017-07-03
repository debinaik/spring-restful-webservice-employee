package com.microservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class EmployeeDTO {

	private int employeeID;
	
	private String employeeName;
	
	private int employeeAge;
	
	
	public EmployeeDTO(){
		super();
	}
	

	public EmployeeDTO(int employeeID, String employeeName, int employeeAge) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	
	
	
}
