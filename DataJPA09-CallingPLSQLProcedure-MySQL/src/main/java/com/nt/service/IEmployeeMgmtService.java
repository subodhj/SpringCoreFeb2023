package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {

	List<Employee> searchEmpsByDesigs(String desig1, String desig2);

}
