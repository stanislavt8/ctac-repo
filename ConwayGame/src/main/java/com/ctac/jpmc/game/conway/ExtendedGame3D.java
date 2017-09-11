package com.ctac.jpmc.game.conway;

import com.ctac.jpmc.game.IGame;
import com.ctac.jpmc.game.IRules;

public class ExtendedGame3D extends Game3D implements IGame {

	public ExtendedGame3D(boolean[][][] gridArray) {
		super(gridArray);
	}
	
	@Override
	public IRules getRules() {
		return new ExtendedRules ();
	}

}
