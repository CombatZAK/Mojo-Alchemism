package com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer;

import net.minecraft.item.ItemStack;
import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cofh.thermalexpansion.util.crafting.PulverizerManager.RecipePulverizer;

/**
 * Replaces an existing recipe with a new one (or adds a new recipe)
 * 
 * @author CombatZAK
 *
 */
public class ReplacePulverizerAction extends PulverizerAction {
	
	/**
	 * Creates a new ReplacePulverizerAction instance
	 * 
	 * @param energy energy cost
	 * @param input input ingredient
	 * @param primaryOutput primary operation output
	 * @param secondaryOutput secondary operation output
	 * @param secondaryChance percentage chance for secondary output
	 */
	public ReplacePulverizerAction(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
		super(energy, input, primaryOutput, secondaryOutput, secondaryChance);
	}
	
	/**
	 * Default constructor
	 */
	public ReplacePulverizerAction() {
		this(0, null, null, null, 0);
	}
	
	/**
	 * Applies the action, removing an existing recipe and replacing it with a new one (or adding new recipe)
	 */
	@Override
	public boolean apply() {
		//perform null tests
		if (input == null) throw new IllegalStateException("Cannot replace recipe without input");
		if (primaryOutput == null) throw new IllegalStateException("Cannot replace recipe without output");
		if (energy <= 0) throw new IllegalStateException("Cannot replace recipe without energy cost");
		if (secondaryOutput != null && secondaryChance <= 0)
			throw new IllegalStateException("Secondary output must have percentage change > 0");
		
		RecipePulverizer existingRecipe = PulverizerManager.getRecipe(input); //attempt to retrieve an existing recipe
		if (existingRecipe != null && ! PulverizerManager.removeRecipe(existingRecipe.getInput()))
				throw new RuntimeException("Failed to remove existing recipe"); //remove the recipe if it is found
		
		if (secondaryOutput == null && !PulverizerManager.addRecipe(energy, input, primaryOutput))
			throw new RuntimeException("Failed to add replacement recipe");
		else if (secondaryOutput != null && !PulverizerManager.addRecipe(energy, input, primaryOutput, secondaryOutput, secondaryChance))
			throw new RuntimeException("Failed to add replacement recipe");
		
		this.setIsApplied(true); //set applied flag
		return true;
	}
}
