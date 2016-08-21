package com.mods.combatzak.mojo.alchemism.updates;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import tconstruct.tools.TinkerTools;
import thaumcraft.api.ItemApi;
import mods.railcraft.common.items.ItemIngot;
import mods.railcraft.common.items.ItemIngot.EnumIngot;
import mods.railcraft.common.items.Metal;
import mrtjp.projectred.ProjectRedExploration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringTranslate;
import cofh.thermalfoundation.block.TFBlocks;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.furnace.ReplaceFurnaceAction;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

public class FurnaceUpdates {
	/**
	 * Stores updates to furnance
	 */
	private GroupAction furnaceActions = new GroupAction(); //stores updates to furnace
	
	/**
	 * Singleton
	 */
	private static FurnaceUpdates instance = new FurnaceUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return FurnaceUpdates singleton
	 */
	public static FurnaceUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies all updates to furnace
	 */
	public void register() {
		if (!furnaceActions.getIsApplied()) furnaceActions.apply();
	}
	
	/**
	 * Default constructor initializes singleton
	 */
	private FurnaceUpdates() {
		//replace furnace recipes that produce any form of ingot or ore with TF variants
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotCopper"), TFItems.ingotCopper));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotTin"), TFItems.ingotTin));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotBronze"), TFItems.ingotBronze));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotSilver"), TFItems.ingotSilver));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotLead"), TFItems.ingotLead));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreCopper"), TFBlocks.blockOre.oreCopper));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreTin"), TFBlocks.blockOre.oreTin));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreSilver"), TFBlocks.blockOre.oreSilver));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreLead"), TFBlocks.blockOre.oreLead));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotAluminum"), new ItemStack(TinkerTools.materials, 1, 11)));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotSteel"), Metal.STEEL.getIngot()));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreAmber"), ItemApi.getBlock("blockCustomOre", 7)));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("orePeridot"), new ItemStack(ProjectRedExploration.blockOres(), 1, 2)));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreSapphire"), new ItemStack(ProjectRedExploration.blockOres(), 1, 1)));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("oreSapphire"), new ItemStack(ProjectRedExploration.blockOres(), 1, 0)));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotPlatinum"), TFItems.ingotPlatinum));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotMithril"), TFItems.ingotMithril));
		furnaceActions.add(new ReplaceFurnaceAction(new OreIngredient("ingotNickel"), TFItems.ingotNickel));
	}
}
