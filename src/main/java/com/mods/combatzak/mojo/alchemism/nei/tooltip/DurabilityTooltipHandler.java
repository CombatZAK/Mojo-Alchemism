package com.mods.combatzak.mojo.alchemism.nei.tooltip;

import java.util.ArrayList;
import java.util.List;

import tconstruct.library.tools.ToolCore;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.guihook.IContainerTooltipHandler;

/**
 * Adds item durability for most tools and armor as a tooltip
 * 
 * @author CombatZAK
 *
 */
public class DurabilityTooltipHandler implements IContainerTooltipHandler {
	/**
	 * Not used by this class
	 */
	@Override
	public List<String> handleItemDisplayName(GuiContainer gui, ItemStack itemstack, List<String> currenttip) {
		return currenttip;
	}

	/**
	 * Adds durability if the item is damageable
	 */
	@Override
	public List<String> handleItemTooltip(GuiContainer gui, ItemStack itemstack, int mousex, int mousey, List<String> currenttip) {
		if (itemstack == null) return currenttip; //null test the item stack
		if (!itemstack.isItemStackDamageable()) return currenttip; //quit if cannot damage item
		if (itemstack.getItem() instanceof ToolCore) return currenttip; //don't bother with TConstruct stuff
		
		//this one is a bit hackish but we don't need a durability tooltip if the item already has one..
		for (String tip : currenttip) {
			if (tip == null || tip.equals("")) continue; //skip any empty tips
			if (tip.toLowerCase().contains("durability") && tip.contains("/")) return currenttip; //hacky check
		}
		
		if (currenttip == null) currenttip = new ArrayList<String>(); //initialize if necessary
		int currentDurability = itemstack.getMaxDamage() - itemstack.getItemDamage(); //get the current durability
		int maxDurability = itemstack.getMaxDamage(); //get the max durability
		currenttip.add("§8Durability: " + currentDurability + "/" + maxDurability + "§r"); //add the tooltip line
		
		return currenttip;
	}

	/**
	 * Not used by this class
	 */
	@Override
	public List<String> handleTooltip(GuiContainer gui, int mousex, int mousey, List<String> currenttip) {
		return currenttip;
	}

}
