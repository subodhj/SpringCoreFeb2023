package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;
import com.nt.type.ResultView1;
import com.nt.type.ResultView2;
import com.nt.type.ResultView3;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {
			System.out.println("-----------------------------ResultView3----------------------------------");
			// 1. Get Corona Vaccines'specific details as custom type object based on
			// give company and in desc order.
			List<ResultView3> listView3 = service.searchCoronaVaccinesByCompanyInDescOrder("Rus", ResultView3.class);
			listView3.forEach(
					view3 -> System.out.println(view3.getName() + " " + view3.getCountry() + " " + view3.getPrice()));

			System.out.println("-----------------------------ResultView3----------------------------------");
			// 1. Get Corona Vaccines'specific details as custom type object based on
			// give company and in desc order of regNo.
			List<ResultView3> listViewRegNo = service.searchCoronaVaccinesByCompanyWithDescOrderOfRegNo("Rus",
					ResultView3.class);
			listViewRegNo.forEach(
					view3 -> System.out.println(view3.getName() + " " + view3.getCountry() + " " + view3.getPrice()));

			System.out.println("-----------------------------ResultView3----------------------------------");

			// 1. Get Corona Vaccines'specific details as custom type object based on
			// give company and in desc order of price.
			List<ResultView3> listView = service.searchCoronaVaccinesByCompanyInPriceDescOrder("Rus",
					ResultView3.class);
			listView.forEach(
					view3 -> System.out.println(view3.getName() + " " + view3.getCountry() + " " + view3.getPrice()));

			System.out.println("-----------------------------ResultView1----------------------------------");

			service.searchCoronaVaccinesByCompanyInPriceDescOrder("Rus", ResultView1.class)
					.forEach(view1 -> System.out.println(view1.getName() + " " + view1.getCountry()));

			System.out.println("-----------------------------ResultView2----------------------------------");

			service.searchCoronaVaccinesByCompanyInPriceDescOrder("Rus", ResultView2.class).forEach(
					view2 -> System.out.println(view2.getRegNo() + " " + view2.getCompany() + " " + view2.getPrice()));

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-------------------");
		}

	}// run(-)

}// class
