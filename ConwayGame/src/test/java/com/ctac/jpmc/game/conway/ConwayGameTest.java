package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;



public class ConwayGameTest {

	@Test
	public void testFewerThan2LiveNeighborsDies() {
		boolean[][] gridArray = { 
			{false,false,false},
			{false,true,false},
			{false,true,false},
		};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("Fewer Than 2 Live Neighbors Dies error ", false, cell.getState());
	}
	
	@Test
	public void testMoreThan3LiveNeighborsDies() {
		boolean[][] gridArray = { 
			{false,false,true},
			{true,true,true},
			{false,true,false},
		};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("More Than 3 Live Neighbors Dies error ", false, cell.getState());
		
	}

	
	@Test
	public void test2LiveNeighborsLives() {
		boolean[][] gridArray = { 
			{false,false,true},
			{true,true,false},
			{false,false,false},
		};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("2 Live Neighbors Lives  error ", true, cell.getState());
	}
	
	@Test
	public void test3LiveNeighborsLives() {
		
		boolean[][] gridArray = { 
				{false,false,true},
				{true,true,true},
				{false,false,false},
				};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("3 Live Neighbors Lives  error ", true, cell.getState());
		
	}
	
	
	@Test
	public void testExactly3LiveNighborsBecomesLive() {
		boolean[][] gridArray = { 
			{false,false,true},
			{true,false,true},
			{false,false,false},
		};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,1);
		assertEquals("Current state error ", false, cell.getState());
		grid = game.getNextStage();
		assertEquals("Exactly 3 Live Nighbors Becomes Live error ", true, cell.getState());
	}
	
	@Test
	public void testAllLives3x3() {
		boolean[][] gridArray = { 
			{true,true,true},
			{true,true,true},
			{true,true,true},
		};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getNextStage();
			
		for (int i = 0; i < 3; i++)	{
			for (int j = 0; j < 3; j++) {
				if ((i==0 && j==0) || (i==0 && j==2) || (i==2 && j==0) || (i==2 && j==2)) {
					assertEquals("Element + "+ i +", " + j + " error ", true, grid.getCell(i,j).getState());
				}
				else {
					assertEquals("Element + "+ i +", " + j + " error ", false, grid.getCell(i,j).getState());
				}
		    }
		}
	}
	
	@Test
	public void testFull6x8() {
		boolean [][] gridArray = { 
			{false,false,false,false,false,false,true,false},
			{true,true,true,false,false,false,true,false},
			{false,false,false,false,false,false,true,false},
			{false,false,false,false,false,false,false,false},
			{false,false,false,true,true,false,false,false},
			{false,false,false,true,true,false,false,false}
		};
		Game2D game = new Game2D (gridArray);
		IGrid grid = game.getNextStage();

		assertEquals("Element 0,0 error ", false, grid.getCell(0,0).getState());
		assertEquals("Element 0,1 error ", true, grid.getCell(0,1).getState());
		assertEquals("Element 1,1 error ", true, grid.getCell(1,1).getState());
		assertEquals("Element 1,5 error ", true, grid.getCell(1,5).getState());
		assertEquals("Element 1,6 error ", true, grid.getCell(1,6).getState());
		assertEquals("Element 1,7 error ", true, grid.getCell(1,7).getState());
		assertEquals("Element 2,1 error ", true, grid.getCell(2,1).getState());
		assertEquals("Element 4,3 error ", true, grid.getCell(4,3).getState());
		assertEquals("Element 4,4 error ", true, grid.getCell(4,4).getState());
		assertEquals("Element 5,3 error ", true, grid.getCell(5,3).getState());
		assertEquals("Element 5,4 error ", true, grid.getCell(5,4).getState());
		
		assertEquals("Element 5,7 error ", false, grid.getCell(5,7).getState());
		
		grid = game.getNextStage();
		// second stage produce same results as initial stage
		for (int i = 0; i < 6; i++)	{
			for (int j = 0; j < 8; j++) {
				assertEquals("Element + "+ i +", " + j + " error ", gridArray[i][j], grid.getCell(i,j).getState());
			}
		}
	}
	

	@Test(timeout=25000)
	public void test100x100Random2Stages() {
		Game2D game = new Game2D (100,100);
		IGrid grid = game.getCurrentStage();
		Collection <IGridCell>  cells = grid.getCells();
		assertEquals("grid size", 100*100, cells.size());
		for (int i = 0; i < 2; i++) {
			grid = game.getNextStage();
		}
	}
	
	


}
