package com.nt.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component(value = "std")
public final class Student {

//	@Autowired
//	@Inject
//	@Named("java")
//	@Named("courseId")
//	@Qualifier("java")
//	@Qualifier("courseId")
//	@Resource(name = "java")
	@Resource(name = "courseId")
	private ICourseMaterial material;

	public Student() {
		System.out.println("Student : 0-param constructor");
	}

	public void interviewPreparation(String interview) {
		System.out.println("Student : interviewPreparation(-) started");
		String content = null;
		double price = 0;

		// get content of course material
		content = material.getContent();

		// get price of course material
		price = material.getPrice();

		System.out.println("Student started preparation for " + interview + " interview");
		System.out.println("Student bought material which costs ₹" + price + "/-");
		System.out.println("Student started reading contents : " + content);
		System.out.println("Student completed preparation for " + interview + " interview");
		System.out.println("Student : interviewPreparation(-) ended");
	}

}
