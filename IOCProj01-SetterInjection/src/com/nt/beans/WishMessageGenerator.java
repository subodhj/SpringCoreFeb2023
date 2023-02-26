package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {

	private Date date;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator : 0-param constructor");
	}

	public void setDate(Date date) {
		this.date = date;
		System.out.println("Date class obj holds system date -> " + date);
		System.out.println("WishMessageGenerator : setDate(-)");
	}

	public String generateWishMessage() {
		int hour = 0;
		// get current hour
		hour = date.getHours();
		// generate wish message
		if (hour < 12)
			return "Good Morning";
		else if (hour < 15)
			return "Good Afternoon";
		else if (hour < 20)
			return "Good Evening";
		else
			return "Good Night";
	}

}// class
