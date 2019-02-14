package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import binnie.extrabees.items.types.ExtraBeeItems;
import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.item.BOPItems;
import blusunrize.immersiveengineering.common.IEContent;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.*;
import com.mods.combatzak.mojo.alchemism.helpers.GCItemsHelper;
import com.mods.combatzak.mojo.alchemism.recipes.EnchantedIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;
import com.progwml6.natura.shared.NaturaCommons;
import com.progwml6.natura.shared.block.clouds.BlockCloud;
import com.rwtema.extrautils2.items.ItemIngredients;
import erogenousbeef.bigreactors.init.BrBlocks;
import erogenousbeef.bigreactors.init.BrItems;
import forestry.arboriculture.ModuleCharcoal;
import forestry.core.ModuleCore;
import ic2.api.item.IC2Items;
import mekanism.common.MekanismBlocks;
import mekanism.common.MekanismItems;
import mekanism.tools.common.ToolsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.shared.TinkerCommons;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;
import com.github.alexthe666.iceandfire.core.ModBlocks;
import com.github.alexthe666.iceandfire.core.ModItems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Manages changes to vanilla crafting recipes
 *
 * Created by CombatZAK on 4/22/2018.
 */
public class CraftingUpdateManager extends UpdateManager {
    private static final IIngredient dustPetrotheum = new ItemIngredient(ItemMaterial.dustPetrotheum);
    private static final IIngredient dustPyrotheum = new ItemIngredient(ItemMaterial.dustPyrotheum);

    private static final IIngredient dustCopper = new OreIngredient("dustCopper");
    private static final IIngredient nuggetCopper = new OreIngredient("nuggetCopper");
    private static final IIngredient ingotCopper = new OreIngredient("ingotCopper");
    private static final IIngredient blockCopper = new OreIngredient("blockCopper");
    private static final IIngredient oreCopper = new OreIngredient("oreCopper");
    private static final IIngredient tinyCopper = new ItemIngredient(IC2Items.getItem("dust", "small_copper"));
    private static final IIngredient beeCopper = new ItemIngredient(ExtraBeeItems.COPPER_DUST.get(1));

    private static final IIngredient dustTin = new OreIngredient("dustTin");
    private static final IIngredient nuggetTin = new OreIngredient("nuggetTin");
    private static final IIngredient ingotTin = new OreIngredient("ingotTin");
    private static final IIngredient blockTin = new OreIngredient("blockTin");
    private static final IIngredient oreTin = new OreIngredient("oreTin");
    private static final IIngredient tinyTin = new ItemIngredient(IC2Items.getItem("dust", "small_tin"));
    private static final IIngredient beeTin = new ItemIngredient(ExtraBeeItems.TIN_DUST.get(1));

    private static final IIngredient dustBronze = new OreIngredient("dustBronze");
    private static final IIngredient nuggetBronze = new OreIngredient("nuggetBronze");
    private static final IIngredient ingotBronze = new OreIngredient("ingotBronze");
    private static final IIngredient blockBronze = new OreIngredient("blockBronze");
    private static final IIngredient tinyBronze = new ItemIngredient(IC2Items.getItem("dust", "small_bronze"));

    private static final IIngredient dustLead = new OreIngredient("dustLead");
    private static final IIngredient nuggetLead = new OreIngredient("nuggetLead");
    private static final IIngredient ingotLead = new OreIngredient("ingotLead");
    private static final IIngredient blockLead = new OreIngredient("blockLead");
    private static final IIngredient oreLead = new OreIngredient("oreLead");
    private static final IIngredient tinyLead = new ItemIngredient(IC2Items.getItem("dust", "small_lead"));
    private static final IIngredient beeLead = new ItemIngredient(ExtraBeeItems.LEAD_DUST.get(1));

    private static final IIngredient dustIron = new OreIngredient("dustIron");
    private static final IIngredient nuggetIron = new ItemIngredient(new ItemStack(Items.IRON_NUGGET));
    private static final IIngredient ingotIron = new ItemIngredient(new ItemStack(Items.IRON_INGOT));
    private static final IIngredient blockIron = new OreIngredient("blockIron");
    private static final IIngredient oreIron = new OreIngredient("oreIron");
    private static final IIngredient tinyIron = new ItemIngredient(IC2Items.getItem("dust", "small_iron"));
    private static final IIngredient beeIron = new ItemIngredient(ExtraBeeItems.IRON_DUST.get(1));

