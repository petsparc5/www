package com.clean.strategy;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.Point;

public class XYGuessGeneratorTest {
	
	private XYGuessGenerator underTest;
	private XYGuessGeneratorTestHelper helper;
	
	@Before
	public void setUp() {
		helper = new XYGuessGeneratorTestHelper();
	}
	
	@Test
	public void testAddMagicElement(){
		//GIVEN
		underTest = new XYGuessGenerator(20);
		List<Point> expected = helper.makeExpectedListForMagicElement();
		List<Point> actual;
		//WHEN
		underTest.addMagicElement();
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}
	
	@Test
	public void testGenerateOptimalGuessWithWithNoShiftAndFirstHalf(){
		//GIVEN
		underTest = new XYGuessGenerator(10);
		List<Point> expected = helper.makeExpectedListWithNoShiftAndFirstHalf();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(0, 0);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}
	
	@Test
	public void testGenerateOptimalGuessWithWithNoShiftAndSecondHalf(){
		//GIVEN
		underTest = new XYGuessGenerator(10);
		List<Point> expected = helper.makeExpectedListWithNoShiftAndSecondHalf();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(0, 1);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}

	@Test
	public void testGenerateOptimalGuessWithWithOneShiftAndFirstHalf(){
		//GIVEN
		underTest = new XYGuessGenerator(10);
		List<Point> expected = helper.makeExpectedListWithAShiftAndFirstHalf();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(1, 0);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}
	
	@Test
	public void testGenerateOptimalGuessWithWithAShiftAndSecondHalf(){
		//GIVEN
		underTest = new XYGuessGenerator(10);
		List<Point> expected = helper.makeExpectedListWithAShiftAndSecondHalf();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(1, 1);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}

}
