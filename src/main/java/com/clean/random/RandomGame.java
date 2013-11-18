package com.clean.random;

import java.util.Random;

import com.clean.interfaces.Torpedo;

public class RandomGame implements Torpedo {
	
	private int winCondition;
	private int counter;

	public boolean fire(int x, int y) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(2);
		return randomInt == 0;
	}
	
	public void play () {
		winCondition = 0;
		counter = 0;
		while (winCondition != 20) {
			if (fire(0,0)) {
				winCondition++;
			}
			counter++;
		}
		System.out.format("Fired %d times %n", counter);
	}

}
