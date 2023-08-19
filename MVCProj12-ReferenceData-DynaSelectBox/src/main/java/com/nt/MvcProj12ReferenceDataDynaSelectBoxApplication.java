package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:com/nt/commons/states.properties")
public class MvcProj12ReferenceDataDynaSelectBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProj12ReferenceDataDynaSelectBoxApplication.class, args);
	}

}
