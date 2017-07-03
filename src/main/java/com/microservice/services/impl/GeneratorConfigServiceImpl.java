package com.microservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.DTO.GeneratorConfigDTO;
import com.microservice.dao.GeneratorConfigDAO;
import com.microservice.entities.GeneratorConfig;
import com.microservice.services.GeneratorConfigService;

@Service
public class GeneratorConfigServiceImpl implements  GeneratorConfigService{
	
	@Autowired
	GeneratorConfigDAO generatorConfigDAO;

	@Override
	public String updateGeneratorConfig(GeneratorConfig generatorConfig) throws Exception  {
		String updateGenConfigStatus = null;
		if (generatorConfig != null) {
			updateGenConfigStatus = generatorConfigDAO.updateGeneratorConfig(generatorConfig);
		}
		return null;
	}

	@Override
	public GeneratorConfigDTO fetchGeneratorConfig(String plantName) throws Exception  {
		GeneratorConfigDTO generatorConfigDTO = null;
		generatorConfigDTO = generatorConfigDAO.fetchGeneratorConfig(plantName);
		return generatorConfigDTO;
	}

}
