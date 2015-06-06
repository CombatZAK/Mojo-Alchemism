package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import tconstruct.library.crafting.CastingRecipe;

/**
 * Removes a recipes from casting list
 * 
 * @author CombatZAK
 *
 */
public abstract class RemoveCastingAction extends CastingAction {
	/**
	 * Creates a new RemoveCastingAction instance
	 * 
	 * @param output item to remove
	 */
	public RemoveCastingAction(ItemStack output) {
		super(null, null, output, false, 0);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveCastingAction() {
		this(null);
	}

	/**
	 * Applies the action, removing any recipes from the registry with the specified output
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (output == null) throw new IllegalStateException("Cannot remove recipes without output to match"); //null test
		
		List<CastingRecipe> registry = getRegistry(); //get the registered recipes
		List<CastingRecipe> matches = new ArrayList<CastingRecipe>(); //stores matches to output
		for (CastingRecipe recipe : registry) { //go through all the casting recipes
			if (isDirectMatch(output, recipe.output)) //check for match
				matches.add(recipe);
		}
		
		for (CastingRecipe match : matches) { //go through all the matches and remove them
			registry.remove(match);
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}

}
