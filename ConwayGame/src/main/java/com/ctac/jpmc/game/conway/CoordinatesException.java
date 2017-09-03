package com.ctac.jpmc.game.conway;

/**
 * 
 * an Exception to handle invalid coordinates
 *
 */
public class CoordinatesException extends RuntimeException {

	private static final long serialVersionUID = -5287403242940367050L;
	
	public CoordinatesException (String msg) {
		super (msg);
	}

}
