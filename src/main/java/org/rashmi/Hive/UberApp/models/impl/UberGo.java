package org.rashmi.Hive.UberApp.models.impl;

import javax.xml.bind.annotation.XmlRootElement;

import org.rashmi.Hive.UberApp.models.api.*;
import org.rashmi.Hive.UberApp.util.DistanceCalculator;

@XmlRootElement
public class UberGo extends Car{
	private final String type = "UberGo";
	private Integer basePrice = 10;
	private Integer farePerKm = 5;
	
	public UberGo(){
		
	}
	
	public UberGo(boolean isAvailable, Location currentLoc) {
		super(isAvailable, currentLoc);
	}

	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(Integer farePerKm) {
		this.farePerKm = farePerKm;
	}

	public String getType() {
		return type;
	}
	
	public Receipt getReceipt() {
		Location loc1 = getCurrentLoc();
		Location loc2 = getDropLoc();
		
		double dist = DistanceCalculator.getDistance(loc1, loc2);
		double price = basePrice + (dist * farePerKm);
		Receipt receipt = new Receipt(dist, price);
		reSet();
		return receipt;
	}
	
}
