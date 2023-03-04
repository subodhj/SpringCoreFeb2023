package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {

	private Courier courier;

	public Flipkart() {
		System.out.println("Flipkart : 0-param constructor");
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart : setCourier(-)");
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
				+ " respectively totalling ₹" + billAmt +"/-";
	}// shop()

}// class
