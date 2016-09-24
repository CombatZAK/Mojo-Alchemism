package com.mods.combatzak.mojo.alchemism.updates;

import ic2.core.Ic2Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import tconstruct.tools.TinkerTools;
import tconstruct.world.TinkerWorld;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import vazkii.botania.common.item.ModItems;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import mods.railcraft.common.items.ItemIngot.EnumIngot;
import mods.railcraft.common.items.ItemNugget;
import mods.railcraft.common.items.Metal;
import mods.railcraft.common.items.ItemNugget.EnumNugget;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import powercrystals.netherores.ores.Ores;
import appeng.items.materials.MaterialType;
import binnie.extrabees.core.ExtraBeeItems;
import binnie.genetics.item.ItemRegistry;
import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.api.content.BOPCItems;
import buildcraft.BuildCraftCore;
import ckathode.weaponmod.BalkonsWeaponMod;
import cofh.thermalexpansion.item.TEItems;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.crafting.AddShapedAction;
import com.mods.combatzak.mojo.alchemism.actions.crafting.AddShapedEnchantmentAction;
import com.mods.combatzak.mojo.alchemism.actions.crafting.AddShapelessAction;
import com.mods.combatzak.mojo.alchemism.actions.crafting.CraftingAction;
import com.mods.combatzak.mojo.alchemism.actions.crafting.RemoveRecipesAction;
import com.mods.combatzak.mojo.alchemism.items.AlchemismItems;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ShapedItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ShapedOreIngredient;

import forestry.core.blocks.BlockResourceStorage.ResourceType;
import forestry.core.items.ItemRegistryCore;
import forestry.plugins.PluginCore;
import galaxyspace.SolarSystem.core.registers.blocks.GSBlocks;
import galaxyspace.SolarSystem.core.registers.items.GSItems;
import ganymedes01.aobd.ore.Ore;
import ganymedes01.aobd.recipes.RecipesModule;
import mods.railcraft.common.items.ItemIngot;
import mrtjp.projectred.ProjectRedCore;
import mrtjp.projectred.ProjectRedExploration;
import mrtjp.projectred.core.PartDefs;
import mrtjp.projectred.exploration.DecorativeStoneDefs;

public class CraftingUpdates {
	/**
	 * Stores the recipe update actions
	 */
	private GroupAction recipeActions = new GroupAction();
	
	/**
	 * Singleton instance of the class
	 */
	private static CraftingUpdates instance = new CraftingUpdates();
	
	/**
	 * Gets the Crafting Updates singleton
	 * 
	 * @return single crafting updates instance
	 */
	public static CraftingUpdates getInstance() { return instance; }
	
	/**
	 * Registers updates to the basic crafting system 
	 */
	public void register() {
		if (!recipeActions.getIsApplied()) recipeActions.apply();
	}
	
