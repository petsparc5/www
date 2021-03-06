package com.clean.strategy;

import java.util.ArrayList;
import java.util.List;

import com.clean.ship.Point;

public class XYGuessGeneratorTestHelper {
	
	public List<Point> makeExpectedListForMagicElement() {
		List<Point> expected = new ArrayList<>();
		expected.add(new Point(-1, -1));
		return expected;
	}
	
	public List<Point> makeExpectedListWithBoardSizeOfTen() {
		List<Point> expected = new ArrayList<>();
		expected.add(new Point(4, 4));
		expected.add(new Point(3, 5));
		expected.add(new Point(5, 5));
		expected.add(new Point(3, 3));
		expected.add(new Point(5, 3));
		expected.add(new Point(2, 6));
		expected.add(new Point(4, 6));
		expected.add(new Point(6, 6));
		expected.add(new Point(2, 2));
		expected.add(new Point(4, 2));
		expected.add(new Point(6, 2));
		expected.add(new Point(2, 4));
		expected.add(new Point(6, 4));
		expected.add(new Point(1, 7));
		expected.add(new Point(3, 7));
		expected.add(new Point(5, 7));
		expected.add(new Point(7, 7));
		expected.add(new Point(1, 1));
		expected.add(new Point(3, 1));
		expected.add(new Point(5, 1));
		expected.add(new Point(7, 1));
		expected.add(new Point(1, 3));
		expected.add(new Point(1, 5));
		expected.add(new Point(7, 3));
		expected.add(new Point(7, 5));
		expected.add(new Point(0, 8));
		expected.add(new Point(2, 8));
		expected.add(new Point(4, 8));
		expected.add(new Point(6, 8));
		expected.add(new Point(8, 8));
		expected.add(new Point(0, 0));
		expected.add(new Point(2, 0));
		expected.add(new Point(4, 0));
		expected.add(new Point(6, 0));
		expected.add(new Point(8, 0));
		expected.add(new Point(0, 2));
		expected.add(new Point(0, 4));
		expected.add(new Point(0, 6));
		expected.add(new Point(8, 2));
		expected.add(new Point(8, 4));
		expected.add(new Point(8, 6));
		expected.add(new Point(1, 9));
		expected.add(new Point(3, 9));
		expected.add(new Point(5, 9));
		expected.add(new Point(7, 9));
		expected.add(new Point(9, 9));
		expected.add(new Point(9, 1));
		expected.add(new Point(9, 3));
		expected.add(new Point(9, 5));
		expected.add(new Point(9, 7));
		return expected;
	}
	
	public List<Point> makeExpectedListWithBoardSizeOfTenAndShiftOne() {
		List<Point> expected = new ArrayList<>();
		expected.add(new Point(5, 4));
		expected.add(new Point(4, 5));
		expected.add(new Point(6, 5));
		expected.add(new Point(4, 3));
		expected.add(new Point(6, 3));
		expected.add(new Point(3, 6));
		expected.add(new Point(5, 6));
		expected.add(new Point(7, 6));
		expected.add(new Point(3, 2));
		expected.add(new Point(5, 2));
		expected.add(new Point(7, 2));
		expected.add(new Point(3, 4));
		expected.add(new Point(7, 4));
		expected.add(new Point(2, 7));
		expected.add(new Point(4, 7));
		expected.add(new Point(6, 7));
		expected.add(new Point(8, 7));
		expected.add(new Point(2, 1));
		expected.add(new Point(4, 1));
		expected.add(new Point(6, 1));
		expected.add(new Point(8, 1));
		expected.add(new Point(2, 3));
		expected.add(new Point(2, 5));
		expected.add(new Point(8, 3));
		expected.add(new Point(8, 5));
		expected.add(new Point(1, 8));
		expected.add(new Point(3, 8));
		expected.add(new Point(5, 8));
		expected.add(new Point(7, 8));
		expected.add(new Point(9, 8));
		expected.add(new Point(1, 0));
		expected.add(new Point(3, 0));
		expected.add(new Point(5, 0));
		expected.add(new Point(7, 0));
		expected.add(new Point(9, 0));
		expected.add(new Point(1, 2));
		expected.add(new Point(1, 4));
		expected.add(new Point(1, 6));
		expected.add(new Point(9, 2));
		expected.add(new Point(9, 4));
		expected.add(new Point(9, 6));
		expected.add(new Point(0, 9));
		expected.add(new Point(2, 9));
		expected.add(new Point(4, 9));
		expected.add(new Point(6, 9));
		expected.add(new Point(8, 9));
		expected.add(new Point(0, 1));
		expected.add(new Point(0, 3));
		expected.add(new Point(0, 5));
		expected.add(new Point(0, 7));
		return expected;
	}
	
