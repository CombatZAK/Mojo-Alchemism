package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import appeng.items.materials.MaterialType;
import cofh.thermalfoundation.fluid.TFFluids;
import cofh.thermalfoundation.item.TFItems;
import lc.LCRuntime;
import lc.items.ItemCraftingReagent;

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
	private static ItemStack blankCrystal = new ItemStack(LCRuntime.runtime.items().lanteaCraftingItem.getItem(), 1, ItemCraftingReagent.ReagentList.BLANKCRYSTAL.ordinal());
	private static ItemStack coreCrystal = new ItemStack(LCRuntime.runtime.items().lanteaCraftingItem.getItem(), 1, ItemCraftingReagent.ReagentList.CORECRYSTAL.ordinal());
	private static ItemStack controlCrystal = new ItemStack(LCRuntime.runtime.items().lanteaCraftingItem.getItem(), 1, ItemCraftingReagent.ReagentList.CONTROLCRYSTAL.ordinal());
	
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
		this.transposerActions.add(new AddTransposerAction(2400, new ItemStack(Blocks.sand), new FluidStack(TFFluids.fluidPetrotheum, 50), MaterialType.Silicon.stack(1), TransposerMode.FILL));
		this.transposerActions.add(new AddTransposerAction(2400, TFItems.dustObsidian, new FluidStack(TFFluids.fluidAerotheum, 50), MaterialType.Silicon.stack(1), TransposerMode.FILL));
		
		this.transposerActions.add(new AddTransposerAction(9600, MaterialType.FluixDust.stack(1), new FluidStack(TFFluids.fluidCryotheum, 1000), blankCrystal, TransposerMode.FILL));
		this.transposerActions.add(new AddTransposerAction(8000, blankCrystal, new FluidStack(TFFluids.fluidRedstone, 1000), controlCrystal, TransposerMode.FILL));
		this.transposerActions.add(new AddTransposerAction(8000, blankCrystal, new FluidStack(TFFluids.fluidEnder, 1000), coreCrystal, TransposerMode.FILL));
	}
}
