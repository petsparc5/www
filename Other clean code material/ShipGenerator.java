package com.epam.torpedogame.ship;

import java.util.ArrayList;
import java.util.List;

import com.epam.torpedogame.point.TablePoint;

public class ShipGenerator {

    public List<TablePoint> makeShipWithFourPointsInATShape(int x, int y) {
        if (checkTShip(x, y)) {
            throw new IllegalArgumentException();
        } else {
            List<TablePoint> points = new ArrayList<>();
            points.add(new TablePoint(x, y));
            points.add(new TablePoint(x + 1, y));
            points.add(new TablePoint(x + 2, y));
            points.add(new TablePoint(x + 1, y + 1));
            return points;
        }
    }

    private boolean checkTShip(int x, int y) {
        return ((x < 0) || (x > 18) || (y < 1) || (y > 20));
    }

    public List<TablePoint> makeShipWithFourConsecutivePoints(int x, int y) {
        if (checkFourPointShip(x, y)) {
            throw new IllegalArgumentException();
        } else {
            List<TablePoint> points = new ArrayList<>();
            points.add(new TablePoint(x, y));
            points.add(new TablePoint(x + 1, y));
            points.add(new TablePoint(x + 2, y));
            points.add(new TablePoint(x + 3, y));
            return points;
        }
    }

    private boolean checkFourPointShip(int x, int y) {
        return ((x < 0) || (x > 17) || (y < 0) || (y > 20));
    }

    public List<TablePoint> makeShipWithThreeConsecutivePoints(int x, int y) {
        if (checkThreePointShip(x, y)) {
            throw new IllegalArgumentException();
        } else {
            List<TablePoint> points = new ArrayList<>();
            points.add(new TablePoint(x, y));
            points.add(new TablePoint(x + 1, y));
            points.add(new TablePoint(x + 2, y));
            return points;
        }
    }

    private boolean checkThreePointShip(int x, int y) {
        return ((x < 0) || (x > 18) || (y < 0) || (y > 20));
    }

    public List<TablePoint> makeShipWithTwoConsecutivePoints(int x, int y) {
        if (checkTwoPointShip(x, y)) {
            throw new IllegalArgumentException();
        } else {
            List<TablePoint> points = new ArrayList<>();
            points.add(new TablePoint(x, y));
            points.add(new TablePoint(x + 1, y));
            return points;
        }
    }

    private boolean checkTwoPointShip(int x, int y) {
        return ((x < 1) || (x > 19) || (y < 1) || (y > 20));
    }

    public List<TablePoint> makeShipWithOnePoint(int x, int y) {
        if (checkOnePointShip(x, y)) {
            throw new IllegalArgumentException();
        } else {
            List<TablePoint> points = new ArrayList<>();
            points.add(new TablePoint(x, y));
            return points;
        }
    }

    private boolean checkOnePointShip(int x, int y) {
        return ((x < 0) || (x > 20) || (y < 0) || (y > 20));
    }
}
