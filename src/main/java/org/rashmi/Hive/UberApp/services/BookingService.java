package org.rashmi.Hive.UberApp.services;

import java.util.List;

import org.rashmi.Hive.UberApp.models.api.Car;
import org.rashmi.Hive.UberApp.models.impl.Location;
import org.rashmi.Hive.UberApp.models.impl.Receipt;
import org.rashmi.Hive.UberApp.models.impl.Rider;

public interface BookingService {
	Car bookCab(Rider rider);
	
	Receipt releaseCar(Integer id);
	
	public List<Car> getAllAvailable();
}
