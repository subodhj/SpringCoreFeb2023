package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {
	
//	@Query(value = "INSERT INTO OTM_PHONENUMBER VALUES(?,?,?,?)", nativeQuery = true)
//	int insertPhoneNumber(long phoneNo, String provider, String type, int personId);

}
