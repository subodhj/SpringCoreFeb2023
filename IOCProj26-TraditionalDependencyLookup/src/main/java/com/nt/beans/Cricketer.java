package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer {

	private String batId;

	/*public Cricketer() {
		System.out.println("Cricketer : 0-param constructor");
	}*/

	public Cricketer(String batId) {
		System.out.println("Cricketer : 1-param constructor " + batId);
		this.batId = batId;
	}

	public void fielding() {
		System.out.println("Cricketer is fielding");
	}

	public void bowling() {
		System.out.println("Cricketer is bowling");
	}

	public void keeping() {
		System.out.println("Cricketer is keeping");
	}

	public void batting() {
		System.out.println("Cricketer is batting");
		ApplicationContext ctx = null;
		CricketBat cBat = null;
		int runs = 0;
		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("2nd IOC container created in Cricketer.batting(-)");
		// get dependent bean class object
//		cBat = ctx.getBean("bat", CricketBat.class);
		cBat = ctx.getBean(batId, CricketBat.class);
		// invoke b.logic
		runs = cBat.scoreRuns();
		System.out.println("Cricketer is batting & his current score is : " + runs);
		// close IOC container
		((AbstractApplicationContext) ctx).close();
	}

}