    private static final IIngredient dustSilver = new OreIngredient("dustSilver");
    private static final IIngredient nuggetSilver = new OreIngredient("nuggetSilver");
    private static final IIngredient ingotSilver = new OreIngredient("ingotSilver");
    private static final IIngredient blockSilver = new OreIngredient("blockSilver");
    private static final IIngredient oreSilver = new OreIngredient("oreSilver");
    private static final IIngredient tinySilver = new ItemIngredient(IC2Items.getItem("dust", "small_silver"));
    private static final IIngredient beeSilver = new ItemIngredient(ExtraBeeItems.SILVER_DUST.get(1));

    private static final IIngredient dustGold = new OreIngredient("dustGold");
    private static final IIngredient nuggetGold = new ItemIngredient(new ItemStack(Items.GOLD_NUGGET));
    private static final IIngredient ingotGold = new ItemIngredient(new ItemStack(Items.GOLD_INGOT));
    private static final IIngredient blockGold = new ItemIngredient(new ItemStack(Blocks.GOLD_BLOCK));
    private static final IIngredient oreGold = new OreIngredient("oreGold");
    private static final IIngredient tinyGold = new ItemIngredient(IC2Items.getItem("dust", "small_gold"));
    private static final IIngredient beeGold = new ItemIngredient(ExtraBeeItems.GOLD_DUST.get(1));

    private static final IIngredient dustAluminum = new OreIngredient("dustAluminum");
    private static final IIngredient nuggetAluminum = new OreIngredient("nuggetAluminum");
    private static final IIngredient dustAluminium = new OreIngredient("dustAluminium");
    private static final IIngredient ingotAluminum = new OreIngredient("ingotAluminum");
    private static final IIngredient ingotAluminium = new OreIngredient("ingotAluminium");
    private static final IIngredient blockAluminum = new OreIngredient("oreAluminum");
    private static final IIngredient blockAluminium = new OreIngredient("oreAluminium");
    private static final IIngredient oreAluminum = new OreIngredient("oreAluminum");
    private static final IIngredient oreAluminium = new OreIngredient("oreAluminium");

    private static final IIngredient ingotBrass = new OreIngredient("ingotBrass");
    private static final IIngredient ingotThaumium = new ItemIngredient(new ItemStack(ItemsTC.ingots));
    private static final IIngredient ingotVoid = new ItemIngredient(new ItemStack(ItemsTC.ingots, 1, 1));
    private static final IIngredient ingotSteel = new OreIngredient("ingotSteel");

    private static final IIngredient oreCoal = new OreIngredient("oreCoal");
    private static final IIngredient beeCoal = new ItemIngredient(ExtraBeeItems.COAL_DUST.get(1));

    private static final IIngredient oreSulfur = new OreIngredient("oreSulfur");
    private static final IIngredient tinySulfur = new ItemIngredient(IC2Items.getItem("dust", "small_sulfur"));
    private static final IIngredient cloudSulfur = new ItemIngredient(new ItemStack(NaturaCommons.clouds, 1, BlockCloud.CloudType.SULFUR.meta));

    private static final IIngredient tinyObsidian = new ItemIngredient(IC2Items.getItem("dust", "small_obsidian"));

    private static final IIngredient oreSapphire = new OreIngredient("oreSapphire");
    private static final IIngredient beeSapphire = new ItemIngredient(ExtraBeeItems.SAPPHIRE_SHARD.get(1));
    private static final IIngredient oreAmber = new OreIngredient("oreAmber");

    private static final IIngredient forgeHammer = new ItemIngredient(IC2Items.getItem("forge_hammer").copy()) {{
        this.getIngredient().setItemDamage(OreDictionary.WILDCARD_VALUE);
    }};

    private static final IIngredient bone = new ItemIngredient(new ItemStack(Items.BONE));

    private static CraftingUpdateManager ourInstance = new CraftingUpdateManager();

    public static CraftingUpdateManager getInstance() {
        return ourInstance;
    }

