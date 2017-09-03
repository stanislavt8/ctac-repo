package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
	public void testCompare() {
		ICoordinates a = new Coordinates2D (33,57);
		ICoordinates b = new Coordinates2D (33,56);
		assertEquals("compare", 1, a.compareTo(b));
	}
	
	@Test(expected = CoordinatesException.class)
	public void testBadCompare() {
		ICoordinates a = new Coordinates2D (0,0);
		ICoordinates b = new Coordinates2D (0,46341);
		b.compareTo(a);
	}
	
	@Test
	public void testSort() {
		List <ICoordinates> list = new ArrayList  <ICoordinates> ();
		ICoordinates c22 = new Coordinates2D (2,2);
		list.add(c22);
		ICoordinates c01 = new Coordinates2D (0,1);
		list.add( c01);
		ICoordinates c00 = new Coordinates2D (0,0);
		list.add( c00);
		ICoordinates c11 = new Coordinates2D (1,1);
		list.add( c11 );
		ICoordinates c99 = new Coordinates2D (9,9);
		list.add( c99 );
		ICoordinates c10 = new Coordinates2D (1,0);
		list.add( c10 );
		ICoordinates c12 = new Coordinates2D (1,2);
		list.add( c12);
		ICoordinates c02 = new Coordinates2D (0,2);
		list.add( c02);
		ICoordinates c21 =  new Coordinates2D (2,1);
		list.add(c21);
		assertEquals("Unsorted 0 element", c22, list.get(0));
		assertEquals("Unsorted 8 element", c21, list.get(8));
		
		Collections.sort(list);
		assertEquals("sorted 0 element", c00, list.get(0));
		assertEquals("sorted 1 element", c01, list.get(1));
		assertEquals("sorted 2 element", c02, list.get(2));
		assertEquals("sorted 3 element", c10, list.get(3));
		assertEquals("sorted 4 element", c11, list.get(4));
		assertEquals("sorted 5 element", c12, list.get(5));
		assertEquals("sorted 6 element", c21, list.get(6));
		assertEquals("sorted 7 element", c22, list.get(7));
		assertEquals("sorted 8 element", c99, list.get(8));
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
	
	@Test
	public void testSortedSet() {
		SortedSet <ICoordinates> set = new TreeSet  <ICoordinates> ();
		ICoordinates a = new Coordinates2D (2,2);
		set.add(a);
		ICoordinates b = new Coordinates2D (0,1);
		set.add( b);
		ICoordinates c = new Coordinates2D (2,2);
		set.add( c);
		set.add( a);
		assertEquals("set size", 2, set.size());
		assertEquals("sorted 0 element", b, set.first());
		assertEquals("sorted 1 element", a, set.last());
	}
	
}