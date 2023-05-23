package com.nt.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

//	@Query("FROM com.nt.entity.CoronaVaccine WHERE company=?1 ")
//	@Query("FROM CoronaVaccine WHERE company=?1 ")
//	@Query("FROM CoronaVaccine as cv WHERE cv.company=?1 ")
//	@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?1 ")
//	@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=? ")
	/*@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=:vendor ")
	List<CoronaVaccine> searchCoronaVaccinesByCompany(String vendor);*/
	@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=:comp")
	List<CoronaVaccine> searchCoronaVaccinesByCompany(@Param("comp") String vendor);

//	@Query("FROM CoronaVaccine WHERE price BETWEEN ?1 AND ?2")
//	@Query("FROM CoronaVaccine WHERE price BETWEEN :priceMin AND :priceMax")
//	@Query("FROM CoronaVaccine WHERE price>=?1 AND price<=?2")
	@Query("FROM CoronaVaccine WHERE price>=:priceMin  AND price<=:priceMax")
	List<CoronaVaccine> searchCoronaVaccinesByPriceRange(double priceMin, double priceMax);

	// --------------Select queries performing bulk operations--------------

	// Entity Query selecting all column values.
	@Query("FROM CoronaVaccine WHERE company IN(:company1, :company2, :company3) ORDER BY company")
//	@Query("FROM CoronaVaccine WHERE company IN(:company1, :company2, :company3) ")
	List<CoronaVaccine> searchCoronaVaccinesByCompanies(String company1, String company2, String company3);

	// Scalar Query selecting specific columns' values.
	@Query("SELECT name, company, price FROM CoronaVaccine WHERE name IN(:name1,:name2) ")
	List<Object[]> searchCoronaVaccinesDetailsByNames(String name1, String name2);

	// Scalar Query selecting specific column value.
	@Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN :priceMin AND :priceMax")
	List<String> searchCoronaVaccinesNamesByPriceRange(double priceMin, double priceMax);

	// --------------Select queries performing single row operations--------------

	// Entity Query selecting single row (or) all column values of one record.
	@Query("FROM CoronaVaccine WHERE name=:vname")
//	CoronaVaccine searchCoronaVaccineByName(String vname);
	Optional<CoronaVaccine> searchCoronaVaccineByName(String vname);

	// Scalar Query selecting specific columns of one record.
	@Query("SELECT name, company, country FROM CoronaVaccine WHERE name=:vname")
	Object searchCoronaVaccineDataByName(String vname);

	// Scalar Query selecting specific column value of one record.
	@Query("SELECT country FROM CoronaVaccine WHERE name=:vname")
	String searchCoronaVaccineCountryByName(String vname);

	// --------------Select queries performing aggregate functions--------------

	@Query("SELECT COUNT(*) FROM CoronaVaccine")
	long getCoronaVaccinesCount();

	@Query("SELECT COUNT(*), MIN(price), MAX(price), SUM(price), AVG(price) FROM CoronaVaccine WHERE price>=:priceMin AND price<=:priceMax")
	Object getCoronaVaccinesAggregateDataByPriceRange(double priceMin, double priceMax);

	// --------------Non-Select Operations (DML Operations)--------------

	@Query("UPDATE CoronaVaccine SET price=:price WHERE country=:country")
	@Modifying
	@Transactional
//	@jakarta.transaction.Transactional
	int updateCoronaVaccinesPricesByCountry(String country, double price);

	@Modifying
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :startPrice AND :endPrice")
	@Transactional
	int deleteCoronaVaccinesByPriceRange(double startPrice, double endPrice);

	// --------------Native SQL Queries--------------

	// Non-Select Query (or) Insert Query (or) DML operation.
	/* CREATE SEQUENCE  "SCOTT"."CORONA_VACCINE_REG_NO_SEQ"  MINVALUE 1000 MAXVALUE 100000 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE ; */
	@Modifying
//	@Query(value = "INSERT INTO CORONA_VACCINE VALUES(?,?,?,?,?,?	)", nativeQuery = true)
	@Query(value = "INSERT INTO CORONA_VACCINE VALUES(CORONA_VACCINE_REG_NO_SEQ.NEXTVAL,?,?,?,?,?	)", nativeQuery = true)
	@Transactional
//	int insertCoronaVaccine(Long regNo, String company, String country, int doses, String name, double price);
	int insertCoronaVaccine(String company, String country, int doses, String name, double price);

	// Select Query.
	@Query(value = "SELECT SYSDATE FROM DUAL", nativeQuery = true)
	Date getSystemDate();

	// Create Query (or) DDL operation.
	@Modifying
	@Query(value = "CREATE TABLE TEMPX(col1 number(5), col2 varchar2(20))", nativeQuery = true)
	@Transactional
	int createTempXTable();       // create=construct=generate

}
