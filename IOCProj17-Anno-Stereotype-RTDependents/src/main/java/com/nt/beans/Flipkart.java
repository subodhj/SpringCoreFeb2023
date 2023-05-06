package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("fpkt")
@Component
//@Scope("prototype")
@Scope("singleton")
@Lazy
//@PropertySources(value= {@PropertySource("com/nt/commons/info1.properties"),@PropertySource("com/nt/commons/info2.properties")})
//@PropertySources({@PropertySource("com/nt/commons/info1.properties"),@PropertySource("com/nt/commons/info2.properties")})
//@PropertySource(value={"com/nt/commons/info1.properties","com/nt/commons/info2.properties"})
//@PropertySource({"com/nt/commons/info1.properties","com/nt/commons/info2.properties"})
@PropertySource("com/nt/commons/info1.properties")
@PropertySource("com/nt/commons/info2.properties")
public final class Flipkart {

	@Autowired
	@Qualifier("cr")
	private Courier courier;

//	@Value("https://www.nareshit.com")
	@Value("${fpkt.info.url}")
	private String url;

//	@Value("20")
	@Value("${fpkt.info.age}")
	private int age;

	@Value("${os.name}")
	private String osName;

	@Value("${Path}")
	private String path;

	public Flipkart() {
		System.out.println("Flipkart : 0-param constructor");
	}

	public String shop(String[] items, float[] prices) {
		System.out.println("\nURL : " + url);
		System.out.println("Age : " + age);
		System.out.println("OSName : " + osName);
		System.out.println("Path : " + path+"\n");

		int oid = 0;
		float billAmt = 0.0f;
		String message = null;
		oid = new Random().nextInt(1000);
		for (float price : prices)
			billAmt += price;
		message = courier.deliver(oid);
		return message + " having products " + Arrays.toString(items) + " , costing " + Arrays.toString(prices)
				+ " respectively totalling ₹" + billAmt + "/-";

	}// shop()

}// class
