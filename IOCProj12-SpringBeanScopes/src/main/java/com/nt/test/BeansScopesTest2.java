package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;

public class BeansScopesTest2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
		WishMessageGenerator w = null;
		
		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get target bean
        //w = ctx.getBean("wmg1", WishMessageGenerator.class);
		

		// close ioc container
		ctx.close();
	}
}
