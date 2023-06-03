package com.nt.service;

import java.util.List;
import java.util.Set;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IPersonMgmtService {

	String registerPerson(Person person);

	String registerPerson(List<Person> listPerson);

	String registerPhoneNumber(PhoneNumber phNo);

	String registerPhoneNumber(Iterable<PhoneNumber> phNos);

	String registerPhoneNumberForPerson(int pid,Set<PhoneNumber> phNos);

	Person getPerson(int pid);

	Iterable<Person> getPerson();

	PhoneNumber getPhoneNumber(long regNo);

	Iterable<PhoneNumber> getPhoneNumber();

	void getAllPhoneNumbersLazyPersons();

	String deletePersonById(int pid);
//	void deletePersonById(int pid);

	String deleteAllPhoneNumbersOfPerson(int pid);

	String deletePhoneNumbersOfPerson(int pid, Set<Long> phNos);

	String deletePerson();

	String deletePhoneNumberByRegNo(long regNo);

	String deletePhoneNumber();

}
