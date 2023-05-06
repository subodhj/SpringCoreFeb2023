package com.nt.test;

import java.io.IOException;

public class Test {

	public void n() throws IOException {
		throw new IOException("device failure"); // checked exception
	}

	public void m() throws IOException {
		n();
	}

	public void p() {
		try {
			m();
		} catch (Exception e) {
			System.out.println("Exception handled!");
		}
	}

	public static void main(String[] args) {
		new Test().p();
	}

}
