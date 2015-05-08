package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;

/**
 * ItemStack input ingredient for a shaped recipe
 * 
 * @author CombatZAK
 *
 */
public class ShapedItemIngredient extends ItemIngredient implements IShapedIngredient {
	/**
	 * Shaped ingredient character label
	 */
	private char label;
	
	/**
	 * Gets the label character for the ingredient
	 */
	@Override
	public char getLabel() {
		return this.label;
	}
	
	/**
	 * Sets the label character for the ingredient
	 * 
	 * @param value ingredient character label
	 */
	public void setLabel(char value) {
		this.label = value;
	}
	
	/**
	 * Creates a new ShapedItemIngredient instance
	 * 
	 * @param ingredient ItemStack recipe input
	 * @param label character label
	 */
	public ShapedItemIngredient(ItemStack ingredient, char label) {
		super(ingredient); //initialize itemstack
		this.label = label; //set character label
	}
	
	/**
	 * Creates a new ShapedItemIngredient instance
	 * 
	 * @param label character label
	 */
	public ShapedItemIngredient(char label) {
		this(null, label);
	}
	
	/**
	 * Default constructor
	 */
	public ShapedItemIngredient() {
		this(null, '\0');
	}
}
