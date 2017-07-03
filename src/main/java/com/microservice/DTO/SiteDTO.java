package com.microservice.DTO;

public class SiteDTO {
	
	private String siteId;	
	
	private String siteName;
	
	private String siteDescription;
	
	private EnterpriseDTO enterprise;

	public SiteDTO() {
		super();
	}

	public SiteDTO(String siteId, String siteName, String siteDescription, EnterpriseDTO enterprise) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.siteDescription = siteDescription;
		this.enterprise = enterprise;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
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

	public EnterpriseDTO getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(EnterpriseDTO enterprise) {
		this.enterprise = enterprise;
	}
	
}
