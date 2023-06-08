package com.nt.document;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class SportsPerson {
	@Id
	private Long id;
	private String name;
	private String country;
	private Set<Sport> sports; // HAS-A property for One-to-Many Association.
	private Map<String, Medal> medals; // HAS-A property for One-to-Many Association.

	public SportsPerson() {
		System.out.println("SportsPerson : 0-param constructor");
	}

	@Override
	public String toString() {
		return "SportsPerson [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

}
