package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface ICustomerService {
	
	String saveCustomer(CustomerDTO customerDTO) throws Exception;

}
