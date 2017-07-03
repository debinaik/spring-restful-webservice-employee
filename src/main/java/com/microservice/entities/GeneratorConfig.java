package com.microservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeneratorConfig {
	
	
	@Column(name = "plantID" ,unique = true, nullable = false)
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int plantID;

	@Column(name = "plantName" ,length=50)
	private String plantName;
	
	@Column(name = "engineFuelMINLevel" ,length=15)
	private String engineFuelMINLevel;
	
	@Column(name = "engineFuelMAXLevel" ,length=15)
	private String engineFuelMAXLevel;
	
	@Column(name = "engineCoolantMINTemprature" ,length=15)
	private String engineCoolantMINTemprature;
	
	@Column(name = "engineCoolantMAXTemprature" ,length=15)
	private String engineCoolantMAXTemprature;
	
	@Column(name = "engineMINPressure" ,length=15)
	private String engineMINPressure;
	
	@Column(name = "engineMAXPressure" ,length=15)
	private String engineMAXPressure;
	
	@Column(name = "alternatorMINVoltage" ,length=15)
	private String alternatorMINVoltage;
	
	@Column(name = "alternatorMAXVoltage" ,length=15)
	private String alternatorMAXVoltage;
	
	public GeneratorConfig(){
		super();
	}

	public GeneratorConfig(String engineFuelMINLevel, String engineFuelMAXLevel, String engineCoolantMINTemprature,
			String engineCoolantMAXTemprature, String engineMINPressure, String engineMAXPressure,
			String alternatorMINVoltage, String alternatorMAXVoltage) {
		super();
		this.engineFuelMINLevel = engineFuelMINLevel;
		this.engineFuelMAXLevel = engineFuelMAXLevel;
		this.engineCoolantMINTemprature = engineCoolantMINTemprature;
		this.engineCoolantMAXTemprature = engineCoolantMAXTemprature;
		this.engineMINPressure = engineMINPressure;
		this.engineMAXPressure = engineMAXPressure;
		this.alternatorMINVoltage = alternatorMINVoltage;
		this.alternatorMAXVoltage = alternatorMAXVoltage;
	}
	
	
	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getEngineFuelMINLevel() {
		return engineFuelMINLevel;
	}

	public void setEngineFuelMINLevel(String engineFuelMINLevel) {
		this.engineFuelMINLevel = engineFuelMINLevel;
	}

	public String getEngineFuelMAXLevel() {
		return engineFuelMAXLevel;
	}

	public void setEngineFuelMAXLevel(String engineFuelMAXLevel) {
		this.engineFuelMAXLevel = engineFuelMAXLevel;
	}

	public String getEngineCoolantMINTemprature() {
		return engineCoolantMINTemprature;
	}

	public void setEngineCoolantMINTemprature(String engineCoolantMINTemprature) {
		this.engineCoolantMINTemprature = engineCoolantMINTemprature;
	}

	public String getEngineCoolantMAXTemprature() {
		return engineCoolantMAXTemprature;
	}

	public void setEngineCoolantMAXTemprature(String engineCoolantMAXTemprature) {
		this.engineCoolantMAXTemprature = engineCoolantMAXTemprature;
	}

	public String getEngineMINPressure() {
		return engineMINPressure;
	}

	public void setEngineMINPressure(String engineMINPressure) {
		this.engineMINPressure = engineMINPressure;
	}

	public String getEngineMAXPressure() {
		return engineMAXPressure;
	}

	public void setEngineMAXPressure(String engineMAXPressure) {
		this.engineMAXPressure = engineMAXPressure;
	}

	public String getAlternatorMINVoltage() {
		return alternatorMINVoltage;
	}

	public void setAlternatorMINVoltage(String alternatorMINVoltage) {
		this.alternatorMINVoltage = alternatorMINVoltage;
	}

	public String getAlternatorMAXVoltage() {
		return alternatorMAXVoltage;
	}

	public void setAlternatorMAXVoltage(String alternatorMAXVoltage) {
		this.alternatorMAXVoltage = alternatorMAXVoltage;
	}
}
