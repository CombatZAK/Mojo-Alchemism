package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ae2.grinder.ReplaceGrinderOutputAction;

/**
 * Stores modifications to AE2 Grinder Recipes
 * Created by CombatZAK on 5/12/2018.
 */
public class GrinderUpdateManager extends UpdateManager {
    private static GrinderUpdateManager ourInstance = new GrinderUpdateManager();

    public static GrinderUpdateManager getInstance() {
        return ourInstance;
    }

    private GrinderUpdateManager() {
        updateActions.add(new ReplaceGrinderOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplaceGrinderOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplaceGrinderOutputAction("dustBronze", ItemMaterial.dustBronze));
        updateActions.add(new ReplaceGrinderOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplaceGrinderOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplaceGrinderOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplaceGrinderOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplaceGrinderOutputAction("dustAluminum", ItemMaterial.dustAluminum));
        updateActions.add(new ReplaceGrinderOutputAction("dustCoal", ItemMaterial.dustCoal));
        updateActions.add(new ReplaceGrinderOutputAction("dustObsidian", ItemMaterial.dustObsidian));
    }
}
