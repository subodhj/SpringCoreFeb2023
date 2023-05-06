package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.beans.BillGenerator;

@SpringBootApplication
@PropertySource("com/nt/commons/inputs.properties")
public class BootProj05ValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BillGenerator generator = null;

		// get IOC Container
		ctx = SpringApplication.run(BootProj05ValueAnnotationApplication.class, args);

		// get spring bean object
		generator = ctx.getBean("bill", BillGenerator.class);

		System.out.println(generator);

		// close IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
