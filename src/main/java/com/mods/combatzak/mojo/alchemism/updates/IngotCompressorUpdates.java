package com.mods.combatzak.mojo.alchemism.updates;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import micdoodle8.mods.galacticraft.core.items.GCItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.gc.compressor.AddShapelessCompressorAction;
import com.mods.combatzak.mojo.alchemism.actions.gc.compressor.CompressorAction;
import com.mods.combatzak.mojo.alchemism.actions.gc.compressor.RemoveCompressorAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

/**
 * Manages updates to the Galacticraft Ingot Compressor
 * 
 * @author CombatZAK
 *
 */
public class IngotCompressorUpdates {
	/**
	 * Stores the ingot compressor update actions
	 */
	private GroupAction compressorActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static IngotCompressorUpdates instance = new IngotCompressorUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return singleton
	 */
	public static IngotCompressorUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Registers all of the compressor updates
	 */
	public void register() {
		if (!this.compressorActions.getIsApplied())
			this.compressorActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private IngotCompressorUpdates() {
		//remove some compressed plates
		this.compressorActions.add(new RemoveCompressorAction(new ItemStack(GCItems.basicItem, 1, 9))); //steel
		this.compressorActions.add(new RemoveCompressorAction(new ItemStack(GCItems.basicItem, 1, 10))); //bronze
		
		//add restrictive recipes for above plates
		this.compressorActions.addAll(getCompressedIngotRecipes());
	}
	
	/**
	 * Creates recipes for the Ingot Compressor
	 * 
	 * @return replacement recipe list
	 */
	private static List<CompressorAction> getCompressedIngotRecipes() {
		List<CompressorAction> result = new ArrayList<CompressorAction>();
		List<IIngredient> inputs;
		for (ItemStack ingot : getOreEntries("ingotSteel")) {
			inputs = new ArrayList<IIngredient>();
			inputs.add(new ItemIngredient(ingot));
			inputs.add(new ItemIngredient(ingot));
			result.add(new AddShapelessCompressorAction(inputs, new ItemStack(GCItems.basicItem, 1, 9)));
		}
		
		for (ItemStack ingot : getOreEntries("ingotBronze")) {
			inputs = new ArrayList<IIngredient>();
			inputs.add(new ItemIngredient(ingot));
			inputs.add(new ItemIngredient(ingot));
			result.add(new AddShapelessCompressorAction(inputs, new ItemStack(GCItems.basicItem, 1, 10)));
		}
		
		return result;
	}
	
	/**
	 * Gets all the entries for a particular dictionary registry
	 * 
	 * @param dict target dictionary registry
	 * @return set of all items in that registry
	 */
	private static List<ItemStack> getOreEntries(String dict) {
		return OreDictionary.getOres(dict, false); //grab the entries from the ore dictionary
	}
}
