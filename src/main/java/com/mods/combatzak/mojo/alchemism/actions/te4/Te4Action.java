package com.mods.combatzak.mojo.alchemism.actions.te4;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Action related to Thermal Expansion 4
 *
 * @author CombatZAK
 *
 */
public abstract class Te4Action extends MojoAction {
	/**
	 * Checks if an ItemStack matches another using the ore dictionary
	 * 
	 * @param testItem item to check
	 * @param target item to match against
	 * @return true if the test item matches the target; false otherwise
	 */
	public static boolean isOreDictMatch(ItemStack testItem, ItemStack target) {
		if (target == null && testItem == null) return true; //double null test
		if (target == null || testItem == null) return false; //single null test
		
		if (isDirectMatch(testItem, target))
			return true; //if there is a direct match, we can stop here
		
		List<ItemStack> oreDictItems = new ArrayList<ItemStack>(); //stores all items in matching target ore dict entries
		for (int oreId : OreDictionary.getOreIDs(target)) {
			oreDictItems.addAll(OreDictionary.getOres(oreId)); //this is obsolete but no equivalent exists
		}
		
		for (ItemStack oreItem : oreDictItems) {
			if (isDirectMatch(oreItem, testItem))
				return true; //if the test item matches any ore dict item, there is an dictionary match
		}
		
		return false; //if we get here, the target and test don't match
	}
	
	/**
	 * Checks if an ItemStack directly matches another
	 * 
	 * @param testItem item to check
	 * @param targetItem item to match against
	 * @return true if the test item matches the target directly; false otherwise
	 */
	public static boolean isDirectMatch(ItemStack testItem, ItemStack targetItem) {
		if (targetItem == null && testItem == null) return true; //double null test
		if (targetItem == null || testItem == null) return false; //single null test
		
		if (testItem.getItem() == targetItem.getItem() && (!targetItem.getHasSubtypes() || targetItem.getItemDamage() == testItem.getItemDamage()))
			return true; //direct item equality test
		
		return false; //can't be a match if we get here
	}
}
