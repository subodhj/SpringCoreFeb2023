package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeMgmtService service;

	@Autowired
	private EmployeeValidator validator;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	/*@GetMapping("/emp_report")
	public String showEmployeeDetails(Map<String, Object> map) {
		// Use service to get all records from emp table.
		List<Employee> empsList = service.getAllEmployees();
		// Keep results as model attribute.
		map.put("empsList", empsList);
		// Return LVN.
		return "employee_report";
	}*/

	@GetMapping("/emp_report")
	public String showEmployeeDetails(
			@PageableDefault(page = 0, size = 3, sort = "empno", direction = Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		// Use service to get all records from emp table.
		Page<Employee> page = service.getEmployeeByPage(pageable);
		// Keep results as model attribute.
		map.put("page", page);
		// Return LVN.
		return "employee_report";
	}

	@GetMapping("/insertEmp")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		// Return LVN.
		return "add_employee";
	}

	/*@PostMapping("/insertEmp")
	public String saveEmployee(RedirectAttributes ra, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		// Check whether Validator can validate the given Command class instance.
		if (validator.supports(emp.getClass())) {
			// Validate for errors.
			validator.validate(emp, errors);
			// Return LVN in case of errors.
			if (errors.hasErrors())
				return "add_employee";
		}
		// Check for application/b.logic errors.
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("Director")) {
			errors.rejectValue("job", "emp.job.restriction");
			return "add_employee";
		}*/

	@PostMapping("/insertEmp")
	public String saveEmployee(RedirectAttributes ra, @ModelAttribute("emp") Employee emp, BindingResult errors) {

//		if (emp.getVflag().equalsIgnoreCase("no")) {
		if (emp.getIsVerified() == false) {
			// Check whether Validator can validate the given Command class instance.
			if (validator.supports(emp.getClass())) {
				// Validate for errors.
				validator.validate(emp, errors);
				// Return LVN in case of errors.
				if (errors.hasErrors())
					return "add_employee";
			}
		}

		// Check for application/b.logic errors.
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("Director")) {
			errors.rejectValue("job", "emp.job.restriction");
			return "add_employee";
		}

		// Use Service to insert a record into emp table.
		String result = service.insertEmployee(emp);
		// Add result to RedirectAttributes.
		ra.addFlashAttribute("resultMsg", result);
		// Redirect request to /emp_report .
		return "redirect:emp_report";

	}

	/*@PostMapping("/insertEmp")
	public String saveEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		// Use Service to insert a record into emp table.
		String result = service.insertEmployee(emp);
		// Add result as Session attributes.
		ses.setAttribute("resultMsg", result);
		// Redirect request to /emp_report .
		return "redirect:emp_report";
	}*/

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
	public String editEmployee(RedirectAttributes ra, @ModelAttribute("emp") Employee emp, BindingResult errors) {
//		if (emp.getVflag().equalsIgnoreCase("no")) {
		if (emp.getIsVerified() == false) {
			// Check whether Validator validate the given Command class instance.
			if (validator.supports(emp.getClass())) {
				// Validate for errors.
				validator.validate(emp, errors);
				// Return LVN in case of errors.
				if (errors.hasErrors())
					return "modify_employee";
			}
		}
		// Check for application/b.logic errors.
		if (emp.getJob().equalsIgnoreCase("President") || emp.getJob().equalsIgnoreCase("Director")) {
			errors.rejectValue("job", "emp.job.restriction");
			return "modify_employee";
		}
		// Use Service to edit a record in emp table.
		String result = service.updateEmployee(emp);
		// Add result to RedirectAttributes.
		ra.addFlashAttribute("resultMsg", result);
		// Redirect request to /emp_report .
		return "redirect:emp_report";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmployee(RedirectAttributes ra, @RequestParam int empno) {
		// Use Service to delete record in emp table.
		String result = service.removeEmployee(empno);
		// Add result to RedirectAttributes.
		ra.addFlashAttribute("resultMsg", result);
		// Redirect request to /emp_report .
		return "redirect:emp_report";
	}

}// class
