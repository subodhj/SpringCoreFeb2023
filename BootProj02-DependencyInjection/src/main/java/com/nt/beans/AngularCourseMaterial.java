package com.nt.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("angular")
@Primary
public final class AngularCourseMaterial implements ICourseMaterial {

	public AngularCourseMaterial() {
		System.out.println("AngularCourseMaterial : 0-param constructor");
	}

	@Override
	public String getContent() {
		System.out.println("AngularCourseMaterial : getContent()");
		return "1. Basics, 2. Expressions, 3. Filters, 4. Directives";
	}

	@Override
	public double getPrice() {
		System.out.println("AngularCourseMaterial : getPrice()");
		return 600;
	}

}
