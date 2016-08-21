package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import java.util.List;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.CastingRecipe;

/**
 * Replaces the particular output for Basin Casting recipes with new output
 * 
 * @author CombatZAK
 *
 */
public class ReplaceBasinCastingAction extends ReplaceCastingAction {
	/**
	 * Creates a new ReplaceBasinCastingAction instance
	 * 
	 * @param oldOutput output to replace
	 * @param newOutput replacement output
	 */
	public ReplaceBasinCastingAction(IIngredient oldOutput, ItemStack newOutput) {
		super(oldOutput, newOutput);
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceBasinCastingAction() {
		this(null, null);
	}
	
	/**
	 * Gets the BasinCasting registry list
	 */
	@Override
	protected List<CastingRecipe> getRegistry() {
		return TConstructRegistry.getBasinCasting().getCastingRecipes();
	}

}
