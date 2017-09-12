package com.ctac.jpmc.game.conway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.ctac.jpmc.game.ICoordinates;


public class Coordinates2DTest {

	
	@Test
	public void testGetValues() {
		ICoordinates c = new Coordinates2D (33,57);
		int [] values = c.getValues();
		assertEquals("size", 2, values.length);
		assertEquals("Equals x", 33, values[0]);
		assertEquals("Equals y", 57, values[1]);
	}
	
		
	@Test
	public void testEquals() {
		ICoordinates a = new Coordinates2D (33,57);
		ICoordinates b = new Coordinates2D (33,57);
		assertEquals("Equals", a, b);
	}
	
	@Test
	public void testNotEquals() {
		ICoordinates a = new Coordinates2D (33,57);
		ICoordinates b = new Coordinates2D (57,33);
		assertNotEquals("Not Equals", a, b);
	}
	
	@Test
	public void testSet() {
		Set <ICoordinates> set = new HashSet  <ICoordinates> ();
		ICoordinates a = new Coordinates2D (2,2);
		set.add(a);
		ICoordinates b = new Coordinates2D (0,1);
		set.add( b);
		ICoordinates c = new Coordinates2D (2,2);
		set.add( c);
		set.add( a);
		assertEquals("set size", 2, set.size());
	}
	
}