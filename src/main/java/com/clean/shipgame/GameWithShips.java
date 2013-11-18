package com.clean.shipgame;

import com.clean.interfaces.Torpedo;
import com.clean.ship.ShipLocations;
import com.clean.tablewithships.ShipImplementation;
import com.clean.tablewithships.ShipSetter;
import com.clean.tablewithships.TableWithShips;

public class GameWithShips implements Torpedo {
	
	private TableWithShips table;
	private ShipLocations shipLocations;
    private ShipImplementation impl;
	private int winCondition;
	private int counter;
	private ShipSetter shipMaker;
	
    public boolean fire(int x, int y) {
    	shipLocations.hit(x, y);
        return table.getXY(x, y);
    }
    
    public boolean checkIfSunken() {
		return shipLocations.checkSunken();
    }
    
    public void initialise() {
    	table.setShipLocations(shipLocations);
    	table.setImpl(impl);
    	table.setShipMaker(shipMaker);
    	table.initialise();
    }

	public void play() {
		winCondition = 0;
		counter = 0;
		while (winCondition != 40) {
			if (fire(counter % 20, counter/20)) {
				winCondition++;
				if (checkIfSunken()){
					System.out.format("Ship Sunken at %d %n", counter);
				}
			}
			counter++;
		}
		System.out.format("Fired %d times %n", counter);
	}

	public void setTable(TableWithShips table) {
		this.table = table;
	}

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

	public void setImpl(ShipImplementation impl) {
		this.impl = impl;
	}
	
	public void setShipMaker(ShipSetter shipMaker) {
		this.shipMaker = shipMaker;
	}

}
