package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.block.dynamo.TileDynamoReactant;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class ReactantDynamoFuelTooltipHelper extends DynamoFuelTooltipHelper {
	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //don't look at null stacks
		
		List<String> result = new ArrayList<String>();
		String reactantTip = getReactantTip(target);
		String fuelTip = getFuelTip(target);
		
		if (reactantTip != null) result.add(reactantTip);
		if (fuelTip != null) result.add(fuelTip);
		
		return result;
	}
	
	/**
	 * Gets the energy value of an item as a reactant
	 * 
	 * @param target item to check
	 * @return energy value tip
	 */
	private String getReactantTip(ItemStack target) {
		if (target == null) return null; //don't deal with null args
		int power = TileDynamoReactant.getReactantEnergy(target); //get the power value for the item
		
		if (power == 0) return null; //test for no hit
		return ("§e" + getMetric((long)power) + "RF (Reactant Dynamo reactant)§r");
	}
	
	/**
	 * Gets the energy value of an item as a fuel
	 * 
	 * @param target item to check
	 * @return energy value tip
	 */
	private String getFuelTip(ItemStack target) {
		if (target == null) return null; //don' deal with null args
		if (!(target.getItem() instanceof IFluidContainerItem)) return null; //give up if not a liquid container
		
		IFluidContainerItem container = (IFluidContainerItem)target.getItem(); //get the container
		FluidStack fluid = container.getFluid(target); //get the fluid from the container
		int energyValue = TileDynamoReactant.getFuelEnergy(fluid); //get the energy value of the fluid per 50mB
		
		if (energyValue == 0) return null; //not a reactant fuel
		int power = energyValue * fluid.amount / 50; //get the power available by amount
		
		return "§2" + getMetric((long)power) + "RF (Reactant Dynamo fuel)§r";
	}
}
