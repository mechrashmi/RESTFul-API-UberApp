package org.rashmi.Hive.UberApp.util;

import org.rashmi.Hive.UberApp.models.impl.Location;

public class DistanceCalculator {
	public static double getDistance(Location loc1, Location loc2) {
		double val1 = Math.pow((loc1.getX() - loc2.getX()), 2);
		double val2 = Math.pow((loc1.getY() - loc2.getY()), 2);
		double dist = Math.sqrt(val1 + val2);
		return dist;
	}

}
