package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.Cricketer;
import com.nt.config.AppConfig;

public class LookupMethodInjectionJavaConfigTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Cricketer cricketer = null;
		// create IOC container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("1st IOC container created in main(-) of client app");
		// get target bean class object
		cricketer = ctx.getBean("cric", Cricketer.class);
		System.out.println(cricketer.getClass() + " " + cricketer.getClass().getSuperclass());
		System.out.println(Arrays.toString(cricketer.getClass().getDeclaredMethods()));
		// invoke business methods
		cricketer.fielding();
		cricketer.bowling();
		cricketer.batting();
		// close IOC container
		((AbstractApplicationContext) ctx).close();
//		((ConfigurableApplicationContext) ctx).close();
	}// main(-)

}// class
