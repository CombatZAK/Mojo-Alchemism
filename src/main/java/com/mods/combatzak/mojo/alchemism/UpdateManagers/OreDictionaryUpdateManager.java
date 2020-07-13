package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import blusunrize.immersiveengineering.common.IEContent;
import com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer.AddOrReplaceSqueezerContainerRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.AddOreEntryAction;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.RemoveOreEntryAction;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;

/**
 * Manages the updates to the Ore Dictionary
 * Created by CombatZAK on 5/20/2018.
 */
public class OreDictionaryUpdateManager extends UpdateManager {
    private static OreDictionaryUpdateManager ourInstance = new OreDictionaryUpdateManager();

    public static OreDictionaryUpdateManager getInstance() {
        return ourInstance;
    }

    private OreDictionaryUpdateManager() {
        updateActions.add(new RemoveOreEntryAction("ingotUranium", IC2Items.getItem("ingot", "uranium")));
        updateActions.add(new RemoveOreEntryAction("ingotUranium", new ItemStack(IEContent.itemMetal, 1, 5)));
        updateActions.add(new RemoveOreEntryAction("dustUranium", new ItemStack(IEContent.itemMetal, 1, 14)));

        /*updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherCoal, "oreNetherCoal"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherDiamond, "oreNetherDiamond"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherEmerald, "oreNetherEmerald"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherGold, "oreNetherGold"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherIron, "oreNetherIron"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherLapis, "oreNetherLapis"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherRedstone, "oreNetherRedstone"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherAluminum, "oreNetherAluminum"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherCopper, "oreNetherCopper"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherIridium, "oreNetherIridium"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherLead, "oreNetherLead"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherNickel, "oreNetherNickel"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherPlatinum, "oreNetherPlatinum"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherSilver, "oreNetherSilver"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherTin, "oreNetherTin"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherCertus, "oreNetherCertus"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherCertusCharged, "oreNetherCertusCharged"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherOsmium, "oreNetherOsmium"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherUranium, "oreNetherUranium"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreNetherYellorite, "oreNetherYellorite"));

        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndCoal, "oreEndCoal"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndDiamond, "oreEndDiamond"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndEmerald, "oreEndEmerald"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndGold, "oreEndGold"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndIron, "oreEndIron"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndLapis, "oreEndLapis"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndRedstone, "oreEndRedstone"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndAluminum, "oreEndAluminum"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndCopper, "oreEndCopper"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndIridium, "oreEndIridium"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndLead, "oreEndLead"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndNickel, "oreEndNickel"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndPlatinum, "oreEndPlatinum"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndSilver, "oreEndSilver"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndTin, "oreEndTin"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndCertus, "oreEndCertus"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndCertusCharged, "oreEndCertusCharged"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndOsmium, "oreEndOsmium"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndUranium, "oreEndUranium"));
        updateActions.add(new AddOreEntryAction(ItemStackHelper.oreEndYellorite, "oreEndYellorite"));*/
    }
}
