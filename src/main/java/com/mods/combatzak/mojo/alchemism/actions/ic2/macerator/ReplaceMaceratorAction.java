package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

@Deprecated
public class ReplaceMaceratorAction extends MaceratorAction {
	/**
	 * Output to replace
	 */
	private ItemStack newOutput;
	
	/**
	 * Gets the new recipe output
	 * 
	 * @return new recipe output stack
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Sets the new recipe output
	 * 
	 * @param value new recipe output stack
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially sets the new output
	 * 
	 * @param value new output item stack
	 * @return self-reference
	 */
	public ReplaceMaceratorAction withNewOutput(ItemStack value) {
		this.setNewOutput(value);
		return this;
	}
	
	/**
	 * Creates a new ReplaceMaceratorAction instance
	 * @param input recipe input
	 * @param oldOutput old recipe output
	 * @param newOutput new recipe output
	 */
	public ReplaceMaceratorAction(IRecipeInput input, ItemStack oldOutput, ItemStack newOutput) {
		super(input, oldOutput); //call base constructor
		this.newOutput = newOutput;
	}
	
	/**
	 * Creates a new ReplaceMaceratorAction instance
	 * @param oldOutput old recipe output
	 * @param newOutput new recipe output
	 */
	public ReplaceMaceratorAction(ItemStack oldOutput, ItemStack newOutput) {
		this(null, oldOutput, newOutput);
	}
	
	/**
	 * Creates a new ReplaceMacteratorAction instance
	 * 
	 * @param newOuput new recipe output (matches on ore-dict)
	 */
	public ReplaceMaceratorAction(ItemStack newOutput) {
		this(null, null, newOutput);
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceMaceratorAction() {
		this(null, null, null);
	}
	
	public boolean apply() {
		if (this.newOutput == null) throw new IllegalStateException("Cannot replace with null output");
		
		Map<IRecipeInput, RecipeOutput> maceratorRecipes = Recipes.macerator.getRecipes();
		List<Map.Entry<IRecipeInput, RecipeOutput>> matches = getMatches(input, getOutput(), newOutput); //get all the recipes
		for (Map.Entry<IRecipeInput, RecipeOutput> match : matches) {
			ItemStack replacementStack = newOutput.copy();
			replacementStack.stackSize = match.getValue().items.get(0).stackSize;
			
			RecipeOutput replacementOutput = new RecipeOutput(match.getValue().metadata, replacementStack);
			
			maceratorRecipes.put(match.getKey(), replacementOutput);
		}
		
		return true;
	}
	
	/**
	 * Gets the recipes that match the filter set up by the action fields
	 * 
	 * @param input recipe input
	 * @param output old recipe output
	 * @param newOutput new recipe output
	 * @return list of recipes that match input/output directly or newOutput on oreDict
	 */
	private static List<Map.Entry<IRecipeInput, RecipeOutput>> getMatches(IRecipeInput input, ItemStack output, ItemStack newOutput) {
		if (input != null && output == null) return null; //can't have any matches in this situation
		if (output != null) return getDirectMatches(input, output);
		else if (newOutput != null) return getOreDictMatches(newOutput);
		
		return null;
	}
	
	/**
	 * Gets the list of recipes that directly match specified input and output
	 * 
	 * @param input input to match; null ignores
	 * @param output output to match; null ignores
	 * @return list of matches
	 */
	private static List<Map.Entry<IRecipeInput, RecipeOutput>> getDirectMatches(IRecipeInput input, ItemStack output) {
		List<Map.Entry<IRecipeInput, RecipeOutput>> result = new ArrayList<Map.Entry<IRecipeInput, RecipeOutput>>();
		
		for (Map.Entry<IRecipeInput, RecipeOutput> entry : Recipes.macerator.getRecipes().entrySet()) { //go through all the recipes
			if (input != null && !input.matches(entry.getKey().getInputs().get(0))) continue;
			if (output != null && !isDirectMatch(output, entry.getValue().items.get(0))) continue;
			
			result.add(entry);
		}
		
		return result;
	}
	
	/**
	 * Gets the list of recipes that match the new output on ore dict
	 * 
	 * @param newOutput ore dict target
	 * @return list of matches
	 */
	private static List<Map.Entry<IRecipeInput, RecipeOutput>> getOreDictMatches(ItemStack newOutput) {
		List<Map.Entry<IRecipeInput, RecipeOutput>> result = new ArrayList<Map.Entry<IRecipeInput, RecipeOutput>>();
		for (Map.Entry<IRecipeInput, RecipeOutput> entry : Recipes.macerator.getRecipes().entrySet()) {
			ItemStack oldOutput = entry.getValue().items.get(0);
			if (isOreDictMatch(newOutput, oldOutput)) result.add(entry);
		}
		
		return result;
	}
}
