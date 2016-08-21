package com.mods.combatzak.mojo.alchemism.actions.ae2.grinder;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mods.combatzak.mojo.alchemism.actions.ae2.Ae2Action;

/**
 * Action for managing grinder recipes
 * 
 * @author CombatZAK
 *
 */
public abstract class GrinderAction extends Ae2Action {
	/**
	 * recipe input
	 */
	protected ItemStack input;
	
	/**
	 * primary, guaranteed output
	 */
	protected ItemStack primaryOutput;
	
	/**
	 * secondary, random output
	 */
	protected ItemStack secondaryOutput;
	
	/**
	 * Probability for secondary output
	 */
	protected float secondaryOutputChance;
	
	/**
	 * tertiary, random output
	 */
	protected ItemStack tertiaryOutput;
	
	/**
	 * Probability for tertiary output
	 */
	protected float tertiaryOutputChance;
	
	/**
	 * Number of turns on the crank required for output
	 */
	protected int turns;
	
	/**
	 * Gets the recipe input
	 * 
	 * @return recipe input
	 */
	public ItemStack getInput() {
		return this.input;
	}
	
	/**
	 * Sets the recipe input
	 * 
	 * @param value recipe input 
	 */
	public void setInput(ItemStack value) {
		this.input = value;
	}
	
	/**
	 * Self-referentially sets recipe input
	 * 
	 * @param value recipe input
	 * @return self-reference
	 */
	public GrinderAction withInput(ItemStack value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Gets the secondary, random output
	 * 
	 * @return secondary, random output
	 */
	public ItemStack getSecondaryOutputItem() {
		return this.secondaryOutput;
	}
	
	/**
	 * Gets the chance for secondary output
	 * 
	 * @return secondary output probability
	 */
	public float getSecondaryOutputChance() {
		return this.secondaryOutputChance;
	}
	
	/**
	 * Sets the secondary output
	 * 
	 * @param item output item
	 * @param chance probability for output
	 */
	public void setSecondaryOutput(ItemStack item, float chance) {
		this.secondaryOutput = item;
		this.secondaryOutputChance = chance;
	}
	
	/**
	 * Self-referentially sets the secondary output
	 * 
	 * @param item output item
	 * @param chance probability for output
	 * @return self-reference
	 */
	public GrinderAction withSecondaryOutput(ItemStack item, float chance) {
		this.setSecondaryOutput(item, chance);
		return this;
	}
	
	/**
	 * Gets the tertiary, random output
	 * 
	 * @return tertiary, random output
	 */
	public ItemStack getTertiaryOutputItem() {
		return this.tertiaryOutput;
	}
	
	/**
	 * Gets the chance for tertiary output
	 * 
	 * @return tertiary output probability
	 */
	public float getTertiaryOutputChance() {
		return this.tertiaryOutputChance;
	}
	
	/**
	 * Sets the tertiary output
	 * 
	 * @param item output item
	 * @param chance probability for output
	 */
	public void setTertiaryOutput(ItemStack item, float chance) {
		this.tertiaryOutput = item;
		this.tertiaryOutputChance = chance;
	}
	
	/**
	 * Self-referentially sets the tertiary output
	 * 
	 * @param item output item
	 * @param chance probability for output
	 * @return self-reference
	 */
	public GrinderAction withTertiaryOutput(ItemStack item, float chance) {
		this.setTertiaryOutput(item, chance);
		return this;
	}
	
	/**
	 * Creates a new GrinderAction instance
	 * 
	 * @param input operation input
	 * @param primaryOutput guaranteed output
	 * @param secondaryOutput secondary random output
	 * @param secondaryOutputChance probability for secondary output
	 * @param tertiaryOutput tertiary random output
	 * @param tertiaryOutputChance probability for tertiary output
	 * @param turns turns of crank for operation
	 */
	public GrinderAction(ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, float secondaryOutputChance, ItemStack tertiaryOutput, float tertiaryOutputChance, int turns) {
		this.input = input;
		this.primaryOutput = primaryOutput;
		this.secondaryOutput = secondaryOutput;
		this.secondaryOutputChance = secondaryOutputChance;
		this.tertiaryOutput = tertiaryOutput;
		this.tertiaryOutputChance = tertiaryOutputChance;
		this.turns = turns;
	}
	
	/**
	 * Default constructor
	 */
	public GrinderAction() {
		this(null, null, null, 0f, null, 0f, 0);
	}
}
