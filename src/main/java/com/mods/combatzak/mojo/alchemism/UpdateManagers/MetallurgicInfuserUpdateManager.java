package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.mekanism.metallurgicinfuser.ReplaceMetallurgicInfuserOutputAction;

/**
 * Stores modifications to Metallurgic Infuser
 * Created by CombatZAK on 5/11/2018.
 */
public class MetallurgicInfuserUpdateManager extends UpdateManager {
    private static MetallurgicInfuserUpdateManager ourInstance = new MetallurgicInfuserUpdateManager();

    public static MetallurgicInfuserUpdateManager getInstance() {
        return ourInstance;
    }

    private MetallurgicInfuserUpdateManager() {
        updateActions.add(new ReplaceMetallurgicInfuserOutputAction("ingotBronze", ItemMaterial.ingotBronze));
        updateActions.add(new ReplaceMetallurgicInfuserOutputAction("dustSteel", ItemMaterial.dustSteel));
    }
}
