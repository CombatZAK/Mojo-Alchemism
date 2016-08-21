package com.mods.combatzak.mojo.alchemism.actions.te4.smelter;

import cofh.thermalexpansion.util.crafting.SmelterManager;
import cofh.thermalexpansion.util.crafting.SmelterManager.RecipeSmelter;
import net.minecraft.item.ItemStack;

/**
 * Adds a Smelter recipe or replaces an identical existing one
 * 
 * @author CombatZAK
 *
 */
public class ReplaceSmelterAction extends SmelterAction {
	/**
	 * Creates a new ReplaceSmelterAction instance
	 * 
	 * @param energy operation energy cost
	 * @param primaryInput primary operation input
	 * @param secondaryInput secondary operation input
	 * @param primaryOutput primary operation output
	 * @param secondaryOutput secondary operation output
	 * @param secondaryOutputChance percentage chance for secondary output
	 */
	public ReplaceSmelterAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryOutputChance) {
		super(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, secondaryOutputChance);
	}
	
	/**
	 * Creates a new ReplaceSmelterAction instance
	 * 
	 * @param energy operation energy cost
	 * @param primaryInput primary operation input
	 * @param secondaryInput secondary operation input
	 * @param primaryOutput primary operation output
	 */
	public ReplaceSmelterAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput) {
		this(energy, primaryInput, secondaryInput, primaryOutput, null, 0);
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceSmelterAction() {
		this(0, null, null, null, null, 0);
	}
	
	/**
	 * Applies the action, removing (if possible) then adding a Smelter recipe
	 */
	@Override
	public boolean apply() throws IllegalStateException, RuntimeException {
		if (energy <= 0) throw new IllegalStateException("Cannot make recipe with 0 energy");
		if (primaryInput == null || secondaryInput == null) throw new IllegalStateException("Recipe requires primary and secondary input");
		if (primaryOutput == null) throw new IllegalStateException("Recipe requires secondary output");
		if (secondaryOutput != null && (secondaryOutputChance < 0 || secondaryOutputChance > 100)) throw new IllegalStateException("Secondary chance must be between 0 and 100");
		if (secondaryOutput == null) secondaryOutputChance = 0; //rationalize secondary chance
		
		RecipeSmelter existingRecipe = SmelterManager.getRecipe(primaryInput, secondaryInput); //attempt to find a matching recipe
		if (existingRecipe != null && !SmelterManager.removeRecipe(existingRecipe.getPrimaryInput(), existingRecipe.getSecondaryInput())) //if there is already a recipe in place, attempt to remove it
			throw new RuntimeException("Failed to remove smelter recipe");
		
		if (!SmelterManager.addRecipe(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, secondaryOutputChance)) //attempt to add recipe
			throw new RuntimeException("Failed to add smelter recipe");
		
		this.setIsApplied(true); //set applied flag
		return true;
	}

}
