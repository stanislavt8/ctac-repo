package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.ICoordinates; 

/**
 * 
 * 2D Coordinates
 * 
 *
 */
public class Coordinates2D  implements ICoordinates {
	
	private int x;
	private int y;

	/**
	 * Constructor with coordinates
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public Coordinates2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Default Constructor
	 * 
	 */
	public Coordinates2D() {
		this (0,0);
	}
		
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	@Override
	public int hashCode() {
		  int tmp = ( y +  ((x+1)/2));
          return x +  ( tmp * tmp);
	}

	@Override
	public boolean equals(Object other) {
		if (!( other instanceof Coordinates2D)) {
			return false;		
		}
		Coordinates2D other2D = (Coordinates2D) other;
		return (other2D.x == x && other2D.y == y );
	}

	/**
	 * get Number Of Dimensions
	 * 
	 * @return returns <code>2</code> 
	 */
	@Override
	public int getNumberOfDimensions() {
		return 2;
	}
	
	/**
	 * get coordinates 
	 * 
	 * @return coordinates array [x,y]
	 */
	@Override
	public int [] getValues () {
		return new int [] {x,y};
	}
  
}
