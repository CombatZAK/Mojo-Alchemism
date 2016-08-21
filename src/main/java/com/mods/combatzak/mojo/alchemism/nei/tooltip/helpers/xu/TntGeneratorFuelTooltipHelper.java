package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorTNT;

import net.minecraft.item.ItemStack;

public class TntGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null;
		
		TileEntityGeneratorTNT generator = new TileEntityGeneratorTNT();
		int power = (int)(generator.genLevel() * generator.getFuelBurn(target));
		
		if (power == 0) return null;
		List<String> result = new ArrayList<String>();
		result.add("§e" + getMetric((long)power) + "RF (TNT Generator)§r");
		
		return result;
	}

}
