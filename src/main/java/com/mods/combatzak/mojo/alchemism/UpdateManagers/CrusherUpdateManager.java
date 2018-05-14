package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ae2.grinder.ReplaceGrinderOutputAction;
import com.mods.combatzak.mojo.alchemism.actions.mekanism.crusher.ReplaceCrusherOutputAction;

/**
 * Contains modifications to Mekanism Crusher recipes
 * Created by CombatZAK on 5/9/2018.
 */
public class CrusherUpdateManager extends UpdateManager {
    private static CrusherUpdateManager ourInstance = new CrusherUpdateManager();

    public static CrusherUpdateManager getInstance() {
        return ourInstance;
    }

    private CrusherUpdateManager() {
        //DUSTS
        updateActions.add(new ReplaceCrusherOutputAction("dustCopper", ItemMaterial.dustCopper));
        updateActions.add(new ReplaceCrusherOutputAction("dustTin", ItemMaterial.dustTin));
        updateActions.add(new ReplaceCrusherOutputAction("dustBronze", ItemMaterial.dustBronze));
        updateActions.add(new ReplaceCrusherOutputAction("dustIron", ItemMaterial.dustIron));
        updateActions.add(new ReplaceCrusherOutputAction("dustLead", ItemMaterial.dustLead));
        updateActions.add(new ReplaceCrusherOutputAction("dustSilver", ItemMaterial.dustSilver));
        updateActions.add(new ReplaceCrusherOutputAction("dustGold", ItemMaterial.dustGold));
        updateActions.add(new ReplaceCrusherOutputAction("dustSteel", ItemMaterial.dustSteel));
        updateActions.add(new ReplaceGrinderOutputAction("dustAluminum", ItemMaterial.dustAluminum));
        updateActions.add(new ReplaceCrusherOutputAction("dustObsidian", ItemMaterial.dustObsidian));
        updateActions.add(new ReplaceCrusherOutputAction("dustCoal", ItemMaterial.dustCoal));
    }
}
