package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.melting;

import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.SmelteryAction;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * Handles modifications to melting recipes
 * 
 * @author CombatZAK
 *
 */
public abstract class MeltingAction extends SmelteryAction {
	/**
	 * item to be melted
	 */
	protected ItemStack input;
	
	/**
	 * Output liquid
	 */
	protected FluidStack output;
	
	/**
	 * Melting temperature required
	 */
	protected int temperature;
	
	/**
	 * Gets the input item
	 * 
	 * @return item to be melted
	 */
	public ItemStack getInput() {
		return this.input;
	}
	
	/**
	 * Sets the input item
	 * 
	 * @param value item to be melted
	 */
	public void setInput(ItemStack value) {
		this.input = value;
	}
	
	/**
	 * Self-referentially sets the input item
	 * 
	 * @param value item to be melted
	 * @return self-reference
	 */
	public MeltingAction withInput(ItemStack value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Gets the output liquid
	 * 
	 * @return output liquid
	 */
	public FluidStack getOutput() {
		return this.output;
	}
	
	/**
	 * Sets the output liquid
	 * 
	 * @param value output liquid
	 */
	public void setOutput(FluidStack value) {
		this.output = value;
	}
	
	/**
	 * Self-referentially sets the output liquid
	 * 
	 * @param value output liquid
	 * @return self-reference
	 */
	public MeltingAction withOutput(FluidStack value) {
		this.output = value;
		return this;
	}
	
	/**
	 * Gets the melting point
	 * 
	 * @return required temperature
	 */
	public int getTemperature() {
		return this.temperature;
	}
	
	/**
	 * Sets the melting point
	 * 
	 * @param value required temperature
	 */
	public void setTemperature(int value) {
		this.temperature = value;
	}
	
	/**
	 * Self-referentially sets the melting point
	 * 
	 * @param value required temperature
	 * @return self-reference
	 */
	public MeltingAction withTemperature(int value) {
		this.setTemperature(value);
		return this;
	}
	
	/**
	 * Creates a new MeltingAction instance
	 * 
	 * @param input item to be melted
	 * @param output output liquid
	 * @param temperature required temperature
	 */
	public MeltingAction(ItemStack input, FluidStack output, int temperature) {
		this.input = input;
		this.output = output;
		this.temperature = temperature;
	}
	
	/**
	 * Default constructor
	 */
	public MeltingAction() {
		this(null, null, 0);
	}
}
