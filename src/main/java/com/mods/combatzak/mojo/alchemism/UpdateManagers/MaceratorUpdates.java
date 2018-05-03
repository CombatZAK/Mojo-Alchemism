package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.AddOrReplaceMaceratorRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.ReplaceMaceratorOutputAction;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import ic2.api.item.IC2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.items.ItemsTC;

/**
 * Governs all the updates to Macerator recipes
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class MaceratorUpdates extends UpdateManager{
    private static MaceratorUpdates ourInstance = new MaceratorUpdates();

    public static MaceratorUpdates getInstance() {
        return ourInstance;
    }

    private MaceratorUpdates() {
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
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterCopper, IC2Items.getItem("purified", "copper"), 3));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterTin, IC2Items.getItem("purified", "tin"), 3));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterLead, IC2Items.getItem("purified", "lead"), 3));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterSilver, IC2Items.getItem("purified", "silver"), 3));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterIron, IC2Items.getItem("purified", "iron"), 3));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterGold, IC2Items.getItem("purified", "gold"), 3));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterCinnabar, new ItemStack(ItemsTC.quicksilver, 3)));
        updateActions.add(new AddOrReplaceMaceratorRecipeAction(ItemStackHelper.clusterQuartz, new ItemStack(Items.QUARTZ, 4)));
    }
}
