package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Robot;

public class RequiredAnnoTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Robot robot = null;
		Robot robot2 = null;
		Robot robot3 = null;
		// create ioc container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get target bean
		robot = ctx.getBean("rt", Robot.class);		
		System.out.println(robot);

//		robot2 = ctx.getBean("com.nt.beans.Robot", Robot.class);
		/*		robot2 = ctx.getBean("com.nt.beans.Robot#0", Robot.class);
				System.out.println(robot2);
				
				robot3 = ctx.getBean("com.nt.beans.Robot#1", Robot.class);
				System.out.println(robot3);*/
		
		// close container
		((AbstractApplicationContext) ctx).close();
	}
}
