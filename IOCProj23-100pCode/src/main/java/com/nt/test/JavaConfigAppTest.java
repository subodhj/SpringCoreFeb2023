package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class JavaConfigAppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = null;
		WishMessageGenerator wmg = null;

		// create IOC container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// get target bean class object
		wmg = ctx.getBean("wmg", WishMessageGenerator.class);
		// invoke b.logic
		System.out.println(wmg.generateMessage("Sri Rama"));
		// close ioc container
		ctx.close();

	}

}
