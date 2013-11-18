package com.clean.TwentybyTwenty;

import com.clean.interfaces.Torpedo;

public class Game implements Torpedo {
	
	Table table;
	int winCondition;
	int counter;
	
	public boolean fire(int x, int y) {
		return table.checkCoordinates(x, y);
	}
	
	public void play() {
		winCondition = 0;
		counter = 0;
		while (winCondition != 25) {
			if (fire(counter % 20, counter/20)) {
				winCondition++;
			}
			counter++;
		}
		System.out.format("Fired %d times %n", counter);
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
	public void initialiseTheTable() {
		table.initialiseTheTable();
	}

	public int getWinCondition() {
		return winCondition;
	}

	public int getCounter() {
		return counter;
	}
}
