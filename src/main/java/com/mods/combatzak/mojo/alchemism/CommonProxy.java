package com.mods.combatzak.mojo.alchemism;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;
import com.mods.combatzak.mojo.alchemism.UpdateManagers.*;
import com.mods.combatzak.mojo.alchemism.actions.cofh.furnace.RedstoneFurnaceAction;
import com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer.SqueezerAction;
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
        CentrifugalSeperatorUpdateManager.getInstance().applyUpdates();

        MaceratorUpdates.getInstance().applyUpdates();
        CompressorUpdateManager.getInstance().applyUpdates();
        ThermalCentrifugeUpdateManager.getInstance().applyUpdates();
        BlastFurnaceUpdateManager.getInstance().applyUpdates();

        ForestryCentrifugeUpdateManager.getInstance().applyUpdates();
        SqueezerUpdateManager.getInstance().applyUpdates();

        TestUpdateManager.getInstance().applyUpdates();
    }
}
