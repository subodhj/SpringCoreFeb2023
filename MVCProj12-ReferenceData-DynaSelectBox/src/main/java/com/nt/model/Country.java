package com.nt.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "COUNTRIES_LIST")
public class Country implements Serializable {
	@Id
	private Integer cid;
	@Column(name = "country")
	private String name;
	@OneToMany(targetEntity = State.class,cascade = CascadeType.ALL,mappedBy = "country")
//	@OneToMany(targetEntity = State.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "cid", referencedColumnName = "cid") // FK Column
	private List<State> states; // For establishing One-to-Many Relationship.

	public Country() {
		System.out.println("Country : 0-param constructor -> "+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", name=" + name + "]";
	}	

}
