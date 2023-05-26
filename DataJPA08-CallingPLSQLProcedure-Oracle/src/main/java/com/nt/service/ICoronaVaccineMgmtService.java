package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	List<CoronaVaccine> getCoronaVaccinesByPriceRange(double minPrice, double maxPrice);

	List<CoronaVaccine> fetchCoronaVaccinesByPriceRange(double priceMin, double priceMax);

	String authenticate(String uname, String pwd);

	Object[] getEmpDetailsByEno(int eno);

}
