package com.mods.combatzak.mojo.alchemism.actions.gc.compressor;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

public class AddShapelessCompressorAction extends CompressorAction {
	/**
	 * Creates a new AddShapelessCompressorAction instance
	 * @param input recipe input ingredients
	 * @param output recipe output
	 */
	public AddShapelessCompressorAction(List<IIngredient> input, ItemStack output) {
		super(input, output);
	}
	
	/**
	 * Default constructor
	 */
	public AddShapelessCompressorAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, adding the shapeless recipe to the Ingot Compressor
	 */
	@Override
	public boolean apply() throws IllegalStateException{
		if (input == null || input.size() == 0) throw new IllegalStateException("Cannot create recipe with empty input");
		if (input.size() > 9) throw new IllegalStateException("Shapeless crafting limited to 9 ingredients");
		if (output == null) throw new IllegalStateException("Cannot create recipe with empty output");
		
		List ingredients = new ArrayList(); //ingredient elemetns
		for (IIngredient ingredient : input) {
			ingredients.add(ingredient.getIngredient()); //add the ingredient to a generic array
		}
		
		CompressorRecipes.addShapelessRecipe(output, ingredients.toArray()); //add the recipe
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}

}
