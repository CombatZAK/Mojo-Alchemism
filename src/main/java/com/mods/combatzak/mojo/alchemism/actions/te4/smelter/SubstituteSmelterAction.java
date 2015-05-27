package com.mods.combatzak.mojo.alchemism.actions.te4.smelter;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.util.crafting.SmelterManager;
import cofh.thermalexpansion.util.crafting.SmelterManager.RecipeSmelter;
import net.minecraft.item.ItemStack;

/**
 * Replaces all output of a specific ore-dict type with a different item in the Induction Smelter
 * 
 * @author CombatZAK
 *
 */
public class SubstituteSmelterAction extends SmelterAction {
	/**
	 * Stores the new operation output
	 */
	private ItemStack newOutput;
	
	/**
	 * Gets the new operation output
	 * 
	 * @return replacement output
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Sets the new operation output
	 * 
	 * @param value replacement output
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially sets the induction smelter output
	 * 
	 * @param value replacement output
	 * @return self-reference
	 */
	public SubstituteSmelterAction withNewOutput(ItemStack value) {
		this.setNewOutput(value);
		return this;
	}
	
	/**
	 * Creates a new SubstituteSmelterAction instance
	 * 
	 * @param primaryInput Operation primary input
	 * @param secondaryInput Operation secondary output
	 * @param primaryOutput Operation output to replace
	 * @param newOutput replacement output
	 */
	public SubstituteSmelterAction(ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack newOutput) {
		super(0, primaryInput, secondaryInput, primaryOutput, null, 0);
		this.newOutput = newOutput;
	}
	
	/**
	 * Creates a new SubstituteSmelterAction instance
	 * 
	 * @param primaryOutput Output to replace
	 * @param newOutput replacement output
	 */
	public SubstituteSmelterAction(ItemStack primaryOutput, ItemStack newOutput) {
		this(null, null, primaryOutput, newOutput);
	}
	
	/**
	 * Applies the action, replacing all output with the new output where the pattern matches
	 */
	@Override
	public boolean apply() throws IllegalStateException, RuntimeException {
		//null test
		if (primaryOutput == null) throw new IllegalStateException("Primary output is required"); //only primary output is required
		if (primaryInput == null ^ secondaryInput == null) throw new IllegalStateException("Input filter requires both primary and secondary inputs, if used"); //XOR null test
		
		
		if (primaryInput != null) //implies neither input is null
			doTargetedApply(); //target a single recipe
		else
			doSearchApply(); //scan all recipes
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Replaces the output for a single recipe based on input and output
	 * 
	 * @throws RuntimeException thrown when a removal or addition fails against the SmelterManager
	 */
	private void doTargetedApply() throws RuntimeException {
		RecipeSmelter target = SmelterManager.getRecipe(this.primaryInput, this.secondaryInput);
		if (target == null) return; //skip this if we can't find a matching recipe
		
		ItemStack primaryStack = null;
		if (isOreDictMatch(target.getPrimaryOutput(), primaryOutput)) { //check the primary output
			ItemStack oldOutput = target.getPrimaryOutput();
			primaryStack = oldOutput.stackSize == newOutput.stackSize //get a stack to replace the output
					? newOutput
					: new ItemStack(newOutput.getItem(), oldOutput.stackSize, newOutput.getItemDamage());
		}
		else primaryStack = target.getPrimaryOutput();
		
		ItemStack secondaryStack = null;
		if (isOreDictMatch(target.getSecondaryOutput(), primaryOutput)) { //check the secondary output
			ItemStack oldOutput = target.getSecondaryOutput();
			secondaryStack = oldOutput.stackSize == newOutput.stackSize //get a stack to replace the output
					? newOutput
					: new ItemStack(newOutput.getItem(), oldOutput.stackSize, newOutput.getItemDamage());
		}
		else secondaryStack = target.getSecondaryOutput();
		
		if (!SmelterManager.removeRecipe(target.getPrimaryOutput(), target.getSecondaryOutput()))
			throw new RuntimeException("Failed to remove smelter recipe");
		
		if (secondaryStack == null && !SmelterManager.addRecipe(target.getEnergy(), target.getPrimaryInput(), target.getSecondaryInput(), primaryStack))
			throw new RuntimeException("Failed to add smelter recipe");
		else if (secondaryStack != null && !SmelterManager.addRecipe(target.getEnergy(), target.getPrimaryInput(), target.getSecondaryInput(), primaryStack, secondaryStack, target.getSecondaryOutputChance()))
			throw new RuntimeException("Failed to add smelter recipe");
	}
	
	/**
	 * Replaces any matching output in registered Smelter recipes
	 * 
	 * @throws RuntimeException thrown when a removal or addition fails against the SmelterManager
	 */
	private void doSearchApply() throws RuntimeException {
		for (RecipeSmelter match : getPrimaryOutputMatches(primaryOutput)) { //go through all the recipes that match on primary output
			if (!SmelterManager.removeRecipe(match.getPrimaryInput(), match.getSecondaryInput())) //remove the existing recipe
				throw new RuntimeException("Failed to remove smelter recipe");
			
			ItemStack oldOutput = match.getPrimaryOutput();
			ItemStack outputStack = oldOutput.stackSize == newOutput.stackSize
					? newOutput
					: new ItemStack(newOutput.getItem(), oldOutput.stackSize, newOutput.getItemDamage());
			
			if (!SmelterManager.addRecipe(match.getEnergy(), match.getPrimaryInput(), match.getSecondaryInput(), outputStack, match.getSecondaryOutput(), match.getSecondaryOutputChance())) //add replacement recipe
				throw new RuntimeException("Failed to add smelter recipe");
		}
		
		for (RecipeSmelter match : getSecondaryOutputMatches(primaryOutput)) { //go through all the recipes that match on secondary output
			if (!SmelterManager.removeRecipe(match.getPrimaryInput(),  match.getSecondaryInput())) //remove the existing recipe
				throw new RuntimeException("Failed to remove smelter recipe");
			
			ItemStack oldOutput = match.getSecondaryOutput();
			ItemStack outputStack = oldOutput.stackSize == newOutput.stackSize
					? newOutput
					: new ItemStack(newOutput.getItem(), oldOutput.stackSize, newOutput.getItemDamage());
			
			if (!SmelterManager.addRecipe(match.getEnergy(), match.getPrimaryInput(), match.getSecondaryInput(), match.getPrimaryOutput(), outputStack, match.getSecondaryOutputChance())) //add replacement recipe
				throw new RuntimeException("Failed to add smelter recipe");
		}
	}
}
