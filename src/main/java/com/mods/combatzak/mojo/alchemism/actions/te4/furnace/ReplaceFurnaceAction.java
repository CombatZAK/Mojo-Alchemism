package com.mods.combatzak.mojo.alchemism.actions.te4.furnace;

import java.util.List;

import cofh.thermalexpansion.util.crafting.FurnaceManager;
import cofh.thermalexpansion.util.crafting.FurnaceManager.RecipeFurnace;
import net.minecraft.item.ItemStack;

/**
 * Replaces the output of matching Redstone Furnace recipes
 * 
 * @author CombatZAK
 *
 */
public class ReplaceFurnaceAction extends FurnaceAction {
	/**
	 * Output to replace in recipes
	 */
	private ItemStack newOutput;
	
	/**
	 * Gets the replacement operation output
	 * 
	 * @return new operation output
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Sets the replacement operation output
	 * 
	 * @param value new operation output
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially sets the replacement operation output
	 * 
	 * @param value new operation output
	 * @return self reference
	 */
	public ReplaceFurnaceAction withNewOutput(ItemStack value) {
		this.setNewOutput(value);
		return this;
	}
	
	/**
	 * Creates a new ReplaceFurnaceAction instance
	 * 
	 * @param input operation input filter
	 * @param output operation output filter
	 * @param newOutput new operation output
	 */
	public ReplaceFurnaceAction(ItemStack input, ItemStack output, ItemStack newOutput) {
		super(0, input, output);
		this.newOutput = newOutput;
	}
	
	/**
	 * Creates a new ReplaceFurnaceAction instance
	 * 
	 * @param output operation output filter
	 * @param newOutput operation input filter
	 */
	public ReplaceFurnaceAction(ItemStack output, ItemStack newOutput) {
		this(null, output, newOutput);
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceFurnaceAction() {
		this(null, null, null);
	}
	
	/**
	 * Applies the action, replacing the output of any recipe which matches the i/o filter with the new output
	 */
	@Override
	public boolean apply() {
		if (this.input == null && this.output == null) //null test
			throw new IllegalStateException("Cannot replace furnace output without specifying input our output");
		
		List<RecipeFurnace> matches = getFurnaceMatches(input, output); //get all the recipes matching the input/output filter
		
		for (RecipeFurnace match : matches) {
			if (!FurnaceManager.removeRecipe(match.getInput())) //remove the existing match
				throw new RuntimeException("Failed to remove recipe");
			
			ItemStack outputStack = match.getOutput().stackSize == newOutput.stackSize //unify stack quantity
					? newOutput
					: new ItemStack(newOutput.getItem(), match.getOutput().stackSize, newOutput.getItemDamage());
			
			if (!FurnaceManager.addRecipe(match.getEnergy(), match.getInput(), outputStack, false)) //add replacement recipe
				throw new RuntimeException("Failed to add replacement recipe");
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
}
