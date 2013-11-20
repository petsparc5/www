package com.clean.strategy;

import org.junit.Before;
import org.junit.Test;

public class FirePositionStrategyTest {
	
	FirePositionStrategy underTest;
	
	@Before
	public void setUp() {
		underTest = new FirePositionStrategy(3);
		underTest.initialise();
	}
	
	@Test
	public void test1() {
		String fire1 = underTest.nextTarget("miss");
		System.out.format("fire1=%s %n", fire1);
		String fire2 = underTest.nextTarget("hit");
		System.out.format("fire2=%s %n", fire2);
		String fire3 = underTest.nextTarget("hit");
		System.out.format("fire3=%s %n", fire3);
		String fire4 = underTest.nextTarget("sunk");
		System.out.format("fire4=%s %n", fire4);
		String fire5 = underTest.nextTarget("miss");
		System.out.format("fire5=%s %n", fire5);
		String fire6 = underTest.nextTarget("sunk");
		System.out.format("fire6=%s %n", fire6);
		String fire7 = underTest.nextTarget("sunk");
		System.out.format("fire7=%s %n", fire7);
		String fire8 = underTest.nextTarget("miss");
		System.out.format("fire8=%s %n", fire8);
		String fire9 = underTest.nextTarget("miss");
		System.out.format("fire9=%s %n", fire9);
		String fire10 = underTest.nextTarget("miss");
		System.out.format("fire10=%s %n", fire10);
		String fire11 = underTest.nextTarget("miss");
		System.out.format("fire11=%s %n", fire11);
		String fire12 = underTest.nextTarget("miss");
		System.out.format("fire12=%s %n", fire12);
		String fire13 = underTest.nextTarget("miss");
		System.out.format("fire13=%s %n", fire13);
		String fire14 = underTest.nextTarget("miss");
		System.out.format("fire14=%s %n", fire14);
		String fire15 = underTest.nextTarget("miss");
		System.out.format("fire15=%s %n", fire15);
		String fire16 = underTest.nextTarget("miss");
		System.out.format("fire16=%s %n", fire16);
	}

}
