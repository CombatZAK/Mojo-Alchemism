package com.mods.combatzak.mojo.alchemism.actions.loot;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

/**
 * Removes a loot entry from a chest
 * 
 * @author CombatZAK
 *
 */
public class RemoveLootAction extends MojoAction {
	/**
	 * Type of chest where loot appears
	 */
	private String lootType;
	
	/**
	 * Loot to remove
	 */
	private IIngredient loot;
	
	/**
	 * Gets the type of loot chest
	 * 
	 * @return chest ID
	 */
	public String getLootType() {
		return this.lootType;
	}
	
	/**
	 * Sets the type of loot chest
	 * 
	 * @param value chest ID
	 */
	public void setLootType(String value) {
		this.lootType = value;
	}
	
	/**
	 * Self-referentially sets the type of loot chest
	 * 
	 * @param value chest ID
	 * @return self-reference
	 */
	public RemoveLootAction withLootType(String value) {
		this.setLootType(value);
		return this;
	}
	
	/**
	 * Creates a new RemoveLootAction instance
	 * 
	 * @param lootType chest ID
	 * @param loot type of loot to remove
	 */
	public RemoveLootAction(String lootType, IIngredient loot) {
		this.lootType = lootType;
		this.loot = loot;
	}
	
	/**
	 * Default constructor
	 */
	public RemoveLootAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, removing loot entries for the item from the chest
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		//null tests
		if (lootType == null) throw new IllegalStateException("Must specificy chest ID to remove loot");
		if (loot == null) throw new IllegalStateException("Must specify loot item to remove");
		
		List<ItemStack> targets = getMatchingItems(); //get all the items to remove
		for (ItemStack target : targets) {
			ChestGenHooks.removeItem(lootType, target);
		}
		
		this.setIsApplied(true);
		return true;
	}
	
	/**
	 * Gets all the items that match the ingredient to remove
	 * 
	 * @return items matching the ingredient
	 */
	private List<ItemStack> getMatchingItems() {
		if (loot == null) return null; //null test
		
		List<ItemStack> result = new ArrayList<ItemStack>();
		if (loot instanceof ItemIngredient) result.add((ItemStack)loot.getIngredient());
		else if (loot instanceof OreIngredient) {
			result = OreDictionary.getOres(loot.getIngredient().toString(), false);
		}
		
		return result;
	}
}
