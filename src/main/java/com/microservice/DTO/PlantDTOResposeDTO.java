package com.microservice.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author 574990
 *
 */

@JsonInclude
public class PlantDTOResposeDTO {
	List<PlantDTO> plants;

	public PlantDTOResposeDTO() {
		super();
	}

	public PlantDTOResposeDTO(List<PlantDTO> plants) {
		super();
		this.plants = plants;
	}

	public List<PlantDTO> getPlants() {
		return plants;
	}

	public void setPlants(List<PlantDTO> plants) {
		this.plants = plants;
	}
	
	
}
