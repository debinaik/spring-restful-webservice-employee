package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Parameter Entity
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
public class Parameter {
	
	@Column(name = "paramterId" ,unique = true, nullable = false)
	@Id @GeneratedValue(generator = "paramterIdGenerator")
	@GenericGenerator(name = "paramterIdGenerator", strategy = "com.microservice.entities.ParamterIdGenerator")
	private String paramterId;
	
	@Column(name="paramName",length=200)
	private String paramName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unitId")
	private Unit unit;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="plantId")
	private Plant plant;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parameter",cascade=CascadeType.REMOVE)
	private List<KPITrends> kpiTrends = new ArrayList<KPITrends>();

	public Parameter() {
		super();
	}

	public Parameter(String paramterId, String paramName, Unit unit, Plant plant, List<KPITrends> kpiTrends) {
		super();
		this.paramterId = paramterId;
		this.paramName = paramName;
		this.unit = unit;
		this.plant = plant;
		this.kpiTrends = kpiTrends;
	}

	public String getParamterId() {
		return paramterId;
	}

	public void setParamterId(String paramterId) {
		this.paramterId = paramterId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public List<KPITrends> getKpiTrends() {
		return kpiTrends;
	}

	public void setKpiTrends(List<KPITrends> kpiTrends) {
		this.kpiTrends = kpiTrends;
	}
			
}
