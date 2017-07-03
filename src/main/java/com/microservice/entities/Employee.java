package com.microservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Column(name = "employeeID" ,unique = true, nullable = false)
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeID;
	
	@Column(name = "employeeName" ,length=200)
	private String employeeName;
	
	@Column(name = "employeeAge" ,length=200)
	private int employeeAge;
	
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeID, String employeeName, int employeeAge) {
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
