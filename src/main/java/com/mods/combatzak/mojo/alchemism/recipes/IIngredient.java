package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;

/**
 * Represents a recipe ingredient
 * 
 * @author CombatZAK
 *
 */
public interface IIngredient {
	
	/**
	 * Retrieves the forge ingredient object for the recipe
	 * @return Ingredient for recipe
	 */
	public Object getIngredient();
	
	/**
	 * Determines if an item matches the ingredient; ignores count, checks metadata
	 * 
	 * @param target target itemstack
	 * @return true if the target item matches the ingredient; false otherwise
	 */
	public boolean matches(ItemStack target);
}
