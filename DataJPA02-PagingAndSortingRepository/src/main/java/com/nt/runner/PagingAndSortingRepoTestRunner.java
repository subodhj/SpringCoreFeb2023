package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class PagingAndSortingRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {

			// 2. Displaying the records of given page number.
//			service.searchAllCoronaVaccinesByGivenPage();

						
			// 2. Displaying the records through pagination.
//			service.searchAllCoronaVaccinesByPagination(2);

			// 2. Displaying the records in sorting order through pagination.
//			service.searchAllCoronaVaccinesByPagination(0, 4, true, "price");
//			service.searchAllCoronaVaccinesByPagination(3, 4, true, "price");

			// 1. Displaying the records in sorting order.
//			service.searchAllCoronaVaccinesBySortingOrder(true, "price");
//			service.searchAllCoronaVaccinesBySortingOrder(false, "price");

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// run(-)

}// class
