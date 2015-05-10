package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

/**
 * Removes any recipes matching the output
 * 
 * @author CombatZAK
 *
 */
public class RemoveRecipesAction extends CraftingAction {
	
	/**
	 * Gets all currently registered recipes that match a specified output
	 * 
	 * @param target recipe output to match
	 * @return list of all recipes that have the specified output
	 */
	private static List getOutputMatches(ItemStack target) {
		List result = new ArrayList(); //make a collection to store the matches
		for (Object recipeObj : getRegisteredRecipes()) {
			if (!(recipeObj instanceof IRecipe)) //if the object is not a recipe...
				continue; //skip it
			
			IRecipe recipe = (IRecipe)recipeObj; //cast the object as a recipe
			ItemStack recipeOutput = recipe.getRecipeOutput(); //get the recipe's output
			
			if (!target.getUnlocalizedName().equals(recipeOutput.getUnlocalizedName())) //if the item names do not match...
				continue; //skip the item; it's not a match
			
			if (target.getHasSubtypes() && target.getItemDamage() != recipeOutput.getItemDamage()) //if the target item has subitems and the metadata does not match...
				continue; //skip the item; it's not a match
			
			result.add(recipeObj); //if we get here, the output matches the target (count not checked); so add it to the list
		}
		
		return result;
	}
	
	/**
	 * Removes all recipes with the matching output
	 * 
	 * @throws IllegalStateException thrown when the output is not initialized
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (this.output == null)
			throw new IllegalStateException("Cannot remove recipes without specifying output");
		
		List recipes = getRegisteredRecipes(); //get all the registered recipes
		List matches = getOutputMatches(this.output); //get all recipes with matching output
		for (Object match : matches) { //go through all the matches
			recipes.remove(match); //remove the current match from the recipe registry
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}

	/**
	 * Creates a new RemoveRecipesAction instance
	 * 
	 * @param output recipe output
	 */
	public RemoveRecipesAction(ItemStack output) {
		super(output);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveRecipesAction() {
		this(null);
	}
	
	@Override
	public RemoveRecipesAction withOutput(ItemStack output) {
		this.setOutput(output);
		return this;
	}
}
