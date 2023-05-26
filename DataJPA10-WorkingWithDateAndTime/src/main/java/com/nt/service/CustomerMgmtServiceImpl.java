package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repo.ICustomerRepo;

@Service("cmService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(Customer customer) {
//		int idVal = 0;

		// Invoke Repository method.
//		idVal = repo.save(customer).getCustId();

//		return "Customer saved with Id: " + idVal;

		return "Customer saved with Id: " + repo.save(customer).getCustId();
	}

	@Override
	public List<Customer> getAllCustomers() {
//		List<Customer> list = null;

		// Invoke Repository method.
//		list = repo.findAll();

//		return list;

		return repo.findAll();
	}

}// class
