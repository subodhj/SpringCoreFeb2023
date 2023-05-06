package com.nt.test;

import java.io.IOException;

public class Test2 {

	public void n() throws IOException {
		throw new IOException("device failure"); // checked exception
	}

	public void m() {
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
		new Test2().p();
	}

}
