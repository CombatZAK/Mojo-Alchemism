package com.mods.combatzak.mojo.alchemism.items;

import cofh.thermalfoundation.ThermalFoundation;

import com.mods.combatzak.mojo.MojoItem;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class AlchemismItems {
	/**
	 * Impure Steel Blend
	 */
	public static MojoItem dustSteel = new MojoItem("dustSteel", ThermalFoundation.tabCommon, 64, "High-carbon and impurity content;\nrequires high-temperature flux for blasting", "alchemism:dustSteel");
	
	/**
	 * Registers the items with the game
	 */
	public static void registerItems() {
		GameRegistry.registerItem(dustSteel, dustSteel.getItemId());
	}
}
