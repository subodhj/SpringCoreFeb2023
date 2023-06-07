package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {

	String registerEmployee(Employee doc);

	List<Employee> getEmployee();

}
