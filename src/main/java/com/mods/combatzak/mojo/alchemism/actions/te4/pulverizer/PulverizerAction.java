package com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer;

import com.mods.combatzak.mojo.alchemism.actions.te4.Te4Action;

import net.minecraft.item.ItemStack;

/**
 * Action related to pulverizer recipes
 * 
 * @author CombatZAK
 *
 */
public abstract class PulverizerAction extends Te4Action {
	/**
	 * Energy cost for operation
	 */
	protected int energy;
	
	/**
	 * Input ingredient (ore-dictionary compatible)
	 */
	protected ItemStack input;
	
	/**
	 * Main output
	 */
	protected ItemStack primaryOutput;
	
	/**
	 * Secondary output
	 */
	protected ItemStack secondaryOutput;
	
	/**
	 * percentage chance to produce secondary output
	 */
	protected int secondaryChance;
	
	/**
	 * Gets the energy cost
	 * 
	 * @return RF cost per operation 
	 */
	public int getEnergy() {
		return this.energy;
	}
	
	/**
	 * Sets the energy cost
	 * 
	 * @param value RF energy value
	 */
	public void setEnergy(int value) {
		this.energy = value;
	}
	
	/**
	 * Gets the input ingredient
	 * 
	 * @return input item
	 */
	public ItemStack getInput() {
		return this.input;
	}
	
	/**
	 * Sets the input ingredient
	 * 
	 * @param value input item
	 */
	public void setInput(ItemStack value) {
		this.input = value;
	}
	
	/**
	 * Gets the primary output
	 * 
	 * @return Guaranteed operation output
	 */
	public ItemStack getPrimaryOutput() {
		return this.primaryOutput;
	}
	
	/**
	 * Sets the primary output
	 * 
	 * @param value guaranteed operation output
	 */
	public void setPrimaryOutput(ItemStack value) {
		this.primaryOutput = value;
	}
	
	/**
	 * Get the secondary output
	 * 
	 * @return secondary operation output
	 */
	public ItemStack getSecondaryOutput() {
		return this.secondaryOutput;
	}
	
	/**
	 * Sets the secondary output
	 * 
	 * @param value secondary operation output
	 */
	public void setSecondaryOutput(ItemStack value) {
		this.secondaryOutput = value;
	}
	
	/**
	 * Gets the chance for secondary output
	 * 
	 * @return percentage chance for secondary output
	 */
	public int getSecondaryChance() {
		return this.secondaryChance;
	}
	
	/**
	 * Sets the chance for secondary output
	 * 
	 * @param value percentage chance for secondary output
	 */
	public void setSecondaryChance(int value) {
		this.secondaryChance = value;
	}
	
	/**
	 * Self-referentially sets the energy cost
	 * 
	 * @param value operation energy cost
	 * @return self-reference
	 */
	public PulverizerAction withEnergy(int value) {
		this.setEnergy(value);
		return this;
	}
	
	/**
	 * Self-referentially sets the operation input
	 * 
	 * @param value operation input
	 * @return self-reference
	 */
	public PulverizerAction withInput(ItemStack value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Self-referentially sets the operation output
	 * 
	 * @param value operation output
	 * @return self-reference
	 */
	public PulverizerAction withPrimaryOutput(ItemStack value) {
		this.setPrimaryOutput(value);
		return this;
	}
	
	/**
	 * Self-referentially sets the secondary output
	 * 
	 * @param value operation secondary output
	 * @return self-reference
	 */
	public PulverizerAction withSecondaryOutput(ItemStack value) {
		this.setSecondaryOutput(value);
		return this;
	}
	
	/**
	 * Self-referentially sets the chance for secondary output
	 * 
	 * @param value percentage chance for secondary output
	 * @return self-reference
	 */
	public PulverizerAction withSecondaryChance(int value) {
		this.setSecondaryChance(value);
		return this;
	}
	
	/**
	 * Creates a new PulverizerAction instance
	 * 
	 * @param energy energy cost per operation
	 * @param input operation input
	 * @param primaryOutput operation primary output
	 * @param secondaryOutput operation secondary output
	 * @param secondaryChance percentage chance for secondary output
	 */
	public PulverizerAction(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
		this.energy = energy;
		this.input = input;
		this.primaryOutput = primaryOutput;
		this.secondaryOutput = secondaryOutput;
		this.secondaryChance = secondaryChance;
	}
	
	/**
	 * Creates a new PulverizerAction instance
	 * 
	 * @param energy energy cost per operation
	 * @param input operation input
	 * @param primaryOutput operation primary output
	 */
	public PulverizerAction(int energy, ItemStack input, ItemStack primaryOutput) {
		this(energy, input, primaryOutput, null, 0);
	}
	
	/**
	 * Default constructor
	 */
	public PulverizerAction() {
		this(0, null, null, null, 0);
	}
}
