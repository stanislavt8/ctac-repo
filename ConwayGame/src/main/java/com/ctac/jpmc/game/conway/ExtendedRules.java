package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.IRules;

public class ExtendedRules extends StandardRules implements IRules {
	
	private static final int minAliveNeighborsCount = 3;
	private static final int maxAliveNeighborsCount = 5;

	@Override
	public int getMinAliveNeighborsCount() {
		return minAliveNeighborsCount;
	}

	@Override
	public int getMaxAliveNeighborsCount() {
		return maxAliveNeighborsCount;
	}
}
