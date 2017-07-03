package com.microservice.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class GeneratorConfigDTO {

	private String plantName;
	
	private String engineFuelMINLevel;
	
	private String engineFuelMAXLevel;
	
	private String engineCoolantMINTemprature;
	
	private String engineCoolantMAXTemprature;
	
	private String engineMINPressure;
	
	private String engineMAXPressure;
	
	private String alternatorMINVoltage;
	
	private String alternatorMAXVoltage;
	
	public GeneratorConfigDTO(){
		super();
	}

	public GeneratorConfigDTO(String engineFuelMINLevel, String engineFuelMAXLevel, String engineCoolantMINTemprature,
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
