package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import java.util.List;

import net.minecraft.item.ItemStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.CastingRecipe;

/**
 * Deletes TConstruct smeltery basin casting recipes
 * 
 * @author CombatZAK
 *
 */
public class RemoveBasinCastingAction extends RemoveCastingAction {
	/**
	 * Creates a new RemoveBasinCastingAction instance
	 * @param output output to remove
	 */
	public RemoveBasinCastingAction(ItemStack output) {
		super(output);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveBasinCastingAction() {
		this(null);
	}
	
	/**
	 * Gets the list of Basin casting recipes
	 */
	@Override
	protected List<CastingRecipe> getRegistry() {
		return TConstructRegistry.getBasinCasting().getCastingRecipes();
	}

}
