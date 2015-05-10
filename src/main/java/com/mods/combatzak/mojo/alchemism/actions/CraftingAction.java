package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.IShapedIngredient;

/**
 * An action that affects standard crafting
 * @author CombatZAK
 *
 */
public abstract class CraftingAction extends MojoAction {
	protected List<IIngredient> inputs; //series of ingredients for the recipe
	protected ItemStack output;
	
	/**
	 * Gets all the crafting recipes currently registered; editing the list should edit in-game recipes
	 * 
	 * @return List of all crafting recipes registered with the game
	 */
	protected static List getRegisteredRecipes() {
		return CraftingManager.getInstance().getRecipeList();
	}
	
	/**
	 * Gets the inputs for the crafting recipe
	 * 
	 * @return set of ingredients in input
	 */
	public  List<? extends IIngredient> getInputs() { return this.inputs; }
	
	/**
	 * Sets the inputs for the crafting recipe
	 * 
	 * @param value set of ingredients in recipe input 
	 */
	public void setInputs(List<IIngredient> value) { this.inputs = value; }
	
	/**
	 * Gets the output for the crafting recipe
	 * 
	 * @return output item
	 */
	public ItemStack getOutput() { return this.output; }
	
	/**
	 * Sets the output for the crafting recipe
	 * 
	 * @param value recipe output stack
	 */
	public void setOutput(ItemStack value) { this.output = value; }
	
	/**
	 * Creates a new CraftingAction instance
	 * 
	 * @param inputs recipe inputs
	 * @param output recipe output
	 */
	public CraftingAction(List<IIngredient> inputs, ItemStack output) {
		//set fields
		this.inputs = (List<IIngredient>) inputs;
		this.output = output;
	}
	
	/**
	 * Creates a new CraftingAction instance
	 * 
	 * @param inputs recipe input 
	 */
	public CraftingAction(List<IIngredient> inputs) {
		this(inputs, null);
	}
	
	/**
	 * Creates a new CraftingAction instance
	 * 
	 * @param output recipe output
	 */
	public CraftingAction(ItemStack output) {
		this(null, output);
	}
	
	/**
	 * Default constructor
	 */
	public CraftingAction() {
		this(null, null);
	}
	
	/**
	 * Self referentially sets input list
	 * 
	 * @param inputs recipe inputs
	 * @return reference to current recipe action
	 */
	public CraftingAction withInputs(List<IIngredient> inputs) {
		this.setInputs((List<IIngredient>) inputs);
		return this;
	}
	
	/**
	 * Self referentially sets output stack
	 * 
	 * @param output output item
	 * @return reference to current action
	 */
	public CraftingAction withOutput(ItemStack output) {
		this.setOutput(output);
		return this;
	}
}
