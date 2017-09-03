package com.ctac.jpmc.game;

import java.util.Set;


/**
 * 
 *  IGridCell interface can be used to represent 2D or 3D Grid Cell
 *
 */
public interface IGridCell   {
	
	/**
	 * get the state of the cell
	 * 
	 * @return boolean state
	 */
	public boolean getState ();
	
	/**
	 * 
	 * set the state of the cell
	 * 
	 * @param state boolean state
	 */
	public void setState(boolean state);
	
	/**
	 * 
	 * get all Neighbors
	 * 
	 * @return set of Neighbors to the current cell
	 */
	public Set<IGridCell> getNeighbors (); 
	
	/**
	 * 
	 * get cell coordinates
	 * 
	 * @return coordinates
	 */
	public ICoordinates getCoordinates ();

}
