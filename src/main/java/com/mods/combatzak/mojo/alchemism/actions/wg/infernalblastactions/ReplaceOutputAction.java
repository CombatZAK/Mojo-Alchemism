package com.mods.combatzak.mojo.alchemism.actions.wg.infernalblastactions;

import java.util.ArrayList;
import java.util.List;

import com.mods.combatzak.mojo.alchemism.actions.wg.WgAction;

import net.minecraft.item.ItemStack;
import witchinggadgets.common.util.recipe.InfernalBlastfurnaceRecipe;

/**
 * Replaces all output with a specified one in an InfernalBlastFurnace recipe
 * 
 * @author comba
 *
 */
public class ReplaceOutputAction extends WgAction {
	/**
	 * Gets the target output; acts as ore dict filter
	 */
	private ItemStack newOutput;
	
	/**
	 * Gets the target output
	 * 
	 * @return new output stack
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Sets the target output
	 * 
	 * @param value new output stack
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially replaces target output
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
	 * @param newOutput new output stack
	 */
	public ReplaceOutputAction(ItemStack newOutput) {
		this.newOutput = newOutput;
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceOutputAction() {
		this(null);
	}
	
	/**
	 * Applies the action, replacing outputs in the Infernal Blast Furnace recipes with specified output where the ore dict matches
	 * 
	 * @throws IllegalStateException thrown when the newOutput field is null
	 */
	@Override
	public boolean apply() {
		if (newOutput == null) throw new IllegalStateException("Cannot replace with null output");
		
		List<InfernalBlastfurnaceRecipe> recipes = InfernalBlastfurnaceRecipe.recipes; //get the list of recipes
		List<InfernalBlastfurnaceRecipe> matches = getMatches(recipes, newOutput); //get the recipes that match on output
		
		for (InfernalBlastfurnaceRecipe match : matches) { //go through all the matches
			ItemStack replacementOutput = isOreDictMatch(newOutput, match.getOutput()) //does the normal output match the action output?
					? newAmount(newOutput, match.getOutput().stackSize) //resize the newOutput stack and use it as standard output
					: match.getOutput(); //otherwise use the recipe's existing output
					
			ItemStack replacementBonus = isOreDictMatch(newOutput, match.getBonus()) //does the bonus output match the action output?
					? newAmount(newOutput, match.getOutput().stackSize) //resize the newOutput stack and use it as bonus output
					: match.getBonus(); //otherwise use the recipe's existing bonus
					
			InfernalBlastfurnaceRecipe newRecipe = new InfernalBlastfurnaceRecipe(replacementOutput, match.getInput(), match.getSmeltingTime(), match.isSpecial());
			if (replacementBonus != null) newRecipe.addBonus(replacementBonus); //add the bonus if it exists
			
			InfernalBlastfurnaceRecipe.removeRecipe(match); //remove the old recipe
			InfernalBlastfurnaceRecipe.addRecipe(newRecipe); //add the new recipe
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Gets a list of Infernal Blast Furnace recipes that match the specified output on ore dict
	 * 
	 * @param master full list of Infernal Blast Furnace recipes to check
	 * @param template output to match on oredict
	 * @return recipes which have bonus or standard output that match the template
	 */
	private static List<InfernalBlastfurnaceRecipe> getMatches(List<InfernalBlastfurnaceRecipe> master, ItemStack template) {
		if (template == null || master == null || master.size() == 0) return null; //conditions under which no matches could be returned
		
		List<InfernalBlastfurnaceRecipe> result = new ArrayList<InfernalBlastfurnaceRecipe>();
		for (InfernalBlastfurnaceRecipe recipe : master) { //go through all the recipes
			if (isOreDictMatch(template, recipe.getOutput()) || isOreDictMatch(template, recipe.getBonus())) //check the recipe output and bonus output
				result.add(recipe);
		}
		
		return result;
	}
}
