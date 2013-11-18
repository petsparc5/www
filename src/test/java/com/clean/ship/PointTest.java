package com.clean.ship;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
	
	private Point underTest;
	
	@Before
	public void setUp() {
		underTest = new Point(3,4);
	}
	
	@Test
	public void testEquals() {
		Point point = new Point(3, 4);
		boolean actual = underTest.equals(point);
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testEqualsGivenWrongPoint() {
		Point point = new Point(1, 4);
		boolean actual = underTest.equals(point);
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testEqualsGivenWrongObject() {
		String randomString = "Peter";
		boolean actual = underTest.equals(randomString);
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testHashCode() {
		int actual = underTest.hashCode();
		int expected = (31 + 3) * 31 + 4;
		Assert.assertEquals(expected, actual);
	}

}
