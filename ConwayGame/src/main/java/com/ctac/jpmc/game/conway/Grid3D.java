package com.ctac.jpmc.game.conway;


import java.util.LinkedHashMap;
import java.util.Map;

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
		super (initializeMap (gridArray));
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
	
	private static  Map <ICoordinates, IGridCell> initializeMap (boolean[][][] gridArray) {
		Map <ICoordinates, IGridCell>  map;
		if (gridArray != null && gridArray.length > 0 && gridArray[0].length > 0) {
			map = new LinkedHashMap  <> ((int)(gridArray.length*gridArray[0].length*gridArray[1].length));
		}
		else {
			map = new LinkedHashMap  <> (0);
		}
		return map;
	}

	/*@Override
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
	
	@Override
	public Set<IGridCell> getNeighbors(IGridCell cell) {
		Set <IGridCell> neighbors = new HashSet <> (0);
		int [] coordinates =   cell.getCoordinates().getValues();
		for (int ix = -1; ix <=1; ix ++) {
			for (int iy = -1; iy <=1; iy ++) {
				if (ix == 0 && iy == 0) {
					continue;
				}
				int [] neighborCoordinates = new int [2] ;
				neighborCoordinates [0] = coordinates [0] + ix; 
				neighborCoordinates [1] = coordinates [1] + iy;
				if ((neighborCoordinates [0] >= 0 && 
					neighborCoordinates [1] >=0 && 
					neighborCoordinates [0] < xDimension &&
					neighborCoordinates [1] < yDimension)) {
						addNeighbor(neighbors, neighborCoordinates);
				}
			}
		}
		return neighbors;
	}

	private void addNeighbor(Set<IGridCell> neighbors, int[] neighborCoordinates) {
		IGridCell neighbor = getCell(neighborCoordinates);
		if (neighbor != null) {
			neighbors.add(neighbor);
		}
	}

	private IGridCell getCell(ICoordinates coordinates) {
		return map.get(coordinates);
	}
	*/
}
