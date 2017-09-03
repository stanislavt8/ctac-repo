package com.ctac.jpmc.game.conway;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctac.jpmc.game.IGridCell;
import com.ctac.jpmc.game.ICoordinates;
import com.ctac.jpmc.game.IGrid;


/**
 * 
 * Cell for Grid of any dimension
 *
 */
public class GridCell implements IGridCell {
	
	private static final int MAX_SIZE_2D = 8; 
	private static final int MAX_SIZE_3D = 26; 
	private final int maxSize;
	private boolean state = false;
	private Set<IGridCell> neighbors = null;
	private IGrid grid;
	private ICoordinates coordinates;
	private Logger logger = LoggerFactory.getLogger(GridCell.class);

	public GridCell(ICoordinates coordinates, boolean state, IGrid grid) {
		this.coordinates = coordinates;
		this.state = state;
		this.grid = grid;
		if (coordinates.getNumberOfDimensions() == 2) {
			maxSize = MAX_SIZE_2D; 
		}
		else {
			maxSize = MAX_SIZE_3D; // TODO change when support 4D coordinates
		}
	}


	@Override
	public Set<IGridCell> getNeighbors() {
		if (neighbors != null) {
			return neighbors;
		}
		logger.debug("calculating Neighbors started");
		neighbors = new HashSet <> (maxSize);
		for (IGridCell element : grid.getCells()) {
			if (element.getCoordinates().isNeighbor (coordinates)) {
				neighbors.add(element);
				if (neighbors.size() == maxSize) {
					break;
				}
			}
		}
		logger.debug("calculating Neighbors done");
		return neighbors;
	}


	@Override
	public boolean getState() {
		return state;
	}

	@Override
	public ICoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public String toString() {
		return "[state=" + state + ", coordinates=" + coordinates.toString() + "]";
	}

	public void setState(boolean state) {
		this.state = state;
	}



}
