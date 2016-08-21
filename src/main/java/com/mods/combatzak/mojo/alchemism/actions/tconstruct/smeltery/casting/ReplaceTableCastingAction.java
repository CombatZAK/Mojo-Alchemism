package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import java.util.List;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.CastingRecipe;

/**
 * Replaces particular outputs of table casting recipes with another output
 * 
 * @author CombatZAK
 *
 */
public class ReplaceTableCastingAction extends ReplaceCastingAction {
	/**
	 * Creates a new ReplaceTableCastingInstance
	 * 
	 * @param oldOutput output to replace
	 * @param newOutput replacement output
	 */
	public ReplaceTableCastingAction(IIngredient oldOutput, ItemStack newOutput) {
		super(oldOutput, newOutput);
	}
	
	/**
	 * Default constructor
	 */
	public ReplaceTableCastingAction() {
		this(null, null);
	}
	
	/**
	 * Gets the TableCasting registry list
	 * 
	 * @return TableCasting registry list
	 */
	@Override
	protected List<CastingRecipe> getRegistry() {
		return TConstructRegistry.getTableCasting().getCastingRecipes();
	}

}
