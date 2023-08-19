package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HUMAN_ACTIVITIES")
public class HumanActivities {
	@Id
	private String hobbies;

}
