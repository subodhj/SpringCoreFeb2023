package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix = "info.emp")
public class Employee {

	private String name;
	private int age;
	private String[] alias;
	private List<String> collegues;
	private Set<Long> mobileNumbers;
	private Map<String, Object> idDetails;
	private Company company;

}
