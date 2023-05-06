package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer implements ApplicationContextAware {

	private String batId;
	private ApplicationContext ctx;

	/*public Cricketer() {
		System.out.println("Cricketer : 0-param constructor");
	}*/

	public Cricketer(String batId) {
		System.out.println("Cricketer : 1-param constructor " + batId);
		this.batId = batId;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer : setApplicationContext(-)");
		this.ctx = ctx;
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
		CricketBat cBat = null;
		int runs = 0;
		// get dependent bean class object
//		cBat = ctx.getBean("bat", CricketBat.class);
		cBat = ctx.getBean(batId, CricketBat.class);
		// invoke b.logic
		runs = cBat.scoreRuns();
		System.out.println("Cricketer is batting & his current score is : " + runs);
		// close IOC container
		((AbstractApplicationContext) ctx).close();
	}

}// class
