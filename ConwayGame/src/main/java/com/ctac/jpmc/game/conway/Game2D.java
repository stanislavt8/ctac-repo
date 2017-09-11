package com.ctac.jpmc.game.conway;


public class Game2D extends AbstractGame {
	
	/**
	 * constructor witch initiate the game
	 * 
	 * @param gridArray initial stage as 2 dimensional array
	 */
	public Game2D( boolean[][] gridArray) {
		initiate (new Grid2D (gridArray));
	}
	
	/**
	 * constructor witch initiate the game with random initial state
	 * 
	 * @param x x-dimension
	 * @param y y-dimension
	 */
	public Game2D(int x, int y) {
		boolean[][] gridArray = getRandomGrid(x, y);
		initiate ( new Grid2D (gridArray) );
	}

	private boolean[][] getRandomGrid(int x, int y) {
		boolean[][] gridArray = new boolean[x][y];
		for (int i = 0; i < x; i++)	{
			for (int j = 0; j < y; j++) {
				gridArray [i] [j] = getRandomBoolean();	
			}
		}
		return gridArray;
	}

}
