package com.nt.runner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		Iterable<CoronaVaccine> coronaVaccines = null;

		try {
			/*The bulk deletion that are happening through CrudRepository(I) methods is not sending 
			delete query with condition clauses (IN clause) but sending multiple delete queries in a
			batch. So we can indirectly say that it is batch deletion.*/

			/*While working with readymade set of methods given by CrudRepository(I) or any other repository,
			generally, ID value will be taken as criteria value. If we want other than ID value as criteria value, 
			then use custom methods or HQL or JPQL or QBC in repository interface.*/

			// 12. Delete all records.
//			System.out.println(service.removeAllCoronaVaccines());

			// 11. Delete bulk records by entities.
//			CoronaVaccine coronaVaccine1 = new CoronaVaccine(); 	coronaVaccine1.setRegNo(54L);
//			CoronaVaccine coronaVaccine2 = new CoronaVaccine();		coronaVaccine2.setRegNo(52L);
//			CoronaVaccine coronaVaccine3 = new CoronaVaccine();		coronaVaccine3.setRegNo(53L);

//			System.out.println(service.removeAllCoronaVaccines(List.of(coronaVaccine1, coronaVaccine2, coronaVaccine3)));

			// 10. Delete multiple records by list of ids.
//			System.out.println(service.removeAllCoronaVaccinesById(List.of(202L, 252L)));
//			System.out.println(service.removeAllCoronaVaccinesById(List.of(202L, 200L, 252L)));
//			System.out.println(service.removeAllCoronaVaccinesById(Arrays.asList(202L, 200L, 252L)));

			// 9. Delete record by entity.
//			CoronaVaccine coronaVaccine = new CoronaVaccine();
//			coronaVaccine.setRegNo(152L);
//			System.out.println(service.removeCoronaVaccineByEntity(coronaVaccine));

			// 8. Delete record by id. (String return type)
//			System.out.println(service.removeCoronaVaccineById(2L));

			// 8. Delete record by id. (void return type)
//			service.deleteCoronaVaccineById(154L);

			// 7. Find record by id.
//			service.searchCoronaVaccineById(153L);
//			service.searchCoronaVaccineById(15L);

			// 6. Finding multiple records by ids.
//			service.searchAllCoronaVaccinesById(List.of(52L, 53L, 54L));
//			service.searchAllCoronaVaccinesById(List.of(52L, 5L, 54L));

			// 5. Finding all records.
//			service.searchAllCoronaVaccines();

			// 4. Check availability a record by id.
//			System.out.println(service.checkCoronaVaccineAvailability(352L));

			// 3. Count of records.
//			System.out.println(service.getCoronaVaccinesCount());

			// 2. Save multiple records (batch/bulk insertion).
			/*service.registerCoronaVaccinesInBatch(List.of(new CoronaVaccine("Suptnik", "Rus", "Russia", 300.0, 2),
					new CoronaVaccine("Pizer", "PizerLtd", "USA", 400.0, 2),
					new CoronaVaccine("Moderna", "ModernaLtd", "USA", 500.0, 2)));*/

			/*service.registerCoronaVaccinesInBatch(Arrays.asList(new CoronaVaccine("Suptnik", "Rus", "Russia", 300.0, 2),
					new CoronaVaccine("Pizer", "PizerLtd", "USA", 400.0, 2),
					new CoronaVaccine("Moderna", "ModernaLtd", "USA", 500.0, 2)));*/

			// 1. Save single record.
//			System.out.println(service.registerCoronaVaccine(new CoronaVaccine(5L, "Covaxin25.0", "BharatBiotech", "India", 700.0, 2)));
//			System.out.println(service.registerCoronaVaccine(new CoronaVaccine(null, "Covaxin25.0", "BharatBiotech", "India", 700.0, 2)));
//			System.out.println(service.registerCoronaVaccine(new CoronaVaccine("Covaxin1", "BharatBiotech", "India", 700.0, 2)));

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// main(-)

}// class
