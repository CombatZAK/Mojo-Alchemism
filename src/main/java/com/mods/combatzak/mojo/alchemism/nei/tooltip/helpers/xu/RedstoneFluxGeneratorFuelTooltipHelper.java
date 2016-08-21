package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.xu;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalfoundation.fluid.TFFluids;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RedstoneFluxGeneratorFuelTooltipHelper extends GeneratorFuelTooltipHelper {
	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null;

		int power = 0;
		if (target.getItem() == Items.redstone) {
			power = 25000;
		}
		else {
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(target);
			if (fluid == null) return null;
			if (fluid.getFluid() != FluidRegistry.LAVA && fluid.getFluid() != TFFluids.fluidRedstone) return null;
			
			power = fluid.amount * 200;
		}
		
		List<String> result = new ArrayList<String>();
		result.add("§4" + getMetric((long)power) + "RF (Heated Redstone Generator)§r");
		return result;
	}
}
