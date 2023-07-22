package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

//@Controller
public class EmployeeController1 {

	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/emp_report")
	public String showEmployeeDetails(Map<String, Object> map) {
		// Use service to get all records from emp table.
		List<Employee> empsList = service.getAllEmployees();
		// Keep results as model attribute.
		map.put("empsList", empsList);
		// Return lvn.
		return "employee_report";
	}

	@GetMapping("/insertEmp")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		// Return LVN
		return "add_employee";
	}

	@PostMapping("/insertEmp")
	public String saveEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		// Use Service to insert a record into emp table.
		String result = service.insertEmployee(emp);
		// Use Service to get all records from emp table.
		List<Employee> empsList = service.getAllEmployees();
		// Add result to ModelAttribute.
		map.put("resultMsg", result);
		map.put("empsList", empsList);
		// Return LVN.
		return "employee_report";
	}

	@GetMapping("/editEmp")
	public String displayEditEmployeeForm(@ModelAttribute("emp") Employee emp, @RequestParam int empno) {
		// Use Service to get the required record details.
		Employee employee = service.getEmployee(empno);
		// Assign the Employee object with persistent data to ModelAttribute Employee
		// object.
		BeanUtils.copyProperties(employee, emp);
		return "modify_employee";
	}

	@PostMapping("/editEmp")
	public String editEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		// Use Service to edit a record in emp table.
		String result = service.updateEmployee(emp);
		// Use Service to get all records from emp table.
		List<Employee> empsList = service.getAllEmployees();
		// Add result to ModelAttribute.
		map.put("resultMsg", result);
		map.put("empsList", empsList);
		// Return LVN.
		return "employee_report";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmployee(Map<String, Object> map, @RequestParam int empno) {
		// Use Service to delete record in emp table.
		String result = service.removeEmployee(empno);
		// Use Service to get all records from emp table.
		List<Employee> empsList = service.getAllEmployees();
		// Add result to ModelAttribute.
		map.put("resultMsg", result);
		map.put("empsList", empsList);
		// Return LVN.
		return "employee_report";
	}

}// class
