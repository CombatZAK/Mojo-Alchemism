package com.mods.combatzak.mojo.alchemism;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;
import com.mods.combatzak.mojo.alchemism.UpdateManagers.*;
import com.mods.combatzak.mojo.alchemism.actions.cofh.furnace.RedstoneFurnaceAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.macerator.MaceratorAction;

/**
 * Handles initialization
 *
 * Created by CombatZAK on 4/19/2018.
 */
public class CommonProxy {
    /**
     * Occurs during post-load; applies all action categories
     */
    public void registerActions() {
        CraftingUpdateManager.getInstance().applyUpdates();
        FurnaceUpdateManager.getInstance().applyUpdates();
        PulverizerUpdateManager.getInstance().applyUpdates();
        RedstoneFurnaceUpdateManager.getInstance().applyUpdates();
        InductionSmelterUpdateManager.getInstance().applyUpdates();

        MaceratorUpdates.getInstance().applyUpdates();

        TestUpdateManager.getInstance().applyUpdates();
    }
}
