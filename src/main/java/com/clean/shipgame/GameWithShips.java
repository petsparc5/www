package com.clean.shipgame;

import com.clean.interfaces.Torpedo;
import com.clean.ship.ShipLocations;
import com.clean.tablewithships.ShipImplementation;

public class GameWithShips implements Torpedo {
	
	private ShipLocations shipLocations;
    private ShipImplementation impl;
	private int winCondition;
	private int counter;
	private ConsolePrinter consolePrinter;
	
    public boolean fire(int x, int y) {
    	return shipLocations.hit(x, y);
    }
    
    public boolean checkIfSunken() {
		return shipLocations.checkSunken();
    }
    
    public void initialise() {
    	impl.setShipLocations(shipLocations);
    	impl.placeShips();
    	consolePrinter = new ConsolePrinter(shipLocations);
    }

	public void play() {
		winCondition = 0;
		counter = 0;
		int numberOfTargets = impl.getNumberOfTargets();
		consolePrinter.printBoard();
		while (winCondition != numberOfTargets) {
			if (fire(counter % 20, counter/20)) {
				winCondition++;
				if (checkIfSunken()){
					System.out.format("Ship Sunken at %d, %d %n", counter%20, counter/20);
					consolePrinter.printBoard();
				}
			}
			counter++;
		}
		System.out.format("Fired %d times %n", counter);
	}

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

	public void setImpl(ShipImplementation impl) {
		this.impl = impl;
	}


}
