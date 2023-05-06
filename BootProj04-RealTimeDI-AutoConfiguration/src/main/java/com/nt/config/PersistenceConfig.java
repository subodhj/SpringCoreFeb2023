package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.vibur.dbcp.ViburDBCPDataSource;

@Configuration
//@ImportResource(locations = "src/main/resources/com/nt/commons/inputs.properties")
//@PropertySource("com/nt/commons/inputs.properties")
public class PersistenceConfig {

	@Autowired
	private Environment env;

//	@Bean("vibur")
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

	/*@Bean
	ProxoolDataSource createProxoolDataSource() {
		System.out.println("PersistenceConfig : createProxoolDataSource()");
		ProxoolDataSource ds = new ProxoolDataSource();
		ds.setDriver(env.getProperty("spring.datasource.driver-class-name"));
		ds.setDriverUrl(env.getProperty("spring.datasource.url"));
		ds.setUser(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		return ds;
	}*/

}
