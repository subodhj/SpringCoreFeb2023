package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class MySqlPLSQLProcedureTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Get Employees by designations.
			service.searchEmpsByDesigs("clerk", "manager").forEach(System.out::println);

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}
	}

}
