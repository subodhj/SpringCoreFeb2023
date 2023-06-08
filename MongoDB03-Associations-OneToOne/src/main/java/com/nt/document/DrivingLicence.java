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
	@Id
	private Long lid;
	private String type;
	private LocalDateTime expiryDate;
	// HAS-A property for One-to-One Association.
	private Citizen citizen; // not required for Uni-Directional Association.

	public DrivingLicence() {
		System.out.println("DrivingLicence : 0-param constructor");
	}

	@Override
	public String toString() {
		return "DrivingLicence [lid=" + lid + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}

}// class
