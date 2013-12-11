package com.clean.tablewithships;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;

/**
 * ShipImpl.
 * @author Peter_Takacs
 *
 */
public class ShipImplementation {

    private final Logger logger = LoggerFactory.getLogger(ShipImplementation.class);
    private Random randomgenerator;
    private ShipLocations shipLocations;
    private ShipFileReader reader;
    private List<String[][]> ships = new ArrayList<String[][]>();
    private List<Integer> numberOfShips = new ArrayList<Integer>();
    private int boardSize;
    private int totalNumberOfTargets;
    private String filename;

    private void calculateNumberOfTargets() {
        totalNumberOfTargets = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (shipLocations.checkPoint(i, j)) {
                    totalNumberOfTargets++;
                }
            }
        }
    }

    /**
     * Initialise method.
     */
    public void initialisation() {
        reader.setFilename(filename);
        reader.read();
        ships = reader.getShips();
        numberOfShips = reader.getNumberOfShips();
        shipLocations.setBoardSize(boardSize);
    }

    /**
     * Placing the ships on the board.
     */
    public void placeShips() {
        randomgenerator = new Random();
        int indexForHowManyTimesWeNeedToPlaceAShip = 0;

        for (int index = 0; index < ships.size(); index++) {
            while (indexForHowManyTimesWeNeedToPlaceAShip < numberOfShips.get(index)) {
                String[][] shipShape = ships.get(index);
                int offset = shipShape.length - 1;
                int randomInt = randomgenerator.nextInt(boardSize + offset);
                int randomInt2 = randomgenerator.nextInt(boardSize + offset);
                if (shipLocations.checkShip(randomInt - offset, randomInt2 - offset, shipShape)) {
                    indexForHowManyTimesWeNeedToPlaceAShip--;
                } else {
                    shipLocations.addShipLocation(randomInt - offset, randomInt2 - offset, shipShape);
                }
                indexForHowManyTimesWeNeedToPlaceAShip++;
            }
            indexForHowManyTimesWeNeedToPlaceAShip = 0;
        }
    }

    public void setShipLocations(ShipLocations shipLocations) {
        this.shipLocations = shipLocations;
    }

    public void setReader(ShipFileReader reader) {
        this.reader = reader;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Calculates the number of hit-able positions.
     * @return the value of the number of hit-able position.
     */
    public int getTotalNumberOfTargets() {
        calculateNumberOfTargets();
        return totalNumberOfTargets;
    }

    /**
     * Sets the board size.
     * @param boardSize : the size of the board
     */
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        logger.warn("boardSize={0}", boardSize);
    }

    public void setShips(List<String[][]> ships) {
        this.ships = ships;
    }

    public void setNumberOfShips(List<Integer> numberOfShips) {
        this.numberOfShips = numberOfShips;
    }

}
