package com.clean.ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of ships.
 * @author Peter_Takacs
 *
 */
public class ShipLocations {

    private List<Ship> shipLocations = new ArrayList<Ship>();
    private int boardSize;
    /**
     * The method creates a ship starting from point (x,y) with the given shape and adds it to the list.
     * @param x Coordinate x
     * @param y Coordinate y
     * @param shape The shape is marked with 'X'
     */
    public void addShipLocation(int x, int y, String[][] shape) {
        Ship ship = new Ship();
        ship.createShip(x, y, shape);
        shipLocations.add(ship);
    }
    /**
     * This method checks whether the shape will be placed on another one.
     * @param x Coordinate x
     * @param y Coordinate y
     * @param shape The shape is marked with 'X'
     * @return true if there are already ship(s) on the board, where we want to place the shape.
     */
    public boolean checkShip(int x, int y, String[][] shape) {
        boolean answer = false;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j].contains("X")) {
                    answer |= checkPoint(x + i, y + j);
                }
            }
        }
        return answer;
    }
    /**
     * This method checks whether a certain point on the board contains a ship part.
     * @param x Coordinate x
     * @param y Coordinate y
     * @return true if a ship contains the point (x,y)
     */
    public boolean checkPoint(int x, int y) {
        boolean answer = false;
        for (Ship ship : shipLocations) {
            answer |= ship.contains(x, y);
        }
        if (x < 0 || y < 0 || x >= boardSize || y >= boardSize) {
            answer = true;
        }
        return answer;
    }
    /**
     * Removes the point from the list (and the ship).
     * @param x Coordinate x
     * @param y Coordinate y
     * @return true if the hit was successful.
     */
    public boolean hit(int x, int y) {
        boolean answer = false;
        for (Ship ship : shipLocations) {
            answer |= ship.hit(x, y);
        }
        return answer;
    }
    /**
     * This method checks whether any of the ships are sunken and if they are then they are removed.
     * @return true if a ship is sunken.
     */
    public boolean checkSunken() {
        boolean sunkenShipChecker = false;
        for (int i = 0; i < shipLocations.size(); i++) {
            Ship ship = shipLocations.get(i);
            if (ship.isSunken()) {
                sunkenShipChecker = true;
                shipLocations.remove(i);
            }
        }
        return sunkenShipChecker;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
