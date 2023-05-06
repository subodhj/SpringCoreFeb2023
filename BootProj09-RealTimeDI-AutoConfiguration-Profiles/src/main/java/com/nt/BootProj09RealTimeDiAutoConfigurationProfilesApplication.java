package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

@SpringBootApplication
public class BootProj09RealTimeDiAutoConfigurationProfilesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		MainController controller = null;
		Scanner scan = null;
		int designNo = 0;
		String[] designations = null;
		List<EmployeeVO> listVO = null;

		// Programmatic approach of activating spring profile.
		SpringApplication application = new SpringApplication(
				BootProj09RealTimeDiAutoConfigurationProfilesApplication.class);
		application.setAdditionalProfiles("prod");
		ctx = application.run(args);

		// get IOC Container
//		ctx = SpringApplication.run(BootProj09RealTimeDiAutoConfigurationProfilesApplication.class, args);

		/*ConfigurableEnvironment env = (ConfigurableEnvironment) ctx.getEnvironment();
		env.addActiveProfile("dev");*/

		// get Main Controller
		controller = ctx.getBean("ctrl", MainController.class);

		// get inputs from end user
		scan = new Scanner(System.in);
		System.out.println("Enter Number of Designations Count: ");
		designNo = scan.nextInt();
		designations = new String[designNo];
		for (int i = 0; i < designNo; ++i) {
			System.out.println("Enter Designation-" + (i + 1) + " : ");
			designations[i] = scan.next();
		} // for

		try {
			// use controller
			listVO = controller.retriveEmpsByDesign(designations);
			listVO.forEach(empVO -> {
				System.out.println(empVO);
			});

		} catch (Exception e) {
			System.out.println("Internal Problem. Try Again.");
		} finally {
			// close Scanner
			scan.close();
			// close IOC Container
//			((AbstractApplicationContext) ctx).close();
			((ConfigurableApplicationContext) ctx).close();
		} // finally

	}// main(-)

}// class
