package com.clean.ship;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	
	Ship underTest;
	
	@Before
	public void setUp() {
		underTest = new Ship();
	}
	
	@Test
	public void testAddShipWithAnUpsideDownTShape() {
		//Given
		//When
		underTest.addShipWithAnUpsideDownTShape(0, 1);
		boolean actual = underTest.contains(0, 1);
		boolean actual1 = underTest.contains(1, 1);
		boolean actual2 = underTest.contains(2, 1);
		boolean actual3 = underTest.contains(1, 0);
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
		underTest.addShipWithFourPoints(10, 6);
		boolean actual = underTest.contains(10, 6);
		boolean actual1 = underTest.contains(11, 6);
		boolean actual2 = underTest.contains(12, 6);
		boolean actual3 = underTest.contains(13, 6);
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
		underTest.addShipWithThreePoints(5, 1);
		boolean actual = underTest.contains(5, 1);
		boolean actual1 = underTest.contains(6, 1);
		boolean actual2 = underTest.contains(7, 1);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
		Assert.assertEquals(true, actual2);
	}
	
	@Test
	public void testAddShipWithTwoPoints() {
		//Given
		//When
		underTest.addShipWithTwoPoints(2, 13);
		boolean actual = underTest.contains(2, 13);
		boolean actual1 = underTest.contains(3, 13);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
	}
	
	@Test
	public void testAddShipWithOnePoint() {
		//Given
		//When
		underTest.addShipWithOnePoint(19, 19);
		boolean actual = underTest.contains(19, 19);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testHit() {
		//Given
		underTest.addShipWithOnePoint(5, 5);
		//When
		underTest.hit(5, 5);
		boolean actual = underTest.contains(5, 5);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHitWithBadArguments() {
		//Given
		underTest.addShipWithOnePoint(5, 5);
		//When
		underTest.hit(6, 6);
		//Then It Throws An Illegal Argument Exception
	}
	
	@Test
	public void testIsSunken() {
		//Given
		underTest.addShipWithOnePoint(5, 5);
		underTest.hit(5, 5);
		//When
		boolean actual = underTest.isSunken();
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testIsSunkenWhenItIsNot() {
		//Given
		underTest.addShipWithTwoPoints(5, 5);
		underTest.hit(5, 5);
		//When
		boolean actual = underTest.isSunken();
		//Then
		Assert.assertEquals(false, actual);
	}

}
