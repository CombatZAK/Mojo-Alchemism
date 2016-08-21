package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import com.rwtema.extrautils.tileentity.generators.TileEntityGeneratorMagma;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class MagmaGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {

	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //ignore null args
		FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(target); //get the fluid in the item
		if (fluid == null || fluid.getFluid() != FluidRegistry.LAVA) return null; //if it doesn't contain lava quit
		
		int power = fluid.amount * 40; //simple calculation
		List<String> result = new ArrayList<String>();
		result.add("§c" + getMetric((long)power) + "RF (Lava Generator)§r");
		return result;
	}

}
