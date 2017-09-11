package com.ctac.jpmc.game.conway;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ctac.jpmc.game.IGame;
import com.ctac.jpmc.game.IGrid;


public class ShapesTest {

	/**
	 * ......
	 * ..oo..
	 * ..oo..
	 * ......
	 */
	@Test
	public void testStableDot2() {
		boolean[][] gridArray = { 
				{false,false,false,false},
				{false,true,true,false},
				{false,true,true,false},
				{false,false,false,false}
		};
		IGame game = new Game2D (gridArray);
		List <boolean[][]> checkList = new ArrayList <> ();
		checkList.add(gridArray);
		checkList.add(gridArray);
		checkList.add(gridArray);
		check (game, checkList);
	}
	
	@Test
	public void test3DStableDot2() {
		boolean[][][] gridArray = { 
				{{false,false,false,false}},
				{{false,true,true,false}},
				{{false,true,true,false}},
				{{false,false,false,false}}
		};
		IGame game = new Game3D (gridArray);
		List <boolean[][][]> checkList = new ArrayList <> ();
		checkList.add(gridArray);
		checkList.add(gridArray);
		checkList.add(gridArray);
		check3D (game, checkList);
	}
	
	/**
	 * .......
	 * ...o...
	 * ..o.o..
	 * ...o...
	 * .......
	 */
	@Test
	public void testStableDiamond4() {
		boolean[][] gridArray = { 
				{false,false,false,false,false},
				{false,false,true,false,false},
				{false,true,false,true,false},
				{false,false,true,false,false},
				{false,false,false,false,false}
		};
		IGame game = new Game2D (gridArray);
		List <boolean[][]> checkList = new ArrayList <> ();
		checkList.add(gridArray);
		checkList.add(gridArray);
		checkList.add(gridArray);
		check (game, checkList);
	}
	
	/**
	 * .......		..o..
	 * ..ooo..  ->  ..o..
	 * .......		..o..
	 */
	@Test
	public void testOscillatingBar3() {
		boolean[][] gridArray = { 
				{false,false,false,false,false},
				{false,false,false,false,false},
				{false,true,true,true,false},
				{false,false,false,false,false},
				{false,false,false,false,false}
		};
		boolean[][] testArray = { 
				{false,false,false,false,false},
				{false,false,true,false,false},
				{false,false,true,false,false},
				{false,false,true,false,false},
				{false,false,false,false,false}
		};
		IGame game = new Game2D (gridArray);
		List <boolean[][]> checkList = new ArrayList <> ();
		checkList.add(testArray);
		checkList.add(gridArray);
		checkList.add(testArray);
		checkList.add(gridArray);
		checkList.add(testArray);
		checkList.add(gridArray);
		check (game, checkList);	
	}
	
	/**
	 * ..ooo..
	 * ...ooo..
	 */
	@Test
	public void testOscillatingToad3() {
		boolean[][] gridArray = { 
				{false,false,false,false,false,false},
				{false,true,true,true,false,false},
				{false,false,true,true,true,false},
				{false,false,false,false,false,false}
		};
		boolean[][] testArray = { 
				{false,false,true,false,false,false},
				{false,true,false,false,true,false},
				{false,true,false,false,true,false},
				{false,false,false,true,false,false}
		};
		IGame game = new Game2D (gridArray);
		List <boolean[][]> checkList = new ArrayList <> ();
		checkList.add(testArray);
		checkList.add(gridArray);
		checkList.add(testArray);
		checkList.add(gridArray);
		checkList.add(testArray);
		checkList.add(gridArray);
		check (game, checkList);	
	}
	
	private void check (IGame game, List <boolean[][]> checkList ) {
		for ( boolean[][] check: checkList ) {
			IGrid grid = game.getNextStage();
			for (int i = 0; i < check.length; i++)	{
				for (int j = 0; j < check[i].length; j++) {
					assertEquals("Element + "+ i +", " + j + " error ", check[i][j], grid.getCell(i,j).getState());
			    }
			}
		}
	}
	
	private void check3D (IGame game, List <boolean[][][]> checkList ) {
		for ( boolean[][][] check: checkList ) {
			IGrid grid = game.getNextStage();
			for (int i = 0; i < check.length; i++)	{
				for (int j = 0; j < check[i].length; j++) {
					for (int k = 0; k < check[i][j].length; k++) {
						assertEquals("Element + "+ i +", " + j + " error ", check[i][j][k], grid.getCell(i,j,k).getState());
					}
				}
			}
		}
	}

}
