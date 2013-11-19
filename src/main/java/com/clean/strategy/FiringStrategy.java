package com.clean.strategy;

import java.util.Arrays;

import com.clean.ship.Point;

public class FiringStrategy {
	
	private boolean[][] hitRecodrs = new boolean[20][20];
	
	public void initisalise() {
		for (boolean[] row : hitRecodrs) {
			Arrays.fill(row, false);
		}
	}
	
	public Point fire() {
		
		return null;
		
	}

}
