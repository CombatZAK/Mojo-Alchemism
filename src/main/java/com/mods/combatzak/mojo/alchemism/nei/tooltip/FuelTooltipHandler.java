package com.mods.combatzak.mojo.alchemism.nei.tooltip;

import java.util.ArrayList;
import java.util.List;

import com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.IItemTooltipHelper;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4.CompressionDynamoFuelTooltipHelper;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4.EnervationDynamoFuelTooltipHelper;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4.MagmaticDynamoFuelTooltipHelper;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4.ReactantDynamoFuelTooltipHelper;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4.SteamDynamoFuelTooltipHelper;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.guihook.IContainerTooltipHandler;

public class FuelTooltipHandler implements IContainerTooltipHandler {
	/**
	 * Singleton instance
	 */
	private static FuelTooltipHandler instance = new FuelTooltipHandler();
	
	/**
	 *  Stores the helpers that derive fuel tooltips
	 */
	private List<IItemTooltipHelper> itemTooltips = new ArrayList<IItemTooltipHelper>();
	
	/**
	 * Gets the singleton
	 * 
	 * @return singleton
	 */
	public static FuelTooltipHandler getInstance() {
		return instance;
	}
	
	/**
	 * Gets the helpers that derive fuel tooltips
	 * 
	 * @return tooltip helper list
	 */
	public List<IItemTooltipHelper> getItemTooltips() {
		return itemTooltips;
	}
	
	/**
	 * Adds an item tooltip helper to the list
	 * 
	 * @param helper helper to add
	 */
	public void addHelper(IItemTooltipHelper helper) {
		itemTooltips.add(helper);
	}
	
	/**
	 * Adds fuel values to item tooltips where appropraite
	 */
	@Override
	public List<String> handleItemTooltip(GuiContainer gui, ItemStack itemstack, int mousex, int mousey, List<String> currenttip) {
		if (itemstack == null) return currenttip; //ignore null items
		
		boolean found = false;
		for (IItemTooltipHelper helper : itemTooltips) { //go through all the tooltip helpers
			List<String> helperTips = helper.getTooltip(itemstack); //get the tooltips for the highlighted item
			if (helperTips == null || helperTips.size() == 0) continue; //skip if no tips
			if (!found) {
				currenttip.add(""); //add a leading blank
				currenttip.add("CAN PRODUCE:"); //add header
				found = true;
			}
			if (currenttip == null) currenttip = new ArrayList<String>(); //initialize the tooltip list if necessary
			currenttip.addAll(helperTips); //add any found tips
		}
		
		return currenttip;
	}
	
	/**
	 * Not used
	 */
	@Deprecated
	@Override
	public List<String> handleItemDisplayName(GuiContainer gui, ItemStack itemstack, List<String> currenttip) {
		return currenttip;
	}
	
	/**
	 * Not used
	 */
	@Deprecated
	@Override
	public List<String> handleTooltip(GuiContainer gui, int mousex, int mousey, List<String> currenttip) {
		return currenttip;
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private FuelTooltipHandler() {
		this.addHelper(new SteamDynamoFuelTooltipHelper());
		this.addHelper(new CompressionDynamoFuelTooltipHelper());
		this.addHelper(new MagmaticDynamoFuelTooltipHelper());
		this.addHelper(new EnervationDynamoFuelTooltipHelper());
		this.addHelper(new ReactantDynamoFuelTooltipHelper());
	}
}
