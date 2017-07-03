package com.microservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class PlantDropDownDTO {
	
	private String plantId;
	
	private String plantName;

	public PlantDropDownDTO() {
		super();
	}

	public PlantDropDownDTO(String plantId, String plantName) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	
}
