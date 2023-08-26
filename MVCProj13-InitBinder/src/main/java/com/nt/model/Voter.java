package com.nt.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "VOTER_INFO")
@Data
public class Voter {
	@Id
	@GeneratedValue
	private Integer vid;
	@Column(length = 20)
	private String name;
	private Date dob;
	private Date dor;	
}
