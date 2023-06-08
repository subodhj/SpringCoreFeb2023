package com.nt.runner;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.MedalType;
import com.nt.document.Sport;
import com.nt.document.SportsPerson;
import com.nt.service.ISportsAuthorityMgmtService;

@Component
public class OneToManyAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private ISportsAuthorityMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {

			// 1. Save SportsPerson document.

			// Create Parent object.
			/*SportsPerson sportsPerson = new SportsPerson();
			sportsPerson.setId(new Random().nextLong(10000));
			sportsPerson.setName("Rama");
			sportsPerson.setCountry("India");*/

			// Create Child-1 object-1
			/*	Sport sport1 = new Sport();
				sport1.setId(new Random().nextInt(10000));
				sport1.setName("Badminton");
				sport1.setEquipment(new String[] { "Racket", "ShuttleCock", "Net" });
				sport1.setTeamSport(false);
				sport1.setOlympicsSport(true);*/

			// Create Child-2 object-2
			/*Sport sport2 = new Sport();
			sport2.setId(new Random().nextInt(10000));
			sport2.setName("Cricket");
			sport2.setEquipment(new String[] { "OilBat", "GraceBall", "Stumps", "Helmet" });
			sport2.setTeamSport(true);
			sport2.setOlympicsSport(false);*/

			// Create Child-2 object-1
			/*Medal medal1 = new Medal();
			medal1.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
			medal1.setType(MedalType.GOLD);
			medal1.setPrizeMoney(50000000.0);
			medal1.setEvent("RioOlympics");*/

			// Create Child-2 object-2
			/*Medal medal2 = new Medal();
			medal2.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
			medal2.setType(MedalType.SILVER);
			medal2.setPrizeMoney(40000000.0);
			medal2.setEvent("DelhiCWG");*/

			// set/map all 4 Children with Parent.
			/*sportsPerson.setSports(Set.of(sport1, sport2));
			sportsPerson.setMedals(Map.of("Olympics", medal1, "CWG", medal2));*/

			// invoke b.logic.
//			System.out.println(service.registerSportsPerson(sportsPerson));

			// 2. Get all SportsPerson documents.
			/*service.getSportsPerson().forEach(sportsPerson -> {
				System.out.println("Parent -> " + sportsPerson);
				Set<Sport> sportSet = sportsPerson.getSports();
				sportSet.forEach(sport -> {
					System.out.println("Child-1 -> " + sport);
				});
				Map<String, Medal> medalMap = sportsPerson.getMedals();
				medalMap.forEach((event, medal) -> {
					System.out.println("Child-2 -> " + event + " <-> " + medal);
				});
			});*/

			// Use DecimalFormat to format a double.
			/*System.out.println(123456789.0);
			double d = 123456789.0;
			DecimalFormat df = new DecimalFormat("#");
			System.out.println(df.format(d));*/

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}
	}// run(-)

}// class
