package com.mods.combatzak.mojo.alchemism.updates;

import ic2.core.Ic2Items;
import mods.railcraft.common.items.ItemIngot;
import mods.railcraft.common.items.ItemIngot.EnumIngot;
import net.minecraft.item.ItemStack;
import tconstruct.tools.TinkerTools;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.furnace.ReplaceFurnaceAction;

public class RedstoneFurnaceUpdates {
	/**
	 * Stores the redstone furnace update actions
	 */
	private GroupAction furnaceActions = new GroupAction();
	
	/**
	 * Stores the singleton instance
	 */
	private static RedstoneFurnaceUpdates instance = new RedstoneFurnaceUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return RedstoneFurnaceUpdates singleton
	 */
	public static RedstoneFurnaceUpdates getInstance() {
		return instance;
	}
	
	public void register() {
		this.furnaceActions.apply();
	}
	
	public RedstoneFurnaceUpdates() {
		//unify ingot smelting
		this.furnaceActions.add(new ReplaceFurnaceAction(TFItems.ingotCopper, TFItems.ingotCopper));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFItems.ingotTin, TFItems.ingotTin));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFItems.ingotBronze, TFItems.ingotBronze));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFItems.ingotSilver, TFItems.ingotSilver));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFItems.ingotLead, TFItems.ingotLead));
		this.furnaceActions.add(new ReplaceFurnaceAction(new ItemStack(TinkerTools.materials, 1, 11), new ItemStack(TinkerTools.materials, 1, 11))); //aluminum
		this.furnaceActions.add(new ReplaceFurnaceAction(Ic2Items.advIronIngot, ItemIngot.getIngot(EnumIngot.STEEL)));
		
		//unify ore smelting
		this.furnaceActions.add(new ReplaceFurnaceAction(TFBlocks.blockOre.oreCopper, TFBlocks.blockOre.oreCopper));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFBlocks.blockOre.oreTin, TFBlocks.blockOre.oreTin));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFBlocks.blockOre.oreSilver, TFBlocks.blockOre.oreSilver));
		this.furnaceActions.add(new ReplaceFurnaceAction(TFBlocks.blockOre.oreLead, TFBlocks.blockOre.oreLead));
	}
}
