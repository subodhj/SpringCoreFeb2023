package com.nt.beans;

import org.springframework.stereotype.Component;

public class SBILoan {

	public SBILoan() {
		System.out.println("SBILoan : 0-param constructor");
	}

	public double calculateInterestRate(double principal, double rate, double time) {
		System.out.println("Bank : calculateInterestAmt(-,-,-)");
		return (principal * Math.pow(1 + rate / 100, time)) - principal;
	}

}
