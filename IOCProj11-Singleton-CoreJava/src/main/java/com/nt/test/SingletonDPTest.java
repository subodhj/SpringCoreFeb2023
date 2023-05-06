package com.nt.test;

import com.nt.sdp.Printer;

public class SingletonDPTest {

	public static void main(String[] args) {
		Printer p1 = null;
		Printer p2 = null;
//      p1 = new Printer();
		p1 = Printer.getInstance();
		p2 = Printer.getInstance();
		System.out.println(p1.hashCode() + " " + p2.hashCode());
		System.out.println("p1 == p2 ? " + (p1 == p2));
		System.out.println(p1 + " " + p2);
	}
}
