package com.clean.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clean.interfaces.GameStrategy;

public class FirePositionStrategy implements GameStrategy {
	
	public FirePositionStrategy(int boardSize) {
		super();
		this.boardSize = boardSize;
		board = new boolean[boardSize][boardSize];
		
	}
	
	private boolean[][] board;

	private int boardSize;
	private int[] guessx;
	private int[] guessy;
	private int counter;
	private List<Integer> hits = new ArrayList<>();
	
	private String converter(int x, int y) {
		return "fire " + String.valueOf(x) + " " +String.valueOf(y);
	}
	
	private boolean checkguesses(int x, int y) {
		return (x < 0 || y < 0 || x >= boardSize || y >= boardSize) ? false : true;
	}
	
	public void print () {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.format("%d, %d=%s %n", i, j, board[i][j]);
			}
		}
	}
	
	private void storeguesses(int x, int y) {
		if (checkguesses(x, y) && (counter < (boardSize * boardSize))) {
			guessx[counter] = x;
			guessy[counter] = y;
			counter++;
		}
	}
	
	private void makerandomguesses(int shift) {
		int middle = (boardSize-1) /2;
		int x;
		int y;
		for (int layer = 0; layer < middle+2; layer++) {
			for (int topsteps = 0; topsteps < layer+1; topsteps++) {
				x = middle - layer + topsteps*2 + shift;
				y = middle + layer;
				storeguesses(x,y);
			}
			for (int bottomsteps = 0; bottomsteps < layer+1; bottomsteps++) { 
				if (layer == 0) {
					
				} else {
					x = middle - layer + bottomsteps*2 + shift;
					y = middle - layer;
					storeguesses(x,y);
				}

			}
			for (int leftsteps = 1; leftsteps < layer; leftsteps++) {
				x = middle - layer + shift;
				y = middle - layer + leftsteps*2;
				storeguesses(x,y);
			}
			for (int rightsteps = 1; rightsteps < layer; rightsteps++) {
				x = middle + layer + shift;
				y = middle - layer + rightsteps*2;
				storeguesses(x,y);
			}
		}
		
	}
	
	public void initialise() {
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], false);
		}
		counter = 0;
		guessx = new int[boardSize*boardSize];
		guessy = new int[boardSize*boardSize];
		makerandomguesses(0);
		makerandomguesses(1);
		counter = 0;
	}
	
	

	@Override
	public String firstTarget() {
		counter++;
		board[guessx[0]][guessy[0]] = true;
		return converter(guessx[0],guessy[0]);
	}

	@Override
	public String nextTarget(String input) {
		String answer = null;
		if (input.toLowerCase().contains("sunk")){
			hits.remove(0);
			hits.remove(0);
			answer = nextTarget("miss");
		}
		else if (input.toLowerCase().contains("hit")) {
			hits.add(guessx[counter - 1]);
			hits.add(guessy[counter - 1]);
			answer = guessingsmart();
		} 
		else if (!(hits.isEmpty())) {
			answer = guessingsmart();
		} 
		else if (board[guessx[counter]][guessy[counter]]) {
			counter++;
			answer = nextTarget(input);
		}
		else {
			answer = converter(guessx[counter],guessy[counter]);
			board[guessx[counter]][guessy[counter]] = true;
			counter++;
		}
		
		return answer;
	}

	private String guessingsmart() {
		int x = hits.get(0);
		int y = hits.get(1);
		String answer = null;
		if (!checkIfAlreadyHit(x+1, y)){
			answer = converter(x+1, y);
			board[x+1][y] = true;
		} else if (!checkIfAlreadyHit(x-1, y)){
			answer = converter(x-1, y);
			board[x-1][y] = true;
		} else if (!checkIfAlreadyHit(x, y+1)){
			answer = converter(x, y+1);
			board[x][y+1] = true;
		} else if (!checkIfAlreadyHit(x, y-1)){
			answer = converter(x, y-1);
			board[x][y-1] = true;
		} else {
			hits.remove(0);
			hits.remove(0);
			if (!(hits.isEmpty())){
			guessingsmart();
			} else {
				answer = nextTarget("miss");
			}
		}
		return answer;
	}

	private boolean checkIfAlreadyHit(int x, int y) {
			return checkguesses(x, y) ? board[x][y] : true;		
	}
		
}
