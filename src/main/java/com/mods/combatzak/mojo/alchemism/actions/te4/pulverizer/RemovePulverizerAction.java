package com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cofh.thermalexpansion.util.crafting.PulverizerManager.RecipePulverizer;
import net.minecraft.item.ItemStack;

public class RemovePulverizerAction extends PulverizerAction {
	/**
	 * Creates a new RemovePulverizerAction instance
	 * 
	 * @param input operation input
	 * @param output operation output
	 */
	public RemovePulverizerAction(ItemStack input, ItemStack primaryOutput) {
		super(0, input, primaryOutput, null, 0);
	}
	
	/**
	 * Creates a new PulverizerAction instance
	 * 
	 * @param output operation output
	 */
	public RemovePulverizerAction(ItemStack primaryOutput) {
		this(null, primaryOutput);
	}
	
	/**
	 * Default constructor
	 */
	public RemovePulverizerAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, removing all pulverizer recipes that match the pattern
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (input == null && primaryOutput == null) throw new IllegalStateException("Cannot remove recipe without input or output to match"); //null test
		
		List<RecipePulverizer> matches = getPatternMatches(); //get the set of recipes that match the i/o pattern
		for (RecipePulverizer match : matches) {
			if (!PulverizerManager.removeRecipe(match.getInput())) //attempt to remove recipe
				throw new RuntimeException("Failed to remove pulverizer recipe");
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Gets the recipes from the pulverizer that match the object's I/O pattern
	 * 
	 * @return matching recipes
	 */
	private List<RecipePulverizer> getPatternMatches() {
		List<RecipePulverizer> result = new ArrayList<RecipePulverizer>();
		for (RecipePulverizer recipe : PulverizerManager.getRecipeList()) { //go through all the recipes
			if (input != null && !isOreDictMatch(recipe.getInput(), input)) continue; //check input pattern
			if (primaryOutput != null && !isOreDictMatch(recipe.getPrimaryOutput(), primaryOutput)) continue; //check output pattern
			
			result.add(recipe); //if we get here the recipe is a match
		}
		
		return result;
	}

}
