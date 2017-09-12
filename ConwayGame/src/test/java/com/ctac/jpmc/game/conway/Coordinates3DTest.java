package com.ctac.jpmc.game.conway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.ctac.jpmc.game.ICoordinates;


public class Coordinates3DTest {

	
	@Test
	public void testGetValues() {
		ICoordinates c = new Coordinates3D (33,57,81);
		int [] values = c.getValues();
		assertEquals("size", 3, values.length);
		assertEquals("Equals x", 33, values[0]);
		assertEquals("Equals y", 57, values[1]);
		assertEquals("Equals y", 81, values[2]);
	}
	
		
	@Test
	public void testEquals() {
		ICoordinates a = new Coordinates3D (33,57,81);
		ICoordinates b = new Coordinates3D (33,57,81);
		assertEquals("Equals", a, b);
	}
	
	@Test
	public void testNotEquals() {
		ICoordinates a = new Coordinates3D (33,57,81);
		ICoordinates b = new Coordinates3D (57,33,81);
		assertNotEquals("Not Equals", a, b);
		ICoordinates c = new Coordinates3D (33,57,88);
		assertNotEquals("Not Equals", a, c);
	}
	
	
	@Test
	public void testSet() {
		Set <ICoordinates> set = new HashSet  <ICoordinates> ();
		ICoordinates a = new Coordinates3D (2,2,0);
		set.add(a);
		ICoordinates b = new Coordinates3D (0,1,0);
		set.add( b);
		ICoordinates c = new Coordinates3D (2,2,0);
		set.add( c);
		set.add( a);
		assertEquals("set size", 2, set.size());
	}
	
}