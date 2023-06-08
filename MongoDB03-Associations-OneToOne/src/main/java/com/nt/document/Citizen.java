package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Citizen {
	@Id
	private Integer cid;
	private String name;
	private String addr;
	private DrivingLicence licence; // HAS-A property for One-to-One Association.

	public Citizen() {
		System.out.println("Citizen : 0-param constructor");
	}

	@Override
	public String toString() {
		return "Citizen [cid=" + cid + ", name=" + name + ", addr=" + addr + "]";
	}

}// class
