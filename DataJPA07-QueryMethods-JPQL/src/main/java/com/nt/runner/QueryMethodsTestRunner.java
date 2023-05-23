package com.nt.runner;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// --------------Select queries performing bulk operations--------------

			// 1. Search Corona Vaccines by company name.
//			List<CoronaVaccine> list = service.fetchCoronaVaccinesByCompany("Rus");
//			List<CoronaVaccine> list = service.fetchCoronaVaccinesByCompany("ModernaLtd");
//			List<CoronaVaccine> list = service.fetchCoronaVaccinesByCompany("BharatBiotech");
//			list.forEach(System.out::println);

			// 2. Search Corona Vaccines by price range.
//			service.fetchCoronaVaccinesByPriceRange(500.0, 700.0).forEach(System.out::println);

			// 3. Search CoronaVaccines by companies.
//			service.fetchCoronaVaccinesByCompanies("Rus", "ModernaLtd", "BharatBiotech").forEach(System.out::println);

			// 4. Search Corona Vaccines details by names.
			/*service.fetchCoronaVaccinesDetailsByNames("Pizer", "Covaxin")
					.forEach(t -> System.out.println("Name=" + t[0] + "   Company=" + t[1] + "   Price=" + t[2]));*/

			/*service.fetchCoronaVaccinesDetailsByNames("Pizer", "Covaxin").forEach(cv -> {
				for (Object o : cv) {
			//					System.out.println(o);
					System.out.print(o + " ");
					System.out.println();
				}
			});*/

			/*service.fetchCoronaVaccinesDetailsByNames("Pizer", "Covaxin").forEach(cv -> {
			
				System.out.println("Name " + "Company " + " Price");
				for (Object o : cv)
			//					System.out.println(o);
					System.out.print(o + " ");
			//					System.out.print(o + " \n");
				System.out.println();
			});*/

			/*service.fetchCoronaVaccinesDetailsByNames("Pizer", "Covaxin").forEach(t -> {
			//				Arrays.stream(t).forEach(System.out::println);
				Arrays.stream(t).forEach(System.out::print);
				System.out.println();
			//							Arrays.stream(t).forEach(o -> System.out.println(o));
				Arrays.stream(t).forEach(o -> System.out.print(o + " "));
				System.out.println();
			});*/

			// 5. Search Corona Vaccines names by price range.
//			service.fetchCoronaVaccinesNamesByPriceRange(500, 700).forEach(System.out::println);

			// --------------Select queries performing single row operations--------------

			// 1. Get Corona Vaccine by name.
//			System.out.println(service.getCoronaVaccineByName("Pizer"));
//			System.out.println(service.getCoronaVaccineByName("Covaxin3"));
			/*service.getCoronaVaccineByName("Covaxin3").ifPresentOrElse(System.out::println,
					() -> System.out.println("Record not found."));*/
			/*service.getCoronaVaccineByName("Covaxin2").ifPresentOrElse(System.out::println,
					() -> System.out.println("Record not found."));*/

			// 2. Get Corona Vaccine data by name.
//			Object obj = service.getCoronaVaccineDataByName("Pizer");
//			Object obj = service.getCoronaVaccineDataByName("Covaxin1");
//			Object[] objArray = (Object[]) obj;
//			Arrays.stream(objArray).forEach(System.out::println);
//			Arrays.stream(objArray).forEach(o -> System.out.print(o + " "));
			/*for (Object o : objArray)
				System.out.print(o + " ");*/
//			System.out.println();

			// 3. Get Corona Vaccine country by name.
//			System.out.println(service.getCoronaVaccineCountryByName("Pizer"));
//			System.out.println(service.getCoronaVaccineCountryByName("Covaxin3"));

			// --------------Select queries performing aggregate functions--------------

			// 1. Get Corona Vaccines count.
//			System.out.println(service.fetchCoronaVaccinesCount());

			// 2. Get Corona Vaccines aggregate data by price range.
			/*Object[] objArray = (Object[]) service.fetchCoronaVaccinesAggregateDataByPriceRange(500, 600);
			System.out.println("Corona Vaccines count : " + objArray[0]);
			System.out.println("Corona Vaccines min price : " + objArray[1]);
			System.out.println("Corona Vaccines max price : " + objArray[2]);
			System.out.println("Corona Vaccines sum of prices : " + objArray[3]);
			System.out.println("Corona Vaccines average of prices : " + objArray[4]);*/

			// --------------Non-Select Operations (DML Operations)--------------

			// 1. Modify Corona Vaccines prices by country.
//			int count = service.modifyCoronaVaccinesPricesByCountry("Russia", 300);
//			System.out.println("No. of records updated : " + count);

			// 2. Remove Corona Vaccines by price range.
//			int count = service.removeCoronaVaccinesByPriceRange(200, 290);
//			System.out.println("No. of records deleted : " + count);

			// --------------Native SQL Queries--------------

			// 1. Insert Corona Vaccine
			/*int count = service.registerCoronaVaccine(225L, "Rus", "Russia", 3, "Suptnik", 260);
			System.out.println("count : " + count);
			if (count == 1)
				System.out.println("Record inserted.");
			else
				System.out.println("Record not inserted.");*/

			/*	int count = service.registerCoronaVaccine("Rus", "Russia", 2, "Suptnik5", 210);
				System.out.println("count : " + count);
				System.out.println(count == 1 ? "Record inserted." : "Record not inserted.");*/
			/*if (count == 1)
				System.out.println("Record inserted.");
			else
				System.out.println("Record not inserted.");*/

			// 2. Get System Date.
//			Date date = service.fetchSystemDate();
//			System.out.println("System Date: " + date);

			// 3. Create a table.
//			int count = service.generateTempXTable();
//			System.out.println("count: " + count);
//			System.out.println(count == 0 ? "Table created" : "Table not created.");
//			(count == 0) ? System.out.println("Table created") : System.out.println("Table not created.");
			/*if (count == 0)
				System.out.println("Table created.");
			else
				System.out.println("Table not created.");
			*/
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------------------");
		}

	}// run(-)

}// class
