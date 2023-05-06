package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.Student;

@SpringBootApplication
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
public class BootProj03DependencyInjectionJavaConfigAnnotationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Student student = null;

		// get IOC container
		ctx = SpringApplication.run(BootProj03DependencyInjectionJavaConfigAnnotationsApplication.class, args);
	
		System.out.println(ctx.getClass());

		// get target bean class object
		student = ctx.getBean("std", Student.class);

		// invoke b.logic
		student.interviewPreparation("TCS");

		// close ioc container
		((ConfigurableApplicationContext) ctx).close();
	}

}
