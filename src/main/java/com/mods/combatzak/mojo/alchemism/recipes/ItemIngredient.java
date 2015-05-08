package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;

/**
 * An ItemStack input ingredient
 * 
 * @author CombatZAK
 *
 */
public class ItemIngredient implements IIngredient {

	/**
	 * Item ingredient for recipe
	 */
	private ItemStack ingredient = null;
		
	/**
	 * Gets the recipe ingredient
	 */
	@Override
	public Object getIngredient() {
		return this.ingredient;
	}
	
	/**
	 * Sets the recipe ingredient
	 * 
	 * @param value
	 */
	public void setIngredient(ItemStack value) { this.ingredient = value; }
	
	/**
	 * Creates a new ItemIngredient instance
	 * 
	 * @param ingredient ItemStack input for recipe
	 */
	public ItemIngredient(ItemStack ingredient) {
		this.ingredient = ingredient;
	}
	
	/**
	 * Default constructor
	 */
	public ItemIngredient() {
		this(null);
	}

}
