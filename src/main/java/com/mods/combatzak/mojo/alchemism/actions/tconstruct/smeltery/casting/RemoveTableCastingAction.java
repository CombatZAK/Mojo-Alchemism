package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting;

import java.util.List;

import net.minecraft.item.ItemStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.CastingRecipe;

/**
 * Deletes TCOnstruct Smeltery table casting recipes
 * @author CombatZAK
 *
 */
public class RemoveTableCastingAction extends RemoveCastingAction {
	/**
	 * Creates a new RemoveTableCastingAction instance
	 * 
	 * @param output output to remove
	 */
	public RemoveTableCastingAction(ItemStack output) {
		super(output);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveTableCastingAction() {
		this(null);
	}
	
	/**
	 * Gets the list of Table casting recipes
	 */
	@Override
	protected List<CastingRecipe> getRegistry() {
		return TConstructRegistry.getTableCasting().getCastingRecipes();
	}

}
