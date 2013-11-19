package com.clean.main;

import com.clean.ship.ShipLocations;
import com.clean.shipgame.GameWithShips;
import com.clean.tablewithships.ShipImplementation;

public class App 
{
    public static void main( String[] args ) {
    	if (args.length != 5) {
    		throw new IllegalArgumentException();
    	}
    	ShipLocations shipLocations = new ShipLocations();
        ShipImplementation impl = new ShipImplementation(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 
        							Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
    	GameWithShips game = new GameWithShips();
    	game.setShipLocations(shipLocations);
    	game.setImpl(impl);
    	game.initialise();
    	game.play();
    }
}
