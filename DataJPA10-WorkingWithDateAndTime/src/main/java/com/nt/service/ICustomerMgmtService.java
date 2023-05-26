package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {

	String registerCustomer(Customer customer);

	List<Customer> getAllCustomers();

}
