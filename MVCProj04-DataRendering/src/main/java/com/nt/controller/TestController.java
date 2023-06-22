package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class TestController {

	@GetMapping("/report1")
	public String showReportPage1(Map<String, Object> map) {
		// Add model attributes to ModelMap object.
		map.put("name", "Rama");
		map.put("age", 25);
		map.put("addrs", "Ayodhya");
		// Return the Logical View Name.
		return "show_report1";
	}

	@GetMapping("/report2")
	public String showReportPage2(Map<String, Object> map) {
		String[] nickNames = new String[] { "ramu", "ramaiah", "ram", "raghava" };
		Set<Long> contactNos = Set.of(9291256944L, 8801969944L, 9988284758L);
		List<String> courses = List.of("CoreJava", "AdvJava", "Spring");
		Map<String, Long> ids = Map.of("Aadhaar", 8387383783L, "PAN", 23478338188L, "VoterId", 46728278284L);
		// Add model attributes to ModelMap object.
		map.put("nickNames", nickNames);
		map.put("contactNos", contactNos);
		map.put("courses", courses);
		map.put("ids", ids);
		// Return the Logical View Name.
		return "show_report2";
	}

	@GetMapping("/report3")
	public String showReportPage3(Map<String, Object> map) {
		// Create List of Model object.
		List<Employee> empsList = List.of(new Employee(1001, "Rama", "Manager", 500000.0),
				new Employee(1002, "Krishna", "Clerk", 300000.0), new Employee(1003, "Shiva", "Accountant", 400000.0));
		// Add model attributes to ModelMap object.
		map.put("empsList", empsList);
		return "show_report3";
	}

	@GetMapping("/report4")
	public String showReportPage4(Map<String, Object> map) {
		// Create Model object.
		Employee emp = new Employee(2001, "Vishnu", "Manager", 500000.0);
		// Add model attribute to ModelMap object.
		map.put("emp", emp);
		return "show_report4";
	}

} // class
