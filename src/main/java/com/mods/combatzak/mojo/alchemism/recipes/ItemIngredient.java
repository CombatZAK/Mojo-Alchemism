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
	 * Determines if an itemstack matches the ingredient
	 */
	@Override
	public boolean matches(ItemStack target) {
		if (target == null) return false; //null test
		if (this.ingredient.getItem() != target.getItem()) return false; //check item reference
		if (this.ingredient.getHasSubtypes() && this.ingredient.getItemDamage() != target.getItemDamage()) return false; //check metadata
		
		return true; //if we get here, the ingredient matches
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
