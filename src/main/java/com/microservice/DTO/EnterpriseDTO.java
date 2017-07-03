package com.microservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class EnterpriseDTO {
	
	private String enterpriseId;
	
	private String enterpriseName;
	
	private String enterpriseDescription;

	public EnterpriseDTO() {
		super();
	}

	public EnterpriseDTO(String enterpriseId, String enterpriseName, String enterpriseDescription) {
		super();
		this.enterpriseId = enterpriseId;
		this.enterpriseName = enterpriseName;
		this.enterpriseDescription = enterpriseDescription;
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
	
	
}
