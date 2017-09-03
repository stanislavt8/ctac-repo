package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

public class Grid2DTest {
	
	@Test
	public void testEmpty() {
		boolean[][] gridArray = {};
		IGrid grid = new Grid2D (gridArray);
		Collection <IGridCell>  cells = grid.getCells();
		assertEquals("grid size", 0, cells.size());
	}
	
	@Test
	public void testNull() {
		boolean[][] gridArray = null;
		IGrid grid = new Grid2D (gridArray);
		Collection <IGridCell>  cells = grid.getCells();
		assertEquals("grid size", 0, cells.size());
	}

	@Test
	public void test1x1() {
		boolean[][] gridArray = { {false}	};
		IGrid grid = new Grid2D (gridArray);
		Collection <IGridCell>  cells = grid.getCells();
		assertEquals("grid size", 1, cells.size());
		IGridCell cell = cells.iterator().next();
		assertEquals("Element + "+ 0 +", " + 0 + "state error ",cell.getState(), gridArray[0][0]);
		assertEquals("element 0,0 Neighbors size", 0, cell.getNeighbors().size()); 

	}
	
	@Test(expected = CoordinatesException.class)
	public void testNullCoordinates() {
		boolean[][] gridArray = { {false}	};
		IGrid grid = new Grid2D (gridArray);
		grid.getCell(null);
	}
	
	@Test(expected = CoordinatesException.class)
	public void testInvalidCoordinates() {
		boolean[][] gridArray = { {false}	};
		IGrid grid = new Grid2D (gridArray);
		grid.getCell(1,2,3,4,5);
	}
	
	
	@Test
	public void test2x2() {
		boolean[][] gridArray = { 
				{false,false},
				{true,true},
				};
		IGrid grid = new Grid2D (gridArray);
		Collection <IGridCell>  cells = grid.getCells();
		assertEquals("grid size", 4, cells.size());
		for (int i = 0; i < 2; i++)	{
			for (int j = 0; j < 2; j++) {
				IGridCell cell = grid.getCell(i,j);
				assertEquals("Element + "+ i +", " + j + "state error ", cell.getState(), gridArray[i][j]);
				assertEquals("element  Neighbors size", 3, cell.getNeighbors().size()); 
		    }
		}
	}
	
	@Test
	public void test3x3() {
		boolean[][] gridArray = { 
				{false,false,true},
				{true,true,false},
				{false,false,false},
				};
		IGrid grid = new Grid2D (gridArray);
		Collection <IGridCell>  cells = grid.getCells();
		assertEquals("grid size", 9, cells.size());
		for (int i = 0; i < 3; i++)	{
			for (int j = 0; j < 3; j++) {
				IGridCell cell = grid.getCell(i,j);
				assertEquals("Element + "+ i +", " + j + "state error ", cell.getState(), gridArray[i][j]);
		    }
		}
		assertEquals("element 0,0 Neighbors size", 3, grid.getCell(0,0).getNeighbors().size()); 
		assertEquals("element 0,1 Neighbors size", 5, grid.getCell(0,1).getNeighbors().size()); 
		assertEquals("element 0,2 Neighbors size", 3, grid.getCell(0,2).getNeighbors().size()); 
		assertEquals("element 1,0 Neighbors size", 5, grid.getCell(1,0).getNeighbors().size()); 
		assertEquals("element 1,1 Neighbors size", 8, grid.getCell(1,1).getNeighbors().size()); 
		assertEquals("element 1,2 Neighbors size", 5, grid.getCell(1,2).getNeighbors().size()); 
		assertEquals("element 2,0 Neighbors size", 3, grid.getCell(2,0).getNeighbors().size()); 
		assertEquals("element 2,1 Neighbors size", 5, grid.getCell(2,1).getNeighbors().size()); 
		assertEquals("element 2,2 Neighbors size", 3, grid.getCell(2,2).getNeighbors().size()); 
	}

}
