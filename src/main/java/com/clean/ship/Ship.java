package com.clean.ship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
	
	private List<Point> ship;
	
	public void addShipWithAnUpsideDownTShape(int x, int y) {
		ship = new ArrayList<Point>();
        ship.add(new Point(x , y));
        ship.add(new Point(x + 1, y));
        ship.add(new Point(x + 2, y));
        ship.add(new Point(x + 1, y - 1));
    }

    public void addShipWithFourPoints(int x, int y) {
    	ship = new ArrayList<Point>();
        ship.add(new Point(x , y));
        ship.add(new Point(x + 1, y));
        ship.add(new Point(x + 2, y));
        ship.add(new Point(x + 3, y));
    }

    public void addShipWithThreePoints(int x, int y) {
    	ship = new ArrayList<Point>();
        ship.add(new Point(x , y));
        ship.add(new Point(x + 1, y));
        ship.add(new Point(x + 2, y));
    }

    public void addShipWithTwoPoints(int x, int y) {
    	ship = new ArrayList<Point>();
        ship.add(new Point(x , y));
        ship.add(new Point(x + 1, y));
    }

    public void addShipWithOnePoint(int x, int y) {
    	ship = new ArrayList<Point>();
        ship.add(new Point(x , y));
    }
    
    public boolean contains (int x, int y) {
    	boolean answer = false;
    	Point searchPoint = new Point(x, y);
    	for (Point point : ship) {
			answer |= searchPoint.equals(point);
		}
    	return answer;
    }
    
    public boolean isSunken() {
    	return ship.isEmpty();
    }
    
    public void hit(int x, int y) {
    	Point deletePoint = new Point(x, y);
    	if(!ship.remove(deletePoint)) {
    		throw new IllegalArgumentException();
    	}
    }
	
}
