package com.mods.combatzak.mojo.alchemism.nei.tooltip.helpers.te4;

import java.util.ArrayList;
import java.util.List;

import cofh.thermalexpansion.block.dynamo.TileDynamoCompression;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

/**
 * Handles fuel tooltips for the TE4 Compression Dynamo
 * 
 * @author CombatZAK
 *
 */
public class CompressionDynamoFuelTooltipHelper extends DynamoFuelTooltipHelper {

	/**
	 * Gets fuel tooltips for the Compression Dynamo
	 */
	@Override
	public List<String> getTooltip(ItemStack target) {
		if (target == null) return null; //skip null args
		if (!(target.getItem() instanceof IFluidContainerItem)) return null; //skip non-fluids
		
		IFluidContainerItem container = (IFluidContainerItem)target.getItem(); //get the fluid container
		FluidStack fluid = container.getFluid(target); //get the fluid
		
		String fuelTip = getFuelTip(fluid);
		String coolantTip = getCoolantTip(fluid);
		
		List<String> result = new ArrayList<String>();
		if (fuelTip != null) result.add(fuelTip);
		if (coolantTip != null) result.add(coolantTip);
		
		return result;
	}
	
	/**
	 * Gets the value of a fluid quantity as fuel
	 * 
	 * @param target fluid to check
	 * @return energy tip
	 */
	private String getFuelTip(FluidStack target) {
		if (target == null) return null; //skip null args
		int energyValue = TileDynamoCompression.getFuelEnergy(target); //get the energy value per 50mB
		
		if (energyValue == 0) return null; //not a valid fuel
		int power = energyValue * target.amount / 50; //calculate power for total fluid
		
		return "§6" + getMetric((long)power) + "RF (Compression Dynamo fuel)§r";
	}
	
	/**
	 * Gets the value of a fluid quantity as coolant
	 * 
	 * @param target fluid to check
	 * @return energy tip
	 */
	private String getCoolantTip(FluidStack target) {
		if (target == null) return null; //skip null args
		int energyValue = TileDynamoCompression.getCoolantEnergy(target); //get the energy value per 50mB
		
		if (energyValue == 0) return null; //not a valid coolant
		int power = energyValue * target.amount / 50; //calculate power based on amount
		
		return "§9" + getMetric((long)power) + "RF (Compression Dynamo coolant)§r";
	}
}
