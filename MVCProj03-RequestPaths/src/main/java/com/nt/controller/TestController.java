package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	// 1. Request Path of Handle Method must start with / and is case-sensitive.

	/*@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@RequestMapping("/report")
	public String showReportPage1(Map<String, Object> map) {
		System.out.println("TestController : showReportPage1(-)");
		return "report1";
	}
	
	@RequestMapping("/REPORT")
	public String showReportPage2(Map<String, Object> map) {
		System.out.println("TestController : showReportPage2(-)");
		return "report2";
	}*/

	// 2. Multiple Handle Method can have the same Request Path
	// but with different Request Method or Mode.

	/*@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	//	@RequestMapping(value = "/report", method = RequestMethod.GET)
	@GetMapping("/report")
	public String showReportPage1(Map<String, Object> map) {
		System.out.println("TestController : showReportPage1(-)");
		return "report1";
	}
	
	//	@RequestMapping(value = "/report", method = RequestMethod.POST)
	@PostMapping("/report")
	public String showReportPage2(Map<String, Object> map) {
		System.out.println("TestController : showReportPage2(-)");
		return "report2";
	}*/

	// 3. Single Handler Method can have multiple Request Paths.

	/*@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping(value = { "/report1", "/report2", "/report3" })
	public String showReportPage1(Map<String, Object> map) {
		System.out.println("TestController : showReportPage1(-)");
		return "report1";
	}*/

	// 4. @RequestMapping annotation without Request Path will have / as Request
	// Path.

	// @RequestMapping("/")
	/*@RequestMapping
	public String showHomePage() {
		return "home";
	}*/

	// 5. Request Path & Request Mode together must be unique with in a Controller
	// class.

	/*@RequestMapping("/report")
	public String showHomePage1() {
		System.out.println("TestController : showHomePage1()");
		return "home";
	}
	
	@RequestMapping("/report")
	public String showHomePage2() {
		System.out.println("TestController : showHomePage2()");
		return "home";
	}*/

	/*@RequestMapping
	public String showHomePage1() {
		System.out.println("TestController : showHomePage1()");
		return "home";
	}
	
	@RequestMapping
	public String showHomePage2() {
		System.out.println("TestController : showHomePage2()");
		return "home";
	}*/

	// 6. In case, 2 Controller classes, have have handle methods,
	// whose Request Path & Request Mode are same, then,
	// they can be differentiated by the Controller class level Global Request Path.

	/*@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}*/

	@GetMapping("/report1")
	public String showReportPage1(Map<String, Object> map) {
		System.out.println("TestController : showReportPage1(-)");
		return "report1";
	}

}// class
