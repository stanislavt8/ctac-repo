package com.ctac.jpmc.game.conway;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ctac.jpmc.game.ICoordinates;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

public abstract class AbstractGrid implements IGrid {
	
	private Map <ICoordinates, IGridCell>  map;
	
	public AbstractGrid(Map <ICoordinates, IGridCell>  map) {
		this.map = map ;
	}

	@Override
	public Collection<IGridCell> getCells() { 
		return map.values();
	}

	@Override
	public IGridCell getCell(int... values) {
		if (values == null) {
			throw new CoordinatesException ("null coordinates");
		}
		else if (values.length == 2) {
			ICoordinates coordinates = new Coordinates2D (values[0],values[1]);
			return getCell (coordinates);
		}
		else if (values.length == 3) {
			ICoordinates coordinates = new Coordinates3D (values[0],values[1],values[2]);
			return getCell (coordinates);
		}
		throw new CoordinatesException ("invalid coordinates");
	}

	@Override
	public Set<IGridCell> getNeighbors(IGridCell cell) {
		int [] coordinates =   cell.getCoordinates().getValues();
		int dimension = coordinates.length;
		Set<IGridCell> neighbors = new HashSet<IGridCell> ();
		getNeighbors(cell.getCoordinates(), new int[] {}, dimension, neighbors);
		return neighbors;
	}
	
	void getNeighbors(ICoordinates coordinates , int[] current, int currentDim, Set<IGridCell>  neighbors) {
		if (currentDim == 0) {
			IGridCell neighbor = getCell(current);
			if (neighbor != null) {
				if (!neighbor.getCoordinates().equals(coordinates)) {
					neighbors.add(neighbor);
				}
			}
			return;
		}
		int[] coordinatesArray = coordinates.getValues();
		currentDim--;
		int currentSize = current.length;
		for (int x = -1; x <= 1; x++) {
			int[] next = new int[currentSize + 1];
			for (int i = 0; i < currentSize; i++) {
				next[i] = current[i];
			}
			next[currentSize] = coordinatesArray [currentSize] + x;
			getNeighbors(coordinates, next, currentDim, neighbors);
		}
	}
	
	
	private IGridCell getCell(ICoordinates coordinates) {
		return map.get(coordinates);
	}

	protected Map<ICoordinates, IGridCell> getMap() {
		return map;
	}
	
	
}
