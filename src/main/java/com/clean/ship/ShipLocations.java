package com.clean.ship;

import java.util.ArrayList;
import java.util.List;

public class ShipLocations {
	
	private List<Ship> shipLocations = new ArrayList<Ship>();
	
	public void addShipLocation(int x, int y, String[][] shape) {
		Ship ship = new Ship();
		ship.createShip(x, y, shape);
		shipLocations.add(ship);
	}
	
    public boolean checkShip(int x, int y, String[][] shape) {
    	boolean answer = false;
    	for (int i = 0; i < shape.length; i++) {
			for (int j = 0; j < shape[i].length; j++) {
				if (shape[i][j].contains("X")){
					answer |= checkPoint(x + i, y + j);
				}
			}
		}
        return answer;
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
				shipLocations.remove(i);
			}
		}
		return sunkenShipChecker;
	}
}
