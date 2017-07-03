package com.microservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.microservice.DTO.EmployeeDTO;
import com.microservice.dao.EmployeeDAO;
import com.microservice.entities.Employee;
import com.microservice.entities.Plant;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<EmployeeDTO> getEmployeeList() {
		List<Employee> employeeList = entityManager.createQuery("from Employee").getResultList();
		if(employeeList != null && !employeeList.isEmpty()){
			return employeeDTOReponse(employeeList);
		}
		return null;
	}

		@Override
	public EmployeeDTO getEmployeeByID(int employeeID) {
	    Employee employee = (Employee) entityManager.createQuery("from Employee where employeeID=:employeeID").setParameter("employeeID",employeeID).getSingleResult();
	    if (employee != null) {
		   EmployeeDTO employeeDTO = new EmployeeDTO();
		   BeanUtils.copyProperties(employee, employeeDTO);
		   return employeeDTO;
		}
		return null;
	}

	@Override
	public String addEmployee(Employee employee) {
		entityManager.persist(employee);
		return "success";
		
	}

	@Override
	public String removeEmployee(Employee employee) {
		entityManager.remove(employee);
		return "success";
		// TODO Auto-generated method stub
	}
	
	private List<EmployeeDTO> employeeDTOReponse(List<Employee> employeeList) {
		ArrayList<EmployeeDTO> EmployeeDTOList = new ArrayList<EmployeeDTO>();
		for (Employee employee : employeeList) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employee, employeeDTO);
			EmployeeDTOList.add(employeeDTO);
		}
		return EmployeeDTOList;
	}
}
