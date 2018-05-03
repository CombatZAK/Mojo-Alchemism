package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.RemoveMaceratorRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.RemoveOreEntryAction;
import erogenousbeef.bigreactors.init.BrItems;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;

/**
 * Let's try some shit
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class TestUpdateManager extends UpdateManager {
    private static TestUpdateManager ourInstance = new TestUpdateManager();

    public static TestUpdateManager getInstance() {
        return ourInstance;
    }

    private TestUpdateManager() {
        //updateActions.add(new RemoveMaceratorRecipeAction("ingotCopper"));
        updateActions.add(new RemoveOreEntryAction("ingotUranium", IC2Items.getItem("ingot", "uranium")));
    }
}
