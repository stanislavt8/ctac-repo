package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.IRules;

public class ExtendedRules extends StandardRules implements IRules {
	
	private static final int MIN_ALIVE_NEIGHBORS_COUNT = 3;
	private static final int MAX_ALIVE_NEIGHBORS_COUNT = 5;

	@Override
	public int getMinAliveNeighborsCount() {
		return MIN_ALIVE_NEIGHBORS_COUNT;
	}

	@Override
	public int getMaxAliveNeighborsCount() {
		return MAX_ALIVE_NEIGHBORS_COUNT;
	}
}
