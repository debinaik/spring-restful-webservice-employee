package com.microservice.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.microservice.dao.StateDAO;
@Transactional
@Service("categoryDAO")
public class StateDAOImpl implements StateDAO
{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<String> stateList(String enterpriseId,String countryName) {
	
	//	List<Site> result=entityManager.createQuery("SELECT addressState FROM Plant where addressCountry=:addressCountry").setParameter("addressCountry", countryName).getResultList();
		
		List<String> result=entityManager.createQuery("SELECT P.addressState FROM Enterprise E,Site S,Plant P WHERE E.enterpriseId=S.enterprise.enterpriseId and S.siteId = P.site.siteId and E.enterpriseId=:enterpriseId and P.addressCountry=:addressCountry").
				setParameter("enterpriseId",enterpriseId).setParameter("addressCountry",countryName).getResultList();
		
	//	SELECT DISTINCT(P.ADDRESS_STATE) FROM ENTERPRISE E JOIN SITE S ON E.ENTERPRISE_ID = S.ENTERPRISE_ID JOIN PLANT P ON S.SITE_ID = P.SITE_ID WHERE E.ENTERPRISE_ID='ENT00000001' AND P.ADDRESS_COUNTRY='USA'; 
		
        System.out.println("resultset of states :"+result);
        
        if(result!=null && result.size()>0){
	    	return result;
	    }
        return null;
		
	}
	
}
