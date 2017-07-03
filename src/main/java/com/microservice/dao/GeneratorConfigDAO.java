package com.microservice.dao;

import com.microservice.DTO.GeneratorConfigDTO;
import com.microservice.entities.GeneratorConfig;

public interface GeneratorConfigDAO {
	
	String updateGeneratorConfig(GeneratorConfig generatorConfig) throws Exception;
	
	GeneratorConfigDTO fetchGeneratorConfig(String plantName) throws Exception;
}
