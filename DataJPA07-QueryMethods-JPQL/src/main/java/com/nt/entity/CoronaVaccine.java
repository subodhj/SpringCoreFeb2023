package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
//@Table(name = "CORONA_VACCINE_TAB")
public class CoronaVaccine implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	@Column(length = 20)
	private String company;
	@NonNull
	@Column(length = 20)
	private String country;
	@NonNull
	private Double price;
	@NonNull
	private Integer doses;

}
