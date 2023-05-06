package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class SBILoanCalculateInterestRateReplacer implements MethodReplacer {

	public SBILoanCalculateInterestRateReplacer() {
		System.out.println("SBILoanCalculateInterestRateReplacer : 0-param constructor");
	}

	@Override
	public Object reimplement(Object target, Method method, Object[] args) throws Throwable {
		System.out.println("SBILoanCalculateInterestRateReplacer : reimplement(-,-,-)");

		double principal = (double) args[0];
		double rate = (double) args[1];
		double time = (double) args[2];

		return (principal * rate * time) / 100;
	}
}
