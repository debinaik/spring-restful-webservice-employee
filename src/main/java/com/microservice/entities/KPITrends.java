package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : KPI Trends Entity
 *
 */
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="KPI_TRENDS")
public class KPITrends {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int kpiId;
	
	@Column(name="kpiValue",length=200)
	private double kpiValue;
	
	@Column(name="timeStamp",length=200)
	private Timestamp timeStamp;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parameterId")
	private Parameter parameter;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="plantId")
	private Plant plant;

	public KPITrends() {
		super();
	}

	public KPITrends(int kpiId, double kpiValue, Timestamp timeStamp, Parameter parameter, Plant plant) {
		super();
		this.kpiId = kpiId;
		this.kpiValue = kpiValue;
		this.timeStamp = timeStamp;
		this.parameter = parameter;
		this.plant = plant;
	}

	public int getKpiId() {
		return kpiId;
	}

	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
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

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
}
