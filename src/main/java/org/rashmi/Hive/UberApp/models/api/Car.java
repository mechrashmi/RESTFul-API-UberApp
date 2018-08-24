package org.rashmi.Hive.UberApp.models.api;

import javax.xml.bind.annotation.XmlTransient;

import org.rashmi.Hive.UberApp.models.impl.Location;
import org.rashmi.Hive.UberApp.models.impl.Receipt;


public abstract class Car {
	private boolean isAvailable;
	private Location currentLoc;
	private Location dropLoc;
	private Integer id;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Location getDropLoc() {
		return dropLoc;
	}

	public void setDropLoc(Location dropLoc) {
		this.dropLoc = dropLoc;
	}

	public Car() {
		
	}
	
	public Car(boolean isAvailable, Location currentLoc) {
		super();
		this.isAvailable = isAvailable;
		this.currentLoc = currentLoc;
		this.dropLoc = null;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Location getCurrentLoc() {
		return currentLoc;
	}
	public void setCurrentLoc(Location currentLoc) {
		this.currentLoc = currentLoc;
	}
	
	public abstract Integer getBasePrice();
	public abstract void setBasePrice(Integer basePrice);
	
	public abstract Integer getFarePerKm();
	public abstract void setFarePerKm(Integer farePerKm);
	
	public abstract Receipt getReceipt();
	

	
	protected void reSet() {
		setDropLoc(null);
		setId(null);
		setCurrentLoc(getDropLoc());
		setBasePrice(getBasePrice());
		setFarePerKm(getFarePerKm());
	}
	
}
