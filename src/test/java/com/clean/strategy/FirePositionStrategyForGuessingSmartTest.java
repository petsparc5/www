package com.clean.strategy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.Point;

/**
 * Guessing Smart test.
 * @author Peter_Takacs
 *
 */
public class FirePositionStrategyForGuessingSmartTest {

    FirePositionStrategy underTest;
    List<Point> listHits = new ArrayList<>();
    List<Point> listFull = new ArrayList<>();

    @Before
    public void setUp() {
        underTest = new FirePositionStrategy();
        listHits = new ArrayList<>();
        listFull = new ArrayList<>();
    }

    @Test
    public void testGuessingSmartForUp() {
        //GIVEN
        setUpForUp();
        Point point = new Point(1, 3);
        //WHEN
        String actual = underTest.guessingsmart();
        //THEN
        Assert.assertEquals(1, underTest.getPeter());
        Assert.assertEquals("fire 1 3", actual);
        Assert.assertEquals(point, underTest.getTempPoint());
    }

    @Test
    public void testGuessingSmartForDown() {
        //GIVEN
        setUpForDown();
        Point point = new Point(1, 1);
        //WHEN
        String actual = underTest.guessingsmart();
        //THEN
        Assert.assertEquals(1, underTest.getPeter());
        Assert.assertEquals("fire 1 1", actual);
        Assert.assertEquals(point, underTest.getTempPoint());
    }

    @Test
    public void testGuessingSmartForLeft() {
        //GIVEN
        setUpForLeft();
        Point point = new Point(0, 2);
        //WHEN
        String actual = underTest.guessingsmart();
        //THEN
        Assert.assertEquals(1, underTest.getPeter());
        Assert.assertEquals("fire 0 2", actual);
        Assert.assertEquals(point, underTest.getTempPoint());
    }

    @Test
    public void testGuessingSmartForRight() {
        //GIVEN
        setUpForRight();
        Point point = new Point(2, 2);
        //WHEN
        String actual = underTest.guessingsmart();
        //THEN
        Assert.assertEquals(1, underTest.getPeter());
        Assert.assertEquals("fire 2 2", actual);
        Assert.assertEquals(point, underTest.getTempPoint());
    }

    @Test
    public void testGuessingSmartWhenEverythingWasAlreadyHit() {
        //GIVEN
        setUpForWhenEverythingWasAlreadyHit();
        Point point = new Point(7, 7);
        //WHEN
        String actual = underTest.guessingsmart();
        //THEN
        Assert.assertEquals(1, underTest.getPeter());
        Assert.assertEquals("fire 7 7", actual);
        Assert.assertEquals(point, underTest.getTempPoint());
    }

    public void setUpForUp() {
        listFull.add(new Point(1, 3));
        listHits.add(new Point(1, 2));
        underTest.setHits(listHits);
        underTest.setGuesses(listFull);
    }

    public void setUpForDown() {
        listFull.add(new Point(1, 1));
        listHits.add(new Point(1, 2));
        underTest.setHits(listHits);
        underTest.setGuesses(listFull);
    }

    public void setUpForLeft() {
        listFull.add(new Point(0, 2));
        listHits.add(new Point(1, 2));
        underTest.setHits(listHits);
        underTest.setGuesses(listFull);
    }

    public void setUpForRight() {
        listFull.add(new Point(2, 2));
        listHits.add(new Point(1, 2));
        underTest.setHits(listHits);
        underTest.setGuesses(listFull);
    }

    public void setUpForWhenEverythingWasAlreadyHit() {
        listFull.add(new Point(7, 7));
        listHits.add(new Point(1, 2));
        listHits.add(new Point(6, 7));
        underTest.setHits(listHits);
        underTest.setGuesses(listFull);
    }

}
