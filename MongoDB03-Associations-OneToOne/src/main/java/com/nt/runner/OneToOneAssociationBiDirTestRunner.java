package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.document.Citizen;
import com.nt.document.DrivingLicence;
import com.nt.service.IRTAMgmtService;

@Component
public class OneToOneAssociationBiDirTestRunner implements CommandLineRunner {

	@Autowired
	private IRTAMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		try {

			// 1. Save Citizen with DrivingLicence.
			// Create Parent object.
			/*Citizen citizen = new Citizen();
			citizen.setCid(new Random().nextInt(10000));
			citizen.setName("Krishna");
			citizen.setAddr("Madhura, UP");*/
			// Create Child object.
			/*DrivingLicence licence = new DrivingLicence();
			licence.setLid(new Random().nextLong(10000L));
			licence.setType("Two-Wheeler");
			licence.setExpiryDate(LocalDateTime.of(2038, 06, 20, 12, 30));*/
			// Set Child object to Parent object.
//			citizen.setLicence(licence);
			// Invoke b.logic
//			System.out.println(service.registerCitizenWithDrivingLicence(citizen));

			// 2. Save DrivingLicence with Citizen.
			// Create Child object.
			/*DrivingLicence licence = new DrivingLicence();
			licence.setLid(new Random().nextLong(10000L));
			licence.setType("Four-Wheeler");
			licence.setExpiryDate(LocalDateTime.of(2038, 06, 20, 12, 30));*/
			// Create Parent object.
			/*Citizen citizen = new Citizen();
			citizen.setCid(new Random().nextInt(10000));
			citizen.setName("Rama");
			citizen.setAddr("Ayodhya, UP");*/
			// Set Parent object to Child object.
//			licence.setCitizen(citizen);
			// Invoke b.logic
//			System.out.println(service.registerDrivingLicenceWithCitizen(licence));

			// 3. Get all Citizen documents.
			/*service.getCitizen().forEach(citizen -> {
				System.out.println("Parent -> " + citizen);
				System.out.println("Child -> " + citizen.getLicence());
			});*/

			// 4. Get all DrivingLicence documents.
			/*service.getDrivingLicence().forEach(licence -> {
				System.out.println("Child -> " + licence);
				System.out.println("Parent -> " + licence.getCitizen());
			});*/

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}

	}// run(-)

}// class
