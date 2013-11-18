package com.clean.tablewithships;

import java.util.Arrays;

import com.clean.ship.ShipLocations;


public class TableWithShips {

    private boolean[][] shipField = new boolean[COLUMNS][ROWS];
    static final int COLUMNS = 20;
    static final int ROWS = 20;
    private ShipImplementation impl;
    private ShipLocations shipLocations;
	private ShipSetter shipMaker;
    
    public void initialise() {
    	for (boolean[] row : shipField) {
    		Arrays.fill(row, false);
		}
    	impl.setTable(this);
    	impl.setShipMaker(shipMaker);
    	impl.setTableInShipSetter(this);
    	impl.placeShips();
    	impl.setShipLocations(shipLocations);
    }

    public void setImpl(ShipImplementation impl) {
		this.impl = impl;
	}

	public void setXY(int x, int y, boolean value) {
        shipField[x][y] = value;
    }

    public boolean getXY(int x, int y) {
        return shipField[x][y];
    }
    
    public boolean checkTShip(int x, int y) {
        return (getXY(x, y) || getXY(x+1, y) || getXY(x+1, y-1) || getXY(x+2, y));
    }
    public boolean checkFourShip(int x, int y) {
        return (getXY(x, y) || getXY(x+1, y) || getXY(x+2, y) || getXY(x+3, y));
    }
    
    public boolean checkThreeShip(int x, int y) {
        return (getXY(x, y) || getXY(x+1, y) || getXY(x+2, y));
    }
    public boolean checkTwoShip(int x, int y) {
        return (getXY(x, y) || getXY(x+1, y));
    }

	public ShipLocations getShipLocations() {
		return shipLocations;
	}

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

	public void setShipMaker(ShipSetter shipMaker) {
		this.shipMaker = shipMaker;
	}

}
