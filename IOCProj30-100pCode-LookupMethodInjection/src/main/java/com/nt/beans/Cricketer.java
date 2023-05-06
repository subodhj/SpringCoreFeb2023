package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("cric")
public interface Cricketer {

	@Lookup
	public abstract CricketBat createCricketBat();

	public default void fielding() {
		System.out.println("Cricketer is fielding");
	}

	public default void bowling() {
		System.out.println("Cricketer is bowling");
	}

	public default void keeping() {
		System.out.println("Cricketer is keeping");
	}

	public default void batting() {
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
