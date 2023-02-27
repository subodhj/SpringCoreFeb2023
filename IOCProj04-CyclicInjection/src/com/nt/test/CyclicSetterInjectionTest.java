package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.A;

public class CyclicSetterInjectionTest {

	public static void main(String[] args) {

//		BeanFactory factory = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		A a = null;

		// create ioc container
//		factory = new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));

		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");

		// get target class object
		a = (A) factory.getBean("a1");

		// display the object
		System.out.println(a);

	}

}
