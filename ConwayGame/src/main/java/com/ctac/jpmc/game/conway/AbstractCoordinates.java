package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.ICoordinates;

public abstract class AbstractCoordinates implements ICoordinates {

	protected abstract  int compareByDistance (ICoordinates other);

	@Override
	public boolean isNeighbor(ICoordinates other) {
		int compare = compareByDistance(other);
		return ((compare > 0 && compare <= 2 ) || (compare < 0 && compare >= -2 )); 
	}

}
