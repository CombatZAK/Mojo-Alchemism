package com.mods.combatzak.mojo.alchemism.updates;

import tconstruct.smeltery.TinkerSmeltery;
import net.minecraftforge.fluids.FluidStack;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.alloy.RemoveAlloyAction;

/**
 * Handles updates to alloy mixing in TConstruct smeltery
 * 
 * @author CombatZAK
 *
 */
public class AlloyUpdates {
	/**
	 * Stores the updates to alloy mixing
	 */
	private GroupAction alloyActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static AlloyUpdates instance = new AlloyUpdates();
	
	/**
	 * Gets the singleton AlloyUpdates instance
	 * 
	 * @return singleton
	 */
	public static AlloyUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Registers all the alloy mixing updates
	 */
	public void register() {
		if (!alloyActions.getIsApplied())
			alloyActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private AlloyUpdates() {
		this.alloyActions.add(new RemoveAlloyAction(new FluidStack(TinkerSmeltery.moltenEnderFluid, 1)));
	}
}
