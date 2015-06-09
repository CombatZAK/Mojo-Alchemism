package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorPink;

import net.minecraft.item.ItemStack;

public class PinkGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null;
		
		TileEntityGeneratorPink generator = new TileEntityGeneratorPink();
		int power = (int)(generator.genLevel() * generator.getFuelBurn(target));
		
		if (power == 0) return null;
		List<String> result = new ArrayList<String>();
		result.add("§d" + getMetric((long)power) + "RF (Pink Generator)§r");
		
		return result;
	}

}
