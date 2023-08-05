package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empMgmtService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll(Sort.by(Order.asc("deptno")));
	}

	@Override
	public String insertEmployee(Employee emp) {
		return "Employee Saved with Id: " + empRepo.save(emp).getEmpno();
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Updated Employee with Id: " + empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployee(int empno) {
		// Use Repository to get required record.
		Optional<Employee> opt = empRepo.findById(empno);
		// Return Employee object.
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public String removeEmployee(int empno) {
		// Use Repository to delete required record.
		empRepo.deleteById(empno);
		return "Deleted Employee with Id: " + empno;
	}

	@Override
	public Page<Employee> getEmployeeByPage(Pageable pageable) {
		// Use Repository to get required records per page.
		return empRepo.findAll(pageable);
	}

}// class
