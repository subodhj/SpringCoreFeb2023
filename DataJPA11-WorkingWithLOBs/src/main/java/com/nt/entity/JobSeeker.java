package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeeker implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	private Long regNo;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	private LocalDate dob;
	@NonNull
	@Column(length = 20)
	private String addrs;
	@NonNull
	@Lob
	private byte[] photo;
	@NonNull
	@Lob
	private char[] resume;
	@NonNull
	private boolean indianNational;

}
