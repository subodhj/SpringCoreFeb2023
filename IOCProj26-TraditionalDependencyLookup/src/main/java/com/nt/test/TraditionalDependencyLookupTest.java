package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Cricketer;

public class TraditionalDependencyLookupTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Cricketer cricketer = null;
		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("1st IOC container created in main(-) of client app");
		// get target bean class object
		cricketer = ctx.getBean("cric", Cricketer.class);
		// invoke business methods
		cricketer.fielding();
		cricketer.bowling();
		cricketer.batting();
		// close IOC container
		((AbstractApplicationContext) ctx).close();
	}// main(-)

}// class
