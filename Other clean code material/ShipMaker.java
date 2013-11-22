package com.epam.torpedo.peter;

public class ShipMaker {

    private Table table;

    public void initialise() {
        table.initialise();
    }

    public void makeShipWithAnUpsideDownTShape(int x, int y) {
        table.setXY(x, y, true);
        table.setXY(x + 1, y, true);
        table.setXY(x + 2, y, true);
        table.setXY(x + 1, y + 1, true);
    }

    public void makeShipWithFourPoints(int x, int y) {
        table.setXY(x, y, true);
        table.setXY(x + 1, y, true);
        table.setXY(x + 2, y, true);
        table.setXY(x + 3, y, true);
    }

    public void makeShipWithThreePoints(int x, int y) {
        table.setXY(x, y, true);
        table.setXY(x + 1, y, true);
        table.setXY(x + 2, y, true);
    }

    public void makeShipWithTwoPoints(int x, int y) {
        table.setXY(x, y, true);
        table.setXY(x + 1, y, true);
    }

    public void makeShipWithOnePoint(int x, int y) {
        table.setXY(x, y, true);
    }

    public Table getTable() {
        return table;
    }
}
