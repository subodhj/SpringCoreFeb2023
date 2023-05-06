package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("vv")
public class VoterVerifier implements InitializingBean, DisposableBean {

	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private int age;
	private Date verificationDate;

	public VoterVerifier() {
		System.out.println("VoterVerifier : 0-param constructor");
	}

	public void setName(String name) {
		System.out.println("VoterVerifier : setName(-)");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("VoterVerifier : setAge(-)");
		this.age = age;
	}

	@PostConstruct
	public void ourInit() {
		System.out.println("VoterVerifier : ourInit()");
		// initializing bean property that is not participating in injection
		// assign current date
		verificationDate = new Date();
		// validation
		if (age < 0 || age > 100)
			throw new IllegalArgumentException("age must be between 0 to 100");
		else if (name == null)
			throw new IllegalArgumentException("name must not be null");
	}

	@PreDestroy
	public void ourDestroy() {
		System.out.println("VoterVerifier : ourDestroy()");
		// nullifying bean properties
		name = null;
		age = 0;
		verificationDate = null;
		System.out.println(name + " " + age + " " + verificationDate);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("VoterVerifier : afterPropertiesSet()");
		// initializing bean property that is not participating in injection
		// assign current date
		verificationDate = new Date();
		// validation
		if (age < 0 || age > 100)
			throw new IllegalArgumentException("age must be between 0 to 100");
		else if (name == null)
			throw new IllegalArgumentException("name must not be null");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("VoterVerifier : destroy()");
		// nullifying bean properties
		name = null;
		age = 0;
		verificationDate = null;
		System.out.println(name + " " + age + " " + verificationDate);
	}

	public void myInit() {
		System.out.println("VoterVerifier : myInit()");
		// initializing bean property that is not participating in injection
		// assign current date
		verificationDate = new Date();
		// validation
		if (age < 0 || age > 100)
			throw new IllegalArgumentException("age must be between 0 to 100");
		else if (name == null)
			throw new IllegalArgumentException("name must not be null");
	}

	public void myDestroy() {
		System.out.println("VoterVerifier : myDestroy()");
		// nullifying bean properties
		name = null;
		age = 0;
		verificationDate = null;
		System.out.println(name + " " + age + " " + verificationDate);
	}

	public String checkVoterEligibility() {
		System.out.println("VoterVerifier : checkVoterEligibility()");
		if (age < 18)
			return "Mr./Ms." + name + " you are not eligible to vote, wait for " + (18 - age) + " years.\n Verified on "
					+ verificationDate;
		else
			return "Mr./Ms." + name + " you are eligible to vote.\n Verified on " + verificationDate;
	}

}// class