	public List<Point> makeExpectedListWithBoardSizeOfEleven() {
		List<Point> expected = new ArrayList<>();
		expected.add(new Point(5, 5));
		expected.add(new Point(4, 6));
		expected.add(new Point(6, 6));
		expected.add(new Point(4, 4));
		expected.add(new Point(6, 4));
		expected.add(new Point(3, 7));
		expected.add(new Point(5, 7));
		expected.add(new Point(7, 7));
		expected.add(new Point(3, 3));
		expected.add(new Point(5, 3));
		expected.add(new Point(7, 3));
		expected.add(new Point(3, 5));
		expected.add(new Point(7, 5));
		expected.add(new Point(2, 8));
		expected.add(new Point(4, 8));
		expected.add(new Point(6, 8));
		expected.add(new Point(8, 8));
		expected.add(new Point(2, 2));
		expected.add(new Point(4, 2));
		expected.add(new Point(6, 2));
		expected.add(new Point(8, 2));
		expected.add(new Point(2, 4));
		expected.add(new Point(2, 6));
		expected.add(new Point(8, 4));
		expected.add(new Point(8, 6));
		expected.add(new Point(1, 9));
		expected.add(new Point(3, 9));
		expected.add(new Point(5, 9));
		expected.add(new Point(7, 9));
		expected.add(new Point(9, 9));
		expected.add(new Point(1, 1));
		expected.add(new Point(3, 1));
		expected.add(new Point(5, 1));
		expected.add(new Point(7, 1));
		expected.add(new Point(9, 1));
		expected.add(new Point(1, 3));
		expected.add(new Point(1, 5));
		expected.add(new Point(1, 7));
		expected.add(new Point(9, 3));
		expected.add(new Point(9, 5));
		expected.add(new Point(9, 7));
		expected.add(new Point(0, 10));
		expected.add(new Point(2, 10));
		expected.add(new Point(4, 10));
		expected.add(new Point(6, 10));
		expected.add(new Point(8, 10));
		expected.add(new Point(10, 10));
		expected.add(new Point(0, 0));
		expected.add(new Point(2, 0));
		expected.add(new Point(4, 0));
		expected.add(new Point(6, 0));
		expected.add(new Point(8, 0));
		expected.add(new Point(10, 0));
		expected.add(new Point(0, 2));
		expected.add(new Point(0, 4));
		expected.add(new Point(0, 6));
		expected.add(new Point(0, 8));
		expected.add(new Point(10, 2));
		expected.add(new Point(10, 4));
		expected.add(new Point(10, 6));
		expected.add(new Point(10, 8));
		return expected;
	}
	
	public List<Point> makeExpectedListWithBoardSizeOfElevenAndShiftOne() {
		List<Point> expected = new ArrayList<>();
		expected.add(new Point(6, 5));
		expected.add(new Point(5, 6));
		expected.add(new Point(7, 6));
		expected.add(new Point(5, 4));
		expected.add(new Point(7, 4));
		expected.add(new Point(4, 7));
		expected.add(new Point(6, 7));
		expected.add(new Point(8, 7));
		expected.add(new Point(4, 3));
		expected.add(new Point(6, 3));
		expected.add(new Point(8, 3));
		expected.add(new Point(4, 5));
		expected.add(new Point(8, 5));
		expected.add(new Point(3, 8));
		expected.add(new Point(5, 8));
		expected.add(new Point(7, 8));
		expected.add(new Point(9, 8));
		expected.add(new Point(3, 2));
		expected.add(new Point(5, 2));
		expected.add(new Point(7, 2));
		expected.add(new Point(9, 2));
		expected.add(new Point(3, 4));
		expected.add(new Point(3, 6));
		expected.add(new Point(9, 4));
		expected.add(new Point(9, 6));
		expected.add(new Point(2, 9));
		expected.add(new Point(4, 9));
		expected.add(new Point(6, 9));
		expected.add(new Point(8, 9));
		expected.add(new Point(10, 9));
		expected.add(new Point(2, 1));
		expected.add(new Point(4, 1));
		expected.add(new Point(6, 1));
		expected.add(new Point(8, 1));
		expected.add(new Point(10, 1));
		expected.add(new Point(2, 3));
		expected.add(new Point(2, 5));
		expected.add(new Point(2, 7));
		expected.add(new Point(10, 3));
		expected.add(new Point(10, 5));
		expected.add(new Point(10, 7));
		expected.add(new Point(1, 10));
		expected.add(new Point(3, 10));
		expected.add(new Point(5, 10));
		expected.add(new Point(7, 10));
		expected.add(new Point(9, 10));
		expected.add(new Point(1, 0));
		expected.add(new Point(3, 0));
		expected.add(new Point(5, 0));
		expected.add(new Point(7, 0));
		expected.add(new Point(9, 0));
		expected.add(new Point(1, 2));
		expected.add(new Point(1, 4));
		expected.add(new Point(1, 6));
		expected.add(new Point(1, 8));
		expected.add(new Point(0, 1));
		expected.add(new Point(0, 3));
		expected.add(new Point(0, 5));
		expected.add(new Point(0, 7));
		expected.add(new Point(0, 9));
		return expected;
	}

}
