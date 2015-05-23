package com.mods.combatzak.mojo.alchemism.actions.furnace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

public class RemoveFurnaceAction extends FurnaceAction {
	/**
	 * Creates a new RemoveFurnaceAction instance
	 * 
	 * @param input furnace input
	 * @param output furnace output
	 */
	public RemoveFurnaceAction(IIngredient input, ItemStack output) {
		super(input, output);
	}
	
	/**
	 * Creates a new RemoveFurnaceAction output
	 * 
	 * @param output furnace output
	 */
	public RemoveFurnaceAction(ItemStack output) {
		this(null, output);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveFurnaceAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, remove any recipe that matches input and output filter
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (this.input == null && this.output == null) throw new IllegalStateException("Cannot remove recipes without a filter");
		
		Map recipeMap = FurnaceRecipes.smelting().getSmeltingList(); //get the furnace recipe map
		Set<Map.Entry> recipeCollection = recipeMap.entrySet(); //get collection of Key-Values from the recipe map
		List<FurnaceRecipe> matches = new ArrayList<FurnaceRecipe>(); //stores matches to the input and output

		for (Map.Entry furnaceEntry : recipeCollection) {
			FurnaceRecipe curRecipe = new FurnaceRecipe((ItemStack)furnaceEntry.getKey(), (ItemStack)furnaceEntry.getValue()); //create a recipe kvp for the current entry
			if (curRecipe.isMatch(input, output))
				matches.add(curRecipe); //add the recipe to the running list if it's a match
		}
		
		for (FurnaceRecipe match : matches) {
			recipeMap.remove(match.input); //degregister each matching recipe
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
}
