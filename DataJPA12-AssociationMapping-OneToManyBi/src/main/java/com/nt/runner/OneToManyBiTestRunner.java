package com.nt.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonMgmtService;

@Component
//@Transactional
@jakarta.transaction.Transactional
public class OneToManyBiTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {

			// 1. Save Person info.
			// Create Person object (parent).
			/*Person person = new Person("Andal", "Srirangam");
			// Create PhoneNumber object (child)
			PhoneNumber ph1 = new PhoneNumber(9127999999L, "Jio", "Residence");
			PhoneNumber ph2 = new PhoneNumber(9157888888L, "AirTel", "Office");
			// Assign Person obj to 2 PhoneNumber objects.
			ph1.setPerson(person);
			ph2.setPerson(person);
			// Assign 2 PhoneNumber objects to Person object.
			Set<PhoneNumber> phoneNos = Set.of(ph1, ph2);
			person.setPhoneNos(phoneNos);
			// Invoke Service method.
			System.out.println(service.registerPerson(person));*/

			// 2. Save multiple Person records.
			/*Person p1 = new Person("Parvathi", "Kailasam");
			Person p2 = new Person("Saraswathi", "SatyLokam");
			PhoneNumber ph1 = new PhoneNumber(1001122222L, "Vi", "Personal");
			PhoneNumber ph2 = new PhoneNumber(2002211111L, "Vi", "Office");
			PhoneNumber ph3 = new PhoneNumber(3003322222L, "Airtel", "Personal");
			PhoneNumber ph4 = new PhoneNumber(4004422222L, "Jio", "Office");
			ph1.setPerson(p1);
			ph2.setPerson(p1);
			ph3.setPerson(p2);
			ph4.setPerson(p2);
			p1.setPhoneNos(Set.of(ph1, ph2));
			p2.setPhoneNos(Set.of(ph3, ph4));
			System.out.println(service.registerPerson(List.of(p1, p2)));*/

			// 3.Save PhoneNumber record.
//			PhoneNumber ph = new PhoneNumber(8989898989L, "Jio", "Office");
//			Person per = new Person("Sita", "Jankpuri");
//			ph.setPerson(per);
//			per.setPhoneNos(Set.of(ph));
//			// Invoke Service method.
//			System.out.println(service.registerPhoneNumber(ph));

			// 4. Save multiple PhoneNumber records.
//			PhoneNumber ph1 = new PhoneNumber(1001212121L, "Jio", "Office");
//			PhoneNumber ph2 = new PhoneNumber(2002323232L, "AirTel", "Personal");
//			PhoneNumber ph3 = new PhoneNumber(3313131313L, "Vi", "Residence");
//			Person p1 = new Person("Hanuman", "Kishkinda");
//			Person p2 = new Person("Angadha", "Kishkinda");
//			ph1.setPerson(p1);
//			ph2.setPerson(p1);
//			ph3.setPerson(p2);
//			Set<PhoneNumber> set1 = new HashSet<>();
//			set1.add(ph1);
//			set1.add(ph2);
//			Set<PhoneNumber> set2 = new HashSet<>();
//			set2.add(ph3);
//			p1.setPhoneNos(set1);
//			p2.setPhoneNos(set2);
//						p1.setPhoneNos(Set.of(ph1, ph2));
//						p2.setPhoneNos(Set.of(ph3));
//			System.out.println(service.registerPhoneNumber(Set.of(ph1)));

//			PhoneNumber ph1 = new PhoneNumber(4004444444L, "AirTel", "Personal");
//			PhoneNumber ph2 = new PhoneNumber(1111111111L, "Jio", "Office");
//			PhoneNumber ph3 = new PhoneNumber(6005555555L, "Vi", "Residence");
//			System.out.println(service.registerPhoneNumberForPerson(52, Set.of(ph2)));

			// 5. Get Person record by Id value.
//			Person person = service.getPerson(3301);
//			 System.out.println(person + "\n" + person.getPhoneNos());
//			System.out.println("parent -> " + person);
//			System.out.println("child -> " + person.getPhoneNos());
			/*Set<PhoneNumber> set = person.getPhoneNos();
			set.forEach(ph -> System.out.println("child -> " + ph));*/

			// 6. Get all Person records.
			/*service.getPerson().forEach(per -> {
				System.out.println(per);
				Set<PhoneNumber> set = per.getPhoneNos();
				set.forEach(System.out::println);
			});*/
			/*service.getPerson().forEach(person -> {
				System.out.println("parent -> " + person);
				Set<PhoneNumber> children = person.getPhoneNos();
			//				for (PhoneNumber child : children)
			//					System.out.println("child -> " + child);
				children.forEach(phoneNumber -> {
					System.out.println("child -> " + phoneNumber);
				});
			});*/

			// 7. Get PhoneNumber record.
//			PhoneNumber ph = service.getPhoneNumber(1004);
//			System.out.println(ph + "\n" + ph.getPerson());
//			System.out.println("child -> " + ph);
//			System.out.println("parent -> " + ph.getPerson());

			// 8. Get all PhoneNumber records.
			/*service.getPhoneNumber().forEach(ph -> {
							System.out.println(ph + "\n" + ph.getPerson());
			//				System.out.println(ph);
			//				System.out.println(ph.getPerson());
			//				System.out.println(ph.getPerson().getPname());
			});*/
//			service.getPhoneNumber().forEach(System.out::println);

			// 9. Get all PhoneNumber records (Lazy Loading of Person).
//			service.getAllPhoneNumbersLazyPersons();

			// 10. Delete Person by id.
//			System.out.println(service.deletePersonById(3052));
//			service.deletePersonById(3053);

			// 11. Delete all Person records.
//			System.out.println(service.deletePerson());

//			System.out.println(service.deleteAllPhoneNumbersOfPerson(52));

//			System.out.println(service.deletePhoneNumbersOfPerson(1, Set.of(2222222222L, 3333333333L)));

			// 12. Delete PhoneNumber by regNo.
//			System.out.println(service.deletePhoneNumberByRegNo(1021));

			// 13. Delete all PhoneNumber records.
//			System.out.println(service.deletePhoneNumber());

		} catch (DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("----------dae----------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------e----------");
		}
	}// run(-)

}// class
