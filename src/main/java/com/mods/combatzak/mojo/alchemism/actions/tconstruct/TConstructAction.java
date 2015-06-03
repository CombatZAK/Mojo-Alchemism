package com.mods.combatzak.mojo.alchemism.actions.tconstruct;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import mantle.utils.ItemMetaWrapper;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Handles actions related to Tinkers' Construct recipes
 * 
 * @author CombatZAK
 *
 */
public abstract class TConstructAction extends MojoAction {
	/**
	 * Checks if an ItemMetaWrapper matches the item represented by an item template
	 * 
	 * @param test item to check
	 * @param target item to check against
	 * @return true if test matches the target; false otherwise
	 */
	public static boolean isDirectMatch(ItemMetaWrapper test, ItemStack target) {
		if (test == null && target == null) return true; //double null test
		if (test == null || target == null) return false; //single null test (implied xor)
		
		if (test.item != target.getItem()) return false; //check that items are equal
		if (!target.getHasSubtypes()) return true; //if no subtypes, it's a match
		
		return target.getItemDamage() == test.meta; //match if meta matches
	}
	
	/**
	 * Checks if a FluidStack matches another
	 * 
	 * @param test FluidStack to check
	 * @param target FluidStack to check against
	 * @return true if the test matches the target (does not check amount); false otherwise
	 */
	public static boolean isFluidMatch(FluidStack test, FluidStack target) {
		if (test == null && target == null) return true; //double null test
		if (test == null || target == null) return false; //single null test (implied xor)
		
		return target.isFluidEqual(test); //check that the fluid matches
	}
}
