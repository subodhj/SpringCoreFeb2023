package com.nt.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.document.Actor;
import com.nt.service.IActorsAssociationMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private IActorsAssociationMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			// 1. Save single document.
			/*System.out.println(
					service.registerActor(new Actor(new Random().nextInt(10000), "Rama", "Hero", 25, 9291256944L)));*/
//			System.out.println(service.registerActor(new Actor(8006, "Rama", "Hero", 25, 9991366944L)));
//			System.out.println(service.registerActor(new Actor(8006, "Rama", "Hero", 25, 8891366944L))); // insert(-)
//			System.out.println(service.registerActor(new Actor(new Random().nextInt(10000), "Ramesh", "Hero", 25, 8891366944L))); // insert(-)

			// 2. Save multiple documents.
			/*System.out.println(service
					.registerActor(List.of(new Actor(new Random().nextInt(10000), " Ravana", "Villan", 65, 9898234567L),
							new Actor(new Random().nextInt(10000), "Kumbakarna", "Villan", 60, 8999012301L))));*/

			// 3. Read all documents.
//			System.out.println(service.getActor());
//			service.getActor().forEach(System.out::println);

			// 4. Read documents by condition.
//			service.getActor("Hero").forEach(System.out::println);

			// 5. Read document by id.
//			System.out.println(service.getActor(8006));

			// 6. Update document by id.
//			System.out.println(service.modifyActorAddrsAndContactNoById(8006, "UP", 9988998899L));

			// 7. Update multiple documents pay based on role & age as criteria.
//			System.out.println(service.modifyActorPayByRoleAndAge("Hero", 25, 20000000));

			// 8. Update or insert multiple documents based on age range.
//			System.out.println(service.saveOrUpdateActorByAgeRange(25, 65, 50000000, 8080808080L, "Mumbai"));

			// 9. Delete first document that matches the given criteria / condition.
//			System.out.println(service.removeActorByAgeGTE(60));

			// 10. Delete all those documents which match given condition.
//			System.out.println(service.removeActorsByPayRange(20000000, 50000000));

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}
	}// run(-)

}// class
