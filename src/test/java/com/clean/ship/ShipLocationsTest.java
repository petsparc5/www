package com.clean.ship;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ShipLocationsTest {
	
	ShipLocations underTest;
	
	@Before
	public void setUp() {
		underTest = new ShipLocations();
	}
	
	@Test
	public void testAddTShipLocation() {
		//Given
		//When
		underTest.addTShipLocation(0, 1);
		boolean actual = underTest.checkPoint(0, 1);
		boolean actual1 = underTest.checkPoint(1, 1);
		boolean actual2 = underTest.checkPoint(2, 1);
		boolean actual3 = underTest.checkPoint(1, 2);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
		Assert.assertEquals(true, actual2);
		Assert.assertEquals(true, actual3);
	}
	
	@Test
	public void testAddShipWithFourPoints() {
		//Given
		//When
		underTest.addFourShipLocation(10, 6);
		boolean actual = underTest.checkPoint(10, 6);
		boolean actual1 = underTest.checkPoint(11, 6);
		boolean actual2 = underTest.checkPoint(12, 6);
		boolean actual3 = underTest.checkPoint(13, 6);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
		Assert.assertEquals(true, actual2);
		Assert.assertEquals(true, actual3);
	}
	
	@Test
	public void testAddShipWithThreePoints() {
		//Given
		//When
		underTest.addThreeShipLocation(5, 1);
		boolean actual = underTest.checkPoint(5, 1);
		boolean actual1 = underTest.checkPoint(6, 1);
		boolean actual2 = underTest.checkPoint(7, 1);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
		Assert.assertEquals(true, actual2);
	}
	
	@Test
	public void testAddShipWithTwoPoints() {
		//Given
		//When
		underTest.addTwoShipLocation(2, 13);
		boolean actual = underTest.checkPoint(2, 13);
		boolean actual1 = underTest.checkPoint(3, 13);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
	}
	
	@Test
	public void testAddShipWithOnePoint() {
		//Given
		//When
		underTest.addOneShipLocation(19, 19);;
		boolean actual = underTest.checkPoint(19, 19);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckTShip() {
		//Given
		underTest.addOneShipLocation(1, 2);
		//When
		boolean actual = underTest.checkTShip(1, 2);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckTShipWhenEmpty() {
		//Given
		//When
		boolean actual = underTest.checkTShip(1, 2);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testCheckFourShip() {
		//Given
		underTest.addOneShipLocation(1, 2);
		//When
		boolean actual = underTest.checkFourShip(1, 2);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckFourShipWhenEmpty() {
		//Given
		//When
		boolean actual = underTest.checkFourShip(1, 2);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testCheckThreeShip() {
		//Given
		underTest.addOneShipLocation(1, 2);
		//When
		boolean actual = underTest.checkThreeShip(1, 2);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckThreeShipWhenEmpty() {
		//Given
		//When
		boolean actual = underTest.checkThreeShip(1, 2);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testCheckTwoShip() {
		//Given
		underTest.addOneShipLocation(1, 2);
		//When
		boolean actual = underTest.checkTwoShip(1, 2);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckTwoShipWhenEmpty() {
		//Given
		//When
		boolean actual = underTest.checkTwoShip(1, 2);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testCheckOneShip() {
		//Given
		underTest.addOneShipLocation(2, 2);
		//When
		boolean actual = underTest.checkOneShip(2, 2);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckOneShipWhenEmpty() {
		//Given
		//When
		boolean actual = underTest.checkOneShip(1, 2);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testHit() {
		//Given
		underTest.addTwoShipLocation(5, 5);
		//When
		boolean actual = underTest.hit(5, 5);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testHitWhenMisses() {
		//Given
		underTest.addTwoShipLocation(5, 5);
		//When
		boolean actual = underTest.hit(6, 6);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testCheckSunken() {
		//Given
		underTest.addThreeShipLocation(5, 5);
		underTest.hit(5, 5);
		underTest.hit(6, 5);
		underTest.hit(7, 5);
		//When
		boolean actual = underTest.checkSunken();
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckSunkenWhenItIsNot() {
		//Given
		underTest.addFourShipLocation(5, 5);
		underTest.hit(5, 5);
		underTest.hit(5, 6);
		//When
		boolean actual = underTest.checkSunken();
		//Then
		Assert.assertEquals(false, actual);
	}

}
