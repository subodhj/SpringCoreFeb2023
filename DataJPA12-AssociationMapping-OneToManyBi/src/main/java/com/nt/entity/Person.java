package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "OTM_PERSON")
public class Person implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	private Integer pid;
	@NonNull
	@Column(length = 20)
	private String pname;
	@NonNull
	@Column(length = 20)
	private String padd;

	@OneToMany(targetEntity = PhoneNumber.class, mappedBy = "person", cascade = CascadeType.ALL)
//	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID") // FK column
	private Set<PhoneNumber> phoneNos; // for One to Many

	public Person() {
		System.out.println("Person : 0-param constructor" + this.getClass());
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", padd=" + padd + "]";
	}

}// class
