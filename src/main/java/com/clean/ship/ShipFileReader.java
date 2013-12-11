package com.clean.ship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads the file with the ships.
 * @author Peter_Takacs
 *
 */
public class ShipFileReader {

    private final Logger logger = LoggerFactory.getLogger(ShipFileReader.class);
    private List<String[][]> ships = new ArrayList<String[][]>();
    private List<Integer> numberOfShips = new ArrayList<Integer>();

    private String filename;

    private String[] convert(String string, int length) {
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            answer[i] = string.substring(i, i + 1);
        }
        return answer;
    }

    /**
     * Reads the content of the file that contains the ships.
     */
    public void read() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(filename)));
            logger.warn("filename=" + filename);
        } catch (IOException e) {
            logger.error("Could not locate your file");
        }

        String line = "";
        int checkForNewShip = 1;
        String[][] shipShape;

        try {
            numberOfShips.add(Integer.valueOf(reader.readLine()));
            String firstline = reader.readLine();
            int length = firstline.length();
            shipShape = new String[length][length];
            shipShape[0] = convert(firstline, length);
            while ((line = reader.readLine()) != null) {
                if (checkForNewShip == length) {
                    numberOfShips.add(Integer.valueOf(line));
                    checkForNewShip = 0;
                    ships.add(shipShape);
                    shipShape = new String[length][length];
                } else {
                    shipShape[checkForNewShip] = convert(line, length);
                    checkForNewShip++;
                }
            }
            ships.add(shipShape);
        } catch (IOException e) {
            logger.error("Could not read from the file");
        }
    }

    public List<String[][]> getShips() {
        return ships;
    }

    public List<Integer> getNumberOfShips() {
        return numberOfShips;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
