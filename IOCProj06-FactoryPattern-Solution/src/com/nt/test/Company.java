package com.nt.test;

import com.nt.comp.Person;
import com.nt.factory.PersonFactory;

public class Company {

	public static void main(String[] args) {
		Person person = null;
		// get Target class object
		person = PersonFactory.getPerson("emp");
		// invoke business method
		person.work();
	}// main

}// class
