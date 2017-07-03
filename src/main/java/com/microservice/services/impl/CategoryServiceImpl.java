package com.microservice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.microservice.DTO.EnterpriseDTO;
import com.microservice.dao.CategoryDAO;
import com.microservice.entities.Enterprise;
import com.microservice.exceptions.DataLayerException;
import com.microservice.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDao;
	
	@Override
	public List<EnterpriseDTO> getAllCategories() throws Exception {
		
		List<Enterprise> entList = null;
		List<EnterpriseDTO> entListDto = null;
		try{
			entList = categoryDao.categoryList();
			if(entList!= null && !entList.isEmpty()){
				entListDto = new ArrayList<EnterpriseDTO>();
				for (Enterprise enterprise : entList) {
					EnterpriseDTO entDto = new EnterpriseDTO();
					entDto.setEnterpriseId(enterprise.getEnterpriseId());
					entDto.setEnterpriseName(enterprise.getEnterpriseName());
					entDto.setEnterpriseDescription(enterprise.getEnterpriseDescription());
					entListDto.add(entDto);
				}
				return entListDto;
			}
			
		}catch(DataAccessException e){
			throw new DataLayerException(e.getMessage());
		}		
		return null;	
		
	}

}
