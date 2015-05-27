package com.mods.combatzak.mojo.alchemism.updates;

import ic2.core.Ic2Items;
import tconstruct.tools.TinkerTools;
import net.minecraft.item.ItemStack;
import cofh.thermalfoundation.block.TFBlocks;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.smelter.RemoveSmelterAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.smelter.SubstituteSmelterAction;

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
		this.smelterActions.add(new RemoveSmelterAction().withPrimaryOutput(Ic2Items.advIronIngot));
	}
}
