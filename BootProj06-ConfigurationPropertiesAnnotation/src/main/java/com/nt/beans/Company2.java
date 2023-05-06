package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company2")
public class Company2 {

		@Value("${org.nit.name}")
		private String title;
		@Value("${org.nit.type}")
		private String type;
		@Value("${org.nit.location}")
		private String address;
	
		@Override
		public String toString() {
			return "Company2 [title=" + title + ", type=" + type + ", address=" + address + "]";
		}
	
}
