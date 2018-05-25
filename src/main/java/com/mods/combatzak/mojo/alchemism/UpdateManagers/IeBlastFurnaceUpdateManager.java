package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ie.blastfurnace.ReplaceBlastFurnaceOutputAction;

/**
 * Manages updates to the IE Blast Furnace
 * Created by CombatZAK on 5/24/2018.
 */
public class IeBlastFurnaceUpdateManager extends UpdateManager {
    private static IeBlastFurnaceUpdateManager ourInstance = new IeBlastFurnaceUpdateManager();

    public static IeBlastFurnaceUpdateManager getInstance() {
        return ourInstance;
    }

    private IeBlastFurnaceUpdateManager() {
        updateActions.add(new ReplaceBlastFurnaceOutputAction("ingotSteel", ItemMaterial.ingotSteel));
        updateActions.add(new ReplaceBlastFurnaceOutputAction("blockSteel", BlockStorageAlloy.blockSteel));
    }
}
