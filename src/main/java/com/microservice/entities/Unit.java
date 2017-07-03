package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Unit Entity
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
public class Unit {

	@Column(name = "unitId" ,unique = true, nullable = false)
	@Id @GeneratedValue(generator = "unitIdGenerator")
	@GenericGenerator(name = "unitIdGenerator", strategy = "com.microservice.entities.UnitIdGenerator")
	private String unitId;
	
	@Column(name="UnitName",length=200)
	private String UnitName;
	
	@Column(name="unitDescription",length=500)
	private String unitDescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="plantId")
	private Plant plant;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="unit",cascade=CascadeType.REMOVE)
	private List<Parameter> parameter = new ArrayList<Parameter>();

	public Unit() {
		super();
	}

	public Unit(String unitId, String unitName, String unitDescription, Plant plant, List<Parameter> parameter) {
		super();
		this.unitId = unitId;
		UnitName = unitName;
		this.unitDescription = unitDescription;
		this.plant = plant;
		this.parameter = parameter;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return UnitName;
	}

	public void setUnitName(String unitName) {
		UnitName = unitName;
	}

	public String getUnitDescription() {
		return unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public List<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}

}
