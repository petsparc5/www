package com.clean.strategy;

import org.junit.Before;
import org.junit.Test;

public class FirePositionStrategyTest {
	
	FirePositionStrategy underTest;
	
	@Before
	public void setUp() {
		underTest = new FirePositionStrategy(6);
		underTest.initialise();
	}
	
	@Test
	public void test1() {
		
	}

}
