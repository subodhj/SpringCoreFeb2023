package com.nt.service;

import java.util.Collection;
import java.util.List;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	// List<CoronaVaccine> findByCompany(String company);
	void fetchCoronaVaccinesByCompany(String company);

	// List<CoronaVaccine> findByPriceLessThan(double price);
	void fetchCoronaVaccinesByPriceLessThan(double price);

	// List<CoronaVaccine> findByPriceBetween(double startPrice, double endPrice);
	void fetchCoronaVaccinesByPriceRange(double startPrice, double endPrice);

	// List<CoronaVaccine> findByNameLike(String initChars);
	void fetchCoronaVaccinesByNameLike(String initChars);

	// List<CoronaVaccine> findByNameStartingWith(String startLetters); // (not
	// working)
	void fetchCoronaVaccinesByNameStartingWith(String startLetters);

	// List<CoronaVaccine> findByNameEndingWith(String endLetters); // (not working)
	void fetchCoronaVaccinesByNameEndingWith(String endLetters);

	// List<CoronaVaccine> findByNameContaining(String letters); // (not working)
	void fetchCoronaVaccinesByNameContaining(String letters);

	// List<CoronaVaccine> findByCountryIn(List<String> country);
	void fetchCoronaVaccinesByCountries(String... countries);

	// List<CoronaVaccine> findByCountryNotIn(List<String> country);
	void fetchCoronaVaccinesByNotInCountries(String... countries);

	// List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(double price);
	void fetchCoronaVaccinesByPriceAsc(double price);

	// List<CoronaVaccine> findByCountryIsNot(String country);
	void fetchCoronaVaccinesByNotFromCountry(String country);

	// Optional<CoronaVaccine> findByRegNo(long regNo);
	void fetchCoronaVaccinesByRegNo(long regNo);

	/* List<CoronaVaccine> findByNameAndCountry(String coronaVaccineName, String country); */
	/* List<CoronaVaccine> findByNameEqualsAndCountryEquals(String coronaVaccineName, String country); */
	/* List<CoronaVaccine> findByNameIsAndCountryIs(String coronaVaccineName, String country); */
	void fetchCoronaVaccinesByNameAndCountry(String coronaVaccineName, String country);

	/* List<CoronaVaccine> findByNameLikeOrPriceBetween(String initChars, double startPrice, double endPrice); */
	void fetchCoronaVaccinesByNameInitCharsOrPriceRange(String initChars, double startPrice, double endPrice);

	/* List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startPrice,	double endPrice); */
	void fetchCoronaVaccinesByCountriesAndPriceRange(Collection<String> countries, double startPrice, double endPrice);

	/* List<CoronaVaccine> findByCountryInAndNameInOrPriceGreaterThanEqual(Collection<String> countries, Collection<String> names, double price); */
	void fetchCoronaVaccinesByCountriesAndNamesOrPriceStartRange(Collection<String> countries,
			Collection<String> names, double price);

}
