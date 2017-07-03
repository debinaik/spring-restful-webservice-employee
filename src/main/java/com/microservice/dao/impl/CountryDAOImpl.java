package com.microservice.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.microservice.dao.CountryDAO;
import com.microservice.entities.Plant;

@Transactional
@Service("countryDAO")
public class CountryDAOImpl implements CountryDAO
{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")	
	public List<Plant> getCountry(String catagoryId){
		
		List<Plant> result=entityManager.createQuery("SELECT DISTINCT P.addressCountry FROM Plant P,Enterprise E,Site S where E.enterpriseId =S.enterprise.enterpriseId and S.siteId = P.site.siteId and E.enterpriseId=:enterpriseId").setParameter("enterpriseId",catagoryId).getResultList();
		System.out.println(result);
	//	SELECT DISTINCT(P.ADDRESS_COUNTRY) FROM ENTERPRISE E JOIN SITE S ON E.ENTERPRISE_ID = S.ENTERPRISE_ID JOIN PLANT P ON S.SITE_ID = P.SITE_ID WHERE E.ENTERPRISE_ID='ENT00000001';
		System.out.println("resultset:"+result);
        List<Plant> countryList=null;
	    if(result!=null && result.size()>0){
	    	countryList =result;
	    }
		return countryList;
		
	}
}
