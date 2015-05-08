package com.mods.combatzak.mojo.alchemism.recipes;

/**
 * Represents an ingredient in a shaped recipe
 * 
 * @author CombatZAK
 *
 */
public interface IShapedIngredient extends IIngredient {
	
	/**
	 * Gets the label character for the ingredient 
	 * @return label character for the ingredient in the shaped recipe
	 */
	public char getLabel();
}
