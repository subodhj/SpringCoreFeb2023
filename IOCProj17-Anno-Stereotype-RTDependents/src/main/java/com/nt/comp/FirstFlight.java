package com.nt.comp;

import org.springframework.stereotype.Component;

import com.nt.beans.Courier;

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
