package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterVerifier;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		VoterVerifier voter = null;
		String result = null;
		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get spring bean object
		voter = ctx.getBean("vv", VoterVerifier.class);
		try {
			// invoke b.logic
			result = voter.checkVoterEligibility();
			// display the result
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// close ioc container
		((AbstractApplicationContext) ctx).close();
	}

}
