package com.ctac.jpmc.game;

/**
 * 
 * this interface hold a single rule to execute
 *
 */
public interface IRule {
	
	/**
	 * evaluate Condition
	 * 
	 * @return <code>true</code> if condition is satisfied
	 */
	public boolean evaluateCondition ();
	
	/**
	 * get boolean result to set if condition is satisfied
	 * 
	 * @return result to set
	 */
	public boolean getResult ();

}
