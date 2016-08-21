package com.mods.combatzak.mojo.alchemism.actions.gc.compressor;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

/**
 * Removes recipes from the ingot compressor
 * 
 * @author CombatZAK
 *
 */
public class RemoveCompressorAction extends CompressorAction {
	/**
	 * Creates a new RemoveCompressorAction instance
	 * 
	 * @param output recipe output
	 */
	public RemoveCompressorAction(ItemStack output) {
		super(null, output);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveCompressorAction() {
		this(null);
	}
	
	/**
	 * Applies the action, removing all recipes with the stored output item from the compressor
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (output == null) throw new IllegalStateException("Cannot remove recipe without output");
		
		List<IRecipe> allRecipes = CompressorRecipes.getRecipeList(); //stores all the compressor recipes
		List<IRecipe> matches = new ArrayList<IRecipe>(); //stores matches
		for (IRecipe recipe : allRecipes) { //go through each compressor recipe
			ItemStack recipeOutput = recipe.getRecipeOutput(); //get the recipe's output
			if (output.getItem() != recipeOutput.getItem()) continue; //skip the recipe if the item doesn't match
			if (output.getHasSubtypes() && output.getItemDamage() != recipeOutput.getItemDamage()) continue; //skip the recipe if the metadata doesn't match
			
			matches.add(recipe); //add the recipe if we get here; it's a match
		}
		
		for (IRecipe match : matches) { //go through all recipes that match
			allRecipes.remove(match); //remove each one
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}

}
