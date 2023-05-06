package com.nt.sdp;

public class Printer {

	private static Printer INSTANCE;

	private Printer() {
		System.out.println("Printer : 0-param private constructor");
	}

	public static Printer getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Printer();
		return INSTANCE;
	}

	public void print(String message) {
		System.out.println(message);
	}

}
