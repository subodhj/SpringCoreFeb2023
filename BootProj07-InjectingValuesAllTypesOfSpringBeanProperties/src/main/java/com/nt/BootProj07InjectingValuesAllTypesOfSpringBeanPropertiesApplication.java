package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.model.Employee;

@SpringBootApplication
public class BootProj07InjectingValuesAllTypesOfSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Employee employee = null;

		// Create IOC Container.
		ctx = SpringApplication.run(BootProj07InjectingValuesAllTypesOfSpringBeanPropertiesApplication.class, args);

		// Get Spring Bean class object.
		employee = ctx.getBean("emp", Employee.class);

		// Display Employee details.
		System.out.println(employee);

		// Close IOC Container.
		((AbstractApplicationContext) ctx).close();
	}

}
