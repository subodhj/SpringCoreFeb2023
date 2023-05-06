package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("java")
public final class JavaCourseMaterial implements ICourseMaterial {

	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial : 0-param constructor");
	}

	@Override
	public String getContent() {
		System.out.println("JavaCourseMaterial : getContent()");
		return "1. OOPs, 2. ExceptionHandling, 3. MultiThreading, 4. CollectionsFramework";
	}

	@Override
	public double getPrice() {
		System.out.println("JavaCourseMaterial : getPrice()");
		return 400;
	}

}
