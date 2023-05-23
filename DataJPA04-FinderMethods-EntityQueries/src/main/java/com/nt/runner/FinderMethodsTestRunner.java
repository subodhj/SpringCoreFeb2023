package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {
			// 13. find records for given countries and names or price start range.
			/*service.fetchCoronaVaccinesByCountriesAndNamesOrPriceStartRange(List.of("Russia", "India"),
					List.of("Covaxin", "Pizer"), 500);*/

			// 12. find records for given countries and price range
//			service.fetchCoronaVaccinesByCountriesAndPriceRange(List.of("Russia", "India"), 400, 500);
//			service.fetchCoronaVaccinesByCountriesAndPriceRange(List.of("Russia", "USA"), 400, 500);
//			service.fetchCoronaVaccinesByCountriesAndPriceRange(List.of("Russia", "USA"), 300, 500);
//			service.fetchCoronaVaccinesByCountriesAndPriceRange(List.of("Russia"), 400, 500);

			// 11. find records based on init chars of name or price range.
//			service.fetchCoronaVaccinesByNameInitCharsOrPriceRange("%P%", 400, 600);
//			service.fetchCoronaVaccinesByNameInitCharsOrPriceRange("%e%", 400, 600);
//			service.fetchCoronaVaccinesByNameInitCharsOrPriceRange("%n", 400, 600);

			// 10. find records based on given name and country.
//			service.fetchCoronaVaccinesByNameAndCountry("Pizer", "India");
//			service.fetchCoronaVaccinesByNameAndCountry("Pizer", "USA");

			// 11. find record based on ID.
//			service.fetchCoronaVaccinesByRegNo(31L);
//			service.fetchCoronaVaccinesByRegNo(102L);

			// 10. find records greater than given price and in ascending order.
//			service.fetchCoronaVaccinesByNotFromCountry("USA");

			// 10. find records greater than given price and in ascending order.
//			service.fetchCoronaVaccinesByPriceAsc(500);

			// 9. find records based on not these given countries.
//			service.fetchCoronaVaccinesByNotInCountries( "USA");

			// 8. find records based on given countries.
//			service.fetchCoronaVaccinesByCountries("India", "USA", "Russia");
//			service.fetchCoronaVaccinesByCountries("India", "Russia");
//			service.fetchCoronaVaccinesByCountries("India");

			// 7. find records based on letters contained in the name. (not working)
//			service.fetchCoronaVaccinesByNameContaining("%e%");

			// 6. find records based on ending letters of name. (not working)
//			service.fetchCoronaVaccinesByNameEndingWith("%a");

			// 5. find records based on starting letters of name. (not working)
//			service.fetchCoronaVaccinesByNameStartingWith("P%");

			// 4. find records based on initial characters of name.
//			service.fetchCoronaVaccinesByNameLike(null);
//			service.fetchCoronaVaccinesByNameLike("");
//			service.fetchCoronaVaccinesByNameLike(" ");
//			service.fetchCoronaVaccinesByNameLike("____");
//			service.fetchCoronaVaccinesByNameLike("_____"); // 5 underscores means name with 5 letters.
//			service.fetchCoronaVaccinesByNameLike("M%");
//			service.fetchCoronaVaccinesByNameLike("m%");
//			service.fetchCoronaVaccinesByNameLike("%a");
//			service.fetchCoronaVaccinesByNameLike("%na");
//			service.fetchCoronaVaccinesByNameLike("%A");
//			service.fetchCoronaVaccinesByNameLike("%e%");
//			service.fetchCoronaVaccinesByNameLike("%E%");

			// 3. find records based on range.
//			service.fetchCoronaVaccinesByPriceRange(0,0);
//			service.fetchCoronaVaccinesByPriceRange(10, 0);
//			service.fetchCoronaVaccinesByPriceRange(0, 10);
//			service.fetchCoronaVaccinesByPriceRange(500,600);
//			service.fetchCoronaVaccinesByPriceRange(600,500);

			// 2. find multiple entities based on less than given price.
//			service.fetchCoronaVaccinesByPriceLessThan(0);
//			service.fetchCoronaVaccinesByPriceLessThan(100);
//			service.fetchCoronaVaccinesByPriceLessThan(500);

			// 1. find multiple entities based on company name.
//			service.fetchCoronaVaccinesByCompany("     ");
//			service.fetchCoronaVaccinesByCompany("");
//			service.fetchCoronaVaccinesByCompany("xxx");
//			service.fetchCoronaVaccinesByCompany("PizerLtd");

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------------------");
		}

	}// run(-)

}// class
