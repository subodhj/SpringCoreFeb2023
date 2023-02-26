package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		
		FileSystemResource resource = null;
		BeanFactory factory = null;
		Object obj1 = null;
		Object obj2 = null;
		WishMessageGenerator wishMG = null;
		String result = null;

		// hold and locate spring bean configuration file
		resource = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		
		// create ioc container
		factory = new XmlBeanFactory(resource);
		
		// get target class object
		obj1 = factory.getBean("wmg");
		obj2 = factory.getBean("wmg");
		
		// type casting
		wishMG = (WishMessageGenerator) obj1;
		
		// invoke business method
		result = wishMG.generateWishMessage();
		
		// display the result
		System.out.println(result);
		
		System.out.println(obj1.hashCode()+" "+obj2.hashCode());
		System.out.println("obj1 == obj2 ? "+(obj1 == obj2));
		

	}

}
