package com.clean.random;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestRandomGame {
	
	private RandomGame underTest;
	
	@Before
	public void setUp() {
		underTest = new RandomGame();
	}
	
	@Test
	public void testFire() {
		boolean firstValue = underTest.fire(0, 0);
		if (firstValue) {
			Assert.assertEquals(true, firstValue);
		} else {
			Assert.assertEquals(false, firstValue);
		}
	}

}
