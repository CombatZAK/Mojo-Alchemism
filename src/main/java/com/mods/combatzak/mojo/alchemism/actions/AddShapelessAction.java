package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Adds a shapeless crafting recipe
 * 
 * @author CombatZAK
 *
 */
public class AddShapelessAction extends CraftingAction {
	/**
	 * Sets the recipe input ingredients
	 * @param value input ingredients
	 * @throws IllegalArgumentException thrown when there are more than 9 ingredients in the list
	 */
	@Override
	public void setInputs(List<IIngredient> value) throws IllegalArgumentException {
		if (inputs != null && inputs.size() > 9) //test recipe size
			throw new IllegalArgumentException("Shapeless recipe cannot have more than 9 ingredients"); //throw exception if illegal
		else
			super.setInputs(value);
	}
	
	/**
	 * Applies the action, adding the ingredient to the game registry
	 * 
	 * @throws IllegalStateException thrown when either the input list is null or empty or when the output is null
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (inputs == null || inputs.size() == 0) //examine the inputs and output of the recipe
			throw new IllegalStateException("Cannot add a recipe without ingredients");
		else if (output == null)
			throw new IllegalStateException("Cannot add a recipe without output");
		
		ArrayList ingredientObjects = new ArrayList(); //make an object list to store the raw inputs
		for (IIngredient input : this.inputs) { //go through all the inputs
			if (input == null || input.getIngredient() == null) //check that the current input isn't null or it's ingredient isn't null
				continue; //skip it if so
			ingredientObjects.add(input.getIngredient()); //add each input to the list otherwise
		}
		
		if (this.hasOreIngredient()) { //if the recipe uses the ore dictionary...
			GameRegistry.addRecipe(new ShapelessOreRecipe(this.getOutput(), ingredientObjects.toArray())); //add a shapeless ore recipe
		}
		else { //otherwise...
			GameRegistry.addShapelessRecipe(this.getOutput(), ingredientObjects.toArray()); //add the recipe to the game
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
}
