package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		Flipkart flipkart = null;
		String result = null;

		// create ioc container
		factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");

		// get target class obj
		flipkart = factory.getBean("fpkt", Flipkart.class);

		// invoke business method
		result = flipkart.shop(new String[] { "Shoes", "Trouser", "Shirt" }, new float[] { 4000f, 5000f, 2000f });

		// display the result
		System.out.println(result);
	}

}
