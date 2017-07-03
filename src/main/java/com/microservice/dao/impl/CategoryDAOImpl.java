package com.microservice.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.microservice.dao.CategoryDAO;
import com.microservice.entities.Enterprise;
import com.microservice.exceptions.DataLayerException;
@Transactional
@Service("categoryService")
public class CategoryDAOImpl implements CategoryDAO
{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Enterprise> categoryList() throws DataAccessException{
		
		List<Enterprise> result=entityManager.createQuery(" FROM Enterprise").getResultList();
       
	    if(result!=null && result.size()>0){
	    	return result;
	    }
		return null;
	}
}
