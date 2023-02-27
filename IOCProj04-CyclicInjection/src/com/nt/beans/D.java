package com.nt.beans;

public class D {

	private C c;

	public D(C c) {
		System.out.println("D : 1-param constructor)");
		this.c = c;
	}

	@Override
	public String toString() {
//		return "D [c=" + c + "]";
		return "from D";
	}

}
