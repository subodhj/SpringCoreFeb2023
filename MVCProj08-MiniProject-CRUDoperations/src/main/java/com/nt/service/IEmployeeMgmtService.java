package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	List<Employee> getAllEmployees();

	String insertEmployee(Employee emp);

	String updateEmployee(Employee emp);

	Employee getEmployee(int empno);

	String removeEmployee(int empno);

}
