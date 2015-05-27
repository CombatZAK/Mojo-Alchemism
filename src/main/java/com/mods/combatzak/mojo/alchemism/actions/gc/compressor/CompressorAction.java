package com.mods.combatzak.mojo.alchemism.actions.gc.compressor;

import java.util.List;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

public abstract class CompressorAction extends MojoAction {
	/**
	 * Set of ingredients for the recipe
	 */
	protected List<IIngredient> input;
	
	/**
	 * Product of the recipe
	 */
	protected ItemStack output;
	
	/**
	 * Gets the recipe input ingredients
	 * 
	 * @return recipe input
	 */
	public List<IIngredient> getInput() {
		return this.input;
	}
	
	/**
	 * Sets the input ingredients
	 * 
	 * @param value recipe input
	 */
	public void setInput(List<IIngredient> value) {
		this.input = value;
	}
	
	/**
	 * Self-referentially sets the input ingredients
	 * 
	 * @param value recipe input
	 * @return self-reference
	 */
	public CompressorAction withInput(List<IIngredient> value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Gets the output item
	 * 
	 * @return recipe output
	 */
	public ItemStack getOutput() {
		return this.output;
	}
	
	/**
	 * Sets the output item
	 * 
	 * @param value recipe output
	 */
	public void setOutput(ItemStack value) {
		this.output = value;
	}
	
	/**
	 * Self-referentially sets the output item
	 * 
	 * @param value recipe output
	 * @return self-reference
	 */
	public CompressorAction withOutput(ItemStack value) {
		this.setOutput(value);
		return this;
	}
	
	/**
	 * Creates a new CompressorAction instance
	 * 
	 * @param input recipe input
	 * @param output recipe output
	 */
	public CompressorAction(List<IIngredient> input, ItemStack output) {
		this.input = input;
		this.output = output;
	}
	
	/**
	 * Default constructor
	 */
	public CompressorAction() {
		this(null, null);
	}
}
