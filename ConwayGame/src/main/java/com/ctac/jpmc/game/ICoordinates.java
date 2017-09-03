package com.ctac.jpmc.game;

import java.util.Comparator;

/**
 * 
 * ICoordinates interface can be used to represent 2D or 3D Coordinates
 * it is not strictly needed, but useful to have a way to compare coordinates
 */
public interface ICoordinates extends Comparable<ICoordinates> , Comparator <ICoordinates>  {
	
	/**
	 * 
	 * A cell's neighbors are those cells which are horizontally, 
	 * vertically or diagonally adjacent. 
	 * Most cells will have eight neighbors. 
	 * Cells placed on the edge of the grid will have fewer.
	 *		
	 * @param other Coordinates
	 * @return <code>true</code> if other cell is a neighbor
	 */
	public boolean isNeighbor (ICoordinates other);
	
	/**
	 * get Number Of Dimensions
	 * 
	 * @return for instance, returns <code>2</code> for 2 dimension coordinates 
	 */
	public int getNumberOfDimensions ();
	
	/**
	 * get coordinates
	 * 
	 * @return coordinates array  [x,y,z,etc.]
	 */
	public int [] getValues ();

}
