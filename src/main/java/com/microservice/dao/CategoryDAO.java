package com.microservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.microservice.entities.Enterprise;
import com.microservice.exceptions.DataLayerException;

@Transactional
@Repository
public interface CategoryDAO {

	List<Enterprise> categoryList() throws DataAccessException;
}
