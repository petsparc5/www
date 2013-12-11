package com.clean.shipgame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.interfaces.Torpedo;
import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;
import com.clean.tablewithships.ShipImplementation;

/**
 * The actual game.
 * @author Csaba_Valyi
 *
 */
public class GameWithShips implements Torpedo {

    private final Logger logger = LoggerFactory.getLogger(GameWithShips.class);
    private ShipLocations shipLocations;
    private ShipImplementation impl;
    private int loseCondition;
    private int numberOfTargets;
    private int boardSize;
    private String filename;
    private ShipFileReader shipFileReader;
    //private ConsolePrinter printer;

    @Override
    public Status fire(int x, int y) {
        Status status = Status.MISS;
        if (shipLocations.hit(x, y)) {
            status = Status.HIT;
            loseCondition++;
            logger.warn("Losecondition=" + loseCondition);
            //printer.printBoard();
            if (checkIfSunken()) {
                status = Status.SUNK;
                logger.warn("SUNK, Oh no!");
                if (loseCondition == numberOfTargets) {
                    status = Status.WIN;
                }
            }
        }
        return status;
    }
/**
 * This method checks whether a ship is sunken or not.
 * @return true if a ship is sunk, false if not.
 */
    public boolean checkIfSunken() {
        return shipLocations.checkSunken();
    }
    /**
     * This method initialises the class.
     */
    public void initialise() {
        impl.setReader(shipFileReader);
        impl.setFilename(filename);
        impl.setShipLocations(shipLocations);
        impl.setBoardSize(boardSize);
        impl.initialisation();
        impl.placeShips();
        //printer = new ConsolePrinter(shipLocations, boardSize);
        numberOfTargets = impl.getTotalNumberOfTargets();
        logger.warn("numberOfTargets=" + numberOfTargets);
    }

    public void setShipLocations(ShipLocations shipLocations) {
        this.shipLocations = shipLocations;
    }

    public void setImpl(ShipImplementation impl) {
        this.impl = impl;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setShipFileReader(ShipFileReader shipFileReader) {
        this.shipFileReader = shipFileReader;

    }

    public void setNumberOfTargets(int numberOfTargets) {
        this.numberOfTargets = numberOfTargets;
    }

}
