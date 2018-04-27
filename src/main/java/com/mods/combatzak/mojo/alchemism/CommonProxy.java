package com.mods.combatzak.mojo.alchemism;

import com.mods.combatzak.mojo.alchemism.UpdateManagers.CraftingUpdateManager;

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
    }
}
