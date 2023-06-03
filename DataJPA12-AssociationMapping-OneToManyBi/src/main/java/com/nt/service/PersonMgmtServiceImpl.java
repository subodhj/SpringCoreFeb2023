package com.nt.service;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repo.IPersonRepo;
import com.nt.repo.IPhoneNumberRepo;

import jakarta.persistence.EntityManager;

@Service("pmService")
//@Transactional
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private EntityManager manager;

	@Autowired
	private IPhoneNumberRepo phoneNoRepo;

	@Override
	public String registerPerson(Person person) {
		int idVal = personRepo.save(person).getPid();
		return "Person record registered with ID: " + idVal;
	}

	@Override
	public String registerPerson(List<Person> listPerson) {
		personRepo.saveAll(listPerson);
		return listPerson.size() + " Person records registered.";
	}

	@Override
	public String registerPhoneNumber(PhoneNumber phNo) {
		long idVal = phoneNoRepo.save(phNo).getRegNo();
		return "PhoneNumber record registered with ID: " + idVal;
	}

	@Override
	public String registerPhoneNumber(Iterable<PhoneNumber> phNos) {
		phoneNoRepo.saveAll(phNos);
		return ((Set<PhoneNumber>) phNos).size() + " PhoneNumber records registered.";
	}

	/*@Override
	public String registerPhoneNumberForPerson(int pid, Set<PhoneNumber> phNos) {
		Person person = null;
		Optional<Person> optional = personRepo.findById(pid);
		if (optional.isPresent()) {
			person = optional.get();
			person.setPhoneNos(phNos);
			return phNos.size() + " Phone Numbers added to Person with Id: " + pid;
		}
		return "Person with Id: " + pid + "does not exist";
	}*/

	/*@Override
	public String registerPhoneNumberForPerson(int pid, Set<PhoneNumber> phNos) {
		Optional<Person> optional = personRepo.findById(pid);
		int count = 0;
		if (optional.isPresent()) {
			Person person = optional.get();
			Set<PhoneNumber> phs = person.getPhoneNos();
			for (int i = 0; i < phs.size(); i++) {
				for (PhoneNumber ph : phs) {
					int result = phoneNoRepo.insertPhoneNumber(ph.getPhoneNo(), ph.getProvider(), ph.getType(), pid);
					count = (result == 1) ? count + 1 : count;
				} // for-each
			} // for
		} // if
		return count + " Phone Numbers inserted for Person with ID: " + pid;
	}*/

	@Override
	public String registerPhoneNumberForPerson(int pid, Set<PhoneNumber> phNos) {
		Optional<Person> optional = personRepo.findById(pid);
		int totalCount = 0;
		if (optional.isPresent()) {
			PhoneNumber[] phArray = phNos.toArray(new PhoneNumber[0]);
			Session ses = manager.unwrap(Session.class);
			totalCount = ses.doReturningWork(con -> {
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO OTM_PHONENUMBER VALUES(SEQ_GEN1.NEXTVAL,?,?,?,?)");
				int count = 0;
				for (int i = 0; i < phArray.length; ++i) {
					ps.setLong(1, phArray[i].getPhoneNo());
					ps.setString(2, phArray[i].getProvider());
					ps.setString(3, phArray[i].getType());
					ps.setInt(4, pid);
					try {
						count = ps.executeUpdate() == 1 ? count + 1 : count;
					} catch (Exception e) {
						if (e.getMessage().contains("unique constraint"))
							System.out.println("PhoneNumber [" + phArray[i].getPhoneNo() + "] already exists.");
					}
				} // for
				return count;
			});
			return totalCount + " PhoneNumber records registered for Person with Id: " + pid;
		} // if
		return "Person with Id: " + pid + " doesnot exist.";
	}

	@Override
	public Person getPerson(int pid) {
		return personRepo.getReferenceById(pid);
	}

	@Override
	public Iterable<Person> getPerson() {
		return personRepo.findAll();
	}

	@Override
	public PhoneNumber getPhoneNumber(long regNo) {
		return phoneNoRepo.getReferenceById(regNo);
	}

	@Override
	public Iterable<PhoneNumber> getPhoneNumber() {
		return phoneNoRepo.findAll();
	}

	@Override
	public void getAllPhoneNumbersLazyPersons() {
		phoneNoRepo.findAll().forEach(ph -> {
			System.out.println("\n" + ph.getPerson().getPname() + "\n" + ph + "\n");
		});
	}

	/*@Override
	public String deletePersonById(int pid) {
			personRepo.deleteById(pid);
	//		Person person = personRepo.getReferenceById(pid);
	//		personRepo.delete(person);
		return "Deleted Person with Id: " + pid;
	}*/

	/*public void deletePersonById(int pid) {
		Optional<Person> optional = personRepo.findById(pid);
		optional.ifPresentOrElse(person -> {
			person.setPhoneNos(null);
			personRepo.delete(person);
			System.out.println("Deleted Person with Id: " + pid);
		}, () -> System.out.println("Not deleted Person with Id: " + pid));
	}*/

	@Override
	public String deletePersonById(int pid) {
		Optional<Person> optional = personRepo.findById(pid);
		if (optional.isPresent()) {
			personRepo.delete(optional.get());
			return "Deleted Person with Id: " + pid;
		}
		return "Person with Id: " + pid + "does not exist";
	}

	@Override
	public String deleteAllPhoneNumbersOfPerson(int pid) {
		Optional<Person> optional = personRepo.findById(pid);
		if (optional.isPresent()) {
			Person person = optional.get();
			Set<PhoneNumber> set = person.getPhoneNos();
			person.setPhoneNos(null);
			set.forEach(ph -> {
				ph.setPerson(null);
			});
			phoneNoRepo.deleteAll(set);
			return "Deleted " + set.size() + " PhoneNumbers of Person with Id: " + pid;
		} // if
		return "Not found Person with Id: " + pid;
	}

	@Override
	public String deletePhoneNumbersOfPerson(int pid, Set<Long> phNos) {
		Optional<Person> optional = personRepo.findById(pid);
		if (optional.isPresent()) {
//			int givenPhNosCount = 0;
//			int phNosCount = 0;
			/*if (phNos != null) {
				givenPhNosCount = phNos.size();
			}*/
			Person person = optional.get();
			Set<PhoneNumber> set = person.getPhoneNos();
			/*if (set != null) {
				phNosCount = set.size();
			}*/
//			if (phNosCount > givenPhNosCount) 
//				Long[] objPh=(Long[])phNos.toArray();
			Long[] objPh = phNos.toArray(new Long[0]);
			System.out.println(Arrays.toString(objPh));
			set.forEach(ph -> {
				long phNo = ph.getPhoneNo();
				for (int i = 0; i < objPh.length; ++i) {
					if (phNo == objPh[i]) {
//						deletePhoneNumberByRegNo(ph.getRegNo());
						ph.setPerson(null);
						phoneNoRepo.delete(ph);
						phoneNoRepo.delete(ph);
					} // if
				} // for
			});
			return phNos.size() + " Phone Numbers deleted from Person with Id: " + pid;
		}
		return "Person with Id: " + pid + " doesn't exist.";
	}

	@Override
	public String deletePerson() {
		personRepo.deleteAll();
		return "Deleted all Person records.";
	}

	@Override
	public String deletePhoneNumberByRegNo(long regNo) {
//		phoneNoRepo.deleteById(regNo);
		PhoneNumber ph = phoneNoRepo.getReferenceById(regNo);
		ph.setPerson(null);
		phoneNoRepo.delete(ph);
		return "Deleted PhoneNumber with RegNo: " + regNo;
	}

	@Override
	public String deletePhoneNumber() {
		phoneNoRepo.deleteAll();
		return "Deleted all PhoneNumber records.";
	}

}// service
