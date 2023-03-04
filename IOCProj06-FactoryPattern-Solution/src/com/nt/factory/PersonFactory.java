package com.nt.factory;

import com.nt.comp.Employee;
import com.nt.comp.Food;
import com.nt.comp.Person;
import com.nt.comp.Student;

public class PersonFactory {

	public static Person getPerson(String type) {
		if (type.equalsIgnoreCase("emp"))
			return new Employee(new Food());
		else if (type.equalsIgnoreCase("stud"))
			return new Student(new Food());
		else
			throw new IllegalArgumentException("invalid person type. must be 'emp' or 'stud'");
	}// getPerson(-)

}// class
