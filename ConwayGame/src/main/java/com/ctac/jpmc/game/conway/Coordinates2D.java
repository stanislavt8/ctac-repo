package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.ICoordinates; 

/**
 * 
 * 2D Coordinates
 * 
 * known limitation: maximum x or y is 46341
 *
 */
public class Coordinates2D extends AbstractCoordinates implements ICoordinates {
	
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


	private int distanceSquaredTo(Coordinates2D that) {
        int dx = this.x - that.x;
        int dy = this.y - that.y;
        int result = dx*dx + dy*dy;
        if (result <0) {
        	throw new CoordinatesException ("overflow"); 
        }
        if ((dx >= 0 && dy >= 0) || (dx > 0 && dy < 0)) {
        	return result;	
        }
	    return -result;
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
	
	/**
	 * 
	 * This specific implementation designed to compare cells in a way which
	 * - return <code>0</code> for cell which have exactly same coordinates
	 * - return <code>1</code> or <code>-1</code> for cells which are horizontally or vertically adjacent;
	 * - return <code>2</code> or <code>-2</code> for cells which are diagonally adjacent;
	 * 
	 **/
	protected int compareByDistance (ICoordinates other) {
		if (other == null) {
			return Integer.MIN_VALUE;
		}
		if (!( other instanceof Coordinates2D)) {
			return Integer.MAX_VALUE ;			
		}
		Coordinates2D other2D = (Coordinates2D) other;
        return distanceSquaredTo(other2D);
	}




  
}
