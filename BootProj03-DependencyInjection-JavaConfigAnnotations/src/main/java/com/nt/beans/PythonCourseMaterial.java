package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("python")
public final class PythonCourseMaterial implements ICourseMaterial {

	public PythonCourseMaterial() {
		System.out.println("PythonCourseMaterial : 0-param constructor");
	}

	@Override
	public String getContent() {
		System.out.println("PythonCourseMaterial : getContent()");
		return "1. OOPs, 2. FileHandling, 3. RegularExpressions, 4. CollectionsFramework";
	}

	@Override
	public double getPrice() {
		System.out.println("PythonCourseMaterial : getPrice()");
		return 500;
	}

}
