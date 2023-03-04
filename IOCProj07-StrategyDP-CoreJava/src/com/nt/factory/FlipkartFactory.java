package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;

public class FlipkartFactory {

	public static Flipkart getInstance(String courierType) {
		Courier courier = null;
		Flipkart flipkart = null;

		// create dependent class object as per the courierType
		if (courierType.equalsIgnoreCase("dtdc"))
			courier = new DTDC();
		else if (courierType.equalsIgnoreCase("blueDart"))
			courier = new BlueDart();
		else
			throw new IllegalArgumentException("Invalid Courier Type!");

		// create target class object
		flipkart = new Flipkart();

		// inject/assign dependent object to target object
		flipkart.setCourier(courier);

		// returning target class object
		return flipkart;

	}// getFlipkart(-)

}// class
