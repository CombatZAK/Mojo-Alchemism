package com.mods.combatzak.mojo.alchemism.updates;

import ic2.core.Ic2Items;
import cofh.thermalexpansion.item.TEItems;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.Equipment;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.renaming.RenameFluidAction;
import com.mods.combatzak.mojo.alchemism.actions.renaming.RenameGenericAction;
import com.mods.combatzak.mojo.alchemism.actions.renaming.RenameItemAction;
import com.mods.combatzak.mojo.alchemism.actions.renaming.RenameTConstructCompatAction;

import cpw.mods.fml.common.registry.GameRegistry;

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
		if (!this.renameActions.getIsApplied())
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
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolShears, "Bronze Shears"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolFishingRod, "Bronze Fishing Rod"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolBow, "Bronze Reinforced Bow"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.toolSickle, "Bronze Sickle"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.armorHelmet, "Bronze Helmet"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.armorPlate, "Bronze Chestplate"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.armorLegs, "Bronze Leggings"));
		this.renameActions.add(new RenameItemAction(Equipment.Bronze.armorBoots, "Bronze Boots"));
		
		//rename Thermal Foundation Shiny to Platinum
		this.renameActions.add(new RenameItemAction(TFItems.dustPlatinum, "Pulverized Platinum"));
		this.renameActions.add(new RenameItemAction(TFItems.ingotPlatinum, "Platinum Ingot"));
		this.renameActions.add(new RenameItemAction(TFItems.nuggetPlatinum, "Platinum Nugget"));
		this.renameActions.add(new RenameItemAction(TFItems.gearPlatinum, "Platinum Gear"));
		this.renameActions.add(new RenameItemAction(TFBlocks.blockStorage.blockPlatinum, "Platinum Block"));
		this.renameActions.add(new RenameItemAction(TFBlocks.blockOre.orePlatinum, "Platinum Ore"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolSword, "Platinum Sword"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolAxe, "Platinum Axe"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolPickaxe, "Platinum Pickaxe"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolShovel, "Platinum Shovel"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolHoe, "Platinum Hoe"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolShears, "Platinum Shears"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolFishingRod, "Platinum Fishing Rod"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolBow, "Platinum Reinforced Bow"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.toolSickle, "Platinum Sickle"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.armorHelmet, "Platinum Helmet"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.armorPlate, "Platinum Chestplate"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.armorLegs, "Platinum Leggings"));
		this.renameActions.add(new RenameItemAction(Equipment.Platinum.armorBoots, "Platinum Boots"));
		this.renameActions.add(new RenameTConstructCompatAction("platinum", "Platinum"));
		this.renameActions.add(new RenameFluidAction("platinum.molten", "Molten Platinum"));
		this.renameActions.add(new RenameGenericAction("tile.fluid.molten.shiny.name", "Molten Platinum"));
		this.renameActions.add(new RenameGenericAction("item.tconstruct.bucket.Shiny.name", "Molten Platinum Bucket"));
		
		//fix some fluid names
		this.renameActions.add(new RenameFluidAction("tin.molten", "Molten Tin"));
		this.renameActions.add(new RenameGenericAction("tile.fluid.molten.tin.name", "Molten Tin"));
		this.renameActions.add(new RenameFluidAction("molten.unstableIngots", "Unstable Fluid"));
		this.renameActions.add(new RenameFluidAction("molten.bedrockiumIngots", "Liquified Bedrockium"));
		
		//Rename IC2 steel to industrial steel
		this.renameActions.add(new RenameGenericAction("ic2.itemIngotAdvIron", "Industrial Steel Ingot"));
		this.renameActions.add(new RenameGenericAction("ic2.itemAdvIronBlockCuttingBlade", "Block Cutting Blade (Industrial Steel)"));
		this.renameActions.add(new RenameGenericAction("ic2.blockMetalAdvIron", "Industrial Steel Block"));
		this.renameActions.add(new RenameGenericAction("ic2.itemPlateAdvIron", "Industrial Steel Plate"));
		this.renameActions.add(new RenameGenericAction("ic2.itemDensePlateAdvIron", "Dense Industrial Steel Plate"));
		this.renameActions.add(new RenameGenericAction("ic2.itemCasingAdvIron", "Industrial Steel Item Casing"));
		this.renameActions.add(new RenameGenericAction("ic2.AdvIronBlockCuttingBlade.info", "cuts materials softer than Industrial Steel"));
		this.renameActions.add(new RenameGenericAction("ic2.itemsteelshaft", "Shaft (Industrial Steel)"));
		
	}
}
