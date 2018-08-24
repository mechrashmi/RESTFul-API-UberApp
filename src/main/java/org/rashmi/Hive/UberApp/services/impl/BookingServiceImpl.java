package org.rashmi.Hive.UberApp.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rashmi.Hive.UberApp.models.api.Car;
import org.rashmi.Hive.UberApp.models.impl.Location;
import org.rashmi.Hive.UberApp.models.impl.Receipt;
import org.rashmi.Hive.UberApp.models.impl.Rider;
import org.rashmi.Hive.UberApp.models.impl.UberGo;
import org.rashmi.Hive.UberApp.services.BookingService;
import org.rashmi.Hive.UberApp.util.DistanceCalculator;

public class BookingServiceImpl implements BookingService{
	private Set<Car> availableCabs;
	private HashMap<Integer, Car> bookedCabs;
	private Integer id = 1;
	
	public BookingServiceImpl() {
		availableCabs = new HashSet<>();
		bookedCabs = new HashMap<>();
		populateCars();
	}
	
	@Override
	public Car bookCab(Rider rider) {
		Location pickUp = rider.getPickUp();
		Car car = null;
		Double min_dist = -1.0d;
		
		for(Car c : availableCabs) {
			double dist = DistanceCalculator.getDistance(pickUp, c.getCurrentLoc());
			if(min_dist == -1.0d || min_dist > dist) {
				min_dist = dist;
				car = c;
				continue;
			}
		}
		
		if(car != null) {
			availableCabs.remove(car);
			car.setDropLoc(rider.getDrop());
			int id = getNextId();
			car.setId(id);
			bookedCabs.put(id, car);
		}
		
		return car;
	}

	@Override
	public Receipt releaseCar(Integer id) {
		Car car = bookedCabs.get(id);
		availableCabs.add(car);
		bookedCabs.remove(id);
		Receipt price = car.getReceipt();
		return price;
	}
	
	
	public List<Car> getAllAvailable(){
		return new ArrayList<Car>(availableCabs);
	}
	
	
	private void populateCars() {
		Integer[] x = {3, 4, 7, 8, 2, 1, 0};
		Integer[] y = {7, 10, 2, 3, 4, 6, 4};
		for(int i = 0; i < x.length; i++) {
			Location loc = new Location(x[i], y[i]);
			Car car = new UberGo(true, loc);
			availableCabs.add(car);
		}
		
	}
	
	private Integer getNextId() {
		return id++;
	}
	
	

}
