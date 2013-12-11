package com.clean.shipgame;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;
import com.clean.tablewithships.ShipImplementation;

/**
 * Test for playing.
 * @author Peter_Takacs
 *
 */
public class GameWithShipsTest {

    ShipImplementation impl;
    ShipLocations shipLocations;
    GameWithShips underTest;
    ShipFileReader reader;

    @Before
    public void setUp() {
        underTest = new GameWithShips();
        impl = EasyMock.createMock(ShipImplementation.class);
        shipLocations = EasyMock.createMock(ShipLocations.class);
        reader = EasyMock.createMock(ShipFileReader.class);
        underTest.setShipLocations(shipLocations);
        underTest.setImpl(impl);
        underTest.setShipFileReader(reader);
        underTest.setFilename("stuff.file");
        underTest.setBoardSize(20);
    }

    @Test
    public void testInitialise() {
        //GIVEN
        impl.setReader(reader);
        EasyMock.expectLastCall();
        impl.setFilename("stuff.file");
        EasyMock.expectLastCall();
        impl.setShipLocations(shipLocations);
        EasyMock.expectLastCall();
        impl.setBoardSize(20);
        EasyMock.expectLastCall();
        impl.initialisation();
        EasyMock.expectLastCall();
        impl.placeShips();
        EasyMock.expectLastCall();
        EasyMock.expect(impl.getTotalNumberOfTargets()).andReturn(50);
        EasyMock.replay(impl);
        //WHEN
        underTest.initialise();
        //THEN
        EasyMock.verify(impl);
    }

    @Test
    public void testFireAndSunk() {
        //GIVEN
        EasyMock.expect(shipLocations.hit(3, 4)).andReturn(true);
        EasyMock.expect(shipLocations.checkSunken()).andReturn(true);
        EasyMock.replay(shipLocations);
        Status expected = Status.SUNK;

        //WHEN
        Status actual = underTest.fire(3, 4);
        //THEN
        EasyMock.verify(shipLocations);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFireAndHit() {
        //GIVEN
        EasyMock.expect(shipLocations.hit(3, 4)).andReturn(true);
        EasyMock.expect(shipLocations.checkSunken()).andReturn(false);
        EasyMock.replay(shipLocations);
        Status expected = Status.HIT;

        //WHEN
        Status actual = underTest.fire(3, 4);
        //THEN
        EasyMock.verify(shipLocations);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFireAndMiss() {
        //GIVEN
        EasyMock.expect(shipLocations.hit(2, 1)).andReturn(false);
        EasyMock.replay(shipLocations);
        Status expected = Status.MISS;
        //WHEN
        Status actual = underTest.fire(2, 1);
        //THEN
        EasyMock.verify(shipLocations);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFireAndWin() {
        //GIVEN
        underTest.setNumberOfTargets(1);
        EasyMock.expect(shipLocations.hit(2, 1)).andReturn(true);
        EasyMock.expect(shipLocations.checkSunken()).andReturn(true);
        EasyMock.replay(shipLocations);
        Status expected = Status.WIN;
        //WHEN
        Status actual = underTest.fire(2, 1);
        //THEN
        EasyMock.verify(shipLocations);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckIfSunkenAndReturnFalse() {
        //GIVEN
        EasyMock.expect(shipLocations.checkSunken()).andReturn(false);
        EasyMock.replay(shipLocations);
        //WHEN
        boolean actual = underTest.checkIfSunken();
        //THEN
        EasyMock.verify(shipLocations);
        Assert.assertFalse(actual);
    }

    @Test
    public void testCheckIfSunken() {
        //GIVEN
        EasyMock.expect(shipLocations.checkSunken()).andReturn(true);
        EasyMock.replay(shipLocations);
        //WHEN
        boolean actual = underTest.checkIfSunken();
        //THEN
        EasyMock.verify(shipLocations);
        Assert.assertTrue(actual);
    }
}
