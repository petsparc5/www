package com.clean.ship;

import java.util.ArrayList;
import java.util.List;

public class ShipLocations {
	
	private List<Ship> shipLocations = new ArrayList<Ship>();

	
	public void addTShipLocation(int location) {
		Ship ship = new Ship();
		ship.addShipWithAnUpsideDownTShape(location / 19 + 1, location % 18);
		shipLocations.add(ship);
	}
	public void addFourShipLocation(int location) {
		Ship ship = new Ship();
		ship.addShipWithFourPoints(location / 17, location % 17);
		shipLocations.add(ship);
	}
	public void addThreeShipLocation(int location) {
		Ship ship = new Ship();
		ship.addShipWithThreePoints(location / 18, location % 18);
		shipLocations.add(ship);
	}
	public void addTwoShipLocation(int location) {
		Ship ship = new Ship();
		ship.addShipWithTwoPoints(location / 19, location % 19);
		shipLocations.add(ship);
	}
	public void addOneShipLocation(int location) {
		Ship ship = new Ship();
		ship.addShipWithOnePoint(location / 20, location % 20);
		shipLocations.add(ship);
	}
	
	public void hit(int x, int y) {
		for (Ship ship : shipLocations) {
			if (ship.contains(x, y)) {
				ship.hit(x, y);
			}
		}
	}
	
	public boolean checkSunken() {
		boolean sunkenShipChecker = false;
		for (Ship ship : shipLocations) {
			if (ship.isSunken()) {
				sunkenShipChecker = true;
			}
			shipLocations.remove(ship);
		}
		return sunkenShipChecker;
	}

}
