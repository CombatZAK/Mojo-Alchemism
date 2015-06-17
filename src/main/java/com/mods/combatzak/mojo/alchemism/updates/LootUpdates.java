package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.item.ItemStack;
import mods.railcraft.common.items.RailcraftToolItems;
import ic2.core.Ic2Items;
import cofh.thermalfoundation.item.Equipment;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.loot.AddLootAction;
import com.mods.combatzak.mojo.alchemism.actions.loot.RemoveLootAction;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;

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
		this.lootActions.add(new RemoveLootAction("dungeonChest", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("dungeonChest", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new AddLootAction("dungeonChest", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("dungetonChest", TFItems.ingotTin, 100, 2, 5));
		
		this.lootActions.add(new RemoveLootAction("mineshaftCorridor", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("mineshaftCorridor", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new AddLootAction("mineshaftCorridor", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("mineshaftCorridor", TFItems.ingotTin, 100, 2, 5));
		
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.bronzePickaxe)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.bronzeSword)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.bronzeHelmet)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.bronzeChestplate)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.bronzeLeggings)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.bronzeBoots)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(RailcraftToolItems.getSteelSword())));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(RailcraftToolItems.getSteelHelm())));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(RailcraftToolItems.getSteelArmor())));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(RailcraftToolItems.getSteelLegs())));
		this.lootActions.add(new RemoveLootAction("pyramidDesertyChest", new ItemIngredient(RailcraftToolItems.getSteelBoots())));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", TFItems.ingotTin, 100, 2, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", Equipment.Bronze.toolPickaxe, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", Equipment.Bronze.toolSword, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", Equipment.Bronze.armorHelmet, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", Equipment.Bronze.armorPlate, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", Equipment.Bronze.armorLegs, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", Equipment.Bronze.armorBoots, 5));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", RailcraftToolItems.getSteelSword(), 3));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", RailcraftToolItems.getSteelHelm(), 3));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", RailcraftToolItems.getSteelArmor(), 3));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", RailcraftToolItems.getSteelLegs(), 3));
		this.lootActions.add(new AddLootAction("pyramidDesertyChest", RailcraftToolItems.getSteelBoots(), 3));
		
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.bronzePickaxe)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.bronzeSword)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.bronzeHelmet)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.bronzeChestplate)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.bronzeLeggings)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.bronzeBoots)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(RailcraftToolItems.getSteelSword())));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(RailcraftToolItems.getSteelHelm())));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(RailcraftToolItems.getSteelArmor())));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(RailcraftToolItems.getSteelLegs())));
		this.lootActions.add(new RemoveLootAction("pyramidJungleChest", new ItemIngredient(RailcraftToolItems.getSteelBoots())));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", TFItems.ingotTin, 100, 2, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", Equipment.Bronze.toolPickaxe, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", Equipment.Bronze.toolSword, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", Equipment.Bronze.armorHelmet, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", Equipment.Bronze.armorPlate, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", Equipment.Bronze.armorLegs, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", Equipment.Bronze.armorBoots, 5));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", RailcraftToolItems.getSteelSword(), 3));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", RailcraftToolItems.getSteelHelm(), 3));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", RailcraftToolItems.getSteelArmor(), 3));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", RailcraftToolItems.getSteelLegs(), 3));
		this.lootActions.add(new AddLootAction("pyramidJungleChest", RailcraftToolItems.getSteelBoots(), 3));
		
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.bronzePickaxe)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.bronzeSword)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.bronzeHelmet)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.bronzeChestplate)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.bronzeLeggings)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.bronzeBoots)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(RailcraftToolItems.getSteelSword())));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(RailcraftToolItems.getSteelHelm())));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(RailcraftToolItems.getSteelArmor())));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(RailcraftToolItems.getSteelLegs())));
		this.lootActions.add(new RemoveLootAction("strongholdCorridor", new ItemIngredient(RailcraftToolItems.getSteelBoots())));
		this.lootActions.add(new AddLootAction("strongholdCorridor", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", TFItems.ingotTin, 100, 2, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", Equipment.Bronze.toolPickaxe, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", Equipment.Bronze.toolSword, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", Equipment.Bronze.armorHelmet, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", Equipment.Bronze.armorPlate, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", Equipment.Bronze.armorLegs, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", Equipment.Bronze.armorBoots, 5));
		this.lootActions.add(new AddLootAction("strongholdCorridor", RailcraftToolItems.getSteelSword(), 3));
		this.lootActions.add(new AddLootAction("strongholdCorridor", RailcraftToolItems.getSteelHelm(), 3));
		this.lootActions.add(new AddLootAction("strongholdCorridor", RailcraftToolItems.getSteelArmor(), 3));
		this.lootActions.add(new AddLootAction("strongholdCorridor", RailcraftToolItems.getSteelLegs(), 3));
		this.lootActions.add(new AddLootAction("strongholdCorridor", RailcraftToolItems.getSteelBoots(), 3));
		
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.bronzePickaxe)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.bronzeSword)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.bronzeHelmet)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.bronzeChestplate)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.bronzeLeggings)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.bronzeBoots)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(RailcraftToolItems.getSteelSword())));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(RailcraftToolItems.getSteelHelm())));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(RailcraftToolItems.getSteelArmor())));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(RailcraftToolItems.getSteelLegs())));
		this.lootActions.add(new RemoveLootAction("strongholdCrossing", new ItemIngredient(RailcraftToolItems.getSteelBoots())));
		this.lootActions.add(new AddLootAction("strongholdCrossing", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", TFItems.ingotTin, 100, 2, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", Equipment.Bronze.toolPickaxe, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", Equipment.Bronze.toolSword, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", Equipment.Bronze.armorHelmet, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", Equipment.Bronze.armorPlate, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", Equipment.Bronze.armorLegs, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", Equipment.Bronze.armorBoots, 5));
		this.lootActions.add(new AddLootAction("strongholdCrossing", RailcraftToolItems.getSteelSword(), 3));
		this.lootActions.add(new AddLootAction("strongholdCrossing", RailcraftToolItems.getSteelHelm(), 3));
		this.lootActions.add(new AddLootAction("strongholdCrossing", RailcraftToolItems.getSteelArmor(), 3));
		this.lootActions.add(new AddLootAction("strongholdCrossing", RailcraftToolItems.getSteelLegs(), 3));
		this.lootActions.add(new AddLootAction("strongholdCrossing", RailcraftToolItems.getSteelBoots(), 3));
		
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.bronzePickaxe)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.bronzeSword)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.bronzeHelmet)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.bronzeChestplate)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.bronzeLeggings)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.bronzeBoots)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.copperIngot)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(Ic2Items.tinIngot)));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(RailcraftToolItems.getSteelSword())));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(RailcraftToolItems.getSteelHelm())));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(RailcraftToolItems.getSteelArmor())));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(RailcraftToolItems.getSteelLegs())));
		this.lootActions.add(new RemoveLootAction("villageBlacksmith", new ItemIngredient(RailcraftToolItems.getSteelBoots())));
		this.lootActions.add(new AddLootAction("villageBlacksmith", TFItems.ingotCopper, 100, 2, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", TFItems.ingotTin, 100, 2, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", Equipment.Bronze.toolPickaxe, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", Equipment.Bronze.toolSword, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", Equipment.Bronze.armorHelmet, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", Equipment.Bronze.armorPlate, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", Equipment.Bronze.armorLegs, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", Equipment.Bronze.armorBoots, 5));
		this.lootActions.add(new AddLootAction("villageBlacksmith", RailcraftToolItems.getSteelSword(), 3));
		this.lootActions.add(new AddLootAction("villageBlacksmith", RailcraftToolItems.getSteelHelm(), 3));
		this.lootActions.add(new AddLootAction("villageBlacksmith", RailcraftToolItems.getSteelArmor(), 3));
		this.lootActions.add(new AddLootAction("villageBlacksmith", RailcraftToolItems.getSteelLegs(), 3));
		this.lootActions.add(new AddLootAction("villageBlacksmith", RailcraftToolItems.getSteelBoots(), 3));
	}
}
