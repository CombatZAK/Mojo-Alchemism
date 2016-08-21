package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorFood;

import net.minecraft.item.ItemStack;

public class FoodGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //skip null args
		
		TileEntityGeneratorFood generator = new TileEntityGeneratorFood();
		int power = (int)(generator.genLevel() * generator.getFuelBurn(target));
		
		if (power == 0) return null; //not a fuel
		List<String> result = new ArrayList<String>();
		result.add("§2" + getMetric((long)power) + "RF (Food Generator)§r");
		
		return result;
	}

}
