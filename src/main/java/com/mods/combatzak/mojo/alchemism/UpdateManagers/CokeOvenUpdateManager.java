package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.block.BlockStorageResource;
import cofh.thermalfoundation.init.TFBlocks;
import cofh.thermalfoundation.init.TFItems;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ie.blastfurnace.ReplaceBlastFurnaceOutputAction;
import com.mods.combatzak.mojo.alchemism.actions.ie.cokeoven.ReplaceCokeOvenOutputAction;

/**
 * Manages updates to the IE coke oven
 * Created by CombatZAK on 5/23/2018.
 */
public class CokeOvenUpdateManager extends UpdateManager {
    private static CokeOvenUpdateManager ourInstance = new CokeOvenUpdateManager();

    public static CokeOvenUpdateManager getInstance() {
        return ourInstance;
    }

    private CokeOvenUpdateManager() {
        updateActions.add(new ReplaceCokeOvenOutputAction("fuelCoke", ItemMaterial.fuelCoke));
        updateActions.add(new ReplaceCokeOvenOutputAction("blockFuelCoke", BlockStorageResource.blockCoke));
    }
}
