package com.mods.combatzak.mojo.alchemism.updates;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.wg.infernalblastactions.ReplaceOutputAction;

import cofh.thermalfoundation.item.TFItems;
import mods.railcraft.common.items.ItemIngot;
import mods.railcraft.common.items.Metal;
import net.minecraft.item.ItemStack;
import tconstruct.tools.TinkerTools;
import mods.railcraft.common.items.ItemIngot.EnumIngot;

/**
 * Manages updates to the Witching Gadgets infernal blast furnace
 * 
 * @author comba
 *
 */
public class InfernalBlastFurnaceUpdates {
	/**
	 * Stores the updates to the blast furnace
	 */
	private GroupAction blastFurnaceUpdates = new GroupAction();
	
	/**
	 * Stores the singleton instance
	 */
	private static InfernalBlastFurnaceUpdates instance = new InfernalBlastFurnaceUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return singleton
	 */
	public static InfernalBlastFurnaceUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the Blast Furnace updates if they're not already regsitered
	 */
	public void register() {
		if (!this.blastFurnaceUpdates.getIsApplied())
			this.blastFurnaceUpdates.apply();
	}
	
	/**
	 * Private construct initializes singleton
	 */
	private InfernalBlastFurnaceUpdates() {
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.ingotCopper));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.ingotTin));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.ingotLead));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.ingotSilver));
		blastFurnaceUpdates.add(new ReplaceOutputAction(new ItemStack(TinkerTools.materials, 1, 11)));
		
		blastFurnaceUpdates.add(new ReplaceOutputAction(ItemIngot.getIngot(EnumIngot.STEEL)));
		blastFurnaceUpdates.add(new ReplaceOutputAction(Metal.STEEL.getBlock()));
		
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.nuggetCopper));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.nuggetTin));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.nuggetIron));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.nuggetLead));
		blastFurnaceUpdates.add(new ReplaceOutputAction(TFItems.nuggetSilver));
		blastFurnaceUpdates.add(new ReplaceOutputAction(new ItemStack(TinkerTools.materials, 1, 22)));
	}
}
