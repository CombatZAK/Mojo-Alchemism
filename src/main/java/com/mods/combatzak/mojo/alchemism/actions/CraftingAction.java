package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

/**
 * An action that affects standard crafting
 * @author CombatZAK
 *
 */
public abstract class CraftingAction extends MojoAction {
	protected List<IIngredient> inputs = new ArrayList<IIngredient>(); //series of ingredients for the recipe
	
	/**
	 * Gets the inputs for the crafting recipe
	 * 
	 * @return
	 */
	protected List<IIngredient> getInputs() { return this.inputs; }
}
