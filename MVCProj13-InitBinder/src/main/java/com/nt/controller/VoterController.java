package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Voter;
import com.nt.service.IVoterMgmtService;

@Controller
public class VoterController {

	@Autowired
	private IVoterMgmtService voterService;

	@GetMapping("/")
	public String displayHomePage() {
		// Return LVN.
		return "home";
	}

	@GetMapping("/register_voter")
	public String displayVoterRegistrationPage(@ModelAttribute Voter voter) {
		// Return LVN.
		return "voter_registration";
	}

	@PostMapping("/register_voter")
	public String registerVoter(Map<String, Object> model, @ModelAttribute Voter voter) {
		int result = 0;
		// Use Service.
		result = voterService.registerVoter(voter);
		// Add result to
		model.put("voterInfo", result);
		// return LVN.
		return "result";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mmm-yyyy");
		CustomDateEditor cde = new CustomDateEditor(sdf, false);
		binder.registerCustomEditor(Date.class, cde);
	}

}// class
