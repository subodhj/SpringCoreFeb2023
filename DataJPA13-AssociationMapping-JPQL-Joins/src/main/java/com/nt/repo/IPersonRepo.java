package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

//	@Query("SELECT p.pid, p.pname, p.padd, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p INNER JOIN p.phoneNos ph ")
//	@Query("SELECT p.pid, p.pname, p.padd, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p RIGHT JOIN p.phoneNos ph ")
//	@Query("SELECT p.pid, p.pname, p.padd, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p LEFT JOIN p.phoneNos ph ")
	@Query("SELECT p.pid, p.pname, p.padd, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p FULL JOIN p.phoneNos ph ")
	public List<Object[]> getPersonInfoUsingJoins();

}
