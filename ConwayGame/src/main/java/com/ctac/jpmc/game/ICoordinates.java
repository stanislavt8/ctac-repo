package com.ctac.jpmc.game;

/**
 * 
 * ICoordinates interface can be used to represent 2D or 3D Coordinates
 *
 */
public interface ICoordinates extends Comparable<ICoordinates> {
	
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
	 * get coordinates [x,y,z,etc.]
	 * 
	 * @return coordinates array
	 */
	public int [] getValues ();

}
