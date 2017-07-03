package com.microservice.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.microservice.DTO.GeneratorConfigDTO;
import com.microservice.dao.GeneratorConfigDAO;
import com.microservice.entities.GeneratorConfig;

@Component
public class GeneratorConfigDAOImpl implements  GeneratorConfigDAO{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public String updateGeneratorConfig(GeneratorConfig generatorConfig) throws Exception {
		entityManager.persist(generatorConfig);
		return "success";
	}

	@Override
	public GeneratorConfigDTO fetchGeneratorConfig(String plantName) throws Exception{
		GeneratorConfig generatorConfig = (GeneratorConfig) entityManager.createQuery("from GeneratorConfig where plantName=:plantName").setParameter("plantName",plantName).getSingleResult();
		
		if (generatorConfig != null) {
			GeneratorConfigDTO generatorConfigDTO = new GeneratorConfigDTO();
			BeanUtils.copyProperties(generatorConfig, generatorConfigDTO);
			return generatorConfigDTO;
			
		}
		return null;
	}

}
