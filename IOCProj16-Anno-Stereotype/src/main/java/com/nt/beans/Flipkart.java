package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

//@Component("fpkt")
//@Component
@Named("fpkt")
//@Scope("prototype")
@Scope("singleton")
@Lazy
public final class Flipkart {

//	@Autowired
	@Inject
//	@Qualifier("fx")
	@Named("bd")
	private Courier courier;

	public Flipkart() {
		System.out.println("Flipkart : 0-param constructor");
	}

	public String shop(String[] items, float[] prices) {
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
