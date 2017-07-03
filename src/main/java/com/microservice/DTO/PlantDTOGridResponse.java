package com.microservice.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class PlantDTOGridResponse {
	
	List<KPIGridDTO> kpiGrid = new ArrayList<KPIGridDTO>();

	public PlantDTOGridResponse() {
		super();
	}

	public PlantDTOGridResponse(List<KPIGridDTO> kpiGrid) {
		super();
		this.kpiGrid = kpiGrid;
	}

	public List<KPIGridDTO> getKpiGrid() {
		return kpiGrid;
	}

	public void setKpiGrid(List<KPIGridDTO> kpiGrid) {
		this.kpiGrid = kpiGrid;
	}
	
	
}
