package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		Scanner scan = null;
		CustomerVO customerVO = null;
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MainController controller = null;
		String result = null;

		// create Scanner class object
		scan = new Scanner(System.in);
		// create CustomerVO object
		customerVO = new CustomerVO();
		// read inputs from console and assign them to VO class object
		System.out.println("Enter Customer Name : ");
		customerVO.setCustomerName(scan.nextLine());
		System.out.println("Enter Customer Address : ");
		customerVO.setCustomerAddress(scan.nextLine());
		System.out.println("Enter Principal Amount : ");
		customerVO.setPrincipalAmount(scan.next());
		System.out.println("Enter Rate : ");
		customerVO.setRate(scan.next());
		System.out.println("Enter Time : ");
		customerVO.setTime(scan.next());

		try {
			// create IOC Container
			factory = new DefaultListableBeanFactory();
			// load spring bean cfg file
			reader = new XmlBeanDefinitionReader(factory);
			reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
			// get controller class obj
			controller = factory.getBean("ctrl", MainController.class);
			// invoke controller class method
			result = controller.processCustomer(customerVO);
			// display the result
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem. Try Again.");
		}

	}// main(-)

}// class
