package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt")
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig : 0-param constructor");
	}

	@Bean(name = "oracleDmds")
	public DriverManagerDataSource getDataSource1() {
		DriverManagerDataSource dmds = null;
		// create DataSource for Oracle
		dmds = new DriverManagerDataSource();
		// set properties to DS
		dmds.setDriverClassName("oracle.jdbc.OracleDriver");
		dmds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dmds.setUsername("scott");
		dmds.setPassword("tiger");
		// return DataSource
		return dmds;
	}

	@Bean(name = "mySqlDmds")
	public DriverManagerDataSource getDataSource2() {
		DriverManagerDataSource dmds = null;
		// create DataSource for MySQL
		dmds = new DriverManagerDataSource();
		// set properties to DS
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql:///ntspbms714db");
		dmds.setUsername("root");
		dmds.setPassword("root");
		// return DataSource
		return dmds;
	}

}// class
