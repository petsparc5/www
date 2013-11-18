package com.clean.TwentybyTwenty;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class TestGame {
	
	private Game underTest;
	private Table table;
	
	@Before
	public void setUp() {
		table = EasyMock.createMock(Table.class);
		underTest = new Game();
		underTest.setTable(table);
	}
	
	@Test
	public void testInitialisation() {
		table.initialiseTheTable();
		EasyMock.expectLastCall();
		EasyMock.replay(table);
		underTest.initialiseTheTable();
		EasyMock.verify(table);
	}
	
	@Test
	public void testFire() {
		EasyMock.expect(table.checkCoordinates(14, 3)).andReturn(true);
		EasyMock.replay(table);
		boolean firstValue = underTest.fire(14, 3);
		Assert.assertEquals(true, firstValue);
		EasyMock.verify(table);
	}
	@Test
	public void testPlayFiredTwentyFiveTimes() {
		EasyMock.expect(table.checkCoordinates(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(25);
		EasyMock.replay(table);
		underTest.play();
		int actualWinCondition = underTest.getWinCondition();
		Assert.assertEquals(25, actualWinCondition);
	}
}
