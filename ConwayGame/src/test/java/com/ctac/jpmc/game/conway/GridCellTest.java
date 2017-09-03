package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;
import com.ctac.jpmc.game.ICoordinates;

public class GridCellTest {

	@Test
	public void testEmpty() {
		boolean[][] gridArray = {};
		IGrid grid = new Grid2D (gridArray);
		IGridCell element = new GridCell ( new Coordinates2D (0,0), true, grid);
		assertEquals("Neighbors size", 0, element.getNeighbors().size());
	}
	
	@Test
	public void testSetState() {
		boolean[][] gridArray = {};
		IGrid grid = new Grid2D (gridArray);
		IGridCell element = new GridCell ( new Coordinates2D (0,0), true, grid);
		assertEquals("init state ", true, element.getState());
		element.setState(false);
		assertEquals("new false state ", false, element.getState());
		element.setState(true);
		assertEquals("new true state ", true, element.getState());
	}
	
	@Test
	public void testGetCoordinates () {
		boolean[][] gridArray = {};
		IGrid grid = new Grid2D (gridArray);
		ICoordinates coord = new Coordinates2D (0,0);
		IGridCell element = new GridCell (coord, true, grid);
		assertEquals("coordinates ", coord, element.getCoordinates());
	}
	
	@Test
	public void test3x3() {
		boolean[][] gridArray = { 
				{false,false,true},
				{true,true,false},
				{false,false,false},
				};
		IGrid grid = new Grid2D (gridArray);
		IGridCell element00 = new GridCell ( new Coordinates2D (0,0), true, grid);
		assertEquals("element 0,0 Neighbors size", 3, element00.getNeighbors().size());
		IGridCell element11 = new GridCell ( new Coordinates2D (1,1), false, grid);
		assertEquals("element 1,1 Neighbors size", 8, element11.getNeighbors().size()); 
	}

}
