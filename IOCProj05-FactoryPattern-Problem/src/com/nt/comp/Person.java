package com.nt.comp;

public abstract class Person {

	private long aadharNo;
	private String name;

	public Person() {
		System.out.println("Person : 0-param constructor");
	}

	public abstract void work();

}
