package com.clean.ship;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ShipFileReaderTest {
	
	private List<String[][]> ships = new ArrayList<String[][]>();
	private List<Integer> numberOfShips = new ArrayList<Integer>();
	
	private ShipFileReader underTest;
	private String[][] shape2;
	private String[][] shape;
	
	@Before
	public void setUp() {
		underTest = new ShipFileReader();
	}
	
	@Test
	public void testReadToTestTheShapeCompositions() {
		//GIVEN
		setUpShape1();
		setUpShape2();
		ships.add(shape);
		ships.add(shape2);
		String filename = "stuff.file";
		underTest.setFilename(filename);
		ships = underTest.getShips();
		//WHEN
		underTest.read();
		//THEN
		String[][] actualShape = ships.get(0);
		for (int i = 0; i < actualShape.length; i++) {
			for (int j = 0; j < actualShape[i].length; j++) {
				Assert.assertEquals(shape[i][j], actualShape[i][j]);
			}
		}
		
		String[][] actualShape2 = ships.get(1);
		for (int i = 0; i < actualShape2.length; i++) {
			for (int j = 0; j < actualShape2[i].length; j++) {
				Assert.assertEquals(shape2[i][j], actualShape2[i][j]);
			}
		}
		
	}
	
	//@Test
	public void testReadToTestTheNumberOfShapes() {
		//GIVEN
		numberOfShips.add(4);
		numberOfShips.add(1);
		String filename = "stuff.file";
		underTest.setFilename(filename);
		numberOfShips = underTest.getNumberOfShips();
		//WHEN
		underTest.read();
		//THEN
		Assert.assertEquals(Integer.valueOf(4), numberOfShips.get(0));
		Assert.assertEquals(Integer.valueOf(1), numberOfShips.get(1));
	}
	

	
	public void setUpShape1() {
		String[] row1 = new String[4];
		row1[0] = "O";
		row1[1] = "O";
		row1[2] = "O";
		row1[3] = "O";
		String[] row2 = new String[4];
		row2[0] = "O";
		row2[1] = "O";
		row2[2] = "O";
		row2[3] = "O";
		String[] row3 = new String[4];
		row3[0] = "O";
		row3[1] = "X";
		row3[2] = "X";
		row3[3] = "X";
		String[] row4 = new String[4];
		row4[0] = "O";
		row4[1] = "O";
		row4[2] = "O";
		row4[3] = "O";
		shape = new String[4][4];
		shape[0] = row1;
		shape[1] = row2;
		shape[2] = row3;
		shape[3] = row4;
	}
	
	public void setUpShape2() {
		String[] row1 = new String[4];
		row1[0] = "O";
		row1[1] = "O";
		row1[2] = "O";
		row1[3] = "O";
		String[] row2 = new String[4];
		row2[0] = "O";
		row2[1] = "X";
		row2[2] = "O";
		row2[3] = "O";
		String[] row3 = new String[4];
		row3[0] = "X";
		row3[1] = "X";
		row3[2] = "X";
		row3[3] = "O";
		String[] row4 = new String[4];
		row4[0] = "O";
		row4[1] = "O";
		row4[2] = "O";
		row4[3] = "O";
		shape2 = new String[4][4];
		shape2[0] = row1;
		shape2[1] = row2;
		shape2[2] = row3;
		shape2[3] = row4;
	}

}
