package com.nt.test;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		Scanner scan = null;
		CustomerVO customerVO = null;
		ClassPathXmlApplicationContext ctx = null;
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
			ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
			// get controller class obj
			controller = ctx.getBean("ctrl", MainController.class);
			// invoke controller class method
			result = controller.processCustomer(customerVO);
			// display the result
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem. Try Again.");
		}
		
		
		
//		System.out.println(System.getProperties());
		/*Properties sysProps = System.getProperties();
		Set<Object> keys= sysProps.keySet();
		for(Object key : keys) {
			System.out.println(key + " = "+sysProps.getProperty((String)key));
		}*/
		System.out.println(System.getProperty("user.name"));
		Environment env = ctx.getEnvironment();
		System.out.println(env.toString());
		System.out.println(env.getClass()+" "+env.getProperty("user.name")+" "+env.getProperty("os.name"));
		System.out.println(env.getProperty("Path"));
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println(ctx.getBeanDefinitionCount());
		
		//close ioc container
				ctx.close();

	}// main(-)

}// class
