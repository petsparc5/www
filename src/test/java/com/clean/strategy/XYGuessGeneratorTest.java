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
	public void testGenerateOptimalGuessWithBoardSizeTen(){
		//GIVEN
		underTest = new XYGuessGenerator(10);
		List<Point> expected = helper.makeExpectedListWithBoardSizeOfTen();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(0);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}

	@Test
	public void testGenerateOptimalGuessWithBoardSizeTenAndShiftOne(){
		//GIVEN
		underTest = new XYGuessGenerator(10);
		List<Point> expected = helper.makeExpectedListWithBoardSizeOfTenAndShiftOne();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(1);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}
	
	@Test
	public void testGenerateOptimalGuessWithBoardSizeEleven(){
		//GIVEN
		underTest = new XYGuessGenerator(11);
		List<Point> expected = helper.makeExpectedListWithBoardSizeOfEleven();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(0);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}
	
	@Test
	public void testGenerateOptimalGuessWithBoardSizeElevenShiftOne(){
		//GIVEN
		underTest = new XYGuessGenerator(11);
		List<Point> expected = helper.makeExpectedListWithBoardSizeOfElevenAndShiftOne();
		List<Point> actual;
		//WHEN
		underTest.generateOptimalGuess(1);
		actual = underTest.getGuesses();
		//THEN
		Assert.assertEquals(expected.size(), actual.size());
		for (Point point : expected) {
			Assert.assertTrue(actual.contains(point));
		}
	}

}
