package com.nt.document;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Medal implements Serializable {
	@Id
	private String id;
	private MedalType type;
	private Double prizeMoney;
	private String event;

	public Medal() {
		System.out.println("Medal : 0-param constructor");
	}

	public String getPrizeMoney() {
		/*	if (prizeMoney != null) {
		// Use DecimalFormat to format a double value.
				DecimalFormat format = new DecimalFormat("#");
				return format.format(prizeMoney);
			}
			return null;*/
		return prizeMoney != null ? new DecimalFormat("#").format(prizeMoney) : null;
	}

	@Override
	public String toString() {
		return "Medal [id=" + id + ", type=" + type + ", prizeMoney=" + getPrizeMoney() + ", event=" + event + "]";
	}

}
