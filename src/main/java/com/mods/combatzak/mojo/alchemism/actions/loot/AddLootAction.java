package com.mods.combatzak.mojo.alchemism.actions.loot;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

/**
 * Adds an entry to the loot table
 * 
 * @author CombatZAK
 *
 */
public class AddLootAction extends LootAction {
	/**
	 * Creates a new AddLootAction instance
	 * 
	 * @param lootType type of chest to add loot
	 * @param loot item being added
	 * @param min minimum stack size
	 * @param max maximum stack size
	 * @param weight relative chance of loot appearing
	 */
	public AddLootAction(String lootType, ItemStack loot, int min, int max, int weight) {
		super(lootType, loot, min, max, weight);
	}
	
	/**
	 * Creates a new AddLootAction instance
	 * 
	 * @param lootType type of chest to add loot
	 * @param loot item being added
	 * @param weight relative chance of loot appearing
	 */
	public AddLootAction(String lootType, ItemStack loot, int weight) {
		this(lootType, loot, 1, 1, weight);
	}
	
	/**
	 * Default constructor
	 */
	public AddLootAction() {
		this(null, null, 0, 0, 0);
	}
	
	/**
	 * Applies the action, adding the loot to the table
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		//null tests
		if (lootType == null) throw new IllegalStateException("Cannot add loot to empty entry");
		if (loot == null) throw new IllegalStateException("Cannot add null loot");
		
		ChestGenHooks.addItem(lootType, new WeightedRandomChestContent(loot, weight, min, max)); //add the item to the chest
		
		this.setIsApplied(true); //set applied flag
		return true;
	}

}
