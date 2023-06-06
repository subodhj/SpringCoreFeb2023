package com.nt.generator;

import java.util.UUID;

public class CustomIDGenerator {

	public static String generateId() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}

}
