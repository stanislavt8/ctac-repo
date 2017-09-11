package com.ctac.jpmc.game;

/**
 * 
 * IGame interface can represent any state changing game operating on a grid
 *
 */
public interface IGame {
	
	/**
	 * Initiate the game
	 * @param grid grid with initial stage
	 */
	public void initiate (IGrid grid);
	
	/**
	 * 
	 * get the current stage of the game 
	 * 
	 * @return grid representing the state
	 */
	public IGrid getCurrentStage ();
	
	/**
	 * 
	 * get the next stage of the game 
	 * 
	 * @return grid representing the state
	 */
	public IGrid getNextStage ();
	
	/**
	 * get rules associated to the game
	 * 
	 * @return rules to evaluate
	 */
	public IRules getRules ();

}
