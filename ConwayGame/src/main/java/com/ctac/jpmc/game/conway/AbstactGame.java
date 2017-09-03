package com.ctac.jpmc.game.conway;


import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctac.jpmc.game.IGame;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell; 


/**
 * 
 * Conway's  game  of  life implementation  (on 2D cell)
 * See details  about the game of life on:  http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 */
public abstract class AbstactGame implements IGame {
	
	private IGrid grid;
	private Logger logger = LoggerFactory.getLogger(AbstactGame.class);
	
	/**
	 * default constructor witch dosen't initiate the game
	 */
	public AbstactGame() {
		initiate ( null );
	}
	
	/**
	 *  constructor witch  initiate the game
	 *  
	 *  @param grid initial stage of the game
	 */
	public AbstactGame(IGrid grid) {
		initiate (grid);
	}
	
	@Override
	public void initiate(IGrid grid) {
		this.grid = grid;
		
	}
	
	@Override
	public IGrid getCurrentStage() {
		return grid;
	}

	@Override
	public IGrid getNextStage() {
		Collection <IGridCell> cells = grid.getCells();
		boolean [] newStates = new boolean  [cells.size()];
		logger.info("getNextStage started");
		Iterator <IGridCell> iterator = cells.iterator();
		for (int i = 0; i < newStates.length; i++) {
			IGridCell cell = iterator.next();
			if (logger.isDebugEnabled()) {
				logger.debug("processing cell "+ cell.toString());
			}
			newStates [i] = getNextState (cell);
		}
		iterator = cells.iterator();
		for (int i = 0; i < newStates.length; i++) {
			iterator.next().setState(newStates [i]);
		}
		logger.info("getNextStage done");
		return grid;
	}


	private boolean getNextState(IGridCell cell) {
		boolean alive = cell.getState();
		int aliveNeighboursCount = getAliveNeighbours (cell);
		if (alive) {
			//Fewer Than 2 Live Neighbors Dies
			if (aliveNeighboursCount <2) {
				alive = false;
			}
			//More Than 3 Live Neighbors Dies 
			else if (aliveNeighboursCount >3 ) {
				alive = false;
			}
			//2 or 3 Live Neighbors Lives do nothing alive is true already;
		}
		else {
			// new alive cell
			if (aliveNeighboursCount == 3 ) {
				alive = true;
			}
		}

		return alive;
	}
	
	private int getAliveNeighbours (IGridCell cell) {
		int count = 0;
		for (IGridCell neighbour : cell.getNeighbors()) {
			if (neighbour.getState()) {
				count ++;
			}
		}
		return count;
	}

}
