package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import appeng.api.AEApi;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.cofh.smelter.AddOrReplaceInductionSmelterRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.AddOrReplaceMaceratorRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.ReplaceMaceratorOutputAction;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.AddOreEntryAction;
//import com.mods.combatzak.mojo.alchemism.helpers.GCItemsHelper;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import erogenousbeef.bigreactors.init.BrItems;
import ic2.api.item.IC2Items;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.items.ItemsTC;

/**
 * Governs all the updates to Macerator recipes
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class MaceratorUpdateManager extends UpdateManager{
    private static MaceratorUpdateManager ourInstance = new MaceratorUpdateManager();

    public static MaceratorUpdateManager getInstance() {
        return ourInstance;
    }

    private MaceratorUpdateManager() {
        ItemStack yelloriumDust = new ItemStack(BrItems.dustYellorium);
        ItemStack coal = new ItemStack(Items.COAL, 6);
        ItemStack lapis = new ItemStack(Items.DYE, 12, 4);
        ItemStack redstone = new ItemStack(Items.REDSTONE, 12);
        ItemStack diamond = new ItemStack(Items.DIAMOND, 4);
        ItemStack emerald = new ItemStack(Items.EMERALD, 4);

        //DUSTS
        updateActions.add(new ReplaceMaceratorOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplaceMaceratorOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplaceMaceratorOutputAction("dustBronze", ItemMaterial.dustBronze));
        updateActions.add(new ReplaceMaceratorOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplaceMaceratorOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplaceMaceratorOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplaceMaceratorOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplaceMaceratorOutputAction("dustCoal", ItemMaterial.dustCoal));
        updateActions.add(new ReplaceMaceratorOutputAction("dustObsidian", ItemMaterial.dustObsidian));
        updateActions.add(new ReplaceMaceratorOutputAction("dustAluminum", ItemMaterial.dustAluminum));

        //CLUSTERS

        //MetalOres
        /*updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherCopper, IC2Items.getItem("crushed", "copper"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherTin, IC2Items.getItem("crushed", "tin"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherIron, IC2Items.getItem("crushed", "iron"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherLead, IC2Items.getItem("crushed", "lead"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherSilver, IC2Items.getItem("crushed", "silver"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherGold, IC2Items.getItem("crushed", "gold"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherUranium, IC2Items.getItem("crushed", "uranium"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherAluminum, GCItemsHelper.oreCrushedAluminum, 4));

        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherNickel, ItemMaterial.dustNickel, 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherPlatinum, ItemMaterial.dustPlatinum, 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherIridium, IC2Items.getItem("misc_resource", "iridium_ore")));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherYellorite, yelloriumDust));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherOsmium, osmiumDust));

        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherCoal, coal));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherCertus, AEApi.instance().definitions().materials().certusQuartzCrystal().maybeStack(4).get()));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherCertusCharged, AEApi.instance().definitions().materials().certusQuartzCrystalCharged().maybeStack(4).get()));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherLapis, lapis));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherRedstone, redstone));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherDiamond, diamond));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreNetherEmerald, emerald));

        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndCopper, IC2Items.getItem("crushed", "copper"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndTin, IC2Items.getItem("crushed", "tin"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndIron, IC2Items.getItem("crushed", "iron"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndLead, IC2Items.getItem("crushed", "lead"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndSilver, IC2Items.getItem("crushed", "silver"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndGold, IC2Items.getItem("crushed", "gold"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndUranium, IC2Items.getItem("crushed", "uranium"), 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndAluminum, GCItemsHelper.oreCrushedAluminum, 4));

        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndNickel, ItemMaterial.dustNickel, 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndPlatinum, ItemMaterial.dustPlatinum, 4));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndIridium, IC2Items.getItem("misc_resource", "iridium_ore")));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndYellorite, yelloriumDust));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndOsmium, osmiumDust));

        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndCoal, coal));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndCertus, AEApi.instance().definitions().materials().certusQuartzCrystal().maybeStack(4).get()));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndCertusCharged, AEApi.instance().definitions().materials().certusQuartzCrystalCharged().maybeStack(4).get()));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndLapis, lapis));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndRedstone, redstone));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndDiamond, diamond));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.oreEndEmerald, emerald));*/
    }
}
