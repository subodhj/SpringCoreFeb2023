package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(15)
public class EmailServiceRunner implements ApplicationRunner, Ordered {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("--------EmailServiceRunner.run()--------");
		System.out.println("Collection of non-option arguments : " + args.getNonOptionArgs());
		System.out.println("Names of all option arguments : " + args.getOptionNames());
		System.out.println("Raw unprocessed arguments passed to app : " + Arrays.toString(args.getSourceArgs()));

	}

	@Override
	public int getOrder() {
		return -1;
	}

}
