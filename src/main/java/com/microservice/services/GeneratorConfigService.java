package com.microservice.services;

import com.microservice.DTO.GeneratorConfigDTO;
import com.microservice.entities.GeneratorConfig;

public interface GeneratorConfigService {
	
	String updateGeneratorConfig(GeneratorConfig generatorConfig) throws Exception;
	
	GeneratorConfigDTO fetchGeneratorConfig(String plantName) throws Exception;

}
