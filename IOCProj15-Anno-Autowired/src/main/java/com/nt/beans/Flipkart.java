package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public final class Flipkart {

	@Autowired(required = true)
	@Qualifier("dtdc")
	private Courier courier;

	public Flipkart() {
		System.out.println("Flipkart : 0-param constructor");
	}

//	@Autowired(required = false)
	@Autowired
	public Flipkart(@Qualifier("bd") Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart : 1-param constructor");
	}

	/*@Autowired
	public Flipkart(@Qualifier("bd") int x) {
		System.out.println("Flipkart : int-param constructor" + x);
	}*/

	@Autowired
	@Qualifier("fx")
	public void setCourier(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart : setCourier(-)");
	}

	@Autowired
	@Qualifier("ff")
	public void assign(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart : assignCourier(-)");
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
