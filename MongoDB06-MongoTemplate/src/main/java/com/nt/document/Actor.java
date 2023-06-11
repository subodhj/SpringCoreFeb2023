package com.nt.document;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor implements Serializable {
	@Id
	private Integer id;
	private String name;
	private String role;
	private Integer age;
	private Long contactNo;
	private String addrs;
	private Double pay;

	public String getPay() {
		/*	if (pay != null) {
				// Use DecimalFormat to format a double value.
				DecimalFormat format = new DecimalFormat("#");
				return format.format(pay);
			}
			return null;*/
		return pay != null ? new DecimalFormat("#").format(pay) : null;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", role=" + role + ", age=" + age + ", contactNo=" + contactNo
				+ ", addrs=" + addrs + ", pay=" + getPay() + "]";
	}

}// class
