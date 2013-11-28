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
		generator.generateOptimalGuess(0, 0);
		EasyMock.expectLastCall();
		generator.generateOptimalGuess(0, 1);
		EasyMock.expectLastCall();
		List<Point> list = new ArrayList<>();
		EasyMock.expect(generator.getGuesses()).andReturn(list);
		generator.resetGuesses();
		EasyMock.expectLastCall();
		generator.generateOptimalGuess(0, 0);
		EasyMock.expectLastCall();
		generator.generateOptimalGuess(0, 1);
		EasyMock.expectLastCall();
		generator.generateOptimalGuess(1, 0);
		EasyMock.expectLastCall();
		generator.generateOptimalGuess(1, 1);
		EasyMock.expectLastCall();
		List<Point> list1 = new ArrayList<>();
		EasyMock.expect(generator.getGuesses()).andReturn(list1);
		EasyMock.replay(generator);
		//WHEN
		underTest.initialise();
		//THEN
		EasyMock.verify(generator);
	}
	
	@Test
	public void testInitialiseForCorrectlyStoringTheHalfLists() {
		//GIVEN
		generator.generateOptimalGuess(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().anyTimes();
		generator.resetGuesses();
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
		generator.generateOptimalGuess(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().anyTimes();
		generator.resetGuesses();
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
}
