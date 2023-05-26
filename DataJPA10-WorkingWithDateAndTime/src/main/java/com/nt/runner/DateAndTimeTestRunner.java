package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class DateAndTimeTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Save Customer record.
			/*Customer customer1 = new Customer("Hanuman", "Kishkinda", LocalDateTime.of(1985, 11, 20, 20, 30, 10),
					LocalDateTime.now(), LocalDate.now());
			System.out.println(service.registerCustomer(customer1));*/

			// 2. Get Customers
//			service.getAllCustomers().forEach(System.out::println);

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}

	}// run(-)

}// class
