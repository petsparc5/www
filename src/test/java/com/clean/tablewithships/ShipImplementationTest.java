package com.clean.tablewithships;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.clean.ship.ShipLocations;

public class ShipImplementationTest {
	
	ShipImplementation underTest;
	ShipLocations shipLocations;
	
	@Before
	public void setUp() {
		underTest = new ShipImplementation(3, 2, 3, 5, 1);
		shipLocations = EasyMock.createMock(ShipLocations.class);
		underTest.setShipLocations(shipLocations);
	}
	
	@Test
	public void testPlaceShips() {
		//GIVEN
		EasyMock.expect(shipLocations.checkTShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(3);
		shipLocations.addTShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(3);
		EasyMock.expect(shipLocations.checkFourShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(2);
		shipLocations.addFourShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(2);
		EasyMock.expect(shipLocations.checkThreeShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(3);
		shipLocations.addThreeShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(3);
		EasyMock.expect(shipLocations.checkTwoShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(5);
		shipLocations.addTwoShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(5);
		EasyMock.expect(shipLocations.checkOneShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(1);
		shipLocations.addOneShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(shipLocations);
		//WHEN
		underTest.placeShips();
		//THEN
		EasyMock.verify(shipLocations);
	}
	
	@Test
	public void testPlaceShipsWhenThereAreTrueReturnStatements() {
		//GIVEN
		EasyMock.expect(shipLocations.checkTShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(2);
		EasyMock.expect(shipLocations.checkTShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(3);
		shipLocations.addTShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(3);
		EasyMock.expect(shipLocations.checkFourShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(5);
		EasyMock.expect(shipLocations.checkFourShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(2);
		shipLocations.addFourShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(2);
		EasyMock.expect(shipLocations.checkThreeShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(5);
		EasyMock.expect(shipLocations.checkThreeShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(3);
		shipLocations.addThreeShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(3);
		EasyMock.expect(shipLocations.checkTwoShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(1);
		EasyMock.expect(shipLocations.checkTwoShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(5);
		shipLocations.addTwoShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(5);
		EasyMock.expect(shipLocations.checkOneShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(true).times(1);
		EasyMock.expect(shipLocations.checkOneShip(EasyMock.anyInt(), EasyMock.anyInt())).andReturn(false).times(1);
		shipLocations.addOneShipLocation(EasyMock.anyInt(), EasyMock.anyInt());
		EasyMock.expectLastCall().times(1);
		EasyMock.replay(shipLocations);
		//WHEN
		underTest.placeShips();
		//THEN
		EasyMock.verify(shipLocations);
	}

}
