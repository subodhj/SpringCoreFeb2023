package com.nt.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
//@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable {
	@Id
	private String id;
	@NonNull
	private Integer cno;
	@NonNull
	private String cname;
	private String cadd;
	private Long phoneNo;
	private Double billAmt;

}
