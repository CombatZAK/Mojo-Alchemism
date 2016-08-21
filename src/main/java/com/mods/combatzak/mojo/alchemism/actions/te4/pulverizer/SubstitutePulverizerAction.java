package com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer;

import java.util.ArrayList;
import java.util.List;

import com.mods.combatzak.mojo.alchemism.actions.te4.Te4Action;

import cofh.lib.inventory.ComparableItemStack;
import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cofh.thermalexpansion.util.crafting.PulverizerManager.RecipePulverizer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SubstitutePulverizerAction extends PulverizerAction {
	private ItemStack newOutput;
	
	/**
	 * Gets the new pulverizer output
	 * 
	 * @return replacement output
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Sets the new pulverizer output
	 * 
	 * @param value replacement output
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially sets the new pulverizer output
	 * 
	 * @param value replacement output
	 * @return self-reference
	 */
	public SubstitutePulverizerAction withNewOutput(ItemStack value) {
		this.setNewOutput(value);
		return this;
	}
	
	/**
	 * Creates a new SubstitutePulverizerAction instance
	 * 
	 * @param output output filter, also used to examine secondary outputs
	 * @param newOutput replacement output
	 */
	public SubstitutePulverizerAction(ItemStack output, ItemStack newOutput) {
		super(0, null, output, null, 0);
		this.newOutput = newOutput;
	}
	
	/**
	 * Default constructor
	 */
	public SubstitutePulverizerAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, substituting the existing output item with the new one in all primary and secondary recipe outputs
	 * 
	 * @throws IllegalStateException thrown when the primaryOutput or newOutput fields are null
	 * @throws RuntimeException thrown when the removal or addition of a pulverizer recipe fails
	 */
	@Override
	public boolean apply() throws IllegalStateException, RuntimeException {
		//perform a null test
		if (this.primaryOutput == null) throw new IllegalStateException("Cannot replace empty output");
		if (this.newOutput == null) throw new IllegalStateException("Cannot replace with empty output");
		
		List<RecipePulverizer> matches = getPrimaryMatches(this.primaryOutput); //retrieves the recipes that match on the primary output
		for (RecipePulverizer match : matches) { //go through all the matches
			if (!PulverizerManager.removeRecipe(match.getInput())) //attempt to remove the recipe
				throw new RuntimeException("Removal of recipe failed");
			
			ItemStack outputStack = (this.newOutput.stackSize == match.getPrimaryOutput().stackSize) 
					? this.newOutput
					: new ItemStack(this.newOutput.getItem(), match.getPrimaryOutput().stackSize, this.newOutput.getItemDamage());
			
			if (!PulverizerManager.addRecipe(match.getEnergy(), match.getInput(), outputStack, match.getSecondaryOutput(), match.getSecondaryOutputChance())) //attempt to add replacement recipe
				throw new RuntimeException("Addition of replacement recipe failed");
		}
		
		matches = getSecondaryMatches(this.primaryOutput); //get the recipes that match on secondary output
		for (RecipePulverizer match : matches) { //go through all the matches
			if (!PulverizerManager.removeRecipe(match.getInput())) //attempt to remove recipe
				throw new RuntimeException("Removal of secondary recipe failed");
			
			ItemStack outputStack = (this.newOutput.stackSize == match.getSecondaryOutput().stackSize)
					? this.newOutput
					: new ItemStack(this.newOutput.getItem(), match.getSecondaryOutput().stackSize, this.newOutput.getItemDamage());
			
			if (!PulverizerManager.addRecipe(match.getEnergy(), match.getInput(), match.getPrimaryOutput(), outputStack, match.getSecondaryOutputChance())) //attempt to add replacement recipe
				throw new RuntimeException("Addition of replacement secondary recipe failed");
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Gets the set of Pulverizer recipes with primary output that match a target
	 * 
	 * @param target output to match
	 * @return list of recipes with primary output matching the target
	 */
	private static List<RecipePulverizer> getPrimaryMatches(ItemStack target) {
		List<RecipePulverizer> result = new ArrayList<RecipePulverizer>();
		for (RecipePulverizer recipe : PulverizerManager.getRecipeList()) { //go through all the pulverizer recipes
			if (isOreDictMatch(recipe.getPrimaryOutput(), target))  //if the recipe matches any of the target dictionary entries...
				result.add(recipe); //add to the result set
		}
		
		return result;
	}
	
	/**
	 * Gets the set of Pulverizer recipes with secondary output that match a target
	 * 
	 * @param target output to match
	 * @return list of recipes with secondary output matching the target
	 */
	private static List<RecipePulverizer> getSecondaryMatches(ItemStack target) {
		List<RecipePulverizer> result = new ArrayList<RecipePulverizer>();
		for (RecipePulverizer recipe : PulverizerManager.getRecipeList()) { //go through all the pulverizer recipes
			if (isOreDictMatch(recipe.getSecondaryOutput(), target))  //if the recipe matches any of the target dictionary entries...
				result.add(recipe); //add to the result set
		}
		
		return result;
	}
}
