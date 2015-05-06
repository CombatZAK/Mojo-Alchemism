package com.mods.combatzak.mojo;

/**
 * Action object that can be invoked once or more. This class is cannot be instantiated
 * 
 * @author CombatZAK
 *
 */
public abstract class MojoAction {
	protected boolean isApplied = false; //indicates whether or not the action is applied; invoking apply should set this value to true
	
	/**
	 * Indicates whether or not the action has been applied
	 * @return true if the action has been applied; false otherwise
	 */
	public boolean getIsApplied() { return this.isApplied; }
	
	/**
	 * Sets the applied status of the action
	 *  
	 * @param value new applied status
	 */
	protected void setIsApplied(boolean value) { this.isApplied = value; }
	
	/**
	 * Applies the action
	 * 
	 * @return true if the action was successful, false otherwise 
	 */
	public abstract boolean apply();
}
