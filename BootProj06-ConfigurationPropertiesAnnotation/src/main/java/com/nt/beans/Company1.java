
package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("company1")
//@Data
@ConfigurationProperties(prefix = "org.nit")
public class Company1 {

	private String name;
	private String type;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company1 [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
	
	

//	@Value("USA")
//	@Value("my.app.addr")
//	private String location;

//	private String address="Hyd,India";

	
	
}
