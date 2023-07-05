package com.nt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataBindingController {

	/*@GetMapping("/")
	public String showHomePage() {
		return "home";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam int sno, @RequestParam String sname) {
		System.out.println("[sno: " + sno + ", sname: " + sname + "]");
		return "result";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam("no") int sno, @RequestParam("name") String sname) {
		System.out.println("[sno: " + sno + ", sname: " + sname + "]");
		return "result";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam("no") int sno, @RequestParam(required = false) String sname) {
		System.out.println("[sno: " + sno + ", sname: " + sname + "]");
		return "result";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam("no") int sno, @RequestParam(defaultValue = "Rama") String sname) {
		System.out.println("[sno: " + sno + ", sname: " + sname + "]");
		return "result";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(defaultValue = "101") int sno, @RequestParam(defaultValue = "Rama") String sname) {
		System.out.println("[sno: " + sno + ", sname: " + sname + "]");
		return "result";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(required = false) Integer sno, @RequestParam(defaultValue = "Rama") String sname) {
		System.out.println("[sno: " + sno + ", sname: " + sname + "]");
		return "result";
	}*/

	/*@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(required = false) Integer no,
			@RequestParam(defaultValue = "Rama") String[] name, @RequestParam("name") Set<String> sname) {
		System.out.println("[ sno: " + no + ", sname: " + Arrays.toString(name) + ", sname" + sname + " ]");
		return "result";
	}*/

	@GetMapping("/data")
	public String bindData(Map<String, Object> map, @RequestParam(required = false) Integer no,
			@RequestParam(defaultValue = "Rama") String name) {
		System.out.println("[ sno: " + no + ", sname: " + name + " ]");
		return "result";
	}

}
