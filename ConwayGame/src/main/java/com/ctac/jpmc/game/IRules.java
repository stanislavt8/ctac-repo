package com.ctac.jpmc.game;

import java.util.Collection;

/**
 * 
 * this interface hold collection of <code>IRule</code> to execute
 *
 */
public interface IRules {
	
	public Collection <IRule> executeRules (IGridCell cell);

}
