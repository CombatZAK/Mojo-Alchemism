package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorNether;

import net.minecraft.item.ItemStack;

public class NetherGeneratorFuelTooltipHelper extends
		GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null;
		
		TileEntityGeneratorNether generator = new TileEntityGeneratorNether();
		long power = (long)(generator.genLevel() * generator.getFuelBurn(target));
		
		if (power == 0) return null;
		List<String> result = new ArrayList<String>();
		result.add("§5" + getMetric(power) + "RF (Nether Star Generator)§r");
		
		return result;
	}

}
