package com.mods.combatzak.mojo.alchemism.updates;

import ic2.core.Ic2Items;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.ItemApi;
import mods.railcraft.common.items.ItemIngot;
import mods.railcraft.common.items.Metal;
import mods.railcraft.common.items.ItemIngot.EnumIngot;
import mrtjp.projectred.ProjectRedExploration;
import net.minecraft.item.ItemStack;
import cofh.thermalexpansion.item.TEItems;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.smelter.RemoveSmelterAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.smelter.ReplaceSmelterAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.smelter.SubstituteSmelterAction;
import com.mods.combatzak.mojo.alchemism.items.AlchemismItems;

/**
 * Manages updates to Induction Smelter recipes
 * 
 * @author CombatZAK
 *
 */
public class InductionSmelterUpdates {
	/**
	 * Stores the Induction Smelter update actions
	 */
	private GroupAction smelterActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static InductionSmelterUpdates instance = new InductionSmelterUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return singleton
	 */
	public static InductionSmelterUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the Induction smelter updates
	 */
	public void register() {
		if (!this.smelterActions.getIsApplied())
			this.smelterActions.apply();
	}
	
	/**
	 * Default constructor initializes singleton
	 */
	private InductionSmelterUpdates() {
		//unify ore smelting
		this.smelterActions.add(new SubstituteSmelterAction(TFBlocks.blockOre.oreCopper, TFBlocks.blockOre.oreCopper));
		this.smelterActions.add(new SubstituteSmelterAction(TFBlocks.blockOre.oreTin, TFBlocks.blockOre.oreTin));
		this.smelterActions.add(new SubstituteSmelterAction(TFBlocks.blockOre.oreLead, TFBlocks.blockOre.oreLead));
		this.smelterActions.add(new SubstituteSmelterAction(new ItemStack(TinkerTools.materials, 1, 11), new ItemStack(TinkerTools.materials, 1, 11)));
		this.smelterActions.add(new SubstituteSmelterAction(new ItemStack(ProjectRedExploration.blockOres(), 1, 2), new ItemStack(ProjectRedExploration.blockOres(), 1, 2)));
		this.smelterActions.add(new SubstituteSmelterAction(new ItemStack(ProjectRedExploration.blockOres(), 1, 1), new ItemStack(ProjectRedExploration.blockOres(), 1, 1)));
		this.smelterActions.add(new SubstituteSmelterAction(new ItemStack(ProjectRedExploration.blockOres(), 1, 0), new ItemStack(ProjectRedExploration.blockOres(), 1, 0)));
		this.smelterActions.add(new SubstituteSmelterAction(ItemApi.getBlock("blockCustomOre", 7), ItemApi.getBlock("blockCustomOre", 7)));
		this.smelterActions.add(new RemoveSmelterAction().withPrimaryOutput(Ic2Items.advIronIngot));
		
		this.smelterActions.add(new SubstituteSmelterAction(TFItems.ingotTin, TFItems.ingotTin));
		
		this.smelterActions.add(new ReplaceSmelterAction(8000, new ItemStack(AlchemismItems.dustSteel, 2), TFItems.dustPyrotheum, Metal.STEEL.getIngot(2), TEItems.slag, 50));
	}
}
