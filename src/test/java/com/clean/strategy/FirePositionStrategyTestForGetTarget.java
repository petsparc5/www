package com.clean.strategy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.Point;
import com.clean.shipgame.Status;

public class FirePositionStrategyTestForGetTarget {
	
	FirePositionStrategy underTest;
	List<Point> listHits = new ArrayList<>();
	List<Point> listFull = new ArrayList<>();
	List<Point> listHalf = new ArrayList<>();
	
	@Before
	public void setUp() {
		underTest = new FirePositionStrategy();
		listHits = new ArrayList<>();
		listFull = new ArrayList<>();
		listHalf = new ArrayList<>();
	}
	
	@Test
	public void testGetTargetWhenThereIsANeedToRemove() {
		//GIVEN
		setUpForSunkWhenThereIsANeedToRemove();
		//WHEN
		String actual = underTest.getTarget(Status.SUNK);
		//THEN
		Assert.assertEquals(1, underTest.getPeter());
		Assert.assertEquals("fire 5 5", actual);
		Assert.assertEquals(null, underTest.getTempPoint());
	}
	
	@Test
	public void testGetTargetWhenThereIsNoNeedToRemove() {
		//GIVEN
		setUpForSunkWhenThereIsNoNeedToRemove();
		Point point = new Point(1, 3);
		//WHEN
		String actual = underTest.getTarget(Status.SUNK);
		//THEN
		Assert.assertEquals(1, underTest.getPeter());
		Assert.assertEquals("fire 1 3", actual);
		Assert.assertEquals(point, underTest.getTempPoint());
	}
	
	@Test
	public void testGetTargetForHitWhenTempIsEmpty() {
		//GIVEN
		setUpForHitWhenTempIsEmpty();
		Point point = new Point(10, 14);
		Point originalPoint = new Point(10, 13);
		//WHEN
		String actual = underTest.getTarget(Status.HIT);
		//THEN
		Assert.assertEquals(1, underTest.getPeter());
		Assert.assertEquals("fire 10 14", actual);
		Assert.assertEquals(point, underTest.getTempPoint());
		Assert.assertEquals(originalPoint, underTest.getHits().get(0));
	}
	
	@Test
	public void testGetTargetForHitWhenTempIsNotEmpty() {
		//GIVEN
		setUpForHitWhenTempIsNotEmpty();
		Point originalPoint = new Point(10, 13);
		Point point = new Point(10, 14);
		//WHEN
		String actual = underTest.getTarget(Status.HIT);
		//THEN
		Assert.assertEquals(1, underTest.getPeter());
		Assert.assertEquals("fire 10 14", actual);
		Assert.assertEquals(point, underTest.getTempPoint());
		Assert.assertEquals(originalPoint, underTest.getHits().get(0));
	}
	
	@Test
	public void testGetTargetForMissWhenHitsIsEmpty() {
		//GIVEN
		setUpForMissWhenHitsIsEmpty();
		//WHEN
		String actual = underTest.getTarget(Status.MISS);
		//THEN
		Assert.assertEquals(1, underTest.getPeter());
		Assert.assertEquals("fire 7 4", actual);
		Assert.assertEquals(null, underTest.getTempPoint());
	}

	@Test
	public void testGetTargetForMissWhenHitsIsNotEmpty() {
		//GIVEN
		setUpForMissWhenHitsIsNotEmpty();
		Point point = new Point(12, 12);
		//WHEN
		String actual = underTest.getTarget(Status.MISS);
		//THEN
		Assert.assertEquals(1, underTest.getPeter());
		Assert.assertEquals("fire 12 12", actual);
		Assert.assertEquals(point, underTest.getTempPoint());
	}
	
	public void setUpForSunkWhenThereIsANeedToRemove() {
		listFull.add(new Point(1, 3));
		listFull.add(new Point(5, 5));
		listHits.add(new Point(1, 2));
		underTest.setHits(listHits);
		underTest.setGuesses(listFull);
		underTest.setGuessesFirstHalf(listHalf);
	}
	public void setUpForSunkWhenThereIsNoNeedToRemove() {
		listFull.add(new Point(1, 3));
		listHalf.add(new Point(1, 2));
		listHits.add(new Point(1, 2));
		underTest.setHits(listHits);
		underTest.setGuesses(listFull);
		underTest.setGuessesFirstHalf(listHalf);
	}
	
	public void setUpForHitWhenTempIsEmpty() {
		listFull.add(new Point(10, 13));
		listFull.add(new Point(10, 14));
		underTest.setHits(listHits);
		underTest.setGuesses(listFull);
		underTest.setGuessesFirstHalf(listHalf);
	}
	
	public void setUpForHitWhenTempIsNotEmpty() {
		listFull.add(new Point(10, 14));
		underTest.setTempPoint(new Point(10, 13));
		underTest.setHits(listHits);
		underTest.setGuesses(listFull);
		underTest.setGuessesFirstHalf(listHalf);
	}
	
	public void setUpForMissWhenHitsIsEmpty() {
		listFull.add(new Point(1, 3));
		listFull.add(new Point(7, 4));
		underTest.setHits(listHits);
		underTest.setGuesses(listFull);
		underTest.setGuessesFirstHalf(listHalf);
	}

	public void setUpForMissWhenHitsIsNotEmpty() {
		listFull.add(new Point(19, 19));
		listFull.add(new Point(12, 12));
		listHits.add(new Point(12, 11));
		underTest.setHits(listHits);
		underTest.setGuesses(listFull);
		underTest.setGuessesFirstHalf(listHalf);
	}

}
