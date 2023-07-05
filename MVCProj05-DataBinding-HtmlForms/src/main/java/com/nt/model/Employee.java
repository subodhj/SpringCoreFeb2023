package com.nt.model;

import lombok.Data;

@Data
public class Employee {

	private Integer eno;
	private String ename;
	private String desig;
	private Double salary;

	public Employee() {
		System.out.println("Employee : 0-param constructor");
	}

}
