package com.nt.document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Employee {

	@Id
	private Integer eno;
	private String ename;
	private LocalDateTime dob;
//	private LocalDate dob;
	private boolean isMarried;
	private String eadd;
	private Set<Long> phoneNos;
	private String[] roles;
	private List<String> projects;
	private Map<String, Double> education;
	private Properties ids;

}
