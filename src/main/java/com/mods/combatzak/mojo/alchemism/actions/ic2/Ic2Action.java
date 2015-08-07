package com.mods.combatzak.mojo.alchemism.actions.ic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
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
	
	/**
	 * Indicates whether two item stacks represent the same item; ignoring quantity
	 * 
	 * @param stack1 first stack to compare
	 * @param stack2 second stack to compare
	 * @return true if the stack contain the same item
	 */
	protected static boolean isDirectMatch(ItemStack stack1, ItemStack stack2) {
		if (stack1 == null && stack2 == null) return true;
		if (stack1 == null || stack2 == null) return false;
		
		if (!stack1.getItem().equals(stack2.getItem())) return false;
		
		return !stack1.getHasSubtypes() || stack1.getItemDamage() == stack2.getItemDamage();
	}
	
	/**
	 * Indicates whether two item stacks match on ore dictionary entries
	 * 
	 * @param target item to compare against (including ore dicts)
	 * @param other item to compare (must be in target's ore dict)
	 * @return true if the items match on ore dictionary
	 */
	protected static boolean isOreDictMatch(ItemStack target, ItemStack other) {
		if (isDirectMatch(target, other)) return true;
		
		List<ItemStack> oreDictItems = new ArrayList<ItemStack>();
		for (int oreId : OreDictionary.getOreIDs(target))
			oreDictItems.addAll(OreDictionary.getOres(oreId));
			
		for (ItemStack dictItem : oreDictItems)
			if (isDirectMatch(dictItem, other)) return true;
		
		return false;
	}
	
	/**
	 * Creates a duplicate of an item stack with specified stack size
	 * 
	 * @param template item stack to copy
	 * @param amount stack size to use
	 * @return duplicate of template stack with new stack size
	 */
	protected static ItemStack newAmount(ItemStack template, int amount) {
		if (template.stackSize == amount) return template;
		
		ItemStack result = template.copy();
		result.stackSize = amount;
		
		return result;
	}
}
