package com.nt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("cvmService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	// --------------Select queries performing bulk operations--------------

	@Override
	public List<CoronaVaccine> fetchCoronaVaccinesByCompany(String company) {
		return repo.searchCoronaVaccinesByCompany(company);
	}

	@Override
	public List<CoronaVaccine> fetchCoronaVaccinesByPriceRange(double priceMin, double priceMax) {
		return repo.searchCoronaVaccinesByPriceRange(priceMin, priceMax);
	}

	@Override
	public List<CoronaVaccine> fetchCoronaVaccinesByCompanies(String company1, String company2, String company3) {
		return repo.searchCoronaVaccinesByCompanies(company1, company2, company3);
	}

	@Override
	public List<Object[]> fetchCoronaVaccinesDetailsByNames(String name1, String name2) {
		return repo.searchCoronaVaccinesDetailsByNames(name1, name2);
	}

	@Override
	public List<String> fetchCoronaVaccinesNamesByPriceRange(double priceMin, double priceMax) {
		return repo.searchCoronaVaccinesNamesByPriceRange(priceMin, priceMax);
	}

	// --------------Select queries performing single row operations--------------

	/*@Override
	public CoronaVaccine getCoronaVaccineByName(String name) {
		return repo.searchCoronaVaccineByName(name);
	}*/

	@Override
	public Optional<CoronaVaccine> getCoronaVaccineByName(String name) {
		return repo.searchCoronaVaccineByName(name);
	}

	@Override
	public Object getCoronaVaccineDataByName(String name) {
		return repo.searchCoronaVaccineDataByName(name);
	}

	@Override
	public String getCoronaVaccineCountryByName(String name) {
		return repo.searchCoronaVaccineCountryByName(name);
	}

	// --------------Select queries performing aggregate functions--------------

	@Override
	public long fetchCoronaVaccinesCount() {
		return repo.getCoronaVaccinesCount();
	}

	@Override
	public Object fetchCoronaVaccinesAggregateDataByPriceRange(double priceMin, double priceMax) {
		return repo.getCoronaVaccinesAggregateDataByPriceRange(priceMin, priceMax);
	}

	// --------------Non-Select Operations (DML Operations)--------------

	@Override
	public int modifyCoronaVaccinesPricesByCountry(String country, double price) {
		return repo.updateCoronaVaccinesPricesByCountry(country, price);
	}

	@Override
	public int removeCoronaVaccinesByPriceRange(double startPrice, double endPrice) {
		return repo.deleteCoronaVaccinesByPriceRange(startPrice, endPrice);
	}

	// --------------Native SQL Queries--------------

	/*	@Override
		public int registerCoronaVaccine(Long regNo, String company, String country, int doses, String name, double price) {
			return repo.insertCoronaVaccine(regNo, company, country, doses, name, price);
		}*/
	
	@Override
	public int registerCoronaVaccine(String company, String country, int doses, String name, double price) {
		return repo.insertCoronaVaccine(company, country, doses, name, price);
	}

	@Override
	public Date fetchSystemDate() {
		return repo.getSystemDate();
	}

	@Override
	public int generateTempXTable() {
		return repo.createTempXTable();
	}

}// class
