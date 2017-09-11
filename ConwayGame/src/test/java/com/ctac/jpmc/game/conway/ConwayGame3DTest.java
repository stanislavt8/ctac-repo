package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ctac.jpmc.game.IGrid;
import com.ctac.jpmc.game.IGridCell;

public class ConwayGame3DTest {

	@Test
	public void testFewerThan2LiveNeighborsDies() {
		boolean[][][] gridArray = { 
			{{false,false,false}},
			{{false,true,false}},
			{{false,true,false}},
		};
		Game3D game = new Game3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("Fewer Than 2 Live Neighbors Dies error ", false, cell.getState());
	}
	
	@Test
	public void testMoreThan3LiveNeighborsDies() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{true,true,true}},
			{{false,true,false}},
		};
		Game3D game = new Game3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("More Than 3 Live Neighbors Dies error ", false, cell.getState());
		
	}
	
	@Test
	public void test2LiveNeighborsLives() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{true,true,false}},
			{{false,false,false}},
		};
		Game3D game = new Game3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("2 Live Neighbors Lives  error ", true, cell.getState());
	}
	
	@Test
	public void test3LiveNeighborsLives() {
		
		boolean[][][] gridArray = { 
				{{false,false,true}},
				{{true,true,true}},
				{{false,false,false}},
				};
		Game3D game = new Game3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", true, cell.getState());
		grid = game.getNextStage();
		assertEquals("3 Live Neighbors Lives  error ", true, cell.getState());
		
	}
	
	
	@Test
	public void testExactly3LiveNeighborsBecomesLive() {
		boolean[][][] gridArray = { 
			{{false,false,true}},
			{{true,false,true}},
			{{false,false,false}},
		};
		Game3D game = new Game3D (gridArray);
		IGrid grid = game.getCurrentStage();
		IGridCell cell = grid.getCell(1,0,1);
		assertEquals("Current state error ", false, cell.getState());
		grid = game.getNextStage();
		assertEquals("Exactly 3 Live Neighbors Becomes Live error ", true, cell.getState());
	}
	


}
