package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import binnie.extrabees.items.types.ExtraBeeItems;
import cofh.thermalfoundation.block.BlockOre;
import cofh.thermalfoundation.item.ItemMaterial;
import com.github.alexthe666.iceandfire.core.ModBlocks;
import com.github.alexthe666.iceandfire.core.ModItems;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.AddShapelessRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.RemoveRecipesAction;
import com.mods.combatzak.mojo.alchemism.helpers.GCItemsHelper;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;
import erogenousbeef.bigreactors.init.BrBlocks;
import erogenousbeef.bigreactors.init.BrItems;
import forestry.core.ModuleCore;
import ic2.api.item.IC2Items;
import mekanism.common.MekanismBlocks;
import mekanism.common.MekanismItems;
import micdoodle8.mods.galacticraft.api.item.GCItems;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
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

    private static final IIngredient beeCoal = new ItemIngredient(ExtraBeeItems.COAL_DUST.get(1));

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
        updateActions.add(new RemoveRecipesAction("extrabees", IC2Items.getItem("dust", "coal"))); //coal dust from coal grains
        updateActions.add(new AddShapelessRecipeAction("beeCoal_compress", Stream.of(beeCoal, beeCoal, beeCoal, beeCoal).collect(Collectors.toList()), ItemMaterial.dustCoal));

        //NUGGETS
        //COPPER
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 5))); //mekanism

        //TIN
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 6))); //mekanism

        //BRONZE
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 2))); //mekanism

        //SILVER
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silverNugget, 1))); //ice and fire

        //STEEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Nugget, 1, 4))); //mekanism

        //INGOTS
        //COPPER
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Ingot, 1, 5))); //mekanism ingot
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "copper"))); //ic2 ingot
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.ingotCopper)); //gc ingot
        updateActions.add(new RemoveRecipesAction(ModuleCore.getItems().ingotCopper)); //forestry ingot
        updateActions.add(new AddShapelessRecipeAction("dustCopper_pyrotheum", Stream.of(ingotCopper, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotCopper)); //from dust+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreCopper_pyrotheum", Stream.of(oreCopper, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotCopper)); //from ore+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreCopper_smelt", Stream.of(oreCopper, dustPetrotheum, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotCopper, 2)); //from dust+petrotheum+pyrotheum

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

        //SILVER
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "silver"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModItems.silverIngot, 1))); //ice and fire
        updateActions.add(new AddShapelessRecipeAction("dustSilver_pyrotheum", Stream.of(dustSilver, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotSilver)); //from dust+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreSilver_pyrotheum", Stream.of(oreSilver, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotSilver)); //from ore+pyrotheum
        updateActions.add(new AddShapelessRecipeAction("oreSilver_smelt", Stream.of(oreSilver, dustPetrotheum, dustPyrotheum).collect(Collectors.toList()), ItemMaterial.ingotSilver, 2)); //from ore+petrotheum+pyrotheum

        //ALUMINUM
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.ingotAluminum)); //gc

        //STEEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismItems.Ingot, 1, 4))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("ingot", "steel"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(BrItems.ingotMetals, 1, 5))); //extreme reactors

        //BLOCKS
        //COPPER
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 12))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("block", "copper"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getBlocks().resourceStorageCopper)); //forestry
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockCopper)); //gc

        //TIN
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 13))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("block", "tin"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getBlocks().resourceStorageTin)); //forestry
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockTin)); //gc

        //BRONZE
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("block", "bronze"))); //ic2
        updateActions.add(new RemoveRecipesAction(ModuleCore.getBlocks().resourceStorageBronze)); //forestry

        //LEAD
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("block", "lead"))); //ic2
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockLead)); //gc

        //SILVER
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("block", "silver"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(ModBlocks.silverBlock, 1))); //ice and fire

        //ALUMINUM
        updateActions.add(new RemoveRecipesAction(GCItemsHelper.blockAluminum)); //gc

        //STEEL
        updateActions.add(new RemoveRecipesAction(new ItemStack(MekanismBlocks.BasicBlock, 1, 5))); //mekanism
        updateActions.add(new RemoveRecipesAction(IC2Items.getItem("block", "steel"))); //ic2
        updateActions.add(new RemoveRecipesAction(new ItemStack(BrBlocks.blockMetals, 1, 5))); //extreme reactors
    }
}
