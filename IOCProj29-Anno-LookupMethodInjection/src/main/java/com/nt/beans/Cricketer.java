package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("cric")
public abstract class Cricketer {

	public Cricketer() {
		System.out.println("Cricketer : 0-param constructor");
	}

	@Lookup
	public abstract CricketBat createCricketBat();

	public void fielding() {
		System.out.println("Cricketer is fielding");
	}

	public void bowling() {
		System.out.println("Cricketer is bowling");
	}

	public void keeping() {
		System.out.println("Cricketer is keeping");
	}

	public void batting() {
		System.out.println("Cricketer is batting");
		CricketBat cBat = null;
		int runs = 0;
		// get dependent bean class object through dependency lookup
		cBat = createCricketBat();
		// invoke b.logic
		runs = cBat.scoreRuns();
		System.out.println("Cricketer is batting & his current score is : " + runs);
	}

}// class
