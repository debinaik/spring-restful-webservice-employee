package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Site
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
public class Site {
 
	@Column(name = "siteId" ,unique = true, nullable = false)
	@Id @GeneratedValue(generator = "siteIdGenerator")
	@GenericGenerator(name = "siteIdGenerator", strategy = "com.microservice.entities.SiteIdGenerator")
	private String siteId;	
	
	@Column(name = "siteName" ,length=200)
	private String siteName;
	
	@Column(name = "siteDescription" ,length=200)
	private String siteDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enterpriseId", nullable = false)
	private Enterprise enterprise;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="site",cascade=CascadeType.REMOVE)
	private List<Plant> plant = new ArrayList<Plant>();
	
	public Site() {
		super();
	}

	public Site(String siteId, Enterprise enterprise, String siteName, String siteDescription) {
		super();
		this.siteId = siteId;
		this.enterprise = enterprise;
		this.siteName = siteName;
		this.siteDescription = siteDescription;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}	

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<Plant> getPlant() {
		return plant;
	}

	public void setPlant(List<Plant> plant) {
		this.plant = plant;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}
	
}
