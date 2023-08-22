package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Country;

public interface ICountryRepo extends JpaRepository<Country, Integer> {

//	@Query("FROM Country WHERE name=?1")
	@Query("FROM Country WHERE name=:country")
	Country getCountry(String country);
//	@Query("FROM Country WHERE name=:ctr")
//	Country getCountry(@Param("ctr") String country);

}
