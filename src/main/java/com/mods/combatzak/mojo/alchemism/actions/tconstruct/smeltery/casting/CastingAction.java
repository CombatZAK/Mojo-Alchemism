package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.SmelteryAction;

public abstract class CastingAction extends SmelteryAction {
	/**
	 * Input item to cast over, if any
	 */
	private ItemStack cast;
	
	/**
	 * Fluid and amount to pour
	 */
	private FluidStack pour;
	
	/**
	 * Output of casting recipe
	 */
	private ItemStack output;
	
	/**
	 * Indicates that the item being casted over should be removed as part of the cast
	 */
	private boolean consumeCast;
	
	/**
	 * Amount of time to wait for cast to cool
	 */
	private int cooldown;
	
	/**
	 * Gets the input cast
	 * 
	 * @return item to cast fluid over
	 */
	public ItemStack getCast() {
		return this.cast;
	}
	
	/**
	 * Sets the input cast
	 * 
	 * @param value item to cast fluid over
	 */
	public void setCast(ItemStack value) {
		this.cast = value;
	}
	
	/**
	 * Self-referentially sets the input cast
	 * 
	 * @param value item to cast fluid over
	 * @return self-reference
	 */
	public CastingAction withCast(ItemStack value) {
		this.setCast(value);
		return this;
	}
	
	/**
	 * Gets the fluid to pour
	 * 
	 * @return fluid input
	 */
	public FluidStack getPour() {
		return this.pour;
	}
	
	/**
	 * Sets the fluid to pour
	 * 
	 * @param value fluid input
	 */
	public void setPour(FluidStack value) {
		this.pour = value;
	}
	
	/**
	 * Self-referentially sets the fluid to pour
	 * 
	 * @param value fluid input
	 * @return self-reference
	 */
	public CastingAction withPour(FluidStack value) {
		this.setPour(value);
		return this;
	}
	
	/**
	 * Gets the output of the cast recipe
	 * 
	 * @return recipe output
	 */
	public ItemStack getOutput() {
		return this.output;
	}
	
	/**
	 * Sets the output of the cast recipe
	 * 
	 * @param value recipe output
	 */
	public void setOutput(ItemStack value) {
		this.output = value;
	}
	
	/**
	 * Self-referentially sets the output of the cast recipe
	 * 
	 * @param value recipe output
	 * @return self-reference
	 */
	public CastingAction withOutput(ItemStack value) {
		this.setOutput(value);
		return this;
	}
	
	/**
	 * Get flag for destroying the cast item
	 * 
	 * @return indicator for destroying cast item in recipe
	 */
	public boolean getConsumeCast() {
		return this.consumeCast;
	}
	
	/**
	 * Sets the flag for destroying cast item
	 * 
	 * @param value indicator for destroying cast item in recipe 
	 */
	public void setConsumeCast(boolean value) {
		this.consumeCast = value;
	}
	
	/**
	 * Self-referentially sets the flag for destroying cast item
	 * 
	 * @param value indicator for destroying cast item in recipe
	 * @return self-reference
	 */
	public CastingAction withConsumeCast(boolean value) {
		this.setConsumeCast(value);
		return this;
	}
	
	/**
	 * Gets the time to wait before item cools
	 * 
	 * @return cooldown time
	 */
	public int getCooldown() {
		return this.cooldown;
	}
	
	/**
	 * Sets the time to wait before item cools
	 * 
	 * @param value cooldown time
	 */
	public void setCooldown(int value) {
		this.cooldown = value;
	}
	
	/**
	 * Self-referentially sets the time to wait before item cools
	 * 
	 * @param value cooldown time
	 * @return self-reference
	 */
	public CastingAction withCooldown(int value) {
		this.setCooldown(value);
		return this;
	}
	
	/**
	 * Creates a new CastingAction instance
	 * 
	 * @param cast item to pour fluid over
	 * @param pour fluid to pour
	 * @param output output item for recipe
	 * @param consumeCast whether or not to destroy the cast item
	 * @param cooldown time to wait before item cools
	 */
	public CastingAction(ItemStack cast, FluidStack pour, ItemStack output, boolean consumeCast, int cooldown) {
		this.cast = cast;
		this.pour = pour;
		this.output = output;
		this.consumeCast = consumeCast;
		this.cooldown = cooldown;
	}
	
	/**
	 * Creates a new CastingAction instance
	 * 
	 * @param cast item to pour fluid over
	 * @param pour fluid to pour
	 * @param output output item for recipe
	 */
	public CastingAction(ItemStack cast, FluidStack pour, ItemStack output) {
		this(cast, pour, output, false, 3);
	}
	
	/**
	 * Creates a new CastingAction instance
	 * 
	 * @param pour fluid to pour
	 * @param output output item for recipe
	 * @param cooldown time to wait before item cools
	 */
	public CastingAction(FluidStack pour, ItemStack output, int cooldown) {
		this(null, pour, output, false, cooldown);
	}
	
	/**
	 * Creates a new CastingAction instance
	 * 
	 * @param pour fluid to pour
	 * @param output output item for recipe
	 */
	public CastingAction(FluidStack pour, ItemStack output) {
		this(null, pour, output, false, 3);
	}
	
	/**
	 * Default constructor
	 */
	public CastingAction() {
		this(null, null, null, false, 0);
	}
}
