package com.clean.main;

import com.clean.interfaces.GameStrategy;
import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;
import com.clean.shipgame.GameWithShips;
import com.clean.strategy.FirePositionStrategy;
import com.clean.tablewithships.ShipImplementation;
import com.clean.torpedo.network.TorpedoClient;
import com.clean.torpedo.network.TorpedoServer;



public class App 
{
    public static void main( String[] args ) {
    	if (args.length != 3) {
    		throw new IllegalArgumentException("You need to specify a file, port or host:port and boardsize");
    	}
    	ShipFileReader shipFileReader = new ShipFileReader();
        ShipLocations shipLocations = new ShipLocations();
        ShipImplementation impl = new ShipImplementation();
        GameWithShips game = new GameWithShips();
        game.setImpl(impl);
        game.setFilename(args[0]);
        game.setShipFileReader(shipFileReader);
        game.setShipLocations(shipLocations);
    	if(args[1].contains(":")){
            TorpedoClient torpedoClient = new TorpedoClient(args[1]);
            game.setBoardSize(Integer.parseInt(args[2]));
            GameStrategy gameStrategy = new FirePositionStrategy(Integer.parseInt(args[2]));
            gameStrategy.initialise();
            torpedoClient.initClient(game, gameStrategy);
    	} else {
            TorpedoServer torpedoServer = new TorpedoServer(args[1]);
            torpedoServer.initServer(game);

    	}
    }
}
