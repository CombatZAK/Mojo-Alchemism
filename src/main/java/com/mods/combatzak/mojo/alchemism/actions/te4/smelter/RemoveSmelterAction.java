package com.mods.combatzak.mojo.alchemism.actions.te4.smelter;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.util.crafting.SmelterManager;
import cofh.thermalexpansion.util.crafting.SmelterManager.RecipeSmelter;
import net.minecraft.item.ItemStack;

/**
 * Removes a recipe from the Induction Smelter matching a pattern
 * 
 * @author CombatZAK
 *
 */
public class RemoveSmelterAction extends SmelterAction {
	/**
	 * Creates a new RemoveSmelterAction instance
	 * 
	 * @param primaryInput primary input filter
	 * @param secondaryInput secondary input filter
	 * @param primaryOutput primary output filter
	 * @param secondaryOutput secondary output filter
	 */
	public RemoveSmelterAction(ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput) {
		super(0, primaryInput, secondaryInput, primaryOutput, secondaryOutput, 0);
	}
	
	/**
	 * Creates a new RemoveSmelterAction instance
	 * 
	 * @param primaryInput primaryInput filter
	 * @param secondaryInput secondaryInput filter
	 */
	public RemoveSmelterAction(ItemStack primaryInput, ItemStack secondaryInput) {
		this(primaryInput, secondaryInput, null, null);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveSmelterAction() {
		this(null, null, null, null);
	}
	
	/**
	 * Applies the action, removing all recipes that match the filter
	 */
	@Override
	public boolean apply() throws IllegalStateException, RuntimeException {
		if (secondaryOutput != null && primaryOutput == null) throw new IllegalStateException("Cannot filter with secondary input and no primary input"); //null test output
		if (primaryInput == null ^ secondaryInput == null) throw new IllegalStateException("Input filter requires both primary and secondary input"); //null test input
		if (primaryInput == null && secondaryInput == null && primaryOutput == null && secondaryOutput == null) throw new IllegalStateException("Action must have a filter"); //general null test
		
		for (RecipeSmelter match : getFilterMatches()) { //go through all recipes that match the pattern
			if (!SmelterManager.removeRecipe(match.getPrimaryInput(), match.getSecondaryInput())) //remove the recipe
				throw new RuntimeException("Failed to remove smelter recipe");
		}
		
		this.setIsApplied(true);
		return true;
	}
	
	/**
	 * Gets a set of smelter recipes that match the i/o pattern
	 * 
	 * @return list of matching smelter recipes
	 */
	private List<RecipeSmelter> getFilterMatches() {
		List<RecipeSmelter> result = new ArrayList<RecipeSmelter>();
		for (RecipeSmelter recipe : SmelterManager.getRecipeList()) { //go through all the recipes
			if (isInputMatch(recipe) && isOutputMatch(recipe))
				result.add(recipe);
		}
		
		return result;
	}
	
	/**
	 * Determines if a Smelter recipe matches the input pattern
	 * 
	 * @param recipe recipe to check
	 * @return true if the recipe matches the pattern or there is no pattern to match; false otherwise
	 */
	private boolean isInputMatch(RecipeSmelter recipe) {
		if (recipe == null) return false; //null test
		if (primaryInput == null && secondaryInput == null) return true; //pattern is ignored
		
		if (isOreDictMatch(recipe.getPrimaryInput(), primaryInput) && isOreDictMatch(recipe.getSecondaryInput(), secondaryInput)) //forward match
			return true;
		else if (isOreDictMatch(recipe.getSecondaryInput(), primaryInput) && isOreDictMatch(recipe.getPrimaryInput(), secondaryInput)) //reverse match
			return true;
		else return false; //no match
	}
	
	/**
	 * Determines if a smelter recipe matches the input pattern
	 * 
	 * @param recipe recipe to check
	 * @return true if the recipe matches the pattern or there is no pattern to match; false otherwise
	 */
	private boolean isOutputMatch(RecipeSmelter recipe) {
		if (recipe == null) return false; //null test
		if (primaryOutput == null && secondaryOutput == null) return true; //pattern is ignored
		
		return isOreDictMatch(recipe.getPrimaryOutput(), primaryOutput) && (secondaryOutput == null || isOreDictMatch(recipe.getSecondaryOutput(), secondaryOutput)); //only forward match allowed
	}
}
