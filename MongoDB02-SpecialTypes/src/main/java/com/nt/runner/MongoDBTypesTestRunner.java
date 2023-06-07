package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class MongoDBTypesTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService empService;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Save Employee document.
			/*Employee emp = new Employee();
			emp.setEno(new Random().nextInt(10000));
			emp.setEname("Rama");
			emp.setEadd("Ayodhya, UP");
			emp.setDob(LocalDateTime.of(1985, 11, 20, 20, 30));*/
//			emp.setDob(LocalDate.of(1985, 11, 20));
			/*emp.setMarried(false);
			emp.setRoles(new String[] { "Developer", "ScrumMaster", "TeamLead" });
			emp.setPhoneNos(Set.of(8801969944L, 9291256944L));
			emp.setProjects(List.of("BankingDomain", "InsuranceDomain"));
			emp.setEducation(Map.of("SSC", 77.0, "Inter", 70.0, "BTech", 60.0));
			Properties props = new Properties();
			props.put("Aadhaar", "326166268839");
			props.put("PAN", "CTWPJ8023P");
			emp.setIds(props);*/
//			System.out.println(empService.registerEmployee(emp));

			// 2. Find all Employee documents.
//			empService.getEmployee().forEach(System.out::println);

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}

	}// run(-)

}// class
