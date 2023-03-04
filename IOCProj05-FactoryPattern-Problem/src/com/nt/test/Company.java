package com.nt.test;

import com.nt.comp.Employee;
import com.nt.comp.Food;

public class Company {

	public static void main(String[] args) {
		Food food = null;
		Employee emp = null;
		// create Dependent class object
		food = new Food();
		// create Target class object
		emp = new Employee(food);
		// invoke business method
		emp.work();
	}// main

}// class
