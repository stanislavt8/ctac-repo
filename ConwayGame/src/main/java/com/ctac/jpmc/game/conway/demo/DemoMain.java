package com.ctac.jpmc.game.conway.demo;


import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;
import com.ctac.jpmc.game.conway.Game2D;

/**
 * 
 * A demonstration of Conway's game of life with 8x6 grid state
 *
 */
public class DemoMain {

	public static void main(String[] args) {
		
	
		boolean [][] gridArray = { 
				{false,false,false,false,false,false,true,false},
				{true,true,true,false,false,false,true,false},
				{false,false,false,false,false,false,true,false},
				{false,false,false,false,false,false,false,false},
				{false,false,false,true,true,false,false,false},
				{false,false,false,true,true,false,false,false}
			};
			Game2D game = new Game2D (gridArray);
			IGrid grid = game.getCurrentStage();
			System.out.println ("Initial state");
			dispalyResults (grid);
			for (int i = 0; i <= 9; i++) {
				System.out.println ("Updated state #" + i);
				grid = game.getNextStage();
				dispalyResults (grid);
			}

	}
	
	private static void dispalyResults(IGrid grid) {
		for (int i = 0; i < 6; i++)	{
			for (int j = 0; j < 8; j++) {
				IGridCell cell = grid.getCell(i,j);
				System.out.print(cell.getState() ? 'o' : ".");
			}
			System.out.println ();
		}
	}

}
