package com.nt.comp;

public class Employee extends Person {

	private String desig;
	private double salary;
	private Food food;

	public Employee(Food food) {
		System.out.println("Employee : 1-param constructor");
		this.food = food;
	}

	@Override
	public void work() {
		System.out.println("Employing is doing software development by " + food);
	}

}
