package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

/**
 * Replaces Furnace recipes with a new output
 * 
 * @author CombatZAK
 *
 */
public class ReplaceFurnaceAction extends FurnaceAction {
	/**
	 * Output to be replaced
	 */
	protected IIngredient oldOutput;
	
	/**
	 * Gets the old output filter
	 * @return old furnace output
	 */
	public IIngredient getOldOutput() {
		return this.oldOutput;
	}
	
	/**
	 * Sets the old output filter
	 * @param value old furnace output
	 */
	public void setOldOutput(IIngredient value) {
		this.oldOutput = value;
	}
	
	/**
	 * Self-referentially sets the old output filter
	 * @param value old furnace output
	 * @return self-reference
	 */
	public ReplaceFurnaceAction withOldOutput(IIngredient value) {
		this.setOldOutput(value);
		return this;
	}
	
	/**
	 * Creates a new ReplaceFurnaceAction instance
	 * 
	 * @param input furnace input
	 * @param oldOutput old furnace output
	 * @param newOutput new furnace output
	 */
	public ReplaceFurnaceAction(IIngredient input, IIngredient oldOutput, ItemStack newOutput) {
		super(input, newOutput);
		this.oldOutput = oldOutput;
	}
	
	/**
	 * Creates a new ReplaceFurnaceAction instance
	 * 
	 * @param oldOutput old output filter
	 * @param newOutput new output type
	 */
	public ReplaceFurnaceAction(IIngredient oldOutput, ItemStack newOutput) {
		this(null, oldOutput, newOutput);
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceFurnaceAction() {
		this(null, null, null);
	}
	
	/**
	 * Replaces any furnace recipe that matches the filter with new output
	 */
	public boolean apply() throws IllegalStateException {
		//state test
		if (this.output == null) throw new IllegalStateException("Cannot replace furnace recipes without new recipe output");
		if (this.input == null && this.oldOutput == null) throw new IllegalStateException("Cannot perform replacement without at least one filter");
		
		Map recipeMap = FurnaceRecipes.smelting().getSmeltingList(); //get the hashmap of input/output pairs
		Set<Map.Entry> entries = recipeMap.entrySet(); //get the volatile entry list on the map
		List<FurnaceRecipe> matches = new ArrayList<FurnaceRecipe>();
		
		for (Map.Entry entry : entries) { //go through all the i/o pairs currently registered
			FurnaceRecipe curRecipe = new FurnaceRecipe((ItemStack)entry.getKey(), (ItemStack)entry.getValue());
			if (isPatternMatch(curRecipe)) { //check the i/o for a match
				matches.add(curRecipe); //save the match for processing
			}
		}
		
		for (FurnaceRecipe match : matches) {
			ItemStack newOutputStack = this.output;
			if (this.output.stackSize != match.output.stackSize) //check for size agreement
				newOutputStack = new ItemStack(this.output.getItem(), match.output.stackSize, this.output.getItemDamage()); //create a new stack if needed
			
			recipeMap.put(match.input, newOutputStack); //push to the map, replacing the old recipe
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Determines if the i/o pattern matches a specified recipe
	 * 
	 * @param target furnace i/o to check against pattern
	 * @return true if the replacement i/o matches the target recipe; false otherwise
	 */
	private boolean isPatternMatch(FurnaceRecipe target) {
		if (target == null) return false; //null test
		
		return target.isMatch(this.input, this.oldOutput);
	}
}
