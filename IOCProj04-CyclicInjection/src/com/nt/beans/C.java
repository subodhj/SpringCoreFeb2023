package com.nt.beans;

public class C {

	private D d;

	public C(D d) {
		System.out.println("C : 1-param constructor");
		this.d = d;
	}

	@Override
	public String toString() {
//		return "C [d=" + d + "]";
		return "from C";
	}

}
