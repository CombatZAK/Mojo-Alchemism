package com.mods.combatzak.mojo.alchemism.actions.ic2;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ic2.api.recipe.IRecipeInput;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Action that manages an IC2 machine recipe
 * 
 * @author CombatZAK
 *
 */
public abstract class Ic2Action extends MojoAction {
	/**
	 * Recipe input, either an ItemStack or OreDict entry
	 */
	protected IRecipeInput input;
	
	/**
	 * Recipe output, one or more item stacks
	 */
	protected List<ItemStack> outputs;
	
	/**
	 * Additional recipe data
	 */
	protected NBTTagCompound otherData;
	
	/**
	 * Gets the item/ore recipe input
	 * 
	 * @return recipe input
	 */
	public IRecipeInput getInput() {
		return this.input;
	}
	
	/**
	 * Sets the item/ore recipe input
	 * 
	 * @param value recipe input
	 */
	public void setInput(IRecipeInput value) {
		this.input = value;
	}
	
	/**
	 * Self-referentially sets the item/ore input
	 * 
	 * @param value recipe input
	 * @return self-reference
	 */
	public Ic2Action withInput(IRecipeInput value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Gets the recipe output
	 * 
	 * @return recipe outputs 
	 */
	public List<ItemStack> getOutputs() {
		return this.outputs;
	}
	
	/**
	 * Sets the recipe output
	 * 
	 * @param value recipe outputs
	 */
	public void setOutputs(List<ItemStack> value) {
		this.outputs = value;
	}
	
	/**
	 * Sets the recipe output
	 * 
	 * @param value output list
	 */
	public void setOutputs(ItemStack... value) {
		this.setOutputs(Arrays.asList(value));
	}
	
	/**
	 * Self-referentially sets the recipe output
	 * 
	 * @param value recipe outputs
	 * @return self-reference
	 */
	public Ic2Action withOutputs(List<ItemStack> value) {
		this.setOutputs(value);
		return this;
	}
	
	/**
	 * Self-referentially sets the recipe output
	 * 
	 * @param value recipe outputs
	 * @return self-reference
	 */
	public Ic2Action withOuputs(ItemStack... value) {
		return this.withOutputs(Arrays.asList(value));
	}
	
	/**
	 * Gets the additional data for the recipe
	 * 
	 * @return special data tag
	 */
	public NBTTagCompound getOtherData() {
		return this.otherData;
	}
	
	/**
	 * Sets the additional data for the recipe
	 * 
	 * @param value special data tag
	 */
	public void setOtherData(NBTTagCompound value) {
		this.otherData = value;
	}
	
	/**
	 * Self-referentially sets the additional data for the recipe
	 * 
	 * @param value special data tag
	 * @return self-reference
	 */
	public Ic2Action withOtherData(NBTTagCompound value) {
		this.setOtherData(value);
		return this;
	}
	
	/**
	 * Creates a new Ic2Action instance
	 * 
	 * @param input recipe input
	 * @param outputs recipe outputs
	 * @param otherData special data tag
	 */
	public Ic2Action(IRecipeInput input, List<ItemStack> outputs, NBTTagCompound otherData) {
		this.input = input;
		this.outputs = outputs;
		this.otherData = otherData;
	}
	
	/**
	 * Default constructor
	 */
	public Ic2Action() {
		this(null, null, null);
	}
}
