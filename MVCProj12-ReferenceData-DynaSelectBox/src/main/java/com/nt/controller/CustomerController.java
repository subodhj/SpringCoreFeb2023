package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Customer;
import com.nt.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/")
	public String displayCustomerFormPage(@ModelAttribute("cust") Customer customer) {
		// Return LVN.
		return "customer_registration";
	}

	@PostMapping("/customer_register")
	public String processCustomerData(Map<String, Object> map, @ModelAttribute("cust") Customer customer) {
		return "result";
	}

	@ModelAttribute("countriesList")
	public Set<String> populateCountries() {
		return service.getCountries();
	}

	@ModelAttribute("languagesList")
	public Set<String> populateLanguages() {
		return service.getLanguages();
	}

	@ModelAttribute("hobbiesList")
	public Set<String> populateHobbies() {
		return service.getHobbies();
	}

	@PostMapping("/states")
	public String populateStates(@RequestParam("country") String country, Map<String, Object> map,
			@ModelAttribute("cust") Customer customer) {
		List<String> statesList = null;
		// Use Service class method to get states from properties file.
//		statesList = service.getStates(country);
		// Use Service class method to get states from Database.
		statesList = service.searchStates(country);
		// Keep result as Model attribute.
		map.put("statesList", statesList);
		// Redirect request to /customer_registration.
//		return "redirect:customer_registration";
		// Return LVN.
		return "customer_registration";
	}

}// class
