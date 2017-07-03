package com.microservice.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.microservice.entities.Plant;;


@Transactional
@Repository
public interface CountryDAO {

	List<Plant> getCountry(String categoryname);
}
