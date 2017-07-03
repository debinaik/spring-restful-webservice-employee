package com.microservice.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.microservice.dao.UserServiceDAO;
import com.microservice.entities.UserDetails;



@Transactional
@Service("userService")
public class UserServiceImpl implements UserServiceDAO{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public UserDetails validateUser(String userName,String password) {
		UserDetails result=(UserDetails) entityManager.createQuery("SELECT c FROM UserDetails c WHERE c.username=:username and c.password=:password").setParameter("username",userName).setParameter("password",password)
		        .getSingleResult();	    
		
	    return result;
		/* try {
	            session.beginTransaction();
	            String hql="Select usersdetails.USER_NAME from UserDetails usersdetails where usersdetails.USER_NAME=:USER_NAME";
	            System.out.println(hql);
	            Query query = (Query) session.createQuery(hql);
	            query.setParameter(":userName", login.getUserName());
	            query.setParameter(":password", login.getPassword());
	            List<UserDetails> result =((org.hibernate.Query) query).list();
	            System.out.println("resultset:"+result);
		    		for(UserDetails user : result){
	    			if(user.getUsername().equalsIgnoreCase(name)){
	    				return user;
	    			}
	    		}
	    } catch (HibernateException e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	    } finally {
	        session.close();
	    }*/	
	}
}
