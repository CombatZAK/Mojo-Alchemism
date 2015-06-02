package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.melting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * Removes a melting recipe from the smeltery
 *  
 * @author CombatZAK
 *
 */
public class RemoveMeltingAction extends MeltingAction {
	/**
	 * Creates a new RemoveMeltingAction instance
	 * 
	 * @param input input filter
	 * @param output output filter
	 */
	public RemoveMeltingAction(ItemStack input, FluidStack output) {
		super(input, output, 0);
	}
	
	/**
	 * Creates a new RemoveMeltingActionInstance
	 * 
	 * @param input input filter
	 */
	public RemoveMeltingAction(ItemStack input) {
		this(input, null);
	}
	
	@Override
	public boolean apply() {
		// TODO Auto-generated method stub
		return false;
	}

}
