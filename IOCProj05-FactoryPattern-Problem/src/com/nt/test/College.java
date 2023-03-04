package com.nt.test;

import com.nt.comp.Food;
import com.nt.comp.Student;

public class College {

	public static void main(String[] args) {
		Food food = null;
		Student stud = null;
		// create Dependent class object
		food = new Food();
		// create Target class object
		stud = new Student(food);
		// invoke business method
		stud.work();
	}// main

}// class