	/**
	 * Default constructor
	 */
	private CraftingUpdates() {
		//deletion of BOP sapphire/ruby/peridot/amber gems/blocks
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCItems.gems, 1, 2)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCItems.gems, 1, 6)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCItems.gems, 1, 1)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCItems.gems, 1, 7)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCBlocks.gemOre, 1, 5)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCBlocks.gemOre, 1, 13)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCBlocks.gemOre, 1, 3)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BOPCBlocks.gemOre, 1, 15)));
		
		//replace some crafting recipes for sapphire/ruby/peridot/amber gems/blocks
		recipeActions.add(new AddShapelessAction(Arrays.asList(new IIngredient[] { 
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
					new ItemIngredient(ExtraBeeItems.SapphireShard.get(1)),
				}), 
				new ItemStack(ProjectRedCore.itemPart(), 1, 38)));
		
		recipeActions.add(new AddShapelessAction(Arrays.asList(new IIngredient[] {
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
				new ItemIngredient(ExtraBeeItems.RubyShard.get(1)),
			}),
			new ItemStack(ProjectRedCore.itemPart(), 1, 37)));
		
		
		//deletion of forestry metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(PluginCore.items.ingotCopper.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(PluginCore.items.ingotTin.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(PluginCore.items.ingotBronze.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(PluginCore.blocks.resourceStorage.get(ResourceType.COPPER)));
		recipeActions.add(new RemoveRecipesAction(PluginCore.blocks.resourceStorage.get(ResourceType.TIN)));
		recipeActions.add(new RemoveRecipesAction(PluginCore.blocks.resourceStorage.get(ResourceType.BRONZE)));
		recipeActions.addAll(getPyrotheumRecipes());
		
		//deletion of TConstruct metal nuggets/ingots/blocks
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 19))); //iron nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 20))); //copper nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 21))); //tin nugget
		//recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 22))); //aluminum nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 31))); //bronze nugget
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 9)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 10)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 13)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerWorld.metalBlock, 1, 3)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerWorld.metalBlock, 1, 4)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerWorld.metalBlock, 1, 5)));
		
		//deletion of Galacticraft metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCItems.basicItem, 1, 3))); //copper
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCItems.basicItem, 1, 4))); //tin
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCItems.basicItem, 1, 5))); //aluminum
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCBlocks.basicBlock, 1, 9))); //copper
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCBlocks.basicBlock, 1, 10))); //tin
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GCBlocks.basicBlock, 1, 11))); //aluminum
		
		//deletion of IC2 metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(Ic2Items.copperIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.tinIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.bronzeIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.silverIngot));
		recipeActions.add(new RemoveRecipesAction(Ic2Items.leadIngot));
		
		//deletion of Railcraft metal ingots/blocks
		recipeActions.add(new RemoveRecipesAction(Metal.COPPER.getNugget()));
		recipeActions.add(new RemoveRecipesAction(Metal.IRON.getNugget()));
		recipeActions.add(new RemoveRecipesAction(Metal.TIN.getNugget()));
		recipeActions.add(new RemoveRecipesAction(Metal.LEAD.getNugget()));
		recipeActions.add(new RemoveRecipesAction(Metal.COPPER.getIngot()));
		recipeActions.add(new RemoveRecipesAction(Metal.LEAD.getIngot()));
		recipeActions.add(new RemoveRecipesAction(Metal.TIN.getIngot()));
		
		//deletion of ProjectRed ingots/blocks
		recipeActions.add(new RemoveRecipesAction(PartDefs.COPPERINGOT().makeStack()));
		recipeActions.add(new RemoveRecipesAction(PartDefs.TININGOT().makeStack()));
		recipeActions.add(new RemoveRecipesAction(PartDefs.SILVERINGOT().makeStack()));
		recipeActions.add(new RemoveRecipesAction(DecorativeStoneDefs.COPPERBLOCK().makeStack()));
		recipeActions.add(new RemoveRecipesAction(DecorativeStoneDefs.TINBLOCK().makeStack()));
		recipeActions.add(new RemoveRecipesAction(DecorativeStoneDefs.SILVERBLOCK().makeStack()));
		
		//deletion of Thaumcraft metal nuggets
		recipeActions.add(new RemoveRecipesAction(ItemApi.getItem("itemNugget", 0))); //iron nugget
		recipeActions.add(new RemoveRecipesAction(ItemApi.getItem("itemNugget", 1))); //copper nugget
		recipeActions.add(new RemoveRecipesAction(ItemApi.getItem("itemNugget", 2))); //tin nugget
		recipeActions.add(new RemoveRecipesAction(ItemApi.getItem("itemNugget", 3))); //silver nugget
		recipeActions.add(new RemoveRecipesAction(ItemApi.getItem("itemNugget", 4))); //lead nugget
		
		//deletion of unbalanced gear recipes
		recipeActions.add(new RemoveRecipesAction(PluginCore.items.gearCopper.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(PluginCore.items.gearTin.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(PluginCore.items.gearBronze.getItemStack()));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BuildCraftCore.ironGearItem)));
		
		//deletion of galaxyspace lead armor
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GSItems.LeadHelmet)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GSItems.LeadPlate)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GSItems.LeadLeg)));
		recipeActions.add(new RemoveRecipesAction(new ItemStack(GSItems.LeadBattery)));
		
		//deletion of AOBD metioric iron recipe
		recipeActions.add(new RemoveRecipesAction(RecipesModule.getOreStack("block", getMeteoricIronAOBDOre())));
		
		//remove all "decorate blocks" from crafting
		for (int idx = 0; idx <= 9; idx++) recipeActions.add(new RemoveRecipesAction(new ItemStack(GSBlocks.MetalsBlock, 1, idx)));
		recipeActions.addAll(getDecorateBlockRecipes());
		
		
		//deletion of TConstruct silky jewel and mossball
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 6))); //mossball
		recipeActions.add(new RemoveRecipesAction(new ItemStack(TinkerTools.materials, 1, 26))); //silky jewel
		recipeActions.add(addSilkyJewelRecipe());
		recipeActions.addAll(addMossballRecipes());
		
		recipeActions.add(getSteelDustRecipe());
		recipeActions.add(getUraniumBlockRecipe());
		
		//replace Musket Shot with lead
		recipeActions.add(new RemoveRecipesAction(new ItemStack(BalkonsWeaponMod.musketBullet)));
		recipeActions.add(addMusketShotRecipe());
		
		//add some shapeless silicon recipes
		recipeActions.addAll(getSiliconRecipes());
		
		//add a recipe to craft aluminum ingots from ore dict nuggets
		recipeActions.add(getAluminumIngotRecipe());
	}
	
	private List<AddShapedAction> getDecorateBlockRecipes() {
		List<AddShapedAction> result = new ArrayList<AddShapedAction>();
		
		ShapedOreIngredient stoneIngredient = new ShapedOreIngredient("stone", 's');
		String[] ingotNames = new String[] {"CompressedLead", "CompressedAdamantite", "CompressedCobaltum", "CompressedMagnesium", "CompressedMithril", "CompressedNickel", "CompressedOriharukon", "CompressedPlatinum", "CompressedWolframium", "compressedCopper" };
		for (int i = 0; i < ingotNames.length; i++) {
			if (i != 8) result.add(new AddShapedAction(Arrays.asList(new IIngredient[] { stoneIngredient, new ShapedOreIngredient(ingotNames[i], 'i') }), new ItemStack(GSBlocks.MetalsBlock, 4, i), new String[] { "si" }));
			else result.add(new AddShapedAction(Arrays.asList(new IIngredient[] { stoneIngredient, new ShapedItemIngredient(new ItemStack(GSItems.CompressedPlates, 1, 9), 'i') }), new ItemStack(GSBlocks.MetalsBlock, 4, 8), new String[] { "si" }));
		}
		
		return result;
	}
	
	private CraftingAction addSilkyJewelRecipe() {
		ItemStack silkTouchBook = new ItemStack(Items.enchanted_book);
		silkTouchBook.addEnchantment(Enchantment.silkTouch, 1);
		
		ArrayList<IIngredient> ingredients = new ArrayList<IIngredient>();
		ingredients.add(new ShapedItemIngredient(silkTouchBook, 'a'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(TinkerTools.materials, 1, 25), 'b'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(Items.diamond), 'c'));
		
		AddShapedEnchantmentAction result = new AddShapedEnchantmentAction(ingredients, new ItemStack(TinkerTools.materials, 1, 26), new String[] { "ab ", "bcb", " ba" });
		return result;
	}
	
	private ArrayList<CraftingAction> addMossballRecipes() {
		ArrayList<CraftingAction> result = new ArrayList<CraftingAction>();
		
		ItemStack repairBook = new ItemStack(Items.enchanted_book);
		repairBook.addEnchantment(Enchantment.enchantmentsList[ThaumcraftApi.enchantRepair], 1);
		
		ArrayList<IIngredient> ingredients = new ArrayList<IIngredient>();
		ingredients.add(new ShapedItemIngredient(repairBook, 'a'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(ModItems.vineBall), 'b'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(TEItems.itemMaterial, 1, 517), 'c'));
		ingredients.add(new ShapedItemIngredient(new ItemStack(Items.diamond), 'd'));
		
		ItemStack mossball = new ItemStack(TinkerTools.materials, 1, 6);
		result.add(new AddShapedEnchantmentAction(ingredients, mossball, new String[] { "ab ", "cdc", " ba" }));
		result.add(new AddShapedEnchantmentAction(ingredients, mossball, new String[] { "ac ", "bdb", " ca" }));
		
		return result;
	}
	
	/**
	 * Gets a set of any pyrotheum recipes removed as part of the crafting unification
	 * 
	 * @return shapeless pyrotheum recipes
	 */
	private static List<AddShapelessAction> getPyrotheumRecipes() {
		List<AddShapelessAction> result = new ArrayList<AddShapelessAction>();
		List<IIngredient> inputs = new ArrayList<IIngredient>();
		inputs.add(new OreIngredient("oreCopper"));
		inputs.add(new ItemIngredient(TFItems.dustPyrotheum));
		result.add(new AddShapelessAction(inputs, TFItems.ingotCopper));
		
		inputs = new ArrayList<IIngredient>();
		inputs.add(new OreIngredient("oreTin"));
		inputs.add(new ItemIngredient(TFItems.dustPyrotheum));
		result.add(new AddShapelessAction(inputs, TFItems.ingotTin));
		
		inputs = new ArrayList<IIngredient>();
		inputs.add(new OreIngredient("oreLead"));
		inputs.add(new ItemIngredient(TFItems.dustPyrotheum));
		result.add(new AddShapelessAction(inputs, TFItems.ingotLead));
		
		inputs = new ArrayList<IIngredient>();
		inputs.add(new OreIngredient("oreSilver"));
		inputs.add(new ItemIngredient(TFItems.dustPyrotheum));
		result.add(new AddShapelessAction(inputs, TFItems.ingotSilver));
		
		return result;
	}
	
	/**
	 * Gets a shapeless recipe for making steel precursor dust
	 * 
	 * @return shapeless recipe for making unblasted steel dust
	 */
	private static AddShapelessAction getSteelDustRecipe() {
		List<IIngredient> inputs = new ArrayList<IIngredient>();
		inputs.add(new OreIngredient("dustIron"));
		OreIngredient dustCharcoal = new OreIngredient("dustCharcoal");
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		inputs.add(dustCharcoal);
		
		return new AddShapelessAction(inputs, new ItemStack(AlchemismItems.dustSteel));
	}
	
	/**
	 * Gets a shapeless recipe for making uranium blocks from U235
	 * 
	 * @return shapless recipe for making U-blocks
	 */
	private static AddShapelessAction getUraniumBlockRecipe() {
		List<IIngredient> inputs = new ArrayList<IIngredient>();
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		inputs.add(new ItemIngredient(Ic2Items.Uran238));
		
		return new AddShapelessAction(inputs, Ic2Items.uraniumBlock);
	}
	
	private static AddShapedAction addMusketShotRecipe() {
		List<IIngredient> inputs = new ArrayList<IIngredient>();
		inputs.add(new ShapedOreIngredient("ingotLead", 'l'));
		inputs.add(new ShapedItemIngredient(new ItemStack(Items.gunpowder), 'g'));
		inputs.add(new ShapedItemIngredient(new ItemStack(Items.paper), 'p'));
		
		return new AddShapedAction(inputs, new ItemStack(BalkonsWeaponMod.musketBullet, 8), new String[] { "l", "g", "p" });
	}
	
	private static List<AddShapelessAction> getSiliconRecipes() {
		List<AddShapelessAction> result = new ArrayList<AddShapelessAction>();
		
		List<IIngredient> inputs = new ArrayList<IIngredient>();
		inputs.add(new ItemIngredient(TFItems.dustBasalz));
		inputs.add(new OreIngredient("sand"));
		result.add(new AddShapelessAction(inputs, MaterialType.Silicon.stack(1)));
		
		inputs = new ArrayList<IIngredient>();
		inputs.add(new ItemIngredient(TFItems.dustBlitz));
		inputs.add(new OreIngredient("dustObsidian"));
		result.add(new AddShapelessAction(inputs, MaterialType.Silicon.stack(1)));
		
		return result;
	}
	
	/**
	 * Creates a shapeless recipe for aluminum ingots from nuggets (ore dict)
	 * 
	 * @return action to create shapeless recipe
	 */
	private static AddShapelessAction getAluminumIngotRecipe() {
		ItemStack output = new ItemStack(TinkerTools.materials, 1, 11);
		IIngredient input = new OreIngredient("nuggetAluminium"); //use IEEE name
	
		return new AddShapelessAction(Arrays.asList(new IIngredient[] { input, input, input, input, input, input, input, input, input }), output);
	}
	
	private Ore getMeteoricIronAOBDOre() {
		for (Ore ore : Ore.ores) {
			if (ore.name().equals("MeteoricIron")) return ore;
		}
		
		return null;
	}
}
