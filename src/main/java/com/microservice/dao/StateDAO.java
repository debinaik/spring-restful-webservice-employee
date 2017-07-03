package com.microservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface StateDAO{

	List<String> stateList(String enterpriseId,String countryName);
}
