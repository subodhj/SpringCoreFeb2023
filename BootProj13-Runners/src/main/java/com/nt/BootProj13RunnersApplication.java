package com.nt;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj13RunnersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProj13RunnersApplication.class, args);
	}

	@Bean // No modularity.
	@Order(-3)
	CommandLineRunner createSchedulingRunner() {
		CommandLineRunner cmdLineRunner = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("--------SchedulingRunner.run()--------");
			}
		};
		return cmdLineRunner;
	}

	@Bean // Keep separate class for runner for modularity.
	@Order(-5)
	ApplicationRunner createTimerRunner() {
		ApplicationRunner appRunner = args -> System.out.println("--------TimerRunner.run()--------");
		return appRunner;
	}
}// class
