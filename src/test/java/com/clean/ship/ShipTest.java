package com.clean.ship;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	
	Ship underTest;
	String[][] shape;
	String[][] shape2;
	String[][] shape3;
	
	@Before
	public void setUp() {
		underTest = new Ship();
		setUpShape1();
	}
	
	@Test
	public void testAddShipWithOnePoint() {
		//Given
		//When
		underTest.createShip(19, 19, shape);
		boolean actual = underTest.contains(19, 19);
		boolean actual1 = underTest.contains(19, 20);
		//Then
		Assert.assertEquals(true, actual);
		Assert.assertEquals(true, actual1);
	}
	
	@Test
	public void testHit() {
		//Given
		underTest.createShip(5, 5, shape);
		//When
		boolean actual = underTest.hit(5, 5);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testHitWithBadArguments() {
		//Given
		underTest.createShip(5, 5, shape);
		//When
		boolean actual = underTest.hit(6, 6);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testIsSunken() {
		//Given
		underTest.createShip(5, 5, shape);
		underTest.hit(5, 5);
		underTest.hit(5, 6);
		//When
		boolean actual = underTest.isSunken();
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testIsSunkenWhenItIsNot() {
		//Given
		underTest.createShip(5, 5, shape);
		underTest.hit(5, 5);
		//When
		boolean actual = underTest.isSunken();
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testEquals() {
		//Given
		underTest.createShip(5, 5, shape);
		Ship ship = new Ship();
		ship.createShip(5, 5, shape);
		//When
		boolean actual = underTest.equals(ship);
		//Then
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testNotEqualsWithLessElements() {
		//Given
		underTest.createShip(5, 5, shape);
		Ship ship = new Ship();
		setUpShape3();
		ship.createShip(5, 5, shape3);
		//When
		boolean actual = underTest.equals(ship);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testNotEqualsWithMoreElements() {
		//Given
		underTest.createShip(5, 5, shape);
		Ship ship = new Ship();
		setUpShape2();
		ship.createShip(5, 5, shape2);
		//When
		boolean actual = underTest.equals(ship);
		//Then
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testHashCode() {
		//Given
		underTest.createShip(5, 5, shape);
		Ship ship = new Ship();
		ship.createShip(5, 5, shape);
		//When
		int expected = ship.hashCode();
		int actual = underTest.hashCode();
		//Then
		Assert.assertEquals(expected, actual);
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
	
	public void setUpShape2() {
		String[] row1 = new String[4];
		row1[0] = "X";
		row1[1] = "X";
		row1[2] = "X";
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
		shape2 = new String[4][4];
		shape2[0] = row1;
		shape2[1] = row2;
		shape2[2] = row3;
		shape2[3] = row4;
	}
	
	public void setUpShape3() {
		String[] row1 = new String[4];
		row1[0] = "X";
		row1[1] = "O";
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
		shape3 = new String[4][4];
		shape3[0] = row1;
		shape3[1] = row2;
		shape3[2] = row3;
		shape3[3] = row4;
	}

}
