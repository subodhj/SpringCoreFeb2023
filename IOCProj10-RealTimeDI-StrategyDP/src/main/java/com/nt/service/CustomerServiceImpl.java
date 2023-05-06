package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;

public final class CustomerServiceImpl implements ICustomerService {

	private ICustomerDAO customerDAO;

	public CustomerServiceImpl(ICustomerDAO customerDAO) {
		System.out.println("CustomerServiceImpl : 1-param constructor");
		this.customerDAO = customerDAO;
	}

	@Override
	public String saveCustomer(CustomerDTO customerDTO) throws Exception {
		CustomerBO customerBO = null;
		float interest = 0.0f;
		int count = 0;
		// calculate simple interest amount
		interest = (customerDTO.getPrincipalAmount() * customerDTO.getTime() * customerDTO.getRate()) / 100.0f;
		// prepare CustomerBO
		customerBO = new CustomerBO();
		customerBO.setCustomerName(customerDTO.getCustomerName());
		customerBO.setCustomerAddress(customerDTO.getCustomerAddress());
		customerBO.setPrincipalAmount(customerDTO.getPrincipalAmount());
		customerBO.setRate(customerDTO.getRate());
		customerBO.setTime(customerDTO.getTime());
		customerBO.setInterest(interest);
		// invoke dao method
		count = customerDAO.insertCustomer(customerBO);
		/*if (result == 0)
			return "Failed to insert customer details!";
		else
			return "Inserted customer details!";*/
		// ternary operator <condition> ? <success> : <failure>
		return count == 1 ? "Customer Registration Successful. \nSimple Interest Amt : " + interest
				: "Customer Registration Failed.";
	}// saveCustomer(-)

}// class
