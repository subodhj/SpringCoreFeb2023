package com.nt.beans;

public class Employee {

	private int eno;
	private String ename;
	private String desig;
	private double salary;

	public Employee() {
		System.out.println("Employee : 0-param constructor");
	}

	public void setEno(int eno) {
		System.out.println("Employee.setEno()");
		this.eno = eno;
	}

	public void setEname(String ename) {
		System.out.println("Employee.setEname()");
		this.ename = ename;
	}

	public void setDesig(String desig) {
		System.out.println("Employee.setDesig()");
		this.desig = desig;
	}

	public void setSalary(double salary) {
		System.out.println("Employee.setSalary()");
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", desig=" + desig + ", salary=" + salary + "]";
	}

}// class
