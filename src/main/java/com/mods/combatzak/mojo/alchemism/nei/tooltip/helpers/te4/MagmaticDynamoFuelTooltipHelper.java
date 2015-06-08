package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.block.dynamo.TileDynamoMagmatic;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

/**
 * Supports fuel tooltips for TE4 magmatic dynamo
 * 
 * @author zhess
 *
 */
public class MagmaticDynamoFuelTooltipHelper extends DynamoFuelTooltipHelper {
	/**
	 * Gets the fuel tooltips for the TE4 Magmatic Dynamo
	 */
	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //give up for null target
		if (!(target.getItem() instanceof IFluidContainerItem)) return null; //give up if not a container
		
		IFluidContainerItem container = (IFluidContainerItem)target.getItem(); //get the container
		FluidStack fluid = container.getFluid(target); //get the fluid
		
		int energyValue = TileDynamoMagmatic.getFuelEnergy(fluid); //energy output per 50mb
		if (energyValue == 0) return null; //not a fuel
		int power = energyValue * fluid.amount / 50; //calculate power available in container

		List<String> result = new ArrayList<String>();
		
		result.add("§c" + getMetric((long)power) + "RF (Magmatic Dynamo)§r");
		return result;
	}
}
