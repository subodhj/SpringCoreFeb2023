package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.repository.ICustomerRepo;

@Service("cmService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo customerRepo;

	@Override
	public List<Object[]> searchCustomerInfoByAddr(String addr) {
		return customerRepo.getCustomerInfoByAddr(addr);
	}

	/*@Override
	public List<Customer> searchCustomerInfoByAddr(String addr) {
		return customerRepo.getCustomerInfoByAddr(addr);
	}*/

	@Override
	public List<Object[]> searchCustomerByAddr(String addr) {
		return customerRepo.getCustomerByAddr(addr);
	}

	/*@Override
	public List<Customer> searchCustomerByAddr(String addr) {
		return customerRepo.getCustomerByAddr(addr);
	}*/

	@Override
	public List<Object[]> searchCustomerInfoByNameAndAddr(String name, String addr) {
		return customerRepo.getCustomerInfoByNameAndAddr(name, addr);
	}

	@Override
	public List<Object[]> searchCustomerInfoByNameOrAddr(String name, String addr) {
		return customerRepo.getCustomerInfoByNameOrAddr(name, addr);
	}

	@Override
	public List<Object[]> searchCustomerInfoByBillAmtRange(double minAmt, double maxAmt) {
		return customerRepo.getCustomerInfoByBillAmtRange(minAmt, maxAmt);
	}

	@Override
	public int findCustomerCountByBillAmtRange(double minAmt, double maxAmt) {
		return customerRepo.getCustomerCountByBillAmtRange(minAmt, maxAmt);
	}

	@Override
	public List<Customer> searchCustomerByAnyCharOfAddr(String charOfAddr) {
		return customerRepo.getCustomerByAnyCharOfAddr(charOfAddr);
	}

	@Override
	public List<Customer> fetchCustomerInAscOrderOfBillAmt() {
		return customerRepo.getCustomerInAscOrderOfBillAmt();
	}

	@Override
	public List<Customer> fetchCustomerInDescOrderOfBillAmt() {
		return customerRepo.getCustomerInDescOrderOfBillAmt();
	}

	@Override
	public List<Customer> searchCustomerHavingBillAmtAndNoPhoneNo() {
		return customerRepo.getCustomerHavingBillAmtAndNoPhoneNo();
	}

	@Override
	public int removeCustomerWithNoBillAmt() {
		return customerRepo.deleteCustomerWithNoBillAmt();
	}
	
	@Override
	public boolean checkCustomerExistsInBillAmtRange(double minAmt, double maxAmt) {
		return customerRepo.doesCustomerExistInBillAmtRange(minAmt, maxAmt);
	}

}// class
