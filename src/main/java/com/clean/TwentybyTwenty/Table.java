package com.clean.TwentybyTwenty;

import java.util.Random;

public class Table {
	
	private boolean[][] table;
	int numberOfTargets;
	
	public void initialiseTheTable() {
		table = new boolean[20][20];
		numberOfTargets = 25;
		Random randomGenerator = new Random();
		int counter = 0;
		int position;
		while (counter != numberOfTargets){
			position = randomGenerator.nextInt(400);
			if (!checkPostion(position)) {
				setPosition(position);
				counter++;
			}
		}
	}
	
	public boolean checkCoordinates (int x, int y) {
		if (x >20 || y>20 || x<0 || y<0) {
			throw new IllegalArgumentException();
		}
		return table[x][y];
	}
	
	private boolean checkPostion (int position) {
		int positionX = findX(position);
		int positionY = findY(position);
		return table[positionX][positionY];
	}
	
	private void setPosition(int position){
		int positionX = findX(position);
		int positionY = findY(position);
		table[positionX][positionY] = !table[positionX][positionY];
	}
	
	private int findX(int position) {		
		return position % 20;
	}
	
	private int findY(int position) {		
		return position/20;
	}
	
	

}
