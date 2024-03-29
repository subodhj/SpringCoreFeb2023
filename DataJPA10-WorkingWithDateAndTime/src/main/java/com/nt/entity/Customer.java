package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CUSTOMER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	@NonNull
	@Column(length = 10)
	private String custName;
	@NonNull
	@Column(length = 20)
	private String custAddrs;
	@NonNull
	private LocalDateTime dob; // MySQL-DATETIME(6) //Oracle-TIMESTAMP(6)
	@NonNull
//	private LocalTime top;  // MySQL-TIME // Oracle-TIMESTAMP(6)
	private LocalDateTime top; // Oracle-TIMESTAMP(6)
	@NonNull
	private LocalDate dop; // MySQL-DATE // Oracle-DATE

}
