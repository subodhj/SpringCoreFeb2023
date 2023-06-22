package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.nt.service.IWishMessageService;

@Service("wishService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMsg() {
		LocalDateTime ldt = null;
		int hour = 0;
		// Create LocalDateTime object.
		ldt = LocalDateTime.now();
		// Get current hour of the day.
		hour = ldt.getHour();
		// Generate Wish Message.
		if (hour < 12)
			return "Good Morning";
		else if (hour < 15)
			return "Good Afternoon";
		else if (hour < 20)
			return "Good Evening";
		else
			return "Good Night";
	}

}
