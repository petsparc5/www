package com.clean.shipgame;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.ShipLocations;
import com.clean.tablewithships.ShipImplementation;

public class GameWithShipsTest {
	
	ShipImplementation impl;
	ShipLocations shipLocations;
	GameWithShips underTest;
	
	@Before
	public void setUp() {
		underTest = new GameWithShips();
		impl = EasyMock.createMock(ShipImplementation.class);
		shipLocations = EasyMock.createMock(ShipLocations.class);
		underTest.setShipLocations(shipLocations);
		underTest.setImpl(impl);
	}
	
	@Test
	public void testInitialise() {
		//GIVEN
		impl.setShipLocations(shipLocations);
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
		Assert.assertEquals(expected , actual);
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
		Assert.assertEquals(expected , actual);
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
	public void testCheckIfSunkenAndReturnFalse() {
		//GIVEN
		EasyMock.expect(shipLocations.checkSunken()).andReturn(false);
		EasyMock.replay(shipLocations);
		//WHEN
		boolean actual = underTest.checkIfSunken();
		//THEN
		EasyMock.verify(shipLocations);
		Assert.assertEquals(false, actual);
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
		Assert.assertEquals(true, actual);
	}
}
