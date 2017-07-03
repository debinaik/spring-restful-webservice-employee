package com.microservice.DTO;

public class PlantGridResponseDTO {
	
	private String plantName;
	
	private double kpiValue;

	public PlantGridResponseDTO() {
		super();
	}

	public PlantGridResponseDTO(String plantName, double kpiValue) {
		super();
		this.plantName = plantName;
		this.kpiValue = kpiValue;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public double getKpiValue() {
		return kpiValue;
	}

	public void setKpiValue(double kpiValue) {
		this.kpiValue = kpiValue;
	}
	
	
	
}
