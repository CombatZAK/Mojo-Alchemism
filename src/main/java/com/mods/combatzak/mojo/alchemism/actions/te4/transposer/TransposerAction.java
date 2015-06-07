package com.mods.combatzak.mojo.alchemism.actions.te4.transposer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.mods.combatzak.mojo.alchemism.actions.te4.Te4Action;

/**
 * Action that manages recipes for the Fluidic Transposer
 * 
 * @author CombatZAK
 *
 */
public abstract class TransposerAction extends Te4Action {
	/**
	 * Mode of recipe
	 * 
	 * @author CombatZAK
	 *
	 */
	public enum TransposerMode {
		/**
		 * Recipe adds fluid to item
		 */
		FILL,
		
		/**
		 * Recipe removes fluid from item
		 */
		EMPTY
	}
	
	/**
	 * Item to fill or extract
	 */
	protected ItemStack inputItem;
	
	/**
	 * Liquid to add or remove from item
	 */
	protected FluidStack transposeFluid;
	
	/**
	 * Item result from fill or extraction
	 */
	protected ItemStack outputItem;
	
	/**
	 * Mode of recipe
	 */
	protected TransposerMode mode;
	
	/**
	 * Gets the item to fill or extract
	 * 
	 * @return target item
	 */
	public ItemStack getInputItem() {
		return this.inputItem;
	}
	
	/**
	 * Sets the item to fill or extract
	 * 
	 * @param value target item
	 */
	public void setInputItem(ItemStack value) {
		this.inputItem = value;
	}
	
	/**
	 * Self-referentially sets item to fill or extract
	 * 
	 * @param value target item
	 * @return self-reference
	 */
	public TransposerAction withInputItem(ItemStack value) {
		this.setInputItem(value);
		return this;
	}
	
	/**
	 * Gets the fluid to add or remove
	 * 
	 * @return i/o liquid
	 */
	public FluidStack getTransposeFluid() {
		return this.transposeFluid;
	}
	
	/**
	 * Gets the fluid to add or remove
	 * 
	 * @param value i/o fluid
	 */
	public void setTransposeFluid(FluidStack value) {
		this.transposeFluid = value;
	}
	
	/**
	 * Self-referentially sets the fluid to add or remove
	 * 
	 * @param value i/o fluid
	 * @return self-reference
	 */
	public TransposerAction withTransposeFluid(FluidStack value) {
		this.setTransposeFluid(value);
		return this;
	}
	
	/**
	 * Gets the resulting item output
	 * 
	 * @return filled or emptied item
	 */
	public ItemStack getOutputItem() {
		return this.outputItem;
	}
	
	/**
	 * Sets the resulting item output
	 * 
	 * @param value filled or emptied item
	 */
	public void setOutputItem(ItemStack value) {
		this.outputItem = value;
	}
	
	/**
	 * Self-referentially sets the resulting item output
	 * 
	 * @param value filled or emptied item
	 * @return self-reference
	 */
	public TransposerAction withOutputItem(ItemStack value) {
		this.setOutputItem(value);
		return this;
	}
	
	/**
	 * Gets the mode of the recipe
	 * 
	 * @return fluid direction
	 */
	public TransposerMode getMode() {
		return this.mode;
	}
	
	/**
	 * Sets the mode of the recipe
	 * 
	 * @param value fluid direction
	 */
	public void setMode(TransposerMode value) {
		this.mode = value;
	}
	
	/**
	 * Self-referentially sets the mode of the recipe
	 * 
	 * @param value fluid direction
	 * @return self-reference
	 */
	public TransposerAction withTransposerMode(TransposerMode value) {
		this.setMode(value);
		return this;
	}
}
