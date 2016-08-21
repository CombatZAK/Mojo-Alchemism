package com.mods.combatzak.mojo.alchemism.actions.te4.furnace;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import cofh.thermalexpansion.util.crafting.FurnaceManager;
import cofh.thermalexpansion.util.crafting.FurnaceManager.RecipeFurnace;

import com.mods.combatzak.mojo.alchemism.actions.te4.Te4Action;

public abstract class FurnaceAction extends Te4Action {
	/**
	 * Operation input
	 */
	protected ItemStack input;
	
	/**
	 * Operation output
	 */
	protected ItemStack output;
	
	/**
	 * Gets the operation input
	 * 
	 * @return operation input
	 */
	public ItemStack getInput() {
		return this.input;
	}
	
	/**
	 * Sets the operation input
	 * 
	 * @param value operation input
	 */
	public void setInput(ItemStack value) {
		this.input = value;
	}
	
	/**
	 * Self-referentially sets the operation input
	 * 
	 * @param value operation input
	 * @return self-reference
	 */
	public FurnaceAction withInput(ItemStack value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Gets the operation output
	 * 
	 * @return operation output
	 */
	public ItemStack getOutput() {
		return this.output;
	}
	
	/**
	 * Sets the operation output
	 * 
	 * @param value operation output
	 */
	public void setOutput(ItemStack value) {
		this.output = value;
	}
	
	/**
	 * Self referentially sets the operation output
	 * 
	 * @param value operation output
	 * @return self-reference
	 */
	public FurnaceAction withOutput(ItemStack value) {
		this.setOutput(value);
		return this;
	}
	
	/**
	 * Creates a new FurnaceAction instance
	 * 
	 * @param energy operation energy cost
	 * @param input operation input
	 * @param output operation output
	 */
	public FurnaceAction(int energy, ItemStack input, ItemStack output) {
		super(energy);
		this.input = input;
		this.output = output;
	}
	
	/**
	 * Default constructor
	 */
	public FurnaceAction() {
		this(0, null, null);
	}
	
	/**
	 * Gets a list of recipes that match the i/o pattern
	 * 
	 * @param inputPattern input stack to match; null to ignore
	 * @param outputPattern output stack to match; null to ignore
	 * @return list of RedstoneFurnace recipes that match the pattern
	 */
	protected static List<RecipeFurnace> getFurnaceMatches(ItemStack inputPattern, ItemStack outputPattern) {
		if (inputPattern == null && outputPattern == null) return null; //null test
		
		List<RecipeFurnace> result = new ArrayList<RecipeFurnace>();
		for (RecipeFurnace recipe : FurnaceManager.getRecipeList()) { //go through all the recipes
			if ((inputPattern == null || isOreDictMatch(recipe.getInput(), inputPattern)) &&
				(outputPattern == null || isOreDictMatch(recipe.getOutput(), outputPattern)))
				result.add(recipe); //match the recipe against the pattern
		}
		
		return result;
	}
}
