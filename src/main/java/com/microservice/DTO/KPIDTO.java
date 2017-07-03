package com.microservice.DTO;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class KPIDTO {
	
	private String kpiName;
	
	private double kpiValue;
	
	private Timestamp timeStamp;

	public KPIDTO() {
		super();
	}

	public KPIDTO(String kpiName, double kpiValue, Timestamp timeStamp) {
		super();
		this.kpiName = kpiName;
		this.kpiValue = kpiValue;
		this.timeStamp = timeStamp;
	}

	public String getKpiName() {
		return kpiName;
	}

	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

	public double getKpiValue() {
		return kpiValue;
	}

	public void setKpiValue(double kpiValue) {
		this.kpiValue = kpiValue;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
