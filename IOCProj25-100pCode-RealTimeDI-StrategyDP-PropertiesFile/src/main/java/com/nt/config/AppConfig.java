package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt")
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
//@ImportResource("com/nt/cfgs/applicationContext.xml")
//@PropertySource({ "com/nt/commons/jdbc1.properties", "com/nt/commons/jdbc2.properties" })
@PropertySource(value="com/nt/commons/jdbc1.properties")
@PropertySource("com/nt/commons/jdbc2.properties")
public class AppConfig {

	@Autowired
	private Environment env;

	public AppConfig() {
		System.out.println("AppConfig : 0-param constructor");
	}

	@Bean(name = "dmds")
	public DriverManagerDataSource createDataSource() {
		System.out.println("AppConfig : getDataSource()");
		DriverManagerDataSource dmds = null;
		// create DataSource for Oracle
		dmds = new DriverManagerDataSource();
		// set properties to DataSource
		dmds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		dmds.setUrl(env.getRequiredProperty("jdbc.url"));
		dmds.setUsername(env.getProperty("db.username"));
		dmds.setPassword(env.getProperty("db.password"));
		// return DataSource
		return dmds;
	}

}// class
