package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Company1;
import com.nt.beans.Company2;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Company1 comp1 = null;
		Company2 comp2 = null;

		// create IOC Container
		ctx = SpringApplication.run(BootProj06ConfigurationPropertiesAnnotationApplication.class, args);

		// get spring bean object
		comp1 = ctx.getBean("company1", Company1.class);

		System.out.println(comp1);

		System.out.println("------------------------------------------------");

		comp2 = ctx.getBean("company2", Company2.class);

		System.out.println(comp2);

		// close IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
