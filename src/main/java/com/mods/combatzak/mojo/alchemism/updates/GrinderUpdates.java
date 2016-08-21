package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.common.config.ConfigItems;
import ic2.core.Ic2Items;
import mrtjp.projectred.ProjectRedCore;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.ae2.grinder.ReplaceGrinderAction;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;

/**
 * Applies updates to the AE2 Quartz grindstone
 * 
 * @author CombatZAK
 *
 */
public class GrinderUpdates {
	/**
	 * Stores the grinder update actions
	 */
	private GroupAction grinderActions = new GroupAction();
	
	/**
	 * singleton instance
	 */
	private static GrinderUpdates instance = new GrinderUpdates();
	
	/**
	 * Gets the singleton
	 * 
	 * @return singleton instance
	 */
	public static GrinderUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies all of the grinder updates
	 */
	public void register() {
		if (!grinderActions.getIsApplied())
			grinderActions.apply();
	}
	
	/**
	 * Private constructor initializes singleton
	 */
	private GrinderUpdates() {
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustCopper"), TFItems.dustCopper));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustTin"), TFItems.dustTin));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustBronze"), TFItems.dustBronze));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustIron"), TFItems.dustIron));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustGold"), TFItems.dustGold));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustSilver"), TFItems.dustSilver));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustLead"), TFItems.dustLead));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustObsidian"), TFItems.dustObsidian));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustCoal"), TFItems.dustCoal));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("dustCharcoal"), TFItems.dustCharcoal));
		this.grinderActions.add(new ReplaceGrinderAction(new ItemIngredient(Ic2Items.diamondDust), new ItemStack(Items.diamond)));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("gemPeridot"), new ItemStack(ProjectRedCore.itemPart(), 1, 39)));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("gemSapphire"), new ItemStack(ProjectRedCore.itemPart(), 1, 38)));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("gemRuby"), new ItemStack(ProjectRedCore.itemPart(), 1, 37)));
		this.grinderActions.add(new ReplaceGrinderAction(new OreIngredient("gemAmber"), new ItemStack(ConfigItems.itemResource, 1, 6)));
	}
}
