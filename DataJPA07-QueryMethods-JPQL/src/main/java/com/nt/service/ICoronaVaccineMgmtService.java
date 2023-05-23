package com.nt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	// --------------Select queries performing bulk operations--------------

	List<CoronaVaccine> fetchCoronaVaccinesByCompany(String company);

	List<CoronaVaccine> fetchCoronaVaccinesByPriceRange(double priceMin, double priceMax);

	List<CoronaVaccine> fetchCoronaVaccinesByCompanies(String company1, String company2, String company3);

	List<Object[]> fetchCoronaVaccinesDetailsByNames(String name1, String name2);

	List<String> fetchCoronaVaccinesNamesByPriceRange(double priceMin, double priceMax);

	// --------------Select queries performing single row operations--------------

//	CoronaVaccine getCoronaVaccineByName(String name);
	Optional<CoronaVaccine> getCoronaVaccineByName(String name);

	Object getCoronaVaccineDataByName(String name);

	String getCoronaVaccineCountryByName(String name);

	// --------------Select queries performing aggregate functions--------------

	long fetchCoronaVaccinesCount();

	Object fetchCoronaVaccinesAggregateDataByPriceRange(double priceMin, double priceMax);

	// --------------Non-Select Operations (DML Operations)--------------

	int modifyCoronaVaccinesPricesByCountry(String country, double price);

	int removeCoronaVaccinesByPriceRange(double startPrice, double endPrice);

	// --------------Native SQL Queries--------------

//	int registerCoronaVaccine(Long regNo, String company, String country, int doses, String name, double price);
	int registerCoronaVaccine(String company, String country, int doses, String name, double price);

	Date fetchSystemDate();

	int generateTempXTable();

}// class
