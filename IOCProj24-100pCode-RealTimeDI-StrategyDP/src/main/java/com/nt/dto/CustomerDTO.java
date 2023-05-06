package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	private String customerName;
	private String customerAddress;
	private Float principalAmount;
	private Float rate;
	private Float time;

	public CustomerDTO() {
		System.out.println("CustomerDTO : 0-param constructor");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Float getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(Float principalAmount) {
		this.principalAmount = principalAmount;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", principalAmount=" + principalAmount + ", rate=" + rate + ", time=" + time + "]";
	}

}
