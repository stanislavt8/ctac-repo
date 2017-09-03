package com.ctac.jpmc.game.conway;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ctac.jpmc.game.ICoordinates;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

/**
 * 
 * 2D Grid
 *
 */
public class Grid2D implements IGrid {
	
	private Map <ICoordinates, IGridCell>  map;
	
	public Grid2D(boolean[][] gridArray) {
		if (gridArray != null && gridArray.length > 0) {
			int xDimension = gridArray.length;
			int yDimension = gridArray[0].length;
			map = new LinkedHashMap  <> (xDimension*yDimension)  ;
			for (int i = 0; i < xDimension; i++)	{
				for (int j = 0; j < gridArray[i].length; j++) { 
					ICoordinates coordinates = new Coordinates2D (i,j);
					IGridCell element = new GridCell (coordinates, gridArray[i][j], this);
					map.put(coordinates, element);
				}
			}
		}
		else {
			map = new LinkedHashMap  <> (0);
		}
	}

	@Override
	public Collection <IGridCell> getCells() {
		return map.values();
	}

	@Override
	public IGridCell getCell(int ... values) {
		if (values == null) {
			throw new CoordinatesException ("null coordinates");
		}
		else if (values.length == 2) {
			ICoordinates coordinates = new Coordinates2D (values[0],values[1]);
			return getCell (coordinates);
		}
		throw new CoordinatesException ("invalid coordinates");
	}
	

	private IGridCell getCell(ICoordinates coordinates) {
		return map.get(coordinates);
	}
}
