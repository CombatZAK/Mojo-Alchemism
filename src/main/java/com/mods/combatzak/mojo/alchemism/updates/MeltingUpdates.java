package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraftforge.fluids.FluidStack;
import cofh.thermalfoundation.fluid.TFFluids;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.melting.RemoveMeltingAction;

/**
 * Registers updates that alter TConstruct Smeltery item melting
 * 
 * @author CombatZAK
 *
 */
public class MeltingUpdates {
	/**
	 * Stores the Smeltering melting updates
	 */
	private GroupAction meltingActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static MeltingUpdates instance = new MeltingUpdates();
	
	/**
	 * Gets the MeltingUpdates singleton
	 * 
	 * @return singleton instance
	 */
	public static MeltingUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Registers the updates to the TConstruct Smeltering Recipes
	 */
	public void register() {
		if (!meltingActions.getIsApplied())
			meltingActions.apply();
	}
	
	/**
	 * Static constructor initializes singleton
	 */
	private MeltingUpdates() {
		this.meltingActions.add(new RemoveMeltingAction(new FluidStack(TFFluids.fluidPyrotheum, 1)));
		this.meltingActions.add(new RemoveMeltingAction(new FluidStack(TFFluids.fluidCoal, 1)));
		this.meltingActions.add(new RemoveMeltingAction(new FluidStack(TFFluids.fluidCryotheum, 1)));
		this.meltingActions.add(new RemoveMeltingAction(new FluidStack(TFFluids.fluidGlowstone, 1)));
	}
}
