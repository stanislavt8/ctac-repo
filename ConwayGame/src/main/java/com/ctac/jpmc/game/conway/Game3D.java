package com.ctac.jpmc.game.conway;


public class Game3D extends AbstractGame {
	
	/**
	 * constructor witch initiate the game
	 * 
	 * @param gridArray initial stage as 2 dimensional array
	 */
	public Game3D( boolean[][][] gridArray) {
		initiate (new Grid3D (gridArray));
	}
	
	/**
	 * constructor witch initiate the game with random initial state
	 * 
	 * @param x x-dimension
	 * @param y y-dimension
	 */
	public Game3D(int x, int y, int z) {
		boolean[][][] gridArray = getRandomGrid(x, y, z);
		initiate ( new Grid3D (gridArray) );
	}

	private boolean[][][] getRandomGrid(int x, int y, int z) {
		boolean[][][] gridArray = new boolean[x][y][z];
		for (int i = 0; i < x; i++)	{
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < z; k++) {
					gridArray [i] [j] [k] = getRandomBoolean();	
				}
			}
		}
		return gridArray;
	}

}
