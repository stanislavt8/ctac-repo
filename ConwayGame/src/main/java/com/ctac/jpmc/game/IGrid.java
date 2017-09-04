package com.ctac.jpmc.game;

import java.util.Collection;
import java.util.Set;

/**
 * 
 IGrid interface can be used to represent 2D or 3D Grid 
 *
 */
public interface IGrid {
	
	/**
	 * 
	 * get all cells of a grid
	 * 
	 * @return collection of cells
	 */
	public Collection <IGridCell> getCells (); 
	
	/**
	 * 
	 * get a specific grid cell by coordinates 
	 * 
	 * @param coordinates input coordinates
	 * @return cell or <code>null</code> if there is no such cell
	 */
	public IGridCell getCell (int ... coordinates); 
	
	/**
	 *  get Neighbors (horizontal, vertical, and diagonal)
	 * 
	 * @param cell cell to analyze
	 * @return set of Neighbors to the specified cell
	 */
	public Set<IGridCell> getNeighbors(IGridCell cell);


}
