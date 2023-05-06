package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("bd")
public final class BlueDart implements Courier {

	public BlueDart() {
		System.out.println("BlueDart : 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "BlueDart will be delivering the OrderNo:" + oid;
	}

}
