package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import net.minecraft.item.ItemStack;

import java.util.Map;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;

/**
 * Adds a recipe to the IC2 macerator
 * 
 * @author CombatZAK
 *
 */
public class AddMaceratorAction extends MaceratorAction {
	/**
	 * Creates a new AddMaceratorAction instance
	 * 
	 * @param input item to grind
	 * @param output grinding output
	 */
	public AddMaceratorAction(IRecipeInput input, ItemStack output) {
		super(input, output);
	}
	
	/**
	 * Default constructor
	 */
	public AddMaceratorAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, adding the recipe to the Macerator registry
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		//null tests
		if (input == null) throw new IllegalStateException("Cannot add recipe with null input");
		if (getOutput() == null) throw new IllegalStateException("Cannot add recipe with null ouput");
		
		Map<IRecipeInput, RecipeOutput> recipes = Recipes.macerator.getRecipes();
		IRecipeInput found = null;
		for (IRecipeInput i : recipes.keySet()) {
			if (i != null && i.matches(input.getInputs().get(0))) {
				found = i;
				break;
			}
		}
		
		if (found != null) recipes.remove(found);
			
		Recipes.macerator.addRecipe(input, otherData, outputs.toArray(new ItemStack[] { })); //add the recipe to the macerator
		
		this.setIsApplied(true); //set applied flag
		return true;
	}
}
