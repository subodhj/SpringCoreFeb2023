package com.nt.service;

import java.util.List;

import com.nt.document.Customer;

public interface ICustomerMgmtService {

	String registerCustomer(Customer document);

	List<Customer> getCustomer();

	String deleteCustomer(String id);

	String saveAllCustomers(Iterable<Customer> customers);

	List<Customer> getCustomersInSortingOrder(boolean asc, String... properties);

	List<Customer> fetchCustomersByInfo(Customer customer);

	List<Customer> fetchCustomersByInfoInSortOrder(Customer customer, boolean asc, String... properties);

	List<Customer> searchCustomersHavingPhoneNoByBillAmtRange(double startAmt, double endAmt);

	List<Customer> searchCustomersByAddress(String... addresses);

}
