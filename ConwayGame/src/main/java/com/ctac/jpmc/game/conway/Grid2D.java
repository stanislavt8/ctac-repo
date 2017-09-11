package com.ctac.jpmc.game.conway;


import com.ctac.jpmc.game.ICoordinates;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

/**
 * 
 * 2D Grid
 *
 */
public class Grid2D extends AbstractGrid implements IGrid {
	
	public Grid2D(boolean[][] gridArray) {
		super ();
		if (gridArray != null && gridArray.length > 0) {
			int xDimension = gridArray.length;
			int yDimension = gridArray[0].length;
			for (int i = 0; i < xDimension; i++)	{
				for (int j = 0; j < yDimension; j++) { 
					ICoordinates coordinates = new Coordinates2D (i,j);
					IGridCell element = new GridCell (coordinates, gridArray[i][j], this);
					getMap().put(coordinates, element);
				}
			}
		}
	}
	

}
