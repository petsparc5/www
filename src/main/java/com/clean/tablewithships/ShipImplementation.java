package com.clean.tablewithships;

import java.util.Random;

import com.clean.ship.ShipLocations;

public class ShipImplementation {

	private TableWithShips table;
    private ShipSetter shipMaker;
    Random randomgenerator;
    private ShipLocations shipLocations;
    static final int NUMBEROFTSHIPS = 3;
    static final int NUMBEROFFOURSHIPS = 2;
    static final int NUMBEROFTHREESHIPS = 3;
    static final int NUMBEROFTWOSHIPS = 5;
    static final int NUMBEROFONESHIPS = 1;

    public void placeShips() {
        randomgenerator = new Random();
        placeTShips();
        placeFourShips();
        placeThreeShips();
        placeTwoShips();
        placeOneShips();
    }

    private void placeTShips() {
        for (int index = 0; index < NUMBEROFTSHIPS; index++) {
            int randomInt = randomgenerator.nextInt(18 * 19);
            if (table.checkTShip(randomInt % 18, randomInt / 19 + 1)) {
            	index--;
            } else {
	            shipMaker.makeShipWithAnUpsideDownTShape(randomInt % 18, randomInt / 19 + 1);
	            shipLocations.addTShipLocation(randomInt);
            }   
        }
    }
    
    private void placeFourShips() {
    	for (int index = 0; index < NUMBEROFFOURSHIPS; index++) {
	        int randomInt = randomgenerator.nextInt(17 * 20);
            if (table.checkFourShip(randomInt % 17, randomInt / 17)) {
            	index--;
            } else {
		        shipLocations.addFourShipLocation(randomInt);
		        shipMaker.makeShipWithFourPoints(randomInt % 17, randomInt / 17);
            }
    	 }
    }
    
    private void placeThreeShips() {
    	for (int index = 0; index < NUMBEROFTHREESHIPS; index++) {
    		 int randomInt = randomgenerator.nextInt(18 * 20);
             if (table.checkThreeShip(randomInt % 18, randomInt / 18)) {
             	index--;
             } else {
	    		 shipLocations.addThreeShipLocation(randomInt);
	    		 shipMaker.makeShipWithThreePoints(randomInt % 18, randomInt / 18);
             }
    	 }
    }

    private void placeTwoShips() {
    	for (int index = 0; index < NUMBEROFTWOSHIPS; index++) {
    		int randomInt = randomgenerator.nextInt(19 * 20);
            if (table.checkTwoShip(randomInt % 19, randomInt / 19)) {
             	index--;
             } else {
	    		shipLocations.addTwoShipLocation(randomInt);
	        	shipMaker.makeShipWithTwoPoints(randomInt % 19, randomInt / 19);
             }
    	 }
    }
    
    private void placeOneShips() {
    	for (int index = 0; index < NUMBEROFONESHIPS; index++) {
    		int randomInt = randomgenerator.nextInt(20 * 20);
            if (table.getXY(randomInt % 20, randomInt / 20)) {
             	index--;
             } else {
	    		shipLocations.addOneShipLocation(randomInt);
	    		shipMaker.makeShipWithOnePoint(randomInt % 20, randomInt / 20);
             }
    	}
    }
    
    public void setTableInShipSetter(TableWithShips table) {
    	shipMaker.setTable(table);
    }

	public void setShipMaker(ShipSetter shipMaker) {
		this.shipMaker = shipMaker;
	}

	public void setShipLocations(ShipLocations shipLocations) {
		this.shipLocations = shipLocations;
	}

	public void setTable(TableWithShips table) {
		this.table = table;
	}

}
