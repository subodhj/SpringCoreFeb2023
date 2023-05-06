package com.nt.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class AlertServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------AlertServiceRunner.run()--------");
		System.out.println("The command line args passed to app : ");
		for (String arg : args)
			System.out.println(arg);

//		System.out.println("................................");
//		System.out.println(Arrays.toString(args));
	}

}
