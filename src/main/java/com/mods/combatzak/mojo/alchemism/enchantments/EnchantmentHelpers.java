package com.mods.combatzak.mojo.alchemism.enchantments;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * Helper methods for comparing enchantments
 * @author CombatZAK
 *
 */
public final class EnchantmentHelpers {
	
	/**
	 * Indicates whether or not an ItemStack has an enchantment at a certain level
	 * @param item ItemStack to examine for enchantment
	 * @param enchantment Enchantment tag (containing ID number and level) to check for
	 * @return false if targetStack is null or does not have the specified enchantment with at least the specified level; true if targetEnchantment is null, has 0 level, or targetStack has the enchantment
	 */
	public static boolean itemHasEnchantment(ItemStack item, NBTTagCompound enchantment) {
		if (item == null) return false; //null-test the target stack
		if (enchantment == null) return true; //null-test the target enchantment
		
		int targetId = enchantment.getInteger("id"); //get the enchantment number
		int targetLevel = enchantment.getInteger("lvl"); //get the enchantment level
		
		if (targetLevel <= 0) return true; //if the enchantment level is 0, stop here
		
		NBTTagList list = item.getEnchantmentTagList(); //get the enchantment tag list
		if (list == null || list.tagCount() == 0) {
			if (!item.hasTagCompound()) return false; //if there is no nbt data, stop here
			NBTTagCompound itemData = item.getTagCompound(); //get the tag data
			NBTBase storedTag = itemData.getTag("StoredEnchantments");
			if (storedTag == null || !(storedTag instanceof NBTTagList)) return false; //give up here
			list = (NBTTagList)storedTag;
		}
		
		for (int i = 0; i < list.tagCount(); i++) { //go through all enchantments
			NBTTagCompound curEnch = list.getCompoundTagAt(i); //get the current enchantment
			int enchId = curEnch.getInteger("id"); //get the current enchantment's number
			int enchLevel = curEnch.getInteger("lvl"); //get the current enchantment's level
			
			if (enchId == targetId && enchLevel >= targetLevel)
				return true; //enchantment found
		}
		
		return false; //processed all enchantments; nothing found
	}
}
