package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.ICoordinates; 

/**
 * 
 * 2D Coordinates
 * 
 *
 */
public class Coordinates3D implements ICoordinates {
	
	private int x;
	private int y;
	private int z;

	/**
	 * Constructor with coordinates
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param z z-coordinate
	 */
	public Coordinates3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Default Constructor
	 * 
	 */
	public Coordinates3D() {
		this (0,0,0);
	}
	
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}

	@Override
	public int hashCode() {
		int h = x;
	    h = h * 31 + y;
	    h = h * 31 + z;
        return h;
	}

	@Override
	public boolean equals(Object other) {
		if (!( other instanceof Coordinates3D)) {
			return false;		
		}
		Coordinates3D other3D = (Coordinates3D) other;
		return (other3D.x == x && other3D.y == y  && other3D.z == z );
	}



	/**
	 * get Number Of Dimensions
	 * 
	 * @return returns <code>3</code> 
	 */
	@Override
	public int getNumberOfDimensions() {
		return 3;
	}
	
	/**
	 * get coordinates 
	 * 
	 * @return coordinates array [x,y,z]
	 */
	@Override
	public int [] getValues () {
		return new int [] {x,y,z};
	}
  
}
