package com.mods.combatzak.mojo.alchemism.actions.te4.transposer;

import cofh.thermalexpansion.util.crafting.TransposerManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * Adds a FluidicTransposer recipe to the registry
 * 
 * @author CombatZAK
 *
 */
public class AddTransposerAction extends TransposerAction {
	/**
	 * Creates a new AddTransposerAction instance
	 * 
	 * @param energy RF energy cost
	 * @param inputItem item to fill or empty
	 * @param transposeFluid fluid to add or extract
	 * @param outputItem resulting item
	 * @param mode fluid direction
	 */
	public AddTransposerAction(int energy, ItemStack inputItem, FluidStack transposeFluid, ItemStack outputItem, TransposerMode mode) {
		super(energy, inputItem, transposeFluid, outputItem, mode);
	}
	
	/**
	 * Default constructor
	 */
	public AddTransposerAction() {
		this(0, null, null, null, TransposerMode.FILL);
	}
	
	/**
	 * Applies the action, adding a Fluidic Transposer recipe
	 */
	@Override
	public boolean apply() throws IllegalStateException, RuntimeException {
		if (energy <= 0) throw new IllegalStateException("Operation must have an energy cost"); //test energy value
		if (inputItem == null) throw new IllegalStateException("Must specify item to fill or empty");
		if (transposeFluid == null) throw new IllegalStateException("Must have a fluid to add or extract");
		if (outputItem == null && mode == TransposerMode.FILL) throw new IllegalStateException("Adding fluid to an item must produce an item");
		
		if (mode == TransposerMode.FILL && !TransposerManager.addFillRecipe(energy, inputItem, outputItem, transposeFluid, false))
			throw new RuntimeException("Failed to add transposer recipe");
		else if (mode == TransposerMode.EMPTY && !TransposerManager.addExtractionRecipe(energy, inputItem, outputItem, transposeFluid, 100, false))
			throw new RuntimeException("Failed to add transposer recipe");
		
		this.setIsApplied(true); //set applied flag
		return true;
	}

}
