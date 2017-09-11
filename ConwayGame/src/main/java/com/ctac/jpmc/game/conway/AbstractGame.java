package com.ctac.jpmc.game.conway;


import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctac.jpmc.game.IGame;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;
import com.ctac.jpmc.game.IRule;
import com.ctac.jpmc.game.IRules;


/**
 * 
 * Conway's  game  of  life implementation  (on 2D cell)
 * See details  about the game of life on:  http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 */
public abstract class AbstractGame implements IGame { 
	
	public static final String STANDARD = "STANDARD";
	public static final String EXTENDED = "EXTENDED";
	
	private IGrid grid;
	private Logger logger = LoggerFactory.getLogger(AbstractGame.class);
	
	/**
	 * default constructor witch dosen't initiate the game
	 */
	public AbstractGame() {
		initiate ( null );
	}
	
	/**
	 *  constructor witch  initiate the game
	 *  
	 *  @param grid initial stage of the game
	 */
	public AbstractGame(IGrid grid) {  
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

	@Override
	public IRules getRules() {
		return new StandardRules ();
	}

	private boolean getNextState(IGridCell cell) {
		IRules rules = getRules();
		Collection <IRule> results = rules.executeRules(cell);
		for (IRule result : results) {
			if (result.evaluateCondition() ) {
				return result.getResult();
			}
		}
		return cell.getState();
	}
	
	protected boolean getRandomBoolean() {
	    return Math.random() < 0.5;
	 }

}
