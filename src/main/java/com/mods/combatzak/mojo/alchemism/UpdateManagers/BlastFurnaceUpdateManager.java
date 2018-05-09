package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ic2.blastfurnace.ReplaceBlastFurnaceOutputAction;

/**
 * Stores the updates to IC2 Blast Furnace Recipes
 *
 * Created by CombatZAK on 5/6/2018.
 */
public class BlastFurnaceUpdateManager extends UpdateManager{
    private static BlastFurnaceUpdateManager ourInstance = new BlastFurnaceUpdateManager();

    public static BlastFurnaceUpdateManager getInstance() {
        return ourInstance;
    }

    private BlastFurnaceUpdateManager() {
        updateActions.add(new ReplaceBlastFurnaceOutputAction("ingotSteel", ItemMaterial.ingotSteel));
    }
}
