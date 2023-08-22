package com.nt.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STATES_LIST")
public class State implements Serializable {
	@Id
	private Integer sid;
	@Column(name = "state")
	private String name;
	@ManyToOne(targetEntity = Country.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", referencedColumnName = "cid") // FK Column
	private Country country; // For establishing Many-to-One Relationship.

	public State() {
		System.out.println("State : 0-param constructor -> "+ this.getClass());
	}
	
	@Override
	public String toString() {
		return "State [sid=" + sid + ", name=" + name + "]";
	}

}
