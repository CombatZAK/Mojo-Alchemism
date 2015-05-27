package com.mods.combatzak.mojo.alchemism.actions.te4.smelter;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import cofh.thermalexpansion.util.crafting.SmelterManager;
import cofh.thermalexpansion.util.crafting.SmelterManager.RecipeSmelter;

import com.mods.combatzak.mojo.alchemism.actions.te4.Te4Action;

/**
 * Handles changes to registered TE4 Induction Smelter recipes
 * 
 * @author CombatZAK
 *
 */
public abstract class SmelterAction extends Te4Action {
	/**
	 * Primary input ingredient
	 */
	protected ItemStack primaryInput;
	
	/**
	 * Secondary input ingredient
	 */
	protected ItemStack secondaryInput;
	
	/**
	 * Primary output (guaranteed)
	 */
	protected ItemStack primaryOutput;
	
	/**
	 * Secondary output (chance)
	 */
	protected ItemStack secondaryOutput;
	
	/**
	 * Percentage chance for secondary output
	 */
	protected int secondaryOutputChance;
	
	/**
	 * Gets the primary input ingredient
	 * 
	 * @return operation primary input
	 */
	public ItemStack getPrimaryInput() {
		return this.primaryInput;
	}
	
	/**
	 * Sets the primary input ingredient
	 * 
	 * @param value operation primary input
	 */
	public void setPrimaryInput(ItemStack value) {
		this.primaryInput = value;
	}
	
	/**
	 * Self-referentially sets the primary input ingredient
	 * 
	 * @param value operation primary input
	 * @return self-reference
	 */
	public SmelterAction withPrimaryInput(ItemStack value) {
		this.setPrimaryInput(value);
		return this;
	}
	
	/**
	 * Gets the secondary input ingredient
	 *  
	 * @return secondary operation input
	 */
	public ItemStack getSecondaryInput() {
		return this.secondaryInput;
	}
	
	/**
	 * Sets the secondary input ingredient
	 * 
	 * @param value secondary operation input
	 */
	public void setSecondaryInput(ItemStack value) {
		this.secondaryInput = value;
	}
	
	/**
	 * Self-referentially sets the secondary input ingredient
	 * 
	 * @param value secondary operation input
	 * @return self-reference
	 */
	public SmelterAction withSecondaryInput(ItemStack value) {
		this.setSecondaryInput(value);
		return this;
	}
	
	/**
	 * Gets the primary output for the operation
	 * 
	 * @return primary operation output
	 */
	public ItemStack getPrimaryOutput() {
		return this.primaryOutput;
	}
	
	/**
	 * Sets the primary output for the operation
	 * 
	 * @param value primary operation output
	 */
	public void setPrimaryOutput(ItemStack value) {
		this.primaryOutput = value;
	}
	
	/**
	 * Self-referentially sets the primary output for the operation
	 * 
	 * @param value primary operation output
	 * @return self-reference
	 */
	public SmelterAction withPrimaryOutput(ItemStack value) {
		this.setPrimaryOutput(value);
		return this;
	}
	
	/**
	 * Gets the secondary output for the operation
	 * 
	 * @return secondary operation output
	 */
	public ItemStack getSecondaryOutput() {
		return this.secondaryOutput;
	}
	
	/**
	 * Sets the secondary output for the operation
	 * 
	 * @param value secondary operation output
	 */
	public void setSecondaryOutput(ItemStack value) {
		this.secondaryOutput = value;
	}
	
	/**
	 * Self-referentially sets the secondary output for the operation
	 * 
	 * @param value secondary operation output
	 * @return self-reference
	 */
	public SmelterAction withSecondaryOutput(ItemStack value) {
		this.setSecondaryOutput(value);
		return this;
	}
	
	/**
	 * Gets the chance for secondary output
	 * 
	 * @return percentage secondary chance
	 */
	public int getSecondaryOutputChance() {
		return this.secondaryOutputChance;
	}
	
	/**
	 * Sets the chance for secondary output
	 * 
	 * @param value percentage secondary chance
	 */
	public void setSecondaryOutputChance(int value) {
		this.secondaryOutputChance = value;
	}
	
	/**
	 * Self-referentially sets the chance for secondary output
	 * 
	 * @param value percentage secondary chance
	 * @return self-reference
	 */
	public SmelterAction withSecondaryOutputChance(int value) {
		this.setSecondaryOutputChance(value);
		return this;
	}
	
	/**
	 * Creates a new SmelterAction instance
	 * 
	 * @param energy operation energy cost
	 * @param primaryInput primary operation input
	 * @param secondaryInput secondary operation input
	 * @param primaryOutput primary operation output
	 * @param secondaryOutput secondary operation output
	 * @param secondaryOutputChance percentage chance for secondary output
	 */
	public SmelterAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryOutputChance) {
		super(energy);
		this.primaryInput = primaryInput;
		this.secondaryInput = secondaryInput;
		this.primaryOutput = primaryOutput;
		this.secondaryOutput = secondaryOutput;
		this.secondaryOutputChance = secondaryOutputChance;
	}
	
	/**
	 * Creates a new SmelterAction instance
	 * 
	 * @param energy operation energy cost
	 * @param primaryInput primary operation input
	 * @param secondaryInput secondary operation input
	 * @param primaryOutput primary operation output
	 */
	public SmelterAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput) {
		this(energy, primaryInput, secondaryInput, primaryOutput, null, 0);
	}
	
	/**
	 * Default constructor
	 */
	public SmelterAction() {
		this(0, null, null, null, null, 0);
	}
	
	/**
	 * Gets a set of Smelter recipes that match an item stack on primary output
	 * 
	 * @param target primary output match target
	 * @return list of Smelter recipes that match the target on primary output
	 */
	public static List<RecipeSmelter> getPrimaryOutputMatches(ItemStack target) {
		if (target == null) return null; //null test
		
		List<RecipeSmelter> result = new ArrayList<RecipeSmelter>();
		for (RecipeSmelter recipe : SmelterManager.getRecipeList()) { //go through all the smelter recipes
			if (isOreDictMatch(recipe.getPrimaryOutput(), target)) //examine primary output
				result.add(recipe);
		}
		
		return result;
	}
	
	/**
	 * Gets a set of Smelter recipes that match an item stack on secondary output
	 * 
	 * @param target secondary output match target
	 * @return list of SmelterRecipes that match the target on secondary output
	 */
	public static List<RecipeSmelter> getSecondaryOutputMatches(ItemStack target) {
		List<RecipeSmelter> result = new ArrayList<RecipeSmelter>();
		for (RecipeSmelter recipe : SmelterManager.getRecipeList()) { //go through all the smelter recipes
			if (isOreDictMatch(recipe.getSecondaryOutput(), target)) //examine secondary output
				result.add(recipe);
		}
		
		return result;
	}
}
