package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import appeng.items.materials.MaterialType;
import cofh.thermalfoundation.fluid.TFFluids;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.transposer.AddTransposerAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.transposer.TransposerAction.TransposerMode;

/**
 * Manages updates to TE4 Fluidic Transposer
 * 
 * @author CombatZAK
 *
 */
public class TransposerUpdates {
	/**
	 * Stores updates to fluidic transposer recipes
	 */
	private GroupAction transposerActions = new GroupAction();
	
	/**
	 * Singleton TransposerUpdates instance
	 */
	private static TransposerUpdates instance = new TransposerUpdates();
	
	/**
	 * Gets the static singleton
	 * 
	 * @return singleton
	 */
	public static TransposerUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the updates to the Fluidic Transposer
	 */
	public void register() {
		if (!this.transposerActions.getIsApplied())
			this.transposerActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private TransposerUpdates() {
		//add recipe for AE silicon
		this.transposerActions.add(new AddTransposerAction(2400, new ItemStack(Blocks.sand), new FluidStack(TFFluids.fluidRedstone, 200), MaterialType.Silicon.stack(1), TransposerMode.FILL));
	}
}
