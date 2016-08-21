package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import java.util.ArrayList;
import java.util.List;

import tconstruct.library.crafting.CastingRecipe;
import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

/**
 * Replaces the output of a set of casting recipes with another output
 * 
 * @author CombatZAK
 *
 */
public abstract class ReplaceCastingAction extends CastingAction {
	/**
	 * The output to replace
	 */
	protected IIngredient oldOutput;
	
	/**
	 * gets the output to replace
	 * 
	 * @return old output
	 */
	public IIngredient getOldOutput() {
		return this.oldOutput;
	}
	
	/**
	 * Sets the output to replace
	 * 
	 * @param value old output
	 */
	public void setOldOutput(IIngredient value) {
		this.oldOutput = value;
	}
	
	/**
	 * Self-referentially sets the output to replace
	 * 
	 * @param value old output
	 * @return self-reference
	 */
	public ReplaceCastingAction withOldOutput(IIngredient value) {
		this.setOldOutput(value);
		return this;
	}
	
	/**
	 * Creates a new ReplaceCastingAction instance
	 * 
	 * @param oldOutput output to replace
	 * @param newOutput output to replace with
	 */
	public ReplaceCastingAction(IIngredient oldOutput, ItemStack newOutput) {
		super(null, null, newOutput, false, 0);
		this.oldOutput = oldOutput;
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceCastingAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, replacing any instances of the old output with new output
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		//null tests
		if (oldOutput == null) throw new IllegalStateException("Cannot replace empty output");
		if (output == null) throw new IllegalStateException("Cannot replace with empty output");
		
		List<CastingRecipe> registry = getRegistry();
		List<CastingRecipe> matches = new ArrayList<CastingRecipe>(); //stores any matches to the old output
		
		for (CastingRecipe recipe : registry) {
			if (oldOutput.matches(recipe.output)) //check each recipe
				matches.add(recipe); //mark it a match if necessary
		}
		
		for (CastingRecipe match : matches) {
			match.output = updateStackSize(output, match.output.stackSize); //replace the output for the recipe
		}
	
		this.setIsApplied(true); //set the applied flag
		return true;
	}
}
