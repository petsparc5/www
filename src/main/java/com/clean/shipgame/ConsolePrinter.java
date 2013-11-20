package com.clean.shipgame;

import com.clean.ship.ShipLocations;

public class ConsolePrinter {
	
	ShipLocations shipLocations;
	
	public ConsolePrinter(ShipLocations shipLocations) {
		super();
		this.shipLocations = shipLocations;
	}
	private String converter(boolean value) {
		return value ? "X" : " ";
	}	
	public void printBoard() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				stringBuilder.append(converter(shipLocations.checkPoint(j, 20-i)));
			}
			stringBuilder.append("\n");
		}
		System.out.format("Table:%n%s%n", stringBuilder.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