    private CraftingUpdateManager() {
        //DUSTS
        //COPPER
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "copper"))); //ic2 copper dust)
        updateActions.add(new AddShapelessRecipeAction("oreCopper_petrotheum", Stream.of(oreCopper, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustCopper, 2)); //from ore+petrotheum
        updateActions.add(new AddShapelessRecipeAction("ingotCopper_petrotheum", Stream.of(ingotCopper, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustCopper)); //from ingot+petrotheum
        updateActions.add(new AddShapelessRecipeAction("tinyCopper_compress", Stream.of(tinyCopper, tinyCopper, tinyCopper, tinyCopper, tinyCopper, tinyCopper,tinyCopper, tinyCopper, tinyCopper).collect(Collectors.toList()), ItemMaterial.dustCopper)); //from tiny copper
        updateActions.add(new AddShapelessRecipeAction("beeCopper_compress", Stream.of(beeCopper, beeCopper, beeCopper, beeCopper).collect(Collectors.toList()), ItemMaterial.dustCopper)); //from copper grains

        //TIN
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "tin"))); //ic2 tin dust
        updateActions.add(new AddShapelessRecipeAction("oreTin_petrotheum", Stream.of(oreTin, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustTin, 2)); //from ore+petrotheum
        updateActions.add(new AddShapelessRecipeAction("ingotTin_petrotheum", Stream.of(ingotTin, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustTin)); //from ingot+petrotheum
        updateActions.add(new AddShapelessRecipeAction("tinyTin_compress", Stream.of(tinyTin, tinyTin, tinyTin, tinyTin, tinyTin, tinyTin, tinyTin, tinyTin, tinyTin).collect(Collectors.toList()), ItemMaterial.dustTin)); //from tiny tin
        updateActions.add(new AddShapelessRecipeAction("beeTin_compress", Stream.of(beeTin, beeTin, beeTin, beeTin).collect(Collectors.toList()), ItemMaterial.dustTin)); //from tin grains

        //BRONZE
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "bronze"))); //ic2 bronze dust
        updateActions.add(new AddShapelessRecipeAction("tinyBronze_compress", Stream.of(tinyBronze, tinyBronze, tinyBronze, tinyBronze, tinyBronze, tinyBronze, tinyBronze, tinyBronze, tinyBronze).collect(Collectors.toList()), ItemMaterial.dustBronze)); //from tiny bronze

        //LEAD
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "lead"))); //ic2 lead dust
        updateActions.add(new AddShapelessRecipeAction("oreLead_petrotheum", Stream.of(oreLead, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustLead, 2)); //from ore+petrotheum
        updateActions.add(new AddShapelessRecipeAction("ingotLead_petrotheum", Stream.of(ingotLead, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustLead)); //from ingot+petrotheum
        updateActions.add(new AddShapelessRecipeAction("tinyLead_compress", Stream.of(tinyLead, tinyLead, tinyLead, tinyLead, tinyLead, tinyLead, tinyLead, tinyLead, tinyLead).collect(Collectors.toList()), ItemMaterial.dustLead)); //from tiny lead
        updateActions.add(new AddShapelessRecipeAction("beeLead_compress", Stream.of(beeLead, beeLead, beeLead, beeLead).collect(Collectors.toList()), ItemMaterial.dustLead)); //from lead grains

        //IRON
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "iron"))); //ic2 iron dust
        updateActions.add(new AddShapelessRecipeAction("oreIron_petrotheum", Stream.of(oreIron, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustIron, 2)); //from ore+petrotheum
        updateActions.add(new AddShapelessRecipeAction("ingotIron_petrotheum", Stream.of(ingotIron, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustIron)); //from ingot+petrotheum
        updateActions.add(new AddShapelessRecipeAction("tinyIron_compress", Stream.of(tinyIron, tinyIron, tinyIron, tinyIron, tinyIron, tinyIron, tinyIron, tinyIron, tinyIron).collect(Collectors.toList()), ItemMaterial.dustIron)); //from tiny iron
        updateActions.add(new AddShapelessRecipeAction("beeIron_compress", Stream.of(beeIron, beeIron, beeIron, beeIron).collect(Collectors.toList()), ItemMaterial.dustIron)); //from iron grains

        //SILVER
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "silver"))); //ic2 silver dust
        updateActions.add(new AddShapelessRecipeAction("oreSilver_petrotheum", Stream.of(oreSilver, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustSilver, 2)); //from ore+petrotheum
        updateActions.add(new AddShapelessRecipeAction("ingotSilver_petrotheum", Stream.of(ingotSilver, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustSilver, 2)); //from ingot+petrotheum
        updateActions.add(new AddShapelessRecipeAction("tinySilver_compress", Stream.of(tinySilver, tinySilver, tinySilver, tinySilver, tinySilver, tinySilver, tinySilver, tinySilver, tinySilver).collect(Collectors.toList()), ItemMaterial.dustSilver)); //from tiny silver
        updateActions.add(new AddShapelessRecipeAction("beeSilver_compress", Stream.of(beeSilver, beeSilver, beeSilver, beeSilver).collect(Collectors.toList()), ItemMaterial.dustSilver)); //from silver grains

        //GOLD
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "gold"))); //ic2 gold dust
        updateActions.add(new AddShapelessRecipeAction("oreGold_petrotheum", Stream.of(oreGold, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustGold, 2)); //from ore+petrotheum
        updateActions.add(new AddShapelessRecipeAction("ingotGold_petrotheum", Stream.of(ingotGold, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustGold)); //from ingot+petrotheum
        updateActions.add(new AddShapelessRecipeAction("tinyGold_compress", Stream.of(tinyGold, tinyGold, tinyGold, tinyGold, tinyGold, tinyGold, tinyGold, tinyGold, tinyGold).collect(Collectors.toList()), ItemMaterial.dustGold)); //from tiny gold
        updateActions.add(new AddShapelessRecipeAction("beeGold_compress", Stream.of(beeGold, beeGold, beeGold, beeGold).collect(Collectors.toList()), ItemMaterial.dustGold)); //from gold grains

        //ALUMINUM
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.dustAluminum)); //GC aluminum dust

        //LAPIS
        updateActions.add(new RemoveRecipesAction("thermalfoundation", IC2Items.getItem("dust", "lapis"))); //lapis dust petrotheum recipe

        //DIAMOND
        updateActions.add(new RemoveRecipesAction("thermalfoundation", IC2Items.getItem("dust", "diamond"))); //diamond dust petrotheum recipe

        //COAL
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "coal"))); //coal dust from coal grains
        updateActions.add(new AddShapelessRecipeAction("oreCoal_petrotheum", Stream.of(oreCoal, dustPetrotheum).collect(Collectors.toList()), new ItemStack(Items.COAL, 2)));
        updateActions.add(new AddShapelessRecipeAction("beeCoal_compress", Stream.of(beeCoal, beeCoal, beeCoal, beeCoal).collect(Collectors.toList()), ItemMaterial.dustCoal));

        //SULFUR
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "sulfur")));
        updateActions.add(new RemoveRecipesAction(NaturaCommons.sulfurPowder));
        updateActions.add(new AddShapelessRecipeAction("tinySulfur_compress", Stream.of(tinySulfur, tinySulfur, tinySulfur, tinySulfur, tinySulfur, tinySulfur, tinySulfur, tinySulfur, tinySulfur).collect(Collectors.toList()), ItemMaterial.dustSulfur));
        updateActions.add(new AddShapelessRecipeAction("oreSulfur_petrotheum", Stream.of(oreSulfur, dustPetrotheum).collect(Collectors.toList()), ItemMaterial.dustSulfur, 2));
        updateActions.add(new AddShapelessRecipeAction("cloudSulfur_compress", Stream.of(cloudSulfur, cloudSulfur, cloudSulfur, cloudSulfur).collect(Collectors.toList()), ItemMaterial.dustSulfur));

        //OBSIDIAN
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("dust", "obsidian")));
        updateActions.add(new AddShapelessRecipeAction("tinyObsidian_compress", Stream.of(tinyObsidian, tinyObsidian, tinyObsidian, tinyObsidian, tinyObsidian, tinyObsidian, tinyObsidian, tinyObsidian, tinyObsidian).collect(Collectors.toList()), ItemMaterial.dustObsidian));

        //NUGGETS
        //COPPER
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 5))); //mekanism
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 20)));

        //TIN
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 6))); //mekanism

        //BRONZE
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 2))); //mekanism

        //SILVER
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silverNugget, 1))); //ice and fire
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 23)));

        //STEEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 4))); //mekanism
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1,28)));

        //ALUMINUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 21)));

        //LEAD
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 22)));

        //NICKEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 24)));

        //URANIUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 25)));

        //CONSTANTAN
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 26)));

        //ELECTRUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 27)));

        //IRON
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 29)));

        //REDSTONE CRYSTAL
        updateActions.add(new RemoveRecipesAction("thermalfoundation", ItemIngredients.Type.REDSTONE_CRYSTAL.newStack()));

        //INGOTS
        //COPPER
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Ingot, 1, 5))); //mekanism ingot
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "copper"))); //ic2 ingot
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.ingotCopper)); //gc ingot
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().ingotCopper)); //forestry ingot
        updateActions.add(new AddShapelessRecipeAction("dustCopper_pyrotheum", Stream.of(ingotCopper, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotCopper)); //from dust+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreCopper_pyrotheum", Stream.of(oreCopper, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotCopper)); //from ore+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreCopper_smelt", Stream.of(oreCopper, dustPetrotheum, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotCopper, 2)); //from dust+petrotheum+pyrotheum
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal)));

        //TIN
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Ingot, 1, 6))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "tin"))); //ic2
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.ingotTin)); //gc
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().ingotTin)); //forestry
        updateActions.add(new AddShapelessRecipeAction("dustTin_pyrotheum", Stream.of(dustTin, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotTin)); //from dust+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreTin_pyrotheum", Stream.of(oreTin, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotTin)); //from ore+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreTin_smelt", Stream.of(oreTin, dustPetrotheum, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotTin, 2)); //from dust+petrotheum+pyrotheum

        //BRONZE
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Ingot, 1, 2))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "bronze"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().ingotBronze)); //forestry

        //LEAD
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "lead"))); //ic2
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.ingotLead)); //gc
        updateActions.add(new AddShapelessRecipeAction("dustLead_pyrotheum", Stream.of(dustLead, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotLead)); //from dust+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreLead_pyrotheum", Stream.of(oreLead, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotLead)); //from ore+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreLead_smelt", Stream.of(oreLead, dustPetrotheum, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotLead, 2)); //from ore+petrotheum+pyrotheum
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 2)));

        //SILVER
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "silver"))); //ic2
        updateActions.add(new AddShapelessRecipeAction("dustSilver_pyrotheum", Stream.of(dustSilver, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotSilver)); //from dust+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreSilver_pyrotheum", Stream.of(oreSilver, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotSilver)); //from ore+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreSilver_smelt", Stream.of(oreSilver, dustPetrotheum, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotSilver, 2)); //from ore+petrotheum+pyrotheum
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silverIngot, 1))); //ice and fire
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 3)));

        //ALUMINUM
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.ingotAluminum)); //gc
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 1)));

        //STEEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Ingot, 1, 4))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "steel"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(BrItems.ingotSteel))); //extreme reactors
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 8)));

        //NICKEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 4)));

        //URANIUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 5)));

        //CONSTANTAN
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 6)));

        //ELECTRUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.itemMetal, 1, 7)));

        //BLOCKS
        //COPPER
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 12))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("resource", "copper_block"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getBlocks().resourceStorageCopper)); //forestry
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockCopper)); //gc
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage)));

        //TIN
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 13))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("resource", "tin_block"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getBlocks().resourceStorageTin)); //forestry
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockTin)); //gc

        //BRONZE
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 1))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("resource", "bronze_block"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getBlocks().resourceStorageBronze)); //forestry

        //LEAD
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("resource", "lead_block"))); //ic2
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockLead)); //gc
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 2)));

        //SILVER
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("resource", "silver_block"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModBlocks.silverBlock, 1))); //ice and fire
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 3)));

        //ALUMINUM
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockAluminum)); //gc
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 1)));

        //STEEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 5))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("resource", "steel_block"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(BrBlocks.blockSteel))); //extreme reactors
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 8)));

        //URANIUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 5)));

        //CONSTANTAN
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 6)));

        //ELECTRUM
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStorage, 1, 7)));

        //CHARCOAL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 3)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModuleCharcoal.getBlocks().charcoal)));

        //COAL COKE
        updateActions.add(new RemoveRecipesAction(new ItemStack(IEContent.blockStoneDecoration, 1, 3)));

        //ARMORS
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeHelmet)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeChestplate)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeLeggings)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeBoots)));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_helmet")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_chestplate")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_leggings")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_boots")));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_helmet, 1)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_chestplate, 1)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_leggings, 1)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_boots, 1)));
        updateActions.add(new AddShapedRecipeAction("silverHelmet_replace", 3, 2, true, Stream.of(ingotSilver, ingotSilver, ingotSilver, ingotSteel, null, ingotSteel).collect(Collectors.toList()), new ItemStack(ModItems.silver_helmet)));
        updateActions.add(new AddShapedRecipeAction("silverChestplate_replace", 3, 3, true, Stream.of(ingotSilver, null, ingotSilver, ingotSilver, ingotSteel, ingotSilver, ingotSilver, ingotSteel, ingotSilver).collect(Collectors.toList()), new ItemStack(ModItems.silver_chestplate)));
        updateActions.add(new AddShapedRecipeAction("silverLeggings_replace", 3, 3, true, Stream.of(ingotSteel, ingotSilver, ingotSteel, ingotSilver, null, ingotSilver, ingotSilver, null, ingotSilver).collect(Collectors.toList()), new ItemStack(ModItems.silver_leggings)));
        updateActions.add(new AddShapedRecipeAction("silverBoots_replace", 3, 2, true, Stream.of(ingotSilver, null, ingotSilver, ingotSteel, null, ingotSteel).collect(Collectors.toList()), new ItemStack(ModItems.silver_boots)));

        //TOOLS
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeAxe)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeSword)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeShovel)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzePickaxe)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.BronzeHoe)));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_axe")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_sword")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_pickaxe")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_shovel")));
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("bronze_hoe")));

        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.SteelAxe)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.SteelSword)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.SteelPickaxe)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.SteelShovel)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ToolsItems.SteelHoe)));

        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_axe)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_sword)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_pickaxe)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_shovel)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silver_hoe)));
        updateActions.add(new AddShapedRecipeAction("silverAxe_replace", 2, 3, true, Stream.of(ingotSilver, ingotSilver, ingotSilver, bone, null, bone).collect(Collectors.toList()), new ItemStack(ModItems.silver_axe)));
        updateActions.add(new AddShapedRecipeAction("silverSword_replace", 1, 3, true, Stream.of(ingotSilver, ingotSilver, bone).collect(Collectors.toList()), new ItemStack(ModItems.silver_sword)));
        updateActions.add(new AddShapedRecipeAction("silverPickaxe_replace", 3, 3, true, Stream.of(ingotSilver, ingotSilver, ingotSilver, null, bone, null, null, bone, null).collect(Collectors.toList()), new ItemStack(ModItems.silver_pickaxe)));
        updateActions.add(new AddShapedRecipeAction("silverShovel_replace", 1, 3, true, Stream.of(ingotSilver, bone, bone).collect(Collectors.toList()), new ItemStack(ModItems.silver_shovel)));
        updateActions.add(new AddShapedRecipeAction("silverHoe_replace", 2, 3, true, Stream.of(ingotSilver, ingotSilver, null, bone, null, bone).collect(Collectors.toList()), new ItemStack(ModItems.silver_hoe)));

        //PLATES
        updateActions.add(new RemoveRecipesAction(new ItemStack(ItemsTC.plate)));
        updateActions.add(new AddShapelessRecipeAction("plateBrass_ic2hammer", Stream.of(ingotBrass, forgeHammer).collect(Collectors.toList()), new ItemStack(ItemsTC.plate)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ItemsTC.plate, 1, 1)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ItemsTC.plate, 1, 2)));
        updateActions.add(new AddShapelessRecipeAction("plateThaumium_ic2hammer", Stream.of(ingotThaumium, forgeHammer).collect(Collectors.toList()), new ItemStack(ItemsTC.plate, 1, 2)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(ItemsTC.plate, 1, 3)));
        updateActions.add(new AddShapelessRecipeAction("plateVoid_ic2hammer", Stream.of(ingotVoid, forgeHammer).collect(Collectors.toList()), new ItemStack(ItemsTC.plate, 1, 3)));

        //GEARS
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().gearCopper));
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().gearTin));
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().gearBronze));

        //MATERIALS
        updateActions.add(new RemoveRecipesAction("natura", new ItemStack(Items.GUNPOWDER)));

        //GEMS
        updateActions.add(new RemoveRecipesAction(new ItemStack(BOPItems.gem, 1, 6)));
        updateActions.add(new RemoveRecipesAction(new ItemStack(BOPBlocks.gem_block, 1, 6)));
        updateActions.add(new RemoveRecipesAction("thermalfoundation", new ItemStack(BOPItems.gem, 1, 7)));
        updateActions.add(new AddShapelessRecipeAction("oreAmber_petrotheum", Stream.of(oreAmber, dustPetrotheum).collect(Collectors.toList()), new ItemStack(ItemsTC.amber)));
        updateActions.add(new AddShapelessRecipeAction("oreSapphire_petrotheum", Stream.of(oreSapphire, dustPetrotheum).collect(Collectors.toList()), new ItemStack(ModItems.sapphireGem, 2)));
        updateActions.add(new AddShapelessRecipeAction("beeSapphire_compress", Stream.of(beeSapphire, beeSapphire, beeSapphire, beeSapphire, beeSapphire, beeSapphire, beeSapphire, beeSapphire, beeSapphire).collect(Collectors.toList()), new ItemStack(ModItems.sapphireGem)));

        //BANNER
        updateActions.addAll(getBannerFixes());

        //FISSILES
        updateActions.addAll(getIC2FissileFixes());

        //Silky jew
        updateActions.addAll(getSilkyJewelRecipeFixes());
    }

    private Collection<CraftingAction> getBannerFixes() {
        List<CraftingAction> result = new ArrayList<>();

        final IIngredient stick = new OreIngredient("stickWood");
        final IIngredient slab = new OreIngredient("slabWood");
        final IIngredient whiteWool = new ItemIngredient(new ItemStack(Blocks.WOOL));
        final IIngredient orangeWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 1));
        final IIngredient magentaWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 2));
        final IIngredient lightBlueWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 3));
        final IIngredient yellowWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 4));
        final IIngredient limeWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 5));
        final IIngredient pinkWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 6));
        final IIngredient greyWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 7));
        final IIngredient lightGreyWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 8));
        final IIngredient cyanWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 9));
        final IIngredient purpleWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 10));
        final IIngredient blueWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 11));
        final IIngredient brownWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 12));
        final IIngredient greenWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 13));
        final IIngredient redWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 14));
        final IIngredient blackWool = new ItemIngredient(new ItemStack(Blocks.WOOL, 1, 15));

        final ItemStack whiteBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.WHITE));
        final ItemStack orangeBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.ORANGE));
        final ItemStack magentaBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.MAGENTA));
        final ItemStack lightBlueBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.LIGHT_BLUE));
        final ItemStack yellowBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.YELLOW));
        final ItemStack limeBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.LIME));
        final ItemStack pinkBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.PINK));
        final ItemStack greyBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.GRAY));
        final ItemStack lightGreyBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.SILVER));
        final ItemStack cyanBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.CYAN));
        final ItemStack purpleBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.PURPLE));
        final ItemStack blueBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.BLUE));
        final ItemStack brownBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.BROWN));
        final ItemStack greenBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.GREEN));
        final ItemStack redBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.RED));
        final ItemStack blackBanner = new ItemStack(BlocksTC.banners.get(EnumDyeColor.BLACK));

        result.add(new RemoveRecipesAction(whiteBanner));
        result.add(new AddShapedRecipeAction("tcbanner_white", 2, 3, Stream.of(whiteWool, stick, whiteWool, stick, whiteWool, slab).collect(Collectors.toList()), whiteBanner));
        result.add(new RemoveRecipesAction(orangeBanner));
        result.add(new AddShapedRecipeAction("tcbanner_orange", 2, 3, Stream.of(orangeWool, stick, orangeWool, stick, orangeWool, slab).collect(Collectors.toList()), orangeBanner));
        result.add(new RemoveRecipesAction(magentaBanner));
        result.add(new AddShapedRecipeAction("tcbanner_magenta", 2, 3, Stream.of(magentaWool, stick, magentaWool, stick, magentaWool, slab).collect(Collectors.toList()), magentaBanner));
        result.add(new RemoveRecipesAction(lightBlueBanner));
        result.add(new AddShapedRecipeAction("tcbanner_lightblue", 2, 3, Stream.of(lightBlueWool, stick, lightBlueWool, stick, lightBlueWool, slab).collect(Collectors.toList()), lightBlueBanner));
        result.add(new RemoveRecipesAction(yellowBanner));
        result.add(new AddShapedRecipeAction("tcbanner_yellow", 2, 3, Stream.of(yellowWool, stick, yellowWool, stick, yellowWool, slab).collect(Collectors.toList()), yellowBanner));
        result.add(new RemoveRecipesAction(limeBanner));
        result.add(new AddShapedRecipeAction("tcbanner_lime", 2, 3, Stream.of(limeWool, stick, limeWool, stick, limeWool, slab).collect(Collectors.toList()), limeBanner));
        result.add(new RemoveRecipesAction(pinkBanner));
        result.add(new AddShapedRecipeAction("tcbanner_pink", 2, 3, Stream.of(pinkWool, stick, pinkWool, stick, pinkWool, slab).collect(Collectors.toList()), pinkBanner));
        result.add(new RemoveRecipesAction(greyBanner));
        result.add(new AddShapedRecipeAction("tcbanner_grey", 2, 3, Stream.of(greyWool, stick, greyWool, stick, greyWool, slab).collect(Collectors.toList()), greyBanner));
        result.add(new RemoveRecipesAction(lightGreyBanner));
        result.add(new AddShapedRecipeAction("tcbanner_lightgrey", 2, 3, Stream.of(lightGreyWool, stick, lightGreyWool, stick, lightGreyWool, slab).collect(Collectors.toList()), lightGreyBanner));
        result.add(new RemoveRecipesAction(cyanBanner));
        result.add(new AddShapedRecipeAction("tcbanner_cyan", 2, 3, Stream.of(cyanWool, stick, cyanWool, stick, cyanWool, slab).collect(Collectors.toList()), cyanBanner));
        result.add(new RemoveRecipesAction(purpleBanner));
        result.add(new AddShapedRecipeAction("tcbanner_purple", 2, 3, Stream.of(purpleWool, stick, purpleWool, stick, purpleWool, slab).collect(Collectors.toList()), purpleBanner));
        result.add(new RemoveRecipesAction(blueBanner));
        result.add(new AddShapedRecipeAction("tcbanner_blue", 2, 3, Stream.of(blueWool, stick, blueWool, stick, blueWool, slab).collect(Collectors.toList()), blueBanner));
        result.add(new RemoveRecipesAction(brownBanner));
        result.add(new AddShapedRecipeAction("tcbanner_brown", 2, 3, Stream.of(brownWool, stick, brownWool, stick, brownWool, slab).collect(Collectors.toList()), brownBanner));
        result.add(new RemoveRecipesAction(greenBanner));
        result.add(new AddShapedRecipeAction("tcbanner_green", 2, 3, Stream.of(greenWool, stick, greenWool, stick, greenWool, slab).collect(Collectors.toList()), greenBanner));
        result.add(new RemoveRecipesAction(redBanner));
        result.add(new AddShapedRecipeAction("tcbanner_red", 2, 3, Stream.of(redWool, stick, redWool, stick, redWool, slab).collect(Collectors.toList()), redBanner));
        result.add(new RemoveRecipesAction(blackBanner));
        result.add(new AddShapedRecipeAction("tcbanner_black", 2, 3, Stream.of(blackWool, stick, blackWool, stick, blackWool, slab).collect(Collectors.toList()), blackBanner));

        return result;
    }

    private Collection<CraftingAction> getIC2FissileFixes() {
        List<CraftingAction> result = new ArrayList<>();

        final IIngredient u238 = new ItemIngredient(IC2Items.getItem("nuclear", "uranium_238"));
        final IIngredient u235 = new ItemIngredient(IC2Items.getItem("nuclear", "small_uranium_235"));
        final IIngredient plutonium = new ItemIngredient(IC2Items.getItem("nuclear", "plutonium"));
        final IIngredient denseIron = new ItemIngredient(IC2Items.getItem("plate", "dense_iron"));

        result.add(new RemoveRecipesAction(IC2Items.getItem("nuclear", "uranium")));
        result.add(new RemoveRecipesAction(IC2Items.getItem("nuclear", "mox")));
        result.add(new RemoveRecipesAction(IC2Items.getItem("resource", "uranium_block")));
        result.add(new RemoveRecipesAction(IC2Items.getItem("nuclear", "rtg_pellet")));

        result.add(new AddShapelessRecipeAction("u238_compress", Stream.of(u238, u238, u238, u238, u238, u238, u238, u238, u238).collect(Collectors.toList()), IC2Items.getItem("resource", "uranium_block")));
        result.add(new AddShapedRecipeAction("uraniumfuel", 3, 3, Stream.of(u238, u238, u238, u235, u235, u235, u238, u238, u238).collect(Collectors.toList()), IC2Items.getItem("nuclear", "uranium")));
        result.add(new AddShapedRecipeAction("moxfuel", 3, 3, Stream.of(u238, u238, u238, plutonium, plutonium, plutonium, u238, u238, u238).collect(Collectors.toList()), IC2Items.getItem("nuclear", "mox")));
        result.add(new AddShapedRecipeAction("rtgfuel_horizontal", 3, 3, Stream.of(denseIron, denseIron, denseIron, plutonium, plutonium, plutonium, denseIron, denseIron, denseIron).collect(Collectors.toList()), IC2Items.getItem("nuclear", "rtg_pellet")));
        result.add(new AddShapedRecipeAction("rtgfuel_vertical", 3, 3, Stream.of(denseIron, plutonium, denseIron, denseIron, plutonium, denseIron, denseIron, plutonium, denseIron).collect(Collectors.toList()), IC2Items.getItem("nuclear", "rtg_pellet")));

        return result;
    }

    private Collection<CraftingAction> getSilkyJewelRecipeFixes() {
        List<CraftingAction> result = new ArrayList<>();

        final IIngredient silkyBlock = new ItemIngredient(TinkerCommons.blockSilkyJewel);
        final IIngredient silkyCloth = new ItemIngredient(TinkerCommons.matSilkyCloth);
        ItemStack silkTouchBook = new ItemStack(Items.ENCHANTED_BOOK);
        silkTouchBook.addEnchantment(Enchantments.SILK_TOUCH, 1);
        final IIngredient silkyBook = new EnchantedIngredient(silkTouchBook);
        final IIngredient emerald = new ItemIngredient(new ItemStack(Items.EMERALD));

        result.add(new RemoveRecipesAction(TinkerCommons.matSilkyJewel));
        result.add(new AddShapelessRecipeAction("silkyBlock_break", Stream.of(silkyBlock).collect(Collectors.toList()), TinkerCommons.matSilkyJewel, 9));
        result.add(new AddShapedRecipeAction("silkyJewel_create", 3, 3, Stream.of(silkyBook, silkyCloth, ItemIngredient.EMPTY, silkyCloth, emerald, silkyCloth, ItemIngredient.EMPTY, silkyCloth, silkyBook).collect(Collectors.toList()), TinkerCommons.matSilkyJewel));

        return result;
    }
}
