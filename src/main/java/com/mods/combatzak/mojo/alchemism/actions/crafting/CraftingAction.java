package com.mods.combatzak.mojo.alchemism.actions.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.IShapedIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

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
	 * Indicates that the ingredient list uses at least one ore dictionary entry
	 * 
	 * @return true if any ingredient uses the ore dictionary, false otherwise
	 */
	protected boolean hasOreIngredient() {
		if (this.inputs == null || this.inputs.isEmpty())
			return false; //check for empty input list
		
		for (IIngredient input : this.inputs) { //go through all the ingredients
			if (input instanceof OreIngredient)
				return true; //if any of them is an ore dictionary ingredient, stop here
		}
		
		return false; //if we get here, there are no ore ingredients
	}
	
	/**
	 * Gets the inputs for the crafting recipe
	 * 
	 * @return set of ingredients in input
	 */
	public List<IIngredient> getInputs() { return this.inputs; }
	
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
