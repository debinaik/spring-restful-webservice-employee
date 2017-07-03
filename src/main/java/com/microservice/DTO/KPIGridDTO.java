package com.microservice.DTO;

import java.util.ArrayList;
import java.util.List;

public class KPIGridDTO {
	
	private String kpiName;
	
	private List<PlantGridResponseDTO> plantGrid = new ArrayList<PlantGridResponseDTO>();

	public KPIGridDTO() {
		super();
	}

	public KPIGridDTO(String kpiName, List<PlantGridResponseDTO> plantGrid) {
		super();
		this.kpiName = kpiName;
		this.plantGrid = plantGrid;
	}

	public String getKpiName() {
		return kpiName;
	}

	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

	public List<PlantGridResponseDTO> getPlantGrid() {
		return plantGrid;
	}

	public void setPlantGrid(List<PlantGridResponseDTO> plantGrid) {
		this.plantGrid = plantGrid;
	}
	
	
}
