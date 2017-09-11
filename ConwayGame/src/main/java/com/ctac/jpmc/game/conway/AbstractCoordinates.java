package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.ICoordinates;

public abstract class AbstractCoordinates implements ICoordinates {

	protected abstract  int compareByDistance (ICoordinates other);
	

	@Override
	public int compare(ICoordinates o1, ICoordinates o2) {
		return o1.compareTo(o2);
	}
	
	@Override
	public int compareTo(ICoordinates other) {
		int result = compareByDistance( other);
		if (result > 0) {
			return 1;
		}
		else if (result < 0) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean isNeighbor(ICoordinates other) {
		int compare = compareByDistance(other);
		return ((compare > 0 && compare <= 2 ) || (compare < 0 && compare >= -2 )); 
	}


}
