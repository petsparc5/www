package com.clean.TwentybyTwenty;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestTable {
	
	Table underTest;
	
	@Before
	public void setUp() {
		underTest = new Table();
		underTest.initialiseTheTable();
	}
	
	@Test
	public void testIntialisationTheTableSetUpTwentyFiveTargets() {
		int count = 0;
		for (int index = 0; index < 400; index++){
			if (underTest.checkCoordinates(index%20, index/20)) {
				count++;
			}
		}
		Assert.assertEquals(25, count);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckCoordinatesThrowsIllegalArgumentExceptionWhenXIsMoreThanTwenty() {
		underTest.checkCoordinates(21, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckCoordinatesThrowsIllegalArgumentExceptionWhenXIsLessThanZero() {
		underTest.checkCoordinates(-5, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckCoordinatesThrowsIllegalArgumentExceptionWhenYIsMoreThanTwenty() {
		underTest.checkCoordinates(15, 99);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckCoordinatesThrowsIllegalArgumentExceptionWhenYIsMoreThanZero() {
		underTest.checkCoordinates(16, -9);
	}
	
	

}
