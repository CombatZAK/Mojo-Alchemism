package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorEnder;

import net.minecraft.item.ItemStack;

public class EnderGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //skip null args
		
		TileEntityGeneratorEnder generator = new TileEntityGeneratorEnder();
		int power = (int)(generator.genLevel() * generator.getFuelBurn(target));
		
		if (power == 0) return null; //not a fuel
		List<String> result = new ArrayList<String>();
		result.add("§3" + getMetric((long) power) + "RF (Ender Generator)§r");
		
		return result;
	}

}
