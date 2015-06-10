package com.mods.combatzak.mojo.alchemism.updates;

import com.mods.combatzak.mojo.GroupAction;

/**
 * Manages updates to chest loot tables
 * 
 * @author CombatZAK
 *
 */
public class LootUpdates {
	/**
	 * Stores the chest contents updates
	 */
	private GroupAction lootActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static LootUpdates instance = new LootUpdates();
	
	/**
	 * Gets the singleton
	 * 
	 * @return singleton
	 */
	public static LootUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the updates to the loot tables
	 */
	public void register() {
		if (!lootActions.getIsApplied())
			lootActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private LootUpdates() {
		
	}
}
