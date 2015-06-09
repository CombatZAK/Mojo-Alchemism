package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorFurnace;

import net.minecraft.item.ItemStack;

public class FurnaceGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //ignore args
		
		TileEntityGeneratorFurnace generator = new TileEntityGeneratorFurnace(); //get a dummy generator for info extraction
		int power = (int)(generator.genLevel() * generator.getFuelBurn(target));
		
		if (power == 0) return null; //not a fuel
		List<String> result = new ArrayList<String>();
		result.add("§1" + getMetric((long)power) + "RF (Furnace Generator)§r");
		
		return result;
	}

}
