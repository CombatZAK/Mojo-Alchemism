package com.mods.combatzak.mojo.alchemism.actions.ae2.grinder;

import net.minecraft.item.ItemStack;
import appeng.api.AEApi;
import appeng.api.features.IGrinderEntry;

import com.mods.combatzak.mojo.alchemism.actions.ae2.Ae2Action;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

/**
 * Replaces output in grinder recipes
 * 
 * @author CombatZAK
 *
 */
public class ReplaceGrinderAction extends Ae2Action {
	/**
	 * Output to replace
	 */
	private IIngredient oldOutput;
	
	/**
	 * Output to replace with
	 */
	private ItemStack newOutput;
	
	/**
	 * Gets the output to be replaced
	 * 
	 * @return old output
	 */
	public IIngredient getOldOutput() {
		return this.oldOutput;
	}
	
	/**
	 * Sets the output to be replaced
	 * 
	 * @param value old output
	 */
	public void setOldOutput(IIngredient value) {
		this.oldOutput = value;
	}
	
	/**
	 * Self-referentially sets output to be replaced
	 *  
	 * @param value old output
	 * @return self-reference
	 */
	public ReplaceGrinderAction withOldOutput(IIngredient value) {
		this.setOldOutput(value);
		return this;
	}
	
	/**
	 * Gets the replacement output
	 * @return new output
	 */
	public ItemStack getNewOutput() {
		return this.newOutput;
	}
	
	/**
	 * Gets the replacement output at a stack size
	 * 
	 * @param amount size of stack
	 * @return newOutput reference if amount is equal to its stacksize, or a copy with appropriate stack size otherwise
	 */
	public ItemStack getNewOutput(int amount) {
		if (amount == this.newOutput.stackSize)
			return this.newOutput;
		
		ItemStack newStack = newOutput.copy();
		newStack.stackSize = amount;
		return newStack;
	}
	
	/**
	 * Sets the replacement output
	 * 
	 * @param value new output
	 */
	public void setNewOutput(ItemStack value) {
		this.newOutput = value;
	}
	
	/**
	 * Self-referentially sets the replacement output
	 * @param value new output
	 * @return self-reference
	 */
	public ReplaceGrinderAction withNewOutput(ItemStack value) {
		this.setNewOutput(value);
		return this;
	}
	
	/**
	 * Creates a new ReplaceGrinderAction instance
	 * 
	 * @param oldOutput old output
	 * @param newOutput new output
	 */
	public ReplaceGrinderAction(IIngredient oldOutput, ItemStack newOutput) {
		this.oldOutput = oldOutput;
		this.newOutput = newOutput;
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceGrinderAction() {
		this(null, null);
	}

	/**
	 * Applies the action, replacing all matches of old output with new output in each grinder recipe
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (oldOutput == null) throw new IllegalStateException("Cannot replace null output"); //null test oldOutput
		if (newOutput == null) throw new IllegalStateException("Cannot replace with null output"); //null test newOutput
		
		for (IGrinderEntry recipe : AEApi.instance().registries().grinder().getRecipes()) {
			if (oldOutput.matches(recipe.getOutput())) //check the primary output
				recipe.setOutput(getNewOutput(recipe.getOutput().stackSize));
			if (oldOutput.matches(recipe.getOptionalOutput())) //check secondary output
				recipe.setOptionalOutput(getNewOutput(recipe.getOptionalOutput().stackSize), recipe.getOptionalChance());
			if (oldOutput.matches(recipe.getSecondOptionalOutput()))
				recipe.setSecondOptionalOutput(getNewOutput(recipe.getSecondOptionalOutput().stackSize), recipe.getSecondOptionalChance());
		}
		
		this.setIsApplied(true); //set applied flag
		return true;
	}
}