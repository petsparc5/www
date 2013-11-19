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
        ship.add(new Point(x + 1, y + 1));
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
    
    public boolean hit(int x, int y) {
    	boolean hitResult = false;
    	Point deletePoint = new Point(x, y);
    	if(ship.remove(deletePoint)) {
    		hitResult = true;
    	}
    	return hitResult;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		int hash = 0;
		for (Point point : ship) {
			hash += point.hashCode();
		}
		result = prime * result + ((ship == null) ? 0 : hash);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (ship == null) {
			if (other.ship != null)
				return false;
		} else 
			for (Point point : other.ship) {
				if (!ship.contains(point)) {
					return false;
				}
			}
			for (Point point : ship) {
				if (!other.ship.contains(point)) {
					return false;
				}
			}
			return true;
	}
	
}
