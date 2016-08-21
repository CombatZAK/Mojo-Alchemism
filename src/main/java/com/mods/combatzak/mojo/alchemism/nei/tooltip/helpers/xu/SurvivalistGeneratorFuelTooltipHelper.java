package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorFurnaceSurvival;

import net.minecraft.item.ItemStack;

public class SurvivalistGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //ignore null args
		
		TileEntityGeneratorFurnaceSurvival generator = new TileEntityGeneratorFurnaceSurvival(); //dummy generator to extract data
		int power = (int)(generator.genLevel() * generator.getFuelBurn(target)); //calculate the power potential
		
		if (power == 0) return null; //invalid fuel
		
		List<String> result = new ArrayList<String>();
		result.add("§8" + getMetric((long)power) + "RF (Survivalist Generator)§r");
		
		return result;
	}

}
