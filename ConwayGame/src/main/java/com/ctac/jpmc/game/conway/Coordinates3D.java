package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.ICoordinates; 

/**
 * 
 * 2D Coordinates
 * 
 * known limitation: maximum x or y is 46341
 *
 */
public class Coordinates3D extends AbstractCoordinates implements ICoordinates {
	
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


	private int distanceSquaredTo(Coordinates3D that) {
        int dx = this.x - that.x;
        int dy = this.y - that.y;
        int dz = this.z - that.z;
        int result = dx*dx + dy*dy + dz*dz;
        if (result <0) {
        	throw new CoordinatesException ("overflow"); 
        }
        return result;
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
		if (!( other instanceof Coordinates3D)) {
			return Integer.MAX_VALUE ;			
		}
		Coordinates3D other3D = (Coordinates3D) other;
        return distanceSquaredTo(other3D);
	}




  
}
