package com.clean.ship;

import java.util.ArrayList;
import java.util.List;

public class ShipLocations {
	
	private List<Ship> shipLocations = new ArrayList<Ship>();
	
	public void addTShipLocation(int x, int y) {
		Ship ship = new Ship();
		ship.addShipWithAnUpsideDownTShape(x, y);
		shipLocations.add(ship);
	}
	public void addFourShipLocation(int x, int y) {
		Ship ship = new Ship();
		ship.addShipWithFourPoints(x, y);
		shipLocations.add(ship);
	}
	public void addThreeShipLocation(int x, int y) {
		Ship ship = new Ship();
		ship.addShipWithThreePoints(x, y);
		shipLocations.add(ship);
	}
	public void addTwoShipLocation(int x, int y) {
		Ship ship = new Ship();
		ship.addShipWithTwoPoints(x, y);
		shipLocations.add(ship);
	}
	public void addOneShipLocation(int x, int y) {
		Ship ship = new Ship();
		ship.addShipWithOnePoint(x, y);
		shipLocations.add(ship);
	}
	
    public boolean checkTShip(int x, int y) {
        return (checkPoint(x, y) || checkPoint(x+1, y) || checkPoint(x+2, y) || checkPoint(x+1, y+1));
    }
    public boolean checkFourShip(int x, int y) {
        return (checkPoint(x, y) || checkPoint(x+1, y) || checkPoint(x+2, y) || checkPoint(x+3, y));
    }
    
    public boolean checkThreeShip(int x, int y) {
        return (checkPoint(x, y) || checkPoint(x+1, y) || checkPoint(x+2, y));
    }
    public boolean checkTwoShip(int x, int y) {
        return (checkPoint(x, y) || checkPoint(x+1, y));
    }
    
    public boolean checkOneShip(int x, int y) {
        return (checkPoint(x, y));
    }
    
    public boolean checkPoint(int x, int y) {
    	boolean answer = false;
		for (Ship ship : shipLocations) {
			answer |= ship.contains(x, y);
		}
    	return answer;
    }
    
	public boolean hit(int x, int y) {
		boolean answer = false;
		for (Ship ship : shipLocations) {
				answer |= ship.hit(x, y);
		}
		return answer;
	}
	
	public boolean checkSunken() {
		boolean sunkenShipChecker = false;
		for (int i = 0; i < shipLocations.size(); i++){
			Ship ship = shipLocations.get(i);
			if (ship.isSunken()) {
				sunkenShipChecker = true;
				shipLocations.remove(ship);
			}
		}
		return sunkenShipChecker;
	}
}
