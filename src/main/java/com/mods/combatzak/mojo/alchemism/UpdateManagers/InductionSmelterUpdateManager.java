package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import appeng.api.AEApi;
import cofh.thermalfoundation.block.BlockOre;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.cofh.smelter.AddOrReplaceInductionSmelterRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.cofh.smelter.ReplaceInductionSmelterOutputAction;
import com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer.AddOrReplaceSqueezerContainerRecipeAction;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import erogenousbeef.bigreactors.init.BrBlocks;
import ic2.api.item.IC2Items;
import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.blocks.ore.EnumOreMetal;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Manages modifications to induction smelter recipes
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class InductionSmelterUpdateManager extends UpdateManager{
    private static InductionSmelterUpdateManager ourInstance = new InductionSmelterUpdateManager();

    public static InductionSmelterUpdateManager getInstance() {
        return ourInstance;
    }

    private InductionSmelterUpdateManager() {
        //INGOTS
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotCopper", ItemMaterial.ingotCopper));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotTin", ItemMaterial.ingotTin ));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotBronze", ItemMaterial.ingotBronze));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotLead", ItemMaterial.ingotLead));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotSilver", ItemMaterial.ingotSilver));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotSteel", ItemMaterial.ingotSteel));

        //ORES+SAND
        ItemStack sand = new ItemStack(Blocks.SAND);
        ItemStack oreIron = new ItemStack(Blocks.IRON_ORE);
        ItemStack oreGold = new ItemStack(Blocks.GOLD_ORE);
        ItemStack oreCoal = new ItemStack(Blocks.COAL_ORE);
        ItemStack oreLapis = new ItemStack(Blocks.LAPIS_ORE);
        ItemStack oreRedstone = new ItemStack(Blocks.REDSTONE_ORE);
        ItemStack oreEmerald = new ItemStack(Blocks.EMERALD_ORE);
        ItemStack oreDiamond = new ItemStack(Blocks.DIAMOND_ORE);
        ItemStack oreCertus = new ItemStack(AEApi.instance().definitions().blocks().quartzOre().maybeBlock().get());
        ItemStack oreCertusCharged = new ItemStack(AEApi.instance().definitions().blocks().quartzOreCharged().maybeBlock().get());
        ItemStack oreUranium = IC2Items.getItem("resource", "uranium_ore");
        ItemStack oreYellorite = new ItemStack(BrBlocks.oreYellorite);
        ItemStack oreZinc = EnumOreMetal.ZINC.getStack();

        /*updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCopper, sand, BlockOre.oreCopper, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherTin, sand, BlockOre.oreTin, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIron, sand, oreIron, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLead, sand, BlockOre.oreLead, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherSilver, sand, BlockOre.oreSilver, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherNickel, sand, BlockOre.oreNickel, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherGold, sand, oreGold, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherPlatinum, sand, BlockOre.orePlatinum, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIridium, sand, BlockOre.oreIridium, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherAluminum, sand, BlockOre.oreAluminum, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherUranium, sand, oreUranium, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherYellorite, sand, oreYellorite, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCoal, sand, oreCoal, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherRedstone, sand, oreRedstone, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLapis, sand, oreLapis, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertus, sand, oreCertus, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertusCharged, sand, oreCertusCharged, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherDiamond, sand, oreDiamond, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherEmerald, sand, oreEmerald, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherZinc, sand, oreZinc, 2, ItemMaterial.crystalSlagRich, 1, 15));

        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCopper, sand, BlockOre.oreCopper, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndTin, sand, BlockOre.oreTin, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIron, sand, oreIron, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLead, sand, BlockOre.oreLead, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndSilver, sand, BlockOre.oreSilver, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndNickel, sand, BlockOre.oreNickel, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndGold, sand, oreGold, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndPlatinum, sand, BlockOre.orePlatinum, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIridium, sand, BlockOre.oreIridium, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndAluminum, sand, BlockOre.oreAluminum, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndUranium, sand, oreUranium, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndYellorite, sand, oreYellorite, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCoal, sand, oreCoal, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndRedstone, sand, oreRedstone, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLapis, sand, oreLapis, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertus, sand, oreCertus, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertusCharged, sand, oreCertusCharged, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndDiamond, sand, oreDiamond, 2, ItemMaterial.crystalSlagRich, 1, 15));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndEmerald, sand, oreEmerald, 2, ItemMaterial.crystalSlagRich, 1, 15));
        
        //ORES+PYROTHEUM
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCopper, ItemMaterial.dustPyrotheum, BlockOre.oreCopper, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherTin, ItemMaterial.dustPyrotheum, BlockOre.oreTin, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIron, ItemMaterial.dustPyrotheum, oreIron, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLead, ItemMaterial.dustPyrotheum, BlockOre.oreLead, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherSilver, ItemMaterial.dustPyrotheum, BlockOre.oreSilver, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherNickel, ItemMaterial.dustPyrotheum, BlockOre.oreNickel, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherGold, ItemMaterial.dustPyrotheum, oreGold, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherPlatinum, ItemMaterial.dustPyrotheum, BlockOre.orePlatinum, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIridium, ItemMaterial.dustPyrotheum, BlockOre.oreIridium, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherAluminum, ItemMaterial.dustPyrotheum, BlockOre.oreAluminum, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherUranium, ItemMaterial.dustPyrotheum, oreUranium, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherYellorite, ItemMaterial.dustPyrotheum, oreYellorite, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCoal, ItemMaterial.dustPyrotheum, oreCoal, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherRedstone, ItemMaterial.dustPyrotheum, oreRedstone, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLapis, ItemMaterial.dustPyrotheum, oreLapis, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertus, ItemMaterial.dustPyrotheum, oreCertus, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertusCharged, ItemMaterial.dustPyrotheum, oreCertusCharged, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherDiamond, ItemMaterial.dustPyrotheum, oreDiamond, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherEmerald, ItemMaterial.dustPyrotheum, oreEmerald, 2, ItemMaterial.crystalSlagRich, 1, 20));

        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCopper, ItemMaterial.dustPyrotheum, BlockOre.oreCopper, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndTin, ItemMaterial.dustPyrotheum, BlockOre.oreTin, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIron, ItemMaterial.dustPyrotheum, oreIron, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLead, ItemMaterial.dustPyrotheum, BlockOre.oreLead, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndSilver, ItemMaterial.dustPyrotheum, BlockOre.oreSilver, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndNickel, ItemMaterial.dustPyrotheum, BlockOre.oreNickel, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndGold, ItemMaterial.dustPyrotheum, oreGold, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndPlatinum, ItemMaterial.dustPyrotheum, BlockOre.orePlatinum, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIridium, ItemMaterial.dustPyrotheum, BlockOre.oreIridium, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndAluminum, ItemMaterial.dustPyrotheum, BlockOre.oreAluminum, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndUranium, ItemMaterial.dustPyrotheum, oreUranium, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndYellorite, ItemMaterial.dustPyrotheum, oreYellorite, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCoal, ItemMaterial.dustPyrotheum, oreCoal, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndRedstone, ItemMaterial.dustPyrotheum, oreRedstone, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLapis, ItemMaterial.dustPyrotheum, oreLapis, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertus, ItemMaterial.dustPyrotheum, oreCertus, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertusCharged, ItemMaterial.dustPyrotheum, oreCertusCharged, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndDiamond, ItemMaterial.dustPyrotheum, oreDiamond, 2, ItemMaterial.crystalSlagRich, 1, 20));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndEmerald, ItemMaterial.dustPyrotheum, oreEmerald, 2, ItemMaterial.crystalSlagRich, 1, 20));
        
        //ORES+RICHSLAG
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCopper, ItemMaterial.crystalSlagRich, BlockOre.oreCopper, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherTin, ItemMaterial.crystalSlagRich, BlockOre.oreTin, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIron, ItemMaterial.crystalSlagRich, oreIron, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLead, ItemMaterial.crystalSlagRich, BlockOre.oreLead, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherSilver, ItemMaterial.crystalSlagRich, BlockOre.oreSilver, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherNickel, ItemMaterial.crystalSlagRich, BlockOre.oreNickel, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherGold, ItemMaterial.crystalSlagRich, oreGold, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherPlatinum, ItemMaterial.crystalSlagRich, BlockOre.orePlatinum, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIridium, ItemMaterial.crystalSlagRich, BlockOre.oreIridium, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherAluminum, ItemMaterial.crystalSlagRich, BlockOre.oreAluminum, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherUranium, ItemMaterial.crystalSlagRich, oreUranium, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherYellorite, ItemMaterial.crystalSlagRich, oreYellorite, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCoal, ItemMaterial.crystalSlagRich, oreCoal, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherRedstone, ItemMaterial.crystalSlagRich, oreRedstone, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLapis, ItemMaterial.crystalSlagRich, oreLapis, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertus, ItemMaterial.crystalSlagRich, oreCertus, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertusCharged, ItemMaterial.crystalSlagRich, oreCertusCharged, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherDiamond, ItemMaterial.crystalSlagRich, oreDiamond, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherEmerald, ItemMaterial.crystalSlagRich, oreEmerald, 3, ItemMaterial.crystalSlag, 1, 100));

        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCopper, ItemMaterial.crystalSlagRich, BlockOre.oreCopper, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndTin, ItemMaterial.crystalSlagRich, BlockOre.oreTin, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIron, ItemMaterial.crystalSlagRich, oreIron, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLead, ItemMaterial.crystalSlagRich, BlockOre.oreLead, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndSilver, ItemMaterial.crystalSlagRich, BlockOre.oreSilver, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndNickel, ItemMaterial.crystalSlagRich, BlockOre.oreNickel, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndGold, ItemMaterial.crystalSlagRich, oreGold, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndPlatinum, ItemMaterial.crystalSlagRich, BlockOre.orePlatinum, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIridium, ItemMaterial.crystalSlagRich, BlockOre.oreIridium, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndAluminum, ItemMaterial.crystalSlagRich, BlockOre.oreAluminum, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndUranium, ItemMaterial.crystalSlagRich, oreUranium, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndYellorite, ItemMaterial.crystalSlagRich, oreYellorite, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCoal, ItemMaterial.crystalSlagRich, oreCoal, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndRedstone, ItemMaterial.crystalSlagRich, oreRedstone, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLapis, ItemMaterial.crystalSlagRich, oreLapis, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertus, ItemMaterial.crystalSlagRich, oreCertus, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertusCharged, ItemMaterial.crystalSlagRich, oreCertusCharged, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndDiamond, ItemMaterial.crystalSlagRich, oreDiamond, 3, ItemMaterial.crystalSlag, 1, 100));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndEmerald, ItemMaterial.crystalSlagRich, oreEmerald, 3, ItemMaterial.crystalSlag, 1, 100));
        
        //ORES+CINNABAR
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCopper, ItemMaterial.crystalCinnabar, BlockOre.oreCopper, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherTin, ItemMaterial.crystalCinnabar, BlockOre.oreTin, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIron, ItemMaterial.crystalCinnabar, oreIron, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLead, ItemMaterial.crystalCinnabar, BlockOre.oreLead, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherSilver, ItemMaterial.crystalCinnabar, BlockOre.oreSilver, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherNickel, ItemMaterial.crystalCinnabar, BlockOre.oreNickel, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherGold, ItemMaterial.crystalCinnabar, oreGold, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherPlatinum, ItemMaterial.crystalCinnabar, BlockOre.orePlatinum, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherIridium, ItemMaterial.crystalCinnabar, BlockOre.oreIridium, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherAluminum, ItemMaterial.crystalCinnabar, BlockOre.oreAluminum, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherUranium, ItemMaterial.crystalCinnabar, oreUranium, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherYellorite, ItemMaterial.crystalCinnabar, oreYellorite, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCoal, ItemMaterial.crystalCinnabar, oreCoal, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherRedstone, ItemMaterial.crystalCinnabar, oreRedstone, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherLapis, ItemMaterial.crystalCinnabar, oreLapis, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertus, ItemMaterial.crystalCinnabar, oreCertus, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherCertusCharged, ItemMaterial.crystalCinnabar, oreCertusCharged, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherDiamond, ItemMaterial.crystalCinnabar, oreDiamond, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreNetherEmerald, ItemMaterial.crystalCinnabar, oreEmerald, 3, ItemMaterial.crystalSlagRich, 1, 75));

        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCopper, ItemMaterial.crystalCinnabar, BlockOre.oreCopper, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndTin, ItemMaterial.crystalCinnabar, BlockOre.oreTin, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIron, ItemMaterial.crystalCinnabar, oreIron, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLead, ItemMaterial.crystalCinnabar, BlockOre.oreLead, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndSilver, ItemMaterial.crystalCinnabar, BlockOre.oreSilver, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndNickel, ItemMaterial.crystalCinnabar, BlockOre.oreNickel, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndGold, ItemMaterial.crystalCinnabar, oreGold, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndPlatinum, ItemMaterial.crystalCinnabar, BlockOre.orePlatinum, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndIridium, ItemMaterial.crystalCinnabar, BlockOre.oreIridium, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndAluminum, ItemMaterial.crystalCinnabar, BlockOre.oreAluminum, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndUranium, ItemMaterial.crystalCinnabar, oreUranium, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndYellorite, ItemMaterial.crystalCinnabar, oreYellorite, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCoal, ItemMaterial.crystalCinnabar, oreCoal, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndRedstone, ItemMaterial.crystalCinnabar, oreRedstone, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndLapis, ItemMaterial.crystalCinnabar, oreLapis, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertus, ItemMaterial.crystalCinnabar, oreCertus, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndCertusCharged, ItemMaterial.crystalCinnabar, oreCertusCharged, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndDiamond, ItemMaterial.crystalCinnabar, oreDiamond, 3, ItemMaterial.crystalSlagRich, 1, 75));
        updateActions.add(new AddOrReplaceInductionSmelterRecipeAction(7500, ItemStackHelper.oreEndEmerald, ItemMaterial.crystalCinnabar, oreEmerald, 3, ItemMaterial.crystalSlagRich, 1, 75));*/
    }
}
