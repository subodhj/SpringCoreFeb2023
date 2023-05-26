package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.nt.entity.CoronaVaccine;

import jakarta.transaction.Transactional;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

//	@Query("FROM CoronaVaccine WHERE price BETWEEN ?1 AND ?2")
//	@Query("FROM CoronaVaccine WHERE price BETWEEN :priceMin AND :priceMax")
//	@Query("FROM CoronaVaccine WHERE price>=?1 AND price<=?2")
//	@Query("FROM CoronaVaccine WHERE price>=:priceMin  AND price<=:priceMax")
//	List<CoronaVaccine> searchCoronaVaccinesByPriceRange(double priceMin, double priceMax);

	/*@Procedure(name = "CoronaVaccine.getVaccinesByPriceRange", refCursor = true)
	List<CoronaVaccine> searchCoronaVaccinesByPriceRange(@Param("STARTPRICE") double priceMin,
			@Param("ENDPRICE") double priceMax);*/

	@Procedure(name = "CoronaVaccine.getVaccinesByPriceRange")
	List<CoronaVaccine> searchCoronaVaccinesByPriceRange(double priceMin, double priceMax);

//	@Procedure(procedureName = "P_GET_VACCINES_BY_PRICERANGE")
//	@Procedure(name = "CoronaVaccine.getVaccinesByPriceRange")
//	@Query(value = "call P_GET_VACCINES_BY_PRICERANGE(:STARTPRICE,:ENDPRICE,:DETAILS)", nativeQuery = true)
//	List<CoronaVaccine> searchCoronaVaccines(double priceMin, double priceMax);
	/*List<CoronaVaccine> searchCoronaVaccinesByPriceRange(@Param("STARTPRICE") double priceMin,
			@Param("ENDPRICE") double priceMax);*/
}
