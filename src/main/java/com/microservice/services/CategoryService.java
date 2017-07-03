package com.microservice.services;

import java.util.List;

import com.microservice.DTO.EnterpriseDTO;

public interface CategoryService {
	List<EnterpriseDTO> getAllCategories()  throws Exception;
}
