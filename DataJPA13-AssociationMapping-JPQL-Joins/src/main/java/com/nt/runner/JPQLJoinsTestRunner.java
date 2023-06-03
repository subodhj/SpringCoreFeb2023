package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.IPersonMgmtService;

@Component
public class JPQLJoinsTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {

			/*List<Object[]> list = service.fetchPhoneDataUsingJoins();
			list.forEach(objArray -> {
				System.out.println("PersonID : " + objArray[0]);
				System.out.println("Name : " + objArray[1]);
				System.out.println("Address : " + objArray[2]);
				System.out.println("Phone Regno : " + objArray[2]);
				System.out.println("Phone Number : " + objArray[2]);
				System.out.println("Service Provider : " + objArray[2]);
				System.out.println("Phone Type : " + objArray[2]);
			});*/

			/*service.fetchPhoneDataUsingJoins().forEach(objArray -> {
				for (Object obj : objArray) {
					System.out.println("val " + obj);
				}
				System.out.println();
			});*/

			/*service.fetchPhoneDataUsingJoins().forEach(objArray -> {
				for (Object obj : objArray) {
					System.out.print(obj + "      ");
				}
				System.out.println();
			});*/

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}
	}

}
