package com.clean.strategy;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.Point;

public class FirePositionStrategyTestForInitialise {
	
	FirePositionStrategy underTest;
	XYGuessGenerator generator;
	
	@Before
	public void setUp() {
		underTest = new FirePositionStrategy();
		generator = EasyMock.createMock(XYGuessGenerator.class);
		underTest.setGenerator(generator);
	}
	
	@Test
	public void testInitialiseForRunningTheCorrectMethods() {
		//GIVEN
		generator.addMagicElement();
		EasyMock.expectLastCall();
		generator.generateOptimalGuess(0);
		EasyMock.expectLastCall();
		List<Point> list = new ArrayList<>();
		EasyMock.expect(generator.getGuesses()).andReturn(list);
		generator.generateOptimalGuess(1);
		EasyMock.expectLastCall();
		EasyMock.expect(generator.getGuesses()).andReturn(list);
		EasyMock.replay(generator);
		//WHEN
		underTest.initialise();
		//THEN
		EasyMock.verify(generator);
	}
	
	@Test
	public void testInitialiseForCorrectlyStoringTheHalfLists() {
		//GIVEN
		generator.generateOptimalGuess(EasyMock.anyInt());
		EasyMock.expectLastCall().anyTimes();
		generator.addMagicElement();
		EasyMock.expectLastCall().anyTimes();
		List<Point> list1 = new ArrayList<>();
		
		List<Point> list = new ArrayList<>();
		list.add(new Point(1, 2));
		EasyMock.expect(generator.getGuesses()).andReturn(list);
		List<Point> expectedHalf = new ArrayList<>();
		expectedHalf.add(new Point(1, 2));

		EasyMock.expect(generator.getGuesses()).andReturn(list1);
		EasyMock.replay(generator);
		//WHEN
		underTest.initialise();
		//THEN
		EasyMock.verify(generator);
		Assert.assertEquals(expectedHalf, underTest.getGuessesFirstHalf());
	}
	
	@Test
	public void testInitialiseForCorrectlyStoringTheFullLists() {
		//GIVEN
		generator.generateOptimalGuess(EasyMock.anyInt());
		EasyMock.expectLastCall().anyTimes();
		generator.addMagicElement();
		EasyMock.expectLastCall().anyTimes();
		List<Point> list = new ArrayList<>();
		EasyMock.expect(generator.getGuesses()).andReturn(list);
	
		List<Point> list1 = new ArrayList<>();
		list1.add(new Point(1, 2));
		list1.add(new Point(2, 2));
		List<Point> expectedFull = new ArrayList<>();
		expectedFull.add(new Point(1, 2));
		expectedFull.add(new Point(2, 2));
		EasyMock.expect(generator.getGuesses()).andReturn(list1);
		EasyMock.replay(generator);
		//WHEN
		underTest.initialise();
		//THEN
		EasyMock.verify(generator);
		Assert.assertEquals(expectedFull, underTest.getGuesses());
	}
	
	
	
/*	@Test
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
*/
}
