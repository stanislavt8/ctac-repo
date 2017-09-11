package com.ctac.jpmc.game.conway;



import com.ctac.jpmc.game.ICoordinates;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

/**
 * 
 * 3D Grid
 *
 */
public class Grid3D extends AbstractGrid implements IGrid {
	
	public Grid3D(boolean[][][] gridArray) {
		super ();
		if (gridArray != null && gridArray.length > 0) {
			int xDimension = gridArray.length;
			int yDimension = gridArray[0].length;
			int zDimension = gridArray[0][0].length;
			for (int i = 0; i < xDimension; i++)	{
				for (int j = 0; j < yDimension; j++) { 
					for (int k = 0; k < zDimension; k++) { 
						ICoordinates coordinates = new Coordinates3D (i,j,k);
						IGridCell element = new GridCell (coordinates, gridArray[i][j][k], this);
						getMap().put(coordinates, element);
					}
				}
			}
		}
	}
	
}
