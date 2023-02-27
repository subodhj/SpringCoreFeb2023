package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.A;
import com.nt.beans.C;

public class CyclicConstructorInjectionTest {

	public static void main(String[] args) {

		BeanFactory factory = null;

		C c = null;

		// create ioc container
		factory = new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));

		// get target class object
		c = (C) factory.getBean("c1");

		// display the object
		System.out.println(c);

	}

}
