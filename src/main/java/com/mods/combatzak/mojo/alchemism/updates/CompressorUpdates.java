package com.mods.combatzak.mojo.alchemism.updates;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.ReplaceOutputAction;

import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.TFItems;
import ic2.api.recipe.Recipes;

/**
 * Manages updates to the IC2 compressor
 * 
 * @author zhess
 *
 */
public class CompressorUpdates {
	/**
	 * Stores the updates to the compressor
	 */
	private GroupAction compressorActions = new GroupAction();
	
	/**
	 * Stores the static singleton instance
	 */
	private static CompressorUpdates instance = new CompressorUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return singleton
	 */
	public static CompressorUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the updates if they haven't already been registered
	 */
	public void register() {
		if (!compressorActions.getIsApplied())
			compressorActions.apply();
	}
	
	/**
	 * Private construct initializes singleton
	 */
	private CompressorUpdates() {
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustCopper));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustTin));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustIron));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustGold));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustLead));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustSilver));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustBronze));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.dustObsidian));
		
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.ingotCopper));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.ingotTin));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.ingotLead));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.ingotSilver));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFItems.ingotBronze));
		
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFBlocks.blockStorage.blockCopper));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFBlocks.blockStorage.blockTin));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFBlocks.blockStorage.blockLead));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFBlocks.blockStorage.blockSilver));
		this.compressorActions.add(new ReplaceOutputAction(Recipes.compressor, TFBlocks.blockStorage.blockBronze));
	}
}
