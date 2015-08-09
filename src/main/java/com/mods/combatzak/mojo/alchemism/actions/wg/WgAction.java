package com.mods.combatzak.mojo.alchemism.actions.wg;

import java.util.ArrayList;
import java.util.List;

import com.mods.combatzak.mojo.MojoAction;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Represents an action related to Witching Gadgets
 * 
 * @author comba
 *
 */
public abstract class WgAction extends MojoAction {
	/**
	 * Default constructor
	 */
	public WgAction() {
		//stub
	}
	
	/**
	 * Examines two item stacks for direct equivalence (ignores stack size)
	 * 
	 * @param stack1 first stack to check
	 * @param stack2 second stack to check
	 * @return true if the item stacks are equivalent items
	 */
	protected static boolean isDirectMatch(ItemStack stack1, ItemStack stack2) {
		if (stack1 == null && stack2 == null) return true; //short circuit null (both)
		if (stack1 == null || stack2 == null) return false; //short circuit null (one)
		
		if (!stack1.getItem().equals(stack2.getItem())) return false; //check referenced item match
		if (!stack1.getHasSubtypes()) return true; //if no subtypes, done
		
		return (stack1.getItemDamage() == stack2.getItemDamage()); //check subtypes
	}
	
	/**
	 * Examines two item stacks for ore dict equivalence (ignores stack size)
	 * 
	 * @param template item to check against (with ore dict)
	 * @param other item to check (no ore dict)
	 * @return true if the items match on template's ore dict
	 */
	protected static boolean isOreDictMatch(ItemStack template, ItemStack other) {
		if (isDirectMatch(template, other)) return true; //direct equivalence (and null) test
		
		List<ItemStack> oreDictItems = new ArrayList<ItemStack>(); //stores all items in the ore dict for the template
		for (int oreId : OreDictionary.getOreIDs(template)) {
			oreDictItems.addAll(OreDictionary.getOres(oreId)); //get all the ores for each ore dict entry to which the template belongs
		}
		
		for (ItemStack oreItem : oreDictItems) { //go through all the ore dict items
			if (isDirectMatch(oreItem, other)) return true; //if any ore dict item matches the test item, done
		}
		
		return false; //no ore dict match
	}
	
	/**
	 * Gegs an ItemStack representing an item with a new stack size
	 * 
	 * @param template item stack to duplicate
	 * @param amount amount for the new stack
	 * @return duplicate stack of template with new stacksize, or if amount is equal to current stacksize, just returns template reference
	 */
	protected static ItemStack newAmount(ItemStack template, int amount) {
		if (template.stackSize == amount) return template; //no need to do work
		
		ItemStack result = template.copy(); //duplicate the stack
		result.stackSize = amount;
		
		return result;
	}
}
