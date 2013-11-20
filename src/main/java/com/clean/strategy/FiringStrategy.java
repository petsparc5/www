package com.clean.strategy;

import com.clean.interfaces.GameStrategy;

public class FiringStrategy implements GameStrategy {
	
	private int[] guessx = new int[20];
	int countery = 0;
	private int[] guessy = new int[20];
	int counterx = 1;
	@Override
	public void initialise() {
		for (int i = 0; i < guessx.length; i++) {
			guessx[i] = i;
			guessy[i] = i;
		}
	}
	@Override
	public String firstTarget() {
		return "fire 0 0";
	}

	@Override
	public String nextTarget(String input) {
		String answer = "fire " + counterx + " " + countery;
		counterx++;
		if (counterx == 20) {
			counterx = 0;
			countery++;
		}
		return answer;
	}


}
