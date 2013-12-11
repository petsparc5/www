package com.clean.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.ship.ShipLocations;

/**
 * Console Printer.
 * @author Csaba_Valyi
 *
 */
public class ConsolePrinter {

    private final Logger logger = LoggerFactory.getLogger(ConsolePrinter.class);
    private ShipLocations shipLocations;
    private final int boardSize;

    /**
     * Constructor.
     * @param shipLocations : the ship location class.
     * @param boardSize : the size of the board.
     */
    public ConsolePrinter(ShipLocations shipLocations, int boardSize) {
        super();
        this.shipLocations = shipLocations;
        this.boardSize = boardSize;
    }

    private String converter(boolean value) {
        return value ? "X" : String.format("%c", '.');
    }

    /**
     * Prints the board with logger.warn().
     */
    public void printBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < boardSize * 2 + 2; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("\n");
        for (int i = 0; i < boardSize; i++) {
            stringBuilder.append("|");
            for (int j = 0; j < boardSize; j++) {
                stringBuilder.append(converter(shipLocations.checkPoint(j, boardSize - i)) + " ");
            }
            stringBuilder.append("|");
            stringBuilder.append("\n");
        }
        for (int i = 0; i < boardSize * 2 + 2; i++) {
            stringBuilder.append("-");
        }
        logger.warn("Table:{0}", stringBuilder.toString());
    }

}
