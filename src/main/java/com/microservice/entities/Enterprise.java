package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : Enterprise Entity
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
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Enterprise {
	
	@Column(name = "enterpriseId" ,unique = true, nullable = false)
	@Id @GeneratedValue(generator = "enterpriseIdGenerator")
	@GenericGenerator(name = "enterpriseIdGenerator", strategy = "com.microservice.entities.EnterpriseIdGenerator")
	private String enterpriseId;
	
	@Column(name = "enterpriseName" ,length=200)
	private String enterpriseName;
	
	@Column(name = "enterpriseDescription" ,length=200)
	private String enterpriseDescription;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="enterprise",cascade=CascadeType.REMOVE)
	private List<Site> siteId = new ArrayList<Site>();

	public Enterprise() {
		super();
	}

	public Enterprise(String enterpriseId, String enterpriseName, String enterpriseDescription, List<Site> siteId) {
		super();
		this.enterpriseId = enterpriseId;
		this.enterpriseName = enterpriseName;
		this.enterpriseDescription = enterpriseDescription;
		this.siteId = siteId;
	}



	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseDescription() {
		return enterpriseDescription;
	}

	public void setEnterpriseDescription(String enterpriseDescription) {
		this.enterpriseDescription = enterpriseDescription;
	}

	public List<Site> getSiteId() {
		return siteId;
	}


	public void setSiteId(List<Site> siteId) {
		this.siteId = siteId;
	}
	
	
	
}
