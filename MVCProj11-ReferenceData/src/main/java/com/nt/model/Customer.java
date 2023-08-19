package com.nt.model;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String country = "India";
	private String[] languages = new String[] { "Telugu", "Hindi" };
	private String[] hobbies = new String[] { "Painting", "Reading" };
}