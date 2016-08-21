package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.block.dynamo.TileDynamoSteam;
import net.minecraft.item.ItemStack;

/**
 * Support for TE4 steam dynamo
 * 
 * @author zhess
 *
 */
public class SteamDynamoFuelTooltipHelper extends DynamoFuelTooltipHelper {
	/**
	 * Gets the fuel tooltips for the TE4 steam dynamo
	 */
	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //give up on empty target
		
		Integer power = TileDynamoSteam.getEnergyValue(target);
		if (power == 0) return null; //give up if the item can't be burned
		
		List<String> result = new ArrayList<String>();
		result.add("§7" + getMetric((long)power) + "RF (Steam Dynamo)§r");
		
		return result;
	}

}
