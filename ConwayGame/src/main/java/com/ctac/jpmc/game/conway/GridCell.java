package com.ctac.jpmc.game.conway;


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
	
	private boolean state = false;
	private Set<IGridCell> neighbors = null;
	private IGrid grid;
	private ICoordinates coordinates;
	private Logger logger = LoggerFactory.getLogger(GridCell.class);

	public GridCell(ICoordinates coordinates, boolean state, IGrid grid) {
		this.coordinates = coordinates;
		this.state = state;
		this.grid = grid;
	}


	@Override
	public Set<IGridCell> getNeighbors() {
		if (neighbors != null) {
			return neighbors;
		}
		logger.debug("calculating Neighbors started");
		neighbors = grid.getNeighbors(this);
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
