package com.nt.document;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Sport implements Serializable {
	@Id
	private Integer id;
	private String name;
	private boolean isTeamSport;
	private boolean isOlympicsSport;
	private String[] equipment;

	public Sport() {
		System.out.println("Sport : 0-param constructor");
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", isTeamSport=" + isTeamSport + ", isOlympicsSport="
				+ isOlympicsSport + ", equipment=" + Arrays.toString(equipment) + "]";
	}

}
