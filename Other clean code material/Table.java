package com.epam.torpedo.peter;

public class Table {

    private boolean[][] shipField = new boolean[COLUMNS][ROWS];
    // x coordinate is column
    static final int COLUMNS = 20;
    // y coordinate is row
    static final int ROWS = 20;

    public void setXY(int x, int y, boolean value) {
        shipField[x][y] = value;
    }

    public boolean getXY(int x, int y) {
        return shipField[x][y];
    }

    public void initialise() {
        for (int row = 0; row < shipField.length; row++) {
            for (int column = 0; column < shipField[row].length; column++) {
                shipField[column][row] = false;
            }
        }
    }

}
