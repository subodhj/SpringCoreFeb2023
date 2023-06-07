package com.nt.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class DrivingLicence {

	public DrivingLicence() {
		System.out.println("DrivingLicence : 0-param constructor");
	}

	@Id
	private Long lid;
	private String type;
	private LocalDateTime expiryDate;
	private Citizen citizen;

	@Override
	public String toString() {
		return "DrivingLicence [lid=" + lid + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}

}// class
