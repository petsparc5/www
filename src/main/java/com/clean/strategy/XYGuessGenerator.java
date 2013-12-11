package com.clean.strategy;

import java.util.ArrayList;
import java.util.List;

import com.clean.ship.Point;

/**
 * Generate optimal guesses.
 * @author Peter_Takacs
 *
 */
public class XYGuessGenerator {

    private int boardSize;
    private List<Point> guesses = new ArrayList<>();

    /**
     * Constructor.
     * @param boardSize the size of the board
     */
    public XYGuessGenerator(int boardSize) {
        super();
        this.boardSize = boardSize;
    }

    /**
     * Generates optimal guesses.
     * @param shift needed to generate guesses for the second half of the board
     * @param oddEven stepping by two while generating the guesses
     */
    public void generateOptimalGuess(int shift, int oddEven) {
        int middle = (boardSize - 1) / 2;
        for (int layer = oddEven; layer < middle + 2 + 1; layer = layer + 2) {
            makeALayerOfGuesses(layer, middle, shift);
        }
    }

    private void makeALayerOfGuesses(int layer, int middle, int shift) {
        for (int step = 0; step < layer; step++) {
            makeTopGuess(layer, middle, shift, step);
            makeRightGuess(layer, middle, shift, step);
            makeBottomGuess(layer, middle, shift, step);
            makeLeftGuess(layer, middle, shift, step);
        }
    }

    private void makeTopGuess(int layer, int middle, int shift, int step) {
        int x;
        int y;
        x = middle - layer + step * 2 + shift;
        y = middle + layer;
        storeGuesses(x, y);
    }

    private void makeBottomGuess(int layer, int middle, int shift, int step) {
        int x;
        int y;
        x = middle + layer - step * 2 + shift;
        y = middle - layer;
        storeGuesses(x, y);
    }

    private void makeLeftGuess(int layer, int middle, int shift, int step) {
        int x;
        int y;
        x = middle - layer + shift;
        y = middle - layer + step * 2;
        storeGuesses(x, y);
    }

    private void makeRightGuess(int layer, int middle, int shift, int step) {
        int x;
        int y;
        x = middle + layer + shift;
        y = middle + layer - step * 2;
        storeGuesses(x, y);
    }

    private boolean checkGuesses(int x, int y) {
        return x < 0 || y < 0 || x >= boardSize || y >= boardSize ? false : true;
    }

    private void storeGuesses(int x, int y) {
        if (checkGuesses(x, y)) {
            Point point = new Point(x, y);
            guesses.add(point);
        }
    }

    public List<Point> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Point> guesses) {
        this.guesses = guesses;
    }

    /**
     * resets the guess list.
     */
    public void resetGuesses() {
        guesses = new ArrayList<Point>();
    }
}
