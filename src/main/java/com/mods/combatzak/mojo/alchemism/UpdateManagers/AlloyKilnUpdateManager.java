package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ie.alloykiln.ReplaceAlloyKilnOutputAction;

/**
 * Manages the updates to the IE Alloy Kiln
 * Created by CombatZAK on 5/23/2018.
 */
public class AlloyKilnUpdateManager extends UpdateManager {
    private static AlloyKilnUpdateManager ourInstance = new AlloyKilnUpdateManager();

    public static AlloyKilnUpdateManager getInstance() {
        return ourInstance;
    }

    private AlloyKilnUpdateManager() {
        this.updateActions.add(new ReplaceAlloyKilnOutputAction("ingotConstantan", ItemMaterial.ingotConstantan));
        this.updateActions.add(new ReplaceAlloyKilnOutputAction("ingotElectrum", ItemMaterial.ingotElectrum));
    }
}
