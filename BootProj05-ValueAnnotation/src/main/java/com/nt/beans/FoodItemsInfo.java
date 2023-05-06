package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fiInfo")
//@PropertySource("com/nt/commons/inputs.properties")
public class FoodItemsInfo {

	@Value("${idle.price}")
//	public double idlePrice;
	private double idlePrice;
	@Value("${dosa.price}")
//	public double dosaPrice;
	private double dosaPrice;
	@Value("${vada.price}")
//	public double vadaPrice;
	private double vadaPrice;

	public double getIdlePrice() {
		return idlePrice;
	}

	public double getDosaPrice() {
		return dosaPrice;
	}

	public double getVadaPrice() {
		return vadaPrice;
	}

	@Override
	public String toString() {
		return "FoodItemsInfo [idlePrice=" + idlePrice + ", dosaPrice=" + dosaPrice + ", vadaPrice=" + vadaPrice + "]";
	}

}
