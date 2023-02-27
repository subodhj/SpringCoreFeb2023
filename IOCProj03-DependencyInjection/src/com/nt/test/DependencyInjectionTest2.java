package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.Employee;
import com.nt.beans.Student;

public class DependencyInjectionTest2 {

	public static void main(String[] args) {

		FileSystemResource resource = null;
		BeanFactory factory = null;
		Employee emp = null;
		Student stud = null;

		// hold and locate spring bean configuration file
		resource = new FileSystemResource("src/com/nt/cfgs/applicationContext2.xml");

		// create ioc container
		factory = new XmlBeanFactory(resource);

		// get target class object
		emp = (Employee) factory.getBean("emp");
//		stud = (Student) factory.getBean("stud");

		// display the emp
		System.out.println(emp);
//		System.out.println(stud);

	}

}
