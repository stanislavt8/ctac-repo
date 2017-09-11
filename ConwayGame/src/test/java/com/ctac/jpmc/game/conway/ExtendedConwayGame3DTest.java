package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ctac.jpmc.game.IGame;
import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

public class ExtendedConwayGame3DTest {

	/*
	minAliveNeighborsCount = 3;
	maxAliveNeighborsCount = 5;
	 */
	@Test
	public void testFewerThan3LiveNeighborsDies() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{false,true,false}},
			{{false,true,false}},
		};
		IGame game = new ExtendedGame3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("Fewer Than 3 Live Neighbors Dies error ", false, cell.getState());
	}
	
	@Test
	public void testMoreThan5LiveNeighborsDies() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{true,true,true}},
			{{true,true,true}},
		};
		IGame game = new ExtendedGame3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("More Than 5 Live Neighbors Dies error ", false, cell.getState());
		
	}
	
	@Test
	public void test4LiveNeighborsLives() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{true,true,true}},
			{{true,false,false}},
		};
		IGame game = new ExtendedGame3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("4 Live Neighbors Lives  error ", true, cell.getState());
	}
	
	@Test
	public void test3LiveNeighborsLives() {
		
		boolean[][][] gridArray = { 
				{{false,false,true}},
				{{true,true,true}},
				{{false,false,false}},
				};
		IGame game = new ExtendedGame3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("3 Live Neighbors Lives  error ", true, cell.getState());
		
	}
	
	
	@Test
	public void testExactly5LiveNeighborsBecomesLive() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{true,false,true}},
			{{false,true,true}},
		};
		IGame game = new ExtendedGame3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", false, cell.getState());
		grid = game.getNextStage();
		assertEquals("Exactly 5 Live Neighbors Becomes Live error ", true, cell.getState());
	}

}
