package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class OraclePLSQLProcedureTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. (JavaConfig) Get Corona Vaccines by calling PL/SQL Procedure.
//			service.getCoronaVaccinesByPriceRange(200, 300).forEach(System.out::println);
//			service.getCoronaVaccinesByPriceRange(300, 400).forEach(System.out::println);
//			service.getCoronaVaccinesByPriceRange(400, 500).forEach(System.out::println);
//			service.getCoronaVaccinesByPriceRange(500, 700).forEach(System.out::println);

			// 2. (Annotation) Search Corona Vaccines by calling PL/SQL Procedure.
			/*List<CoronaVaccine> list = service.fetchCoronaVaccinesByPriceRange(200, 300);
				list.forEach(System.out::println);*/
//			service.fetchCoronaVaccinesByPriceRange(300, 400).forEach(System.out::println);

			// 3. Authenticate by calling PL/SQL Procedure.
//			System.out.println(service.authenticate("rama1", "sita123"));
//			System.out.println(service.authenticate("shiva4", "parvathi456"));

			// 4. Get Employee details by empno.
//			Object[] empDetails = service.getEmpDetailsByEno(7499);
//			Object[] empDetails = service.getEmpDetailsByEno(7900);
			/*System.out.println("EmployeeName: "+empDetails[1]);
			System.out.println("Designation: "+empDetails[2]);
			System.out.println("Salary: "+empDetails[3]);
			System.out.println("DepartmentNo: "+empDetails[0]);*/
			
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("--------------dae--------------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--------------e--------------");
		}

	}// run(-)

}// class
