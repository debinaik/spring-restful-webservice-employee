package com.microservice.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entities.UserDetails;

@Transactional
@Repository
public interface UserServiceDAO{
	
	UserDetails validateUser(String name,String password);
	
}
