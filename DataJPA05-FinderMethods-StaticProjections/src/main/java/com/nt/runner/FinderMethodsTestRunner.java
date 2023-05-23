package com.nt.runner;

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
			// 1. Get Corona Vaccines' names and countries as custom type object based on
			// give price start range and in asc order.
			service.searchCoronaVaccinesByPriceStartRangeAndInAscOrder(500);

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------------------");
		}

	}// run(-)

}// class
