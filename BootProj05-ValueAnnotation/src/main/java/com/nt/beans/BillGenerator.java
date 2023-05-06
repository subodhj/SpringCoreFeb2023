package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
//@PropertySource("com/nt/commons/inputs.properties")
public class BillGenerator {

	@Value("Brundavanam")
	private String restaurant;

	@Autowired
	private FoodItemsInfo itemsInfo;

//	@Value("#{(20*100)/10}")
	@Value("#{fiInfo.idlePrice + fiInfo.dosaPrice + fiInfo.vadaPrice}")
	private double totalAmt;

	@Override
	public String toString() {
		return "BillGenerator [restaurant=" + restaurant + ", itemsInfo=" + itemsInfo + ", totalAmt=" + totalAmt
				+ "]";
	}

}
