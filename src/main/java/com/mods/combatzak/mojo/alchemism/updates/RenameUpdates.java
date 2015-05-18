package com.mods.combatzak.mojo.alchemism.updates;

import cofh.thermalexpansion.item.TEItems;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.Equipment;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.RenameItemAction;

/**
 * Manages the updates to component display names
 * 
 * @author CombatZAK
 *
 */
public class RenameUpdates {
	/**
	 * Stores list of rename updates to apply
	 */
	private GroupAction renameActions = new GroupAction();
	
	/**
	 * Singleton class instance
	 */
	private static RenameUpdates instance = new RenameUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return RenameUpdates singleton
	 */
	public static RenameUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies all the display name updates
	 */
	public void register() {
		this.renameActions.apply();
	}
	
	/**
	 * Default constructor used to initialize singleton
	 */
	private RenameUpdates() {
		//rename Thermal Foundation Tinkers' Alloy to Bronze
		this.renameActions.add(new RenameItemAction(TFItems.dustBronze, "Bronze Blend"));
		this.renameActions.add(new RenameItemAction(TFItems.ingotBronze, "Bronze Ingot"));
		this.renameActions.add(new RenameItemAction(TFItems.nuggetBronze, "Bronze Nugget"));
		this.renameActions.add(new RenameItemAction(TFItems.gearBronze, "Bronze Gear"));
		this.renameActions.add(new RenameItemAction(TFBlocks.blockStorage.blockBronze, "Bronze Block"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolSword, "Bronze Sword"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolAxe, "Bronze Axe"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolPickaxe, "Bronze Pickaxe"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolShovel, "Bronze Shovel"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolHoe, "Bronze Hoe"));
	}
}
