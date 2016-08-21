package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.item.ItemStack;
import tconstruct.tools.TinkerTools;
import tconstruct.world.TinkerWorld;
import ic2.api.item.IC2Items;
import ic2.core.Ic2Items;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.nei.HideNeiAction;

/**
 * Handles updates to the NEI item display
 * @author CombatZAK
 *
 */
public class NeiItemUpdates {
	/**
	 * Stores update actions for NEI item display
	 */
	private GroupAction itemActions = new GroupAction();
	
	/**
	 * Static singleton instance
	 */
	private static NeiItemUpdates instance = new NeiItemUpdates();
	
	/**
	 * Gets the NeiItemUpdates singleton instance
	 * 
	 * @return singleton instance
	 */
	public static NeiItemUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the updates to the NEI item display
	 */
	public void register() {
		if (!this.itemActions.getIsApplied())
			this.itemActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private NeiItemUpdates() {
		//hide all entries for non TF ores with a few other exceptions
		this.itemActions.add(new HideNeiAction("oreCopper", TFBlocks.blockOre.oreCopper, Ic2Items.copperOre, new ItemStack(TinkerWorld.oreGravel, 1, 2)));
		this.itemActions.add(new HideNeiAction("oreTin", TFBlocks.blockOre.oreTin, Ic2Items.tinOre, new ItemStack(TinkerWorld.oreGravel, 1, 3)));
		this.itemActions.add(new HideNeiAction("oreLead", TFBlocks.blockOre.oreLead, Ic2Items.leadOre));
		this.itemActions.add(new HideNeiAction("oreAluminum", new ItemStack(TinkerWorld.oreSlag, 1, 5), new ItemStack(TinkerWorld.oreGravel, 1, 4)));
		this.itemActions.add(new HideNeiAction("oreSilver", TFBlocks.blockOre.oreSilver));
		
		//hide all entries for non TF ingots
		this.itemActions.add(new HideNeiAction("ingotCopper", TFItems.ingotCopper));
		this.itemActions.add(new HideNeiAction("ingotTin", TFItems.ingotTin));
		this.itemActions.add(new HideNeiAction("ingotSilver", TFItems.ingotSilver));
		this.itemActions.add(new HideNeiAction("ingotLead", TFItems.ingotLead));
		this.itemActions.add(new HideNeiAction("ingotBronze", TFItems.ingotBronze));
		
		//hide certain non-TF dusts
		this.itemActions.add(new HideNeiAction("dustBronze", TFItems.dustBronze));
		
		//hide non-tf blocks
		this.itemActions.add(new HideNeiAction("blockCopper", TFBlocks.blockStorage.blockCopper));
		this.itemActions.add(new HideNeiAction("blockTin", TFBlocks.blockStorage.blockTin));
		this.itemActions.add(new HideNeiAction("blockBronze", TFBlocks.blockStorage.blockBronze));
		this.itemActions.add(new HideNeiAction("blockLead", TFBlocks.blockStorage.blockLead));
		this.itemActions.add(new HideNeiAction("blockSilver", TFBlocks.blockStorage.blockSilver));
		this.itemActions.add(new HideNeiAction("blockAluminum", new ItemStack(TinkerWorld.metalBlock, 1, 6)));
		
		//hide non-TF nuggets
		this.itemActions.add(new HideNeiAction("nuggetCopper", TFItems.nuggetCopper, new ItemStack(TinkerWorld.oreBerries, 1, 2)));
		this.itemActions.add(new HideNeiAction("nuggetTin", TFItems.nuggetTin, new ItemStack(TinkerWorld.oreBerries, 1, 3)));
		this.itemActions.add(new HideNeiAction("nuggetBronze", TFItems.nuggetBronze));
		this.itemActions.add(new HideNeiAction("nuggetLead", TFItems.nuggetLead));
		this.itemActions.add(new HideNeiAction("nuggetSilver", TFItems.nuggetSilver));
		this.itemActions.add(new HideNeiAction("nuggetIron", TFItems.nuggetIron, new ItemStack(TinkerWorld.oreBerries, 1, 0)));
	}
}
