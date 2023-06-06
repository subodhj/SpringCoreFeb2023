package com.nt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {

	List<Customer> findByBillAmtBetweenAndPhoneNoIsNotNull(double startAmt, double endAmt);

	List<Customer> findByCaddIn(String... addresses);

}
