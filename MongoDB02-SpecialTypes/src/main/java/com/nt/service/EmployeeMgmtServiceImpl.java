package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("emService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public String registerEmployee(Employee doc) {
		return "Employee registered with Id: " + empRepo.save(doc).getEno();
	}

	@Override
	public List<Employee> getEmployee() {
		return empRepo.findAll();
	}

}
