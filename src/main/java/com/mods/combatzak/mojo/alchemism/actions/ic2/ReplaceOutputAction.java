package com.mods.combatzak.mojo.alchemism.actions.ic2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import net.minecraft.item.ItemStack;

/**
 * Replaces every instance of an item in an IC2 machines output with another
 * 
 * @author zhess
 *
 */
public class ReplaceOutputAction extends Ic2Action {
	/**
	 * Stores the recipe list to modify
	 */
	private IMachineRecipeManager recipeList;
	
	/**
	 * Gets the recipe list to modify
	 * 
	 * @return type of recipes to edit
	 */
	public IMachineRecipeManager getRecipeList() {
		return this.recipeList;
	}
	
	/**
	 * Sets the recipe list to modify
	 * 
	 * @param value target recipe list
	 */
	public void setRecipeList(IMachineRecipeManager value) {
		this.recipeList = value;
	}
	
	/**
	 * Self-referentially sets the recipe list to modify
	 * 
	 * @param value target recipe list
	 * @return self-reference
	 */
	public ReplaceOutputAction withRecipeList(IMachineRecipeManager value) {
		setRecipeList(value);
		return this;
	}
	
	/**
	 * Stores the stack to replace (matches on ore dictionary)
	 */
	private ItemStack newOutput;
	
	/**
	 * Gets the output to replace
	 * 
	 * @return new output stack
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Sets the output to replace
	 * 
	 * @param value new output stack
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially sets the output to replace
	 * 
	 * @param value new output stack
	 * @return self-reference
	 */
	public ReplaceOutputAction withNewOutput(ItemStack value) {
		setNewOutput(value);
		return this;
	}
	
	/**
	 * Creates a new ReplaceOutputAction instance
	 * 
	 * @param recipeList type of machine recipes to replace
	 * @param newOutput new output stack
	 */
	public ReplaceOutputAction(IMachineRecipeManager recipeList, ItemStack newOutput) {
		super();
		this.recipeList = recipeList;
		this.newOutput = newOutput;
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceOutputAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, replacing all items in any recipe of the machine which have an OreDict match to the newOutput
	 * 
	 * @throws IllegalStateException thrown when recipeList or newOutput is null
	 */
	@Override
	public boolean apply() {
		if (this.recipeList == null) throw new IllegalStateException("Cannot scan null recipe list");
		if (this.newOutput == null) throw new IllegalStateException("Cannot replace with null output");
		
		Map<IRecipeInput, RecipeOutput> recipeMap = recipeList.getRecipes(); //get the list of recipes where modification will take place
		List<Map.Entry<IRecipeInput, RecipeOutput>> matches = getMatches(recipeMap, newOutput); //get the matches to the output stack on ore dictionary
		
		for (Map.Entry<IRecipeInput, RecipeOutput> match : matches) { //go through all the matches
			List<ItemStack> newOutputItems = new ArrayList<ItemStack>(); //make a list of output items to replace the current one
			for (ItemStack oldItem : match.getValue().items) { //go through all the output items
				if (isOreDictMatch(newOutput, oldItem)) { //replace any ore dict matches
					ItemStack newOutputStack = newAmount(newOutput, oldItem.stackSize);
					newOutputItems.add(newOutputStack);
				}
				else newOutputItems.add(oldItem); //add any unchecked items as-is
			}
			
			RecipeOutput newOutput = new RecipeOutput(match.getValue().metadata, newOutputItems); //create a new output object
			recipeMap.put(match.getKey(), newOutput); //replace the recipe
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}

	/**
	 * Gets a list of machine recipes that have any output ingredient which matches the search argument on ore dict
	 * 
	 * @param source list of machine recipes ot scan
	 * @param search item to scan for ore dict matches
	 * @return list of entries which contain an ore dict match to the search parameter
	 */
	private static List<Map.Entry<IRecipeInput, RecipeOutput>> getMatches(Map<IRecipeInput, RecipeOutput> source, ItemStack search) {
		if (source == null || search == null) return null;
		
		List<Map.Entry<IRecipeInput, RecipeOutput>> result = new ArrayList<Map.Entry<IRecipeInput, RecipeOutput>>();
		for (Map.Entry<IRecipeInput, RecipeOutput> entry : source.entrySet()) {
			for (ItemStack item : entry.getValue().items) {
				if (isOreDictMatch(search, item)) {
					result.add(entry);
					break;
				}				
			}
		}
		
		return result;
	}
}
