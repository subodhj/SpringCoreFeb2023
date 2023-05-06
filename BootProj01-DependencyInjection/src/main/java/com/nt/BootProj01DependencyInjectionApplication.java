package com.nt;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

//	@Bean(name = "ldt")
	@Bean
	@Scope("prototype")
//	@Primary
	LocalDateTime getLocalDateTime() {
		System.out.println("BootProj01DependencyInjectionApplication : getLocalDateTime()");
		return LocalDateTime.now();
	}
	
	@Bean(name = "ldt1")
	@Scope("prototype")
	LocalDateTime getLocalDateTime1() {
		System.out.println("BootProj01DependencyInjectionApplication : getLocalDateTime1()");
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		WishMessageGenerator generator = null;
		String result = null;
		// get IOC container
		ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		System.out.println(ctx.getClass());
		// get target class object
//		generator = ctx.getBean("wmg", WishMessageGenerator.class);
//		generator = ctx.getBean("wishMessageGenerator", WishMessageGenerator.class);
		LocalDateTime date = ctx.getBean("getLocalDateTime", LocalDateTime.class);
		// invoke b.logic
//		result = generator.generateMessage("Sri Rama");
		// display the result
//		System.out.println(result);
		System.out.println(ctx.getBeanDefinitionCount());
//		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		String[] beanNames = ctx.getBeanDefinitionNames();
		int count =0;
		for(int i=0;i<beanNames.length;i++) {
			count=count+1;
//			count+=count; //wrong
//			count+=1;
//			count++;
//			count = count++; //wrong
		}
		System.out.println(count);
		// close ioc container
		((ConfigurableApplicationContext) ctx).close();
	}

}
