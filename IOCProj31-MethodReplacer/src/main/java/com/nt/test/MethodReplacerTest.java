package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.SBILoan;

public class MethodReplacerTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		SBILoan sbiLoan = null;
		double interestRate = 0;
		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get target bean class obj
		sbiLoan = ctx.getBean("sbil", SBILoan.class);
		System.out.println(sbiLoan.getClass() + " " + sbiLoan.getClass().getSuperclass());
		// invoke b.logic
		interestRate = sbiLoan.calculateInterestRate(1000000, 2, 2);
		System.out.println("Rate of Interest : " + interestRate);
		// close ioc container
		((AbstractApplicationContext) ctx).close();
	}
}
