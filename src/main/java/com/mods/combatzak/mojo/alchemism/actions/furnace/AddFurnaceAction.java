package com.mods.combatzak.mojo.alchemism.actions.furnace;

import java.util.List;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AddFurnaceAction extends FurnaceAction {
	
	/**
	 * Creates a new AddFurnaceAction instance
	 * 
	 * @param input furnace input
	 * @param output furnace output
	 * @param experience experience reward
	 */
	public AddFurnaceAction(IIngredient input, ItemStack output, float experience) {
		super(input, output, experience);
	}
	
	/**
	 * Creates a new AddFurnaceAction instance
	 * 
	 * @param input furnace input
	 * @param output furnace output
	 */
	public AddFurnaceAction(IIngredient input, ItemStack output) {
		this(input, output, 0f);
	}
	
	/**
	 * Default constructor
	 */
	public AddFurnaceAction() {
		this(null, null, 0f);
	}
	
	/**
	 * Applies the action by adding registering a vanilla furnace recipe; if a recipe for the input already exists, it will be replaced
	 */
	@Override
	public boolean apply() throws IllegalStateException, UnsupportedOperationException {
		//check input and output
		if (input == null) throw new IllegalStateException("Cannot add recipe without input");
		if (output == null) throw new IllegalStateException("Cannot add recipe without output");
		
		if (input instanceof ItemIngredient) { //if the input is a single item...
			GameRegistry.addSmelting((ItemStack)input.getIngredient(), output, experience); //register the recipe
		}
		else if (input instanceof OreIngredient) { //otherwise, if the input is an ore dictionary entry...
			List<ItemStack> entryList = OreDictionary.getOres((String)input.getIngredient(), false);
			if (entryList == null || entryList.isEmpty())
				throw new IllegalStateException("Cannot add recipe with empty ore dictionary entry"); //handle empty oredict entry
			
			for (ItemStack dictItem : entryList) { //go through all the items in the entry list
				GameRegistry.addSmelting(dictItem, output, experience); //register each recipe individually
			}
		}
		else throw new UnsupportedOperationException("Input type not recognized");
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
}
