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
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Well, this should not happen! If you managed to get this message, please contact me! I'm your new lover.");
		}
	}

}
