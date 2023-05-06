package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("ff")
public final class FirstFlight implements Courier {

	public FirstFlight() {
		System.out.println("FirstFlight : 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "FirstFlight will be delivering the OrderNo:" + oid;
	}

}
