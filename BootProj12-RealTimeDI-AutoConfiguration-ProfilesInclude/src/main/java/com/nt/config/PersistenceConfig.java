package com.nt.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.vibur.dbcp.ViburDBCPDataSource;

@Configuration
//@Profile("dev")
public class PersistenceConfig {

	@Autowired
	private Environment env;

	@Bean("viburDBCP")
	@Profile("dev")
	ViburDBCPDataSource createViburDBCPDataSource() {
		System.out.println("PersistenceConfig : createViburDBCPDataSource()");

		ViburDBCPDataSource ds = new ViburDBCPDataSource();

		ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));

		ds.start();
		return ds;
	}

	@Bean("commonsDBCP")
	@Profile("default")
	BasicDataSource createBasicDataSource() {
		System.out.println("PersistenceConfig : createBasicDataSource()");

		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///ntspbms714db");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}

}
