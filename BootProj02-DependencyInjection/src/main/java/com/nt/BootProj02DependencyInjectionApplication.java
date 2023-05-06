package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.Student;

@SpringBootApplication
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
public class BootProj02DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Student student = null;

		// get IOC container
		ctx = SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);

		// get target bean class object
		student = ctx.getBean("std", Student.class);

		// invoke b.logic
		student.interviewPreparation("TCS");

		// close ioc container
		((ConfigurableApplicationContext) ctx).close();
	}

}
