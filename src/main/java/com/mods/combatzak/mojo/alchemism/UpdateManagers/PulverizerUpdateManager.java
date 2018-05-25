package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.github.alexthe666.iceandfire.core.ModItems;
import com.mods.combatzak.mojo.alchemism.actions.cofh.pulverizer.AddOrReplacePulverizerRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.cofh.pulverizer.ReplacePulverizerOutputAction;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import mekanism.common.MekanismItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.items.ItemsTC;

/**
 * Created by CombatZAK on 4/30/2018.
 */
public class PulverizerUpdateManager extends UpdateManager {
    private static PulverizerUpdateManager ourInstance = new PulverizerUpdateManager();

    public static PulverizerUpdateManager getInstance() {
        return ourInstance;
    }

    private PulverizerUpdateManager() {
        final ItemStack quartz = new ItemStack(Items.QUARTZ, 1);
        final ItemStack coal = new ItemStack(Items.COAL, 6);
        final ItemStack lapis = new ItemStack(Items.DIAMOND, 12, 4);
        final ItemStack redstone = new ItemStack(Items.REDSTONE, 12);

        updateActions.add(new ReplacePulverizerOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplacePulverizerOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplacePulverizerOutputAction("dustBronze", ItemMaterial.dustBronze));
        updateActions.add(new ReplacePulverizerOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplacePulverizerOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplacePulverizerOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplacePulverizerOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplacePulverizerOutputAction("dustAluminum", ItemMaterial.dustAluminum));
        updateActions.add(new ReplacePulverizerOutputAction("dustSteel", ItemMaterial.dustSteel));
        updateActions.add(new ReplacePulverizerOutputAction("dustDiamond", new ItemStack(MekanismItems.OtherDust)));
        updateActions.add(new ReplacePulverizerOutputAction("gemAmber", new ItemStack(ItemsTC.amber)));
        updateActions.add(new ReplacePulverizerOutputAction("gemSapphire", new ItemStack(ModItems.sapphireGem)));
        updateActions.add(new ReplacePulverizerOutputAction("dustCoal", ItemMaterial.dustCoal));

        updateActions.add(new AddOrReplacePulverizerRecipeAction(7000, ItemStackHelper.oreNetherCoal, coal, null, 0));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(7000, ItemStackHelper.oreNetherRedstone, redstone, null, 0));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(7000, ItemStackHelper.oreNetherLapis, lapis, null, 0));

        updateActions.add(new AddOrReplacePulverizerRecipeAction(7000, ItemStackHelper.oreEndCoal, coal, null, 0));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(7000, ItemStackHelper.oreEndRedstone, redstone, null, 0));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(7000, ItemStackHelper.oreEndLapis, lapis, null, 0));

        /*updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1, 2), ItemMaterial.dustCopper, 3, ItemMaterial.dustCopper, 1, 25));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1, 3), ItemMaterial.dustTin, 3, ItemMaterial.dustTin, 1, 25));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1), ItemMaterial.dustIron, 3, ItemMaterial.dustIron, 1, 25));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1, 5), ItemMaterial.dustLead, 3, ItemMaterial.dustLead, 1, 25));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1, 4), ItemMaterial.dustSilver, 3, ItemMaterial.dustSilver, 1, 25));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1, 1), ItemMaterial.dustGold, 3, ItemMaterial.dustGold, 1, 25));
        updateActions.add(new AddOrReplacePulverizerRecipeAction(5000, new ItemStack(ItemsTC.clusters, 1, 7), quartz, 4, quartz, 2, 25));*/
    }
}
