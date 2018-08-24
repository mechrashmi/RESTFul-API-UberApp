package org.rashmi.Hive.UberApp.models.impl;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Receipt {
	private double distance;
	private double price;
	
	public Receipt() {
		
	}
	public Receipt(double distance, double price) {
		super();
		this.distance = distance;
		this.price = price;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
