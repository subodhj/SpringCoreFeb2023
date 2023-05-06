package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerService;
import com.nt.vo.CustomerVO;

public class MainController {

	private ICustomerService customerService;

	public MainController(ICustomerService customerService) {
		System.out.println("MainController : 1-param constructor");
		this.customerService = customerService;
	}

	public String processCustomer(CustomerVO customerVO) throws Exception {
		CustomerDTO customerDTO = null;
		String result = null;
		// prepare CustomerDTO object
		customerDTO = new CustomerDTO();
		customerDTO.setCustomerName(customerVO.getCustomerName());
		customerDTO.setCustomerAddress(customerVO.getCustomerAddress());
		customerDTO.setPrincipalAmount(Float.parseFloat(customerVO.getPrincipalAmount()));
		customerDTO.setRate(Float.parseFloat(customerVO.getRate()));
		customerDTO.setTime(Float.parseFloat(customerVO.getTime()));
		// invoke service method
		result = customerService.saveCustomer(customerDTO);
		return result;
	}// enterCustomer(-)

}// class
