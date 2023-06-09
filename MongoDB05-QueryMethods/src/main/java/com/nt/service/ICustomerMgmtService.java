package com.nt.service;

import java.util.List;

import com.nt.document.Customer;

public interface ICustomerMgmtService {

	List<Object[]> searchCustomerInfoByAddr(String addr);
//	List<Customer> searchCustomerInfoByAddr(String addr);

	List<Object[]> searchCustomerByAddr(String addr);
//	List<Customer> searchCustomerByAddr(String addr);

	List<Object[]> searchCustomerInfoByNameAndAddr(String name, String addr);

	List<Object[]> searchCustomerInfoByNameOrAddr(String name, String addr);

	List<Object[]> searchCustomerInfoByBillAmtRange(double minAmt, double maxAmt);

	int findCustomerCountByBillAmtRange(double minAmt, double maxAmt);

	List<Customer> searchCustomerByAnyCharOfAddr(String charOfAddr);

	List<Customer> fetchCustomerInAscOrderOfBillAmt();

	List<Customer> fetchCustomerInDescOrderOfBillAmt();

	List<Customer> searchCustomerHavingBillAmtAndNoPhoneNo();

	int removeCustomerWithNoBillAmt();

	boolean checkCustomerExistsInBillAmtRange(double minAmt, double maxAmt);

}
