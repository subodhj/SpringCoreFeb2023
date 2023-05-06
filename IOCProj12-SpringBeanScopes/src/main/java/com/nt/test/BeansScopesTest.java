package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenerator;

public class BeansScopesTest {
	public static void main(String[] args) {
		Resource resource = null;
		BeanFactory factory = null;
		WishMessageGenerator w1 = null;
		WishMessageGenerator w2 = null;
		WishMessageGenerator w3 = null;
		WishMessageGenerator w4 = null;
		Printer printer1 = null;
		Printer printer2 = null;
		Printer printer3 = null;
		Printer printer4 = null;
		// locate and hold spring bean configuration file
		resource = new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		// create IOC container
		factory = new XmlBeanFactory(resource);
		// get target bean
		w1 = factory.getBean("wmg1", WishMessageGenerator.class);
		w2 = factory.getBean("wmg1", WishMessageGenerator.class);

		System.out.println(w1.hashCode() + " " + w2.hashCode());
		
		w3 = factory.getBean("wmg2", WishMessageGenerator.class);
		w4 = factory.getBean("wmg2", WishMessageGenerator.class);

		System.out.println(w3.hashCode() + " " + w4.hashCode());

		System.out.println("w1 == w3 ? " + (w1 == w3));
		
		printer1 = factory.getBean("p1", Printer.class);
		printer2 = factory.getBean("p1", Printer.class);

		System.out.println(printer1.hashCode() + " " + printer2.hashCode());
		
		printer3 = factory.getBean("p2", Printer.class);
		printer4 = factory.getBean("p2", Printer.class);
		
		System.out.println(printer3.hashCode() + " " + printer4.hashCode());
		
		System.out.println("printer1 == printer3 ? " + (printer1 == printer3));
	}
}
