package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repo.EmployeeRepo;

@Service("emService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public String registerEmployee(Employee doc) {
		return "Employee registered with Id: " + empRepo.save(doc).getEno();
	}

}
