package org.rashmi.Hive.UberApp.models.impl;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rider {
	private Location pickUp;
	private Location drop;
	private String type;
	
	public Rider() {
		
	}
	
	public Rider(Location pickUp, Location drop, String type) {
		super();
		this.pickUp = pickUp;
		this.drop = drop;
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Location getPickUp() {
		return pickUp;
	}
	public void setPickUp(Location pickUp) {
		this.pickUp = pickUp;
	}
	public Location getDrop() {
		return drop;
	}
	public void setDrop(Location drop) {
		this.drop = drop;
	}
	
	
}
