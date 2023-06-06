package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.repo.ICustomerRepo;

@Service("cmService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo customerRepo;

	@Override
	public String registerCustomer(Customer document) {
//		return "Customer doc saved with Id: " + customerRepo.insert(document).getId();
		return "Customer doc saved with Id: " + customerRepo.save(document).getId();
	}

	@Override
	public List<Customer> getCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public String deleteCustomer(String id) {
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent()) {
			customerRepo.delete(optional.get());
			return "Deleted Customer document with Id: " + id;
		}
		return " Customer document with id: " + id + " not found";
	}

	@Override
	public String saveAllCustomers(Iterable<Customer> customers) {
		List<Customer> customerList = customerRepo.saveAll(customers);
		return customerList.size() + " Customer documents saved.";
	}

	@Override
	public List<Customer> getCustomersInSortingOrder(boolean asc, String... properties) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		return customerRepo.findAll(sort);
	}

	@Override
	public List<Customer> fetchCustomersByInfo(Customer customer) {
		Example<Customer> example = Example.of(customer);
		return customerRepo.findAll(example);
	}

	@Override
	public List<Customer> fetchCustomersByInfoInSortOrder(Customer customer, boolean asc, String... properties) {
		return customerRepo.findAll(Example.of(customer), Sort.by(asc ? Direction.ASC : Direction.DESC, properties));
	}

	@Override
	public List<Customer> searchCustomersHavingPhoneNoByBillAmtRange(double startAmt, double endAmt) {
		return customerRepo.findByBillAmtBetweenAndPhoneNoIsNotNull(startAmt, endAmt);
	}
	
	@Override
	public List<Customer> searchCustomersByAddress(String... addresses) {
		return customerRepo.findByCaddIn(addresses);
	}

}// class