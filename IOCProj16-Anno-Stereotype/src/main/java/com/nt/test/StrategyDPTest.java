package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Flipkart flipkart = null;
		String result = null;

		// create ioc container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get target class obj
		flipkart = ctx.getBean("fpkt", Flipkart.class);
//		flipkart = ctx.getBean("flipkart", Flipkart.class);

		// invoke business method
		result = flipkart.shop(new String[] { "Shoes", "Trouser", "Shirt" }, new float[] { 4000f, 5000f, 2000f });

		// display the result
		System.out.println(result);

		// close ioc container
		((AbstractApplicationContext) ctx).close();
	}

}
