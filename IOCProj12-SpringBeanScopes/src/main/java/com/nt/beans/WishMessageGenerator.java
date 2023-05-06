package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {

	private Date date;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator : 0-param constructor");
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String generateWishMessage(String name) {
		int hour = 0;
		// get current hour of the day
		hour = date.getHours();
		if (hour < 12)
			return "GoodMorning " + name;
		else if (hour < 15)
			return "GoodAfternoon " + name;
		else if (hour < 20)
			return "GoodEvening " + name;
		else
			return "GoodNight " + name;
	}

}// class
