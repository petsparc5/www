package com.clean.tablewithships;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.ShipFileReader;
import com.clean.ship.ShipLocations;

public class ShipImplementationTest {
	
	ShipImplementation underTest;
	ShipLocations shipLocations;
	ShipFileReader reader;
	List<String[][]> ships = new ArrayList<String[][]>();
	List<Integer> numberOfShips = new ArrayList<Integer>();
	private String[][] shape2;
	private String[][] shape;
	
	@Before
	public void setUp() {
		underTest = new ShipImplementation();
		shipLocations = EasyMock.createMock(ShipLocations.class);
		underTest.setShipLocations(shipLocations);
		reader = EasyMock.createMock(ShipFileReader.class);
		underTest.setReader(reader);
		setUpShape1();
		setUpShape2();
		ships.add(shape);
		ships.add(shape2);
		numberOfShips.add(4);
		numberOfShips.add(1);
	}
	
	
	
	@Test
	public void testInitialisation() {
		//GIVEN
		reader.setFilename("boohoo");
		EasyMock.expectLastCall();
		reader.read();
		EasyMock.expectLastCall();
		EasyMock.expect(reader.getShips()).andReturn(ships);
		EasyMock.expect(reader.getNumberOfShips()).andReturn(numberOfShips);
		EasyMock.replay(reader);
		EasyMock.expect(shipLocations.checkPoint(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(50);
		EasyMock.expect(shipLocations.checkPoint(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(350);
		underTest.setBoardSize(20);
		EasyMock.expectLastCall();
		shipLocations.setBoardSize(20);
		EasyMock.replay(shipLocations);
		//WHEN
		underTest.setFilename("boohoo");
		underTest.initialisation();
		int actual = underTest.getTotalNumberOfTargets();
		//THEN
		Assert.assertEquals(50, actual);
		EasyMock.verify(reader);
		EasyMock.verify(shipLocations);
	}
	
	@Test
	public void testPlaceShips() {
		//GIVEN
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(false).times(4);
		shipLocations.addShipLocation(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject());
		EasyMock.expectLastCall().times(4);
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(false);
		shipLocations.addShipLocation(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(shipLocations);	
		underTest.setNumberOfShips(numberOfShips);
		underTest.setShips(ships);
		underTest.setBoardSize(20);
		//WHEN
		underTest.placeShips();
		//THEN
		EasyMock.verify(shipLocations);
	}
	
	//@Test
	public void testPlaceShipsWhenBoardSizeIsZero() {
		//GIVEN
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(false).times(4);
		shipLocations.addShipLocation(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject());
		EasyMock.expectLastCall().times(4);
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(false);
		shipLocations.addShipLocation(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(shipLocations);	
		underTest.setNumberOfShips(numberOfShips);
		underTest.setShips(ships);
		underTest.setBoardSize(0);
		//WHEN
		underTest.placeShips();
		//THEN
		EasyMock.verify(shipLocations);
	}
	
	@Test
	public void testPlaceShipsWhenThereAreTrueReturnStatements() {
		//GIVEN
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(true).times(3);
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(false).times(4);
		shipLocations.addShipLocation(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject());
		EasyMock.expectLastCall().times(4);
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(true).times(5);
		EasyMock.expect(shipLocations.checkShip(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject())).andReturn(false);
		shipLocations.addShipLocation(EasyMock.anyInt(), EasyMock.anyInt(), (String[][]) EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(shipLocations);	
		underTest.setNumberOfShips(numberOfShips);
		underTest.setShips(ships);
		underTest.setBoardSize(20);
		//WHEN
		underTest.placeShips();
		//THEN
		EasyMock.verify(shipLocations);
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
