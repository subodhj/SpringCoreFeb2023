package com.nt.vo;

public class CustomerVO {

	private String customerName;
	private String customerAddress;
	private String principalAmount;
	private String rate;
	private String time;

	public CustomerVO() {
		System.out.println("CustomerVO : 0-param constructor");
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

	public String getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(String principalAmount) {
		this.principalAmount = principalAmount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CustomerVO [customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", principalAmount=" + principalAmount + ", rate=" + rate + ", time=" + time + "]";
	}

}
