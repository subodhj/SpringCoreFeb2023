package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 3. Delete multiple records based on given IDs.
//			service.removeAllCoronaVaccinesById(List.of(152L, 153L, 154L));
//			service.removeAllCoronaVaccinesById(List.of(152L, 155L, 154L));

			// 2. Get record for the given ID.
//			service.getCoronaVaccineById(104);
//			service.getCoronaVaccineById(21);

			// 1. Find all records that match with all the properties' values that
			// are mentioned in the given Entity object and get them in given sorting order,
			// based on the given property as criteria value.
//			CoronaVaccine coronaVaccine = new CoronaVaccine();
//			coronaVaccine.setCountry("USA");
//			coronaVaccine.setCountry("Russia");
//			coronaVaccine.setPrice(300.0);
//			coronaVaccine.setDoses(2);
//			service.searchAllCoronaVaccinesByData(coronaVaccine, true, "price");

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------------------");
		}

	}// run(-)

}// class
