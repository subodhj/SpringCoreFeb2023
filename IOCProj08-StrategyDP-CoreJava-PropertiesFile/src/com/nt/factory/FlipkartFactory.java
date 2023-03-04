package com.nt.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.nt.comp.Courier;
import com.nt.comp.Flipkart;

public class FlipkartFactory {

	private static InputStream is = null;
	private static Properties properties = null;

	static {

		try {
			// locate and hold properties file
			is = new FileInputStream("src/com/nt/commons/info.properties");
			// load the content of properties file into java.util.Properties class object
			properties = new Properties();
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// static

	// static factory method having Factory Pattern logic
	public static Flipkart getInstance() {
		String value = null;
		Class clazz = null;
		Constructor[] constructors = null;
		Courier courier = null;
		Flipkart flipkart = null;

		try {
			// get the property value
			value = properties.getProperty("courier.type");

			// load the depenent class as per courier type
			clazz = Class.forName(value);

			// create dependent class object
//			courier = (Courier) clazz.newInstance();

			constructors = clazz.getDeclaredConstructors();
			courier = (Courier) constructors[0].newInstance();

			// create target class object
			flipkart = new Flipkart();

			// inject/assign dependent object to target object
			flipkart.setCourier(courier);

			// returning target class object
			return flipkart;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}

	}// getFlipkart(-)

}// class
