package com.microservice.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class PlantDTO {
	
	private String plantId;
	
	private String plantName;
	
	private String plantDescription;
	
	private double plantLatitude;
	
	private double plantLongitude;
	
	private String siteId;
	
	private String status;
	
	private String address;
	
	private String addressState;
	
	private String addressCountry;
	
    private List<KPIDTO> kpi;

	public PlantDTO() {
		super();
	}
	
	public PlantDTO(String plantId, String plantName, String plantDescription, double plantLatitude,
			double plantLongitude, String siteId, String status, String address, String addressState,
			String addressCountry, List<KPIDTO> kpi) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantDescription = plantDescription;
		this.plantLatitude = plantLatitude;
		this.plantLongitude = plantLongitude;
		this.siteId = siteId;
		this.status = status;
		this.address = address;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.kpi = kpi;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public double getPlantLatitude() {
		return plantLatitude;
	}

	public void setPlantLatitude(double plantLatitude) {
		this.plantLatitude = plantLatitude;
	}

	public double getPlantLongitude() {
		return plantLongitude;
	}

	public void setPlantLongitude(double plantLongitude) {
		this.plantLongitude = plantLongitude;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public List<KPIDTO> getKpi() {
		return kpi;
	}

	public void setKpi(List<KPIDTO> kpi) {
		this.kpi = kpi;
	}
	
}
