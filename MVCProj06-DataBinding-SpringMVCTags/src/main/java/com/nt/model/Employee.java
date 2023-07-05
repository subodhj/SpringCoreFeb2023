package com.nt.model;

import lombok.Data;

@Data
public class Employee {

	private Integer eno=1001;
	private String ename="Rama";
	private String desig="MD";
	private Double salary=50000.0;

	public Employee() {
		System.out.println("Employee : 0-param constructor");
	}

}
