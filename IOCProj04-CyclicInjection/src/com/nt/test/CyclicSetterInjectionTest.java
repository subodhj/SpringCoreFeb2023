package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.A;

public class CyclicSetterInjectionTest {

	public static void main(String[] args) {

		BeanFactory factory = null;

		A a = null;

		// create ioc container
		factory = new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));

		// get target class object
		a = (A) factory.getBean("a1");

		// display the object
		System.out.println(a);

	}

}
