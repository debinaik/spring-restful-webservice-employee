package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Plant Entity
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Plant {
  
	@Column(name = "plantId" ,unique = true, nullable = false)
	@Id @GeneratedValue(generator = "plantIdGenerator")
	@GenericGenerator(name = "plantIdGenerator", strategy = "com.microservice.entities.PlantIdGenerator")
	private String plantId;
	
	@Column(name = "plantName" ,length=200)
	private String plantName;
	
	@Column(name = "plantDescription" ,length=200)
	private String plantDescription;
	
	@Column(name = "plantLatitude" ,length=200)
	private double plantLatitude;
	
	@Column(name = "plantLongitude" ,length=200)
	private double plantLongitude;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="siteId")
	private Site site;
	
	@Column(name = "status" ,length=50)
	private String status;
	
	@Column(name = "address" ,length=200)
	private String address;
	
	@Column(name = "addressZipcode" ,length=200)
	private String addressZipcode;
	
	@Column(name = "addressState" ,length=200)
	private String addressState;
	
	@Column(name = "addressCountry" ,length=200)
	private String addressCountry;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="plant",cascade=CascadeType.REMOVE)
	private List<Unit> unit = new ArrayList<Unit>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="plant",cascade=CascadeType.REMOVE)
	private List<Parameter> parameter = new ArrayList<Parameter>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="plant",cascade=CascadeType.REMOVE)
	private List<KPITrends> kpiTrends = new ArrayList<KPITrends>();

	
	public Plant() {
		super();
	}


	public Plant(String plantId, String plantName, String plantDescription, double plantLatitude, double plantLongitude,
			Site site, String status, String address, String addressZipcode, String addressState, String addressCountry,
			List<Unit> unit, List<Parameter> parameter, List<KPITrends> kpiTrends) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantDescription = plantDescription;
		this.plantLatitude = plantLatitude;
		this.plantLongitude = plantLongitude;
		this.site = site;
		this.status = status;
		this.address = address;
		this.addressZipcode = addressZipcode;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.unit = unit;
		this.parameter = parameter;
		this.kpiTrends = kpiTrends;
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


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddressZipcode() {
		return addressZipcode;
	}


	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
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


	public List<Unit> getUnit() {
		return unit;
	}


	public void setUnit(List<Unit> unit) {
		this.unit = unit;
	}


	public List<Parameter> getParameter() {
		return parameter;
	}


	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}


	public List<KPITrends> getKpiTrends() {
		return kpiTrends;
	}


	public void setKpiTrends(List<KPITrends> kpiTrends) {
		this.kpiTrends = kpiTrends;
	}
		
}
