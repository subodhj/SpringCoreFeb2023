package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private LocalDateTime date;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator : 0-param constructor");
	}

	// b.logic
	public String generateMessage(String name) {
		System.out.println("WishMessageGenerator : generateMessage(-)");
		int hour = 0;
		// get current hour of the day
		hour = date.getHour();
		// generate wish message
		if (hour < 12)
			return "Good Morning " + name;
		else if (hour < 15)
			return "Good Afternoon " + name;
		else if (hour < 20)
			return "Good Evening " + name;
		else
			return "Good Night " + name;
	}

}// class
