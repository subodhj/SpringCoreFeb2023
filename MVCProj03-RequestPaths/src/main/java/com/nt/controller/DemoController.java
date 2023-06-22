package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private ServletContext sc;

	@Autowired
	private ServletConfig cg;

//	@Autowired
//	private HttpSession ses;

	@GetMapping("/report1")
	public String showReportPage1(Map<String, Object> map, HttpSession ses) {
		System.out.println("DemoController : showReportPage1(-)");
		System.out.println("Context Path : " + sc.getContextPath());
		System.out.println("Logical Name of DispatcherServlet  : " + cg.getServletName());
		System.out.println("Session Id : " + ses.getId());
		return "report1";
	}

}// class
