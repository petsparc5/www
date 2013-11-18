package com.clean.main;

import com.clean.ship.ShipLocations;
import com.clean.shipgame.GameWithShips;
import com.clean.tablewithships.ShipImplementation;
import com.clean.tablewithships.ShipSetter;
import com.clean.tablewithships.TableWithShips;

public class App 
{
    public static void main( String[] args ) {
    	TableWithShips table = new TableWithShips();
    	ShipLocations shipLocations = new ShipLocations();
        ShipImplementation impl = new ShipImplementation();
    	ShipSetter shipMaker = new ShipSetter();
    	GameWithShips game = new GameWithShips();
    	game.setShipLocations(shipLocations);
    	game.setTable(table);
    	game.setImpl(impl);
		game.setShipMaker(shipMaker);
    	game.initialise();
    	game.play();
    }
}
