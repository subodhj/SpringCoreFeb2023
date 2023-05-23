package com.nt.service;

import java.util.Collection;
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

	@Override
	public void fetchCoronaVaccinesByCompany(String company) {
		List<CoronaVaccine> coronaVaccines = null;

		// Invoke Repository method.
		if (company != null && !(company.isEmpty()) && !(company.isBlank())) {
			coronaVaccines = repo.findByCompany(company);
//			coronaVaccines = repo.findByCompanyEquals(company);
//			coronaVaccines = repo.findByCompanyIs(company);
			// Print the resultant entities.
			if (coronaVaccines != null && coronaVaccines.size() > 0)
				coronaVaccines.forEach(System.out::println);
			else
				System.out.println("Corona Vaccines of the given company does not exist.");
		} else
			System.out.println("Not a valid company name.");
	}

	@Override
	public void fetchCoronaVaccinesByPriceLessThan(double price) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		if (price > 0) {
			coronaVaccines = repo.findByPriceLessThan(price);
			// Print resultant entities.
			if (coronaVaccines != null && !coronaVaccines.isEmpty())
				coronaVaccines.forEach(System.out::println);
			else
				System.out.println("Corona Vaccines having price less than ₹" + price + "/-  are not available.");
		} else
			System.out.println("Invalid price, must be greater than zero.");
	}

	@Override
	public void fetchCoronaVaccinesByPriceRange(double startPrice, double endPrice) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		if (startPrice > 0 && endPrice > 0) {
			if (startPrice < endPrice) {
				coronaVaccines = repo.findByPriceBetween(startPrice, endPrice);
				if (coronaVaccines != null && coronaVaccines.size() > 0)
					coronaVaccines.forEach(System.out::println);
				else
					System.out.println("CoronaVaccines between price range of " + startPrice + " and " + endPrice
							+ " are not available.");
			} else
				System.out.println("Start Price must be less than End Price.");
		} else if (startPrice < 0 || endPrice > 0) // (startPrice <= 0 && endPrice > 0)
			System.out.println("Start Price must be greater than zero.");
		else if (startPrice > 0 || endPrice < 0) // (startPrice > 0 && endPrice <= 0)
			System.out.println("End Price must be greater than zero.");
		else
			System.out.println("Start Price and End Price must be greater than zero.");
	}

	@Override
	public void fetchCoronaVaccinesByNameLike(String initChars) {
		List<CoronaVaccine> coronaVaccines = null;
		if (initChars != null && !initChars.isEmpty() && !initChars.isBlank()) {
			// Invoke Repository method.
			coronaVaccines = repo.findByNameLike(initChars);
			if (coronaVaccines != null && !coronaVaccines.isEmpty())
				coronaVaccines.forEach(System.out::println);
			else
				System.out.println("Corona Vaccines having names with given initials " + initChars + " not found.");
		} else if (initChars == null)
			System.out.println("Given input must not be null.");
		else if (initChars.isEmpty())
			System.out.println("Given input must not be an empty string.");
		else if (initChars.isBlank())
			System.out.println("Given input must not be blank.");
		else
			System.out.println("Invalid Input.");
	}

	@Override
	public void fetchCoronaVaccinesByNameStartingWith(String startLetters) {
		List<CoronaVaccine> coronaVaccines = null;
		if (startLetters != null && !startLetters.isEmpty() && !startLetters.isBlank()) {
			// Invoke Repository method.
			coronaVaccines = repo.findByNameStartingWith(startLetters);
			if (coronaVaccines != null && !coronaVaccines.isEmpty())
				coronaVaccines.forEach(System.out::println);
			else
				System.out.println(
						"Corona Vaccines having names with given starting letters " + startLetters + " not found.");
		} else if (startLetters == null)
			System.out.println("Given input must not be null.");
		else if (startLetters.isEmpty())
			System.out.println("Given input must not be an empty string.");
		else if (startLetters.isBlank())
			System.out.println("Given input must not be blank.");
		else
			System.out.println("Invalid Input.");
	}

	@Override
	public void fetchCoronaVaccinesByNameEndingWith(String endLetters) {
		List<CoronaVaccine> coronaVaccines = null;
		if (endLetters != null && !endLetters.isEmpty() && !endLetters.isBlank()) {
			// Invoke Repository method.
			coronaVaccines = repo.findByNameEndingWith(endLetters);
			if (coronaVaccines != null && !coronaVaccines.isEmpty())
				coronaVaccines.forEach(System.out::println);
			else
				System.out.println(
						"Corona Vaccines having names with given ending letters " + endLetters + " not found.");
		} else if (endLetters == null)
			System.out.println("Given input must not be null.");
		else if (endLetters.isEmpty())
			System.out.println("Given input must not be an empty string.");
		else if (endLetters.isBlank())
			System.out.println("Given input must not be blank.");
		else
			System.out.println("Invalid Input.");
	}

	@Override
	public void fetchCoronaVaccinesByNameContaining(String letters) {
		List<CoronaVaccine> coronaVaccines = null;
		if (letters != null && !letters.isEmpty() && !letters.isBlank()) {
			// Invoke Repository method.
			coronaVaccines = repo.findByNameContaining(letters);
			if (coronaVaccines != null && !coronaVaccines.isEmpty())
				coronaVaccines.forEach(System.out::println);
			else
				System.out.println("Corona Vaccines having names containing letters " + letters + " not found.");
		} else if (letters == null)
			System.out.println("Given input must not be null.");
		else if (letters.isEmpty())
			System.out.println("Given input must not be an empty string.");
		else if (letters.isBlank())
			System.out.println("Given input must not be blank.");
		else
			System.out.println("Invalid Input.");
	}

	@Override
	public void fetchCoronaVaccinesByCountries(String... countries) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		coronaVaccines = repo.findByCountryIn(List.of(countries));
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByNotInCountries(String... countries) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		coronaVaccines = repo.findByCountryNotIn(List.of(countries));
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByPriceAsc(double price) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		coronaVaccines = repo.findByPriceGreaterThanOrderByPriceAsc(price);
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByNotFromCountry(String country) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
//		coronaVaccines = repo.findByCountryIsNot(country);
		coronaVaccines = repo.findByCountryNot(country);
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByRegNo(long regNo) {
		Optional<CoronaVaccine> optional = null;
		// Invoke Repository method.
		optional = repo.findByRegNo(regNo);
		optional.ifPresentOrElse(System.out::println, () -> {
			System.out.println("Corona Vaccine with regNo:" + regNo + " not found.");
		});
	}

	@Override
	public void fetchCoronaVaccinesByNameAndCountry(String coronaVaccineName, String country) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
//		coronaVaccines = repo.findByNameAndCountry(coronaVaccineName, country);
//		coronaVaccines = repo.findByNameEqualsAndCountryEquals(coronaVaccineName, country);
		coronaVaccines = repo.findByNameIsAndCountryIs(coronaVaccineName, country);
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByNameInitCharsOrPriceRange(String initChars, double startPrice, double endPrice) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		coronaVaccines = repo.findByNameLikeOrPriceBetween(initChars, startPrice, endPrice);
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByCountriesAndPriceRange(Collection<String> countries, double startPrice,
			double endPrice) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		coronaVaccines = repo.findByCountryInAndPriceBetween(countries, startPrice, endPrice);
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

	@Override
	public void fetchCoronaVaccinesByCountriesAndNamesOrPriceStartRange(Collection<String> countries,
			Collection<String> names, double price) {
		List<CoronaVaccine> coronaVaccines = null;
		// Invoke Repository method.
		coronaVaccines = repo.findByCountryInAndNameInOrPriceGreaterThanEqual(countries, names, price);
		// Print resultant records.
		coronaVaccines.forEach(System.out::println);
	}

}// class
