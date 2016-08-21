package com.mods.combatzak.mojo.alchemism.updates;

import tconstruct.tools.TinkerTools;
import net.minecraft.item.ItemStack;
import cofh.thermalexpansion.block.TEBlocks;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting.RemoveBasinCastingAction;
import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting.ReplaceBasinCastingAction;
import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.casting.ReplaceTableCastingAction;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

/**
 * Applies updates to the TConstruct Smeltery casting recipes
 * 
 * @author CombatZAK
 *
 */
public class CastingUpdates {
	/**
	 * Stores the casting recipe updates
	 */
	private GroupAction castingActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static CastingUpdates instance = new CastingUpdates();
	
	/**
	 * Gets the singleton CastingUpdates instance
	 * 
	 * @return singleton
	 */
	public static CastingUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the updates to the casting recipes
	 */
	public void register() {
		if (!this.castingActions.getIsApplied())
			this.castingActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private CastingUpdates() {
		//fix ingot casting
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("ingotCopper"), TFItems.ingotCopper));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("ingotTin"), TFItems.ingotTin));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("ingotBronze"), TFItems.ingotBronze));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("ingotLead"), TFItems.ingotLead));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("ingotSilver"), TFItems.ingotSilver));
		
		//fix nugget casting
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetCopper"), TFItems.nuggetCopper));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetTin"), TFItems.nuggetTin));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetBronze"), TFItems.nuggetBronze));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetLead"), TFItems.nuggetLead));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetSilver"), TFItems.nuggetSilver));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetIron"), TFItems.nuggetIron));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("nuggetAluminum"), new ItemStack(TinkerTools.materials, 1, 22)));
		
		//fix block casting
		this.castingActions.add(new ReplaceBasinCastingAction(new OreIngredient("blockCopper"), TFBlocks.blockStorage.blockCopper));
		this.castingActions.add(new ReplaceBasinCastingAction(new OreIngredient("blockTin"), TFBlocks.blockStorage.blockTin));
		this.castingActions.add(new ReplaceBasinCastingAction(new OreIngredient("blockBronze"), TFBlocks.blockStorage.blockBronze));
		this.castingActions.add(new ReplaceBasinCastingAction(new OreIngredient("blockLead"), TFBlocks.blockStorage.blockLead));
		this.castingActions.add(new ReplaceBasinCastingAction(new OreIngredient("blockSilver"), TFBlocks.blockStorage.blockSilver));
		
		//fix gear casting
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("gearCopper"), TFItems.gearCopper));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("gearTin"), TFItems.gearTin));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("gearBronze"), TFItems.gearBronze));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("gearIron"), TFItems.gearIron));
		this.castingActions.add(new ReplaceTableCastingAction(new OreIngredient("gearGold"), TFItems.gearGold));
		
		//remove some recipes
		this.castingActions.add(new RemoveBasinCastingAction(new ItemStack(TEBlocks.blockGlass)));
	}
}
