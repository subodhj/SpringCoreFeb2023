package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/register")
	public String showRegistrationPage() {
		return "register";
	}

	@PostMapping("/register")
	public String registerEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		//Read and use form data from Model object & send to service class.
		System.out.println(emp);
		return "result";
	}
}
