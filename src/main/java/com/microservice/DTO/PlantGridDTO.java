package com.microservice.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class PlantGridDTO {
	
	private String plantName;
	
	private List<KPIDTO> kpiList = new ArrayList<KPIDTO>();

	public PlantGridDTO() {
		super();
	}
	
	public PlantGridDTO(String plantName, List<KPIDTO> kpiList) {
		super();
		this.plantName = plantName;
		this.kpiList = kpiList;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public List<KPIDTO> getKpiList() {
		return kpiList;
	}

	public void setKpiList(List<KPIDTO> kpiList) {
		this.kpiList = kpiList;
	}
	
}
