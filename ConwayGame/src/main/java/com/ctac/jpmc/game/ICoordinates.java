package com.ctac.jpmc.game;


/**
 * 
 * ICoordinates interface can be used to represent 2D or 3D Coordinates
 *	
 */
public interface ICoordinates {
	
	
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
