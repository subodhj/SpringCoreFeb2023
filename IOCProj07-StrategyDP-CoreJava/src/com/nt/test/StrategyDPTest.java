package com.nt.test;

import com.nt.comp.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		Flipkart flipkart = null;
		String result = null;

		// get target class object having dependent class object
		flipkart = FlipkartFactory.getInstance("BLUEDART");

		// invoke business method
		result = flipkart.shop(new String[] { "Shoes", "Trouser", "Shirt" }, new float[] { 4000f, 5000f, 2000f });

		// display the result
		System.out.println(result);
	}

}
