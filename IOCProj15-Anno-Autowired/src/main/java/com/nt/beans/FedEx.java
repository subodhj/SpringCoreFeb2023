package com.nt.beans;

public final class FedEx implements Courier {

	public FedEx() {
		System.out.println("FedEx : 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "FedEx will be delivering the OrderNo:" + oid;
	}

}
