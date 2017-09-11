package com.ctac.jpmc.game.conway;

import java.util.ArrayList;
import java.util.Collection;

import com.ctac.jpmc.game.IGridCell;
import com.ctac.jpmc.game.IRule;
import com.ctac.jpmc.game.IRules;

public class StandardRules implements IRules { 
	
	private static final int minAliveNeighborsCount = 2;
	private static final int maxAliveNeighborsCount = 3;
	
	@Override
	public Collection<IRule> executeRules(IGridCell cell) {
		final boolean alive = cell.getState();
		final int aliveNeighboursCount = getAliveNeighbors (cell);
		Collection<IRule> rules = new ArrayList <> ();
		rules.add(fewerThan2LiveNeighborsDies(alive, aliveNeighboursCount));
		rules.add(moreThan3LiveNeighborsDies(alive, aliveNeighboursCount));
		rules.add(livesIf2Or3LiveNeighbors(alive, aliveNeighboursCount));
		rules.add(aliveIf3AliveNeighbors(alive, aliveNeighboursCount));
		return rules;
	}

	private IRule fewerThan2LiveNeighborsDies (final boolean alive, final int aliveNeighboursCount) {
		IRule rule = new IRule () {
			@Override
			public boolean evaluateCondition() {
				return alive && aliveNeighboursCount < getMinAliveNeighborsCount();
			}
			@Override
			public boolean getResult() {
				return false;
			}
		};	
		return rule;
	}
	
	private IRule moreThan3LiveNeighborsDies (final boolean alive, final int aliveNeighboursCount) {
		IRule rule = new IRule () {
			@Override
			public boolean evaluateCondition() {
				return alive && aliveNeighboursCount > getMaxAliveNeighborsCount();
			}
			@Override
			public boolean getResult() {
				return false;
			}
		};	
		return rule;
	}
	
	private IRule livesIf2Or3LiveNeighbors  (final boolean alive, final int aliveNeighboursCount) {
		IRule rule = new IRule () {
			@Override
			public boolean evaluateCondition() {
				return alive && 
						aliveNeighboursCount >= getMinAliveNeighborsCount() && 
						aliveNeighboursCount <= getMaxAliveNeighborsCount() ;
			}
			@Override
			public boolean getResult() {
				return true;
			}
		};	
		return rule;
	}
	
	private IRule aliveIf3AliveNeighbors  (final boolean alive, final int aliveNeighboursCount) {
		IRule rule = new IRule () {
			@Override
			public boolean evaluateCondition() {
				return !alive && aliveNeighboursCount == getMaxAliveNeighborsCount ();
			}
			@Override
			public boolean getResult() {
				return true;
			}
		};	
		return rule;
	}
	
	private int getAliveNeighbors (IGridCell cell) {
		int count = 0;
		for (IGridCell neighbour : cell.getNeighbors()) {
			if (neighbour.getState()) {
				count ++;
			}
		}
		return count;
	}

	public int getMinAliveNeighborsCount() {
		return minAliveNeighborsCount;
	}

	public int getMaxAliveNeighborsCount() {
		return maxAliveNeighborsCount;
	}

}
