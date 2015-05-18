package com.mods.combatzak.mojo.alchemism.recipes;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Ore Dictionary recipe ingredient
 * 
 * @author CombatZAK
 *
 */
public class OreIngredient implements IIngredient {

	/**
	 * Ore dictionary entry
	 */
	private String oreEntry;
	
	/**
	 * Gets the recipe ingredient
	 */
	@Override
	public Object getIngredient() {
		return this.oreEntry;
	}
	
	/**
	 * Indicates whether or not a target item matches the ore dictionary entry
	 */
	@Override
	public boolean matches(ItemStack target) {
		if (target == null) return false; //null check
		List<ItemStack> entry = OreDictionary.getOres(oreEntry, false); //get the ore list for the entry
		if (entry == null || entry.isEmpty()) return false; //can't have a match if there are no items in the dictionary
		
		for (ItemStack item : entry) { //go through all the items in the entry
			boolean itemMatches = item.getItem() == target.getItem();
			boolean metaMatches = item.getHasSubtypes() && item.getItemDamage() == target.getItemDamage();
			
			if (itemMatches && metaMatches) return true; //if the item and metadata match any entry, the target matches the ingredient
		}
		
		return false; //if we get here, there is no match
	}
	
	/**
	 * Sets the ingredient value
	 * 
	 * @param value ore dictionary entry
	 */
	public void setIngredient(String value) {
		this.oreEntry = value;
	}
	
	/**
	 * Creates a new OreIngredient instance
	 * 
	 * @param oreEntry ore dictionary entry
	 */
	public OreIngredient(String oreEntry) {
		this.oreEntry = oreEntry; //set ingredient value
	}
	
	/**
	 * Default constructor
	 */
	public OreIngredient() {
		this(null);
	}

}
