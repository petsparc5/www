package com.clean.tablewithships;

import java.util.Random;

import com.clean.ship.ShipLocations;

public class ShipImplementation {
	
    Random randomgenerator;
    private ShipLocations shipLocations;


	public ShipImplementation(int numberOfTShip, int numberOfFourShip,
			int numberOfThreeShip, int numberOfTwoShip, int numberOfOneShip) {
		super();
		this.numberOfTShip = numberOfTShip;
		this.numberOfFourShip = numberOfFourShip;
		this.numberOfThreeShip = numberOfThreeShip;
		this.numberOfTwoShip = numberOfTwoShip;
		this.numberOfOneShip = numberOfOneShip;
		if (numberOfFourShip < 0 || numberOfOneShip < 0 || numberOfThreeShip < 0 || numberOfTShip < 0 || numberOfTwoShip < 0|| 
			numberOfFourShip > 5 || numberOfOneShip > 5 || numberOfThreeShip > 5 || numberOfTShip > 5 || numberOfTwoShip > 5) {
			throw new IllegalArgumentException();
		}
	}

	private final int numberOfTShip;
	private final int numberOfFourShip;
    private final int numberOfThreeShip;
    private final int numberOfTwoShip;
    private final int numberOfOneShip;
    
    public int getNumberOfTargets(){
    	return numberOfTShip * 4 + numberOfFourShip * 4 + numberOfThreeShip * 3 + numberOfTwoShip * 2 + numberOfOneShip; 
    }

    public void placeShips() {
        randomgenerator = new Random();
        placeTShips();
        placeFourShips();
        placeThreeShips();
        placeTwoShips();
        placeOneShips();
    }

    private void placeTShips() {
        for (int index = 0; index < numberOfTShip; index++) {
        	 int randomInt = randomgenerator.nextInt(18);
        	 int randomInt2 = randomgenerator.nextInt(19);
            if (shipLocations.checkTShip(randomInt, randomInt2)) {
            	index--;
            } else {
	            shipLocations.addTShipLocation(randomInt, randomInt2);
            }   
        }
    }
    
    private void placeFourShips() {
    	for (int index = 0; index < numberOfFourShip; index++) {
       	 int randomInt = randomgenerator.nextInt(17);
       	 int randomInt2 = randomgenerator.nextInt(20);
            if (shipLocations.checkFourShip(randomInt, randomInt2)) {
            	index--;
            } else {
		        shipLocations.addFourShipLocation(randomInt, randomInt2);
            }
    	 }
    }
    
    private void placeThreeShips() {
    	for (int index = 0; index < numberOfThreeShip; index++) {
       	 int randomInt = randomgenerator.nextInt(18);
       	 int randomInt2 = randomgenerator.nextInt(20);
             if (shipLocations.checkThreeShip(randomInt, randomInt2)) {
             	index--;
             } else {
	    		 shipLocations.addThreeShipLocation(randomInt, randomInt2);
             }
    	 }
    }

    private void placeTwoShips() {
    	for (int index = 0; index < numberOfTwoShip; index++) {
       	 int randomInt = randomgenerator.nextInt(19);
       	 int randomInt2 = randomgenerator.nextInt(20);
            if (shipLocations.checkTwoShip(randomInt, randomInt2)) {
             	index--;
             } else {
	    		shipLocations.addTwoShipLocation(randomInt, randomInt2);
             }
    	 }
    }
    
    private void placeOneShips() {
    	for (int index = 0; index < numberOfOneShip; index++) {
       	 int randomInt = randomgenerator.nextInt(20);
       	 int randomInt2 = randomgenerator.nextInt(20);
            if (shipLocations.checkOneShip(randomInt, randomInt2)) {
             	index--;
             } else {
	    		shipLocations.addOneShipLocation(randomInt, randomInt2);
             }
    	}
    }

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

}
