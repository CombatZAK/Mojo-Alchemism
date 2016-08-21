package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.block.dynamo.TileDynamoEnervation;
import net.minecraft.item.ItemStack;

/**
 * Handles fuel tooltips for TE4 Enervation Dynamo
 * 
 * @author CombatZAK
 *
 */
public class EnervationDynamoFuelTooltipHelper extends DynamoFuelTooltipHelper {

	/**
	 * Gets the value of the an item as a TE4 Enervation Dynamo fuel
	 */
	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //skip null args
		int power = TileDynamoEnervation.getEnergyValue(target); //get the energy according to the dynamo
		
		if (power == 0) return null;
		List<String> result = new ArrayList<String>();
		result.add("§4" + getMetric((long)power) + "RF (Enervation Dynamo)§r");
		
		return result;
	}
}
