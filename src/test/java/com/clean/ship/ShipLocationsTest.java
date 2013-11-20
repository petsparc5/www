package com.clean.ship;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ShipLocationsTest {
	
	ShipLocations underTest;
	private String[][] shape;
	
	@Before
	public void setUp() {
		underTest = new ShipLocations();
		setUpShape1();
	}
	
	@Test
	public void testAddShipLocation() {
		//Given
		//When
		underTest.addShipLocation(19, 19, shape);
		boolean actual = underTest.checkPoint(19, 19);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckShip() {
		//Given
		underTest.addShipLocation(1, 2, shape);
		//When
		boolean actual = underTest.checkShip(1, 2, shape);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckShipWhenEmpty() {
		//Given
		//When
		boolean actual = underTest.checkShip(1, 2, shape);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testHit() {
		//Given
		underTest.addShipLocation(5, 5, shape);
		//When
		boolean actual = underTest.hit(5, 5);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testHitWhenMisses() {
		//Given
		underTest.addShipLocation(5, 5, shape);
		//When
		boolean actual = underTest.hit(6, 6);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testCheckSunken() {
		//Given
		underTest.addShipLocation(5, 5, shape);
		underTest.hit(5, 5);
		underTest.hit(5, 6);
		//When
		boolean actual = underTest.checkSunken();
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testCheckSunkenWhenItIsNot() {
		//Given
		underTest.addShipLocation(5, 5, shape);
		underTest.hit(5, 5);
		//When
		boolean actual = underTest.checkSunken();
		//Then
		Assert.assertEquals(false, actual);
	}
	
	public void setUpShape1() {
		String[] row1 = new String[4];
		row1[0] = "X";
		row1[1] = "X";
		row1[2] = "O";
		row1[3] = "O";
		String[] row2 = new String[4];
		row2[0] = "O";
		row2[1] = "O";
		row2[2] = "O";
		row2[3] = "O";
		String[] row3 = new String[4];
		row3[0] = "O";
		row3[1] = "O";
		row3[2] = "O";
		row3[3] = "O";
		String[] row4 = new String[4];
		row4[0] = "O";
		row4[1] = "O";
		row4[2] = "O";
		row4[3] = "O";
		shape = new String[4][4];
		shape[0] = row1;
		shape[1] = row2;
		shape[2] = row3;
		shape[3] = row4;
	}

}
