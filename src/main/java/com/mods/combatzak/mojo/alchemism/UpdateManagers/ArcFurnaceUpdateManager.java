package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.init.TFItems;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.ie.arcfurnace.ReplaceArcFurnaceOutputAction;

/**
 * Manages updates to the IE Arc Furnace
 * Created by CombatZAK on 5/23/2018.
 */
public class ArcFurnaceUpdateManager extends UpdateManager {
    private static ArcFurnaceUpdateManager ourInstance = new ArcFurnaceUpdateManager();

    public static ArcFurnaceUpdateManager getInstance() {
        return ourInstance;
    }

    private ArcFurnaceUpdateManager() {
        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotConstantan", ItemMaterial.ingotConstantan));
        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotElectrum", ItemMaterial.ingotElectrum));
        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotSteel", ItemMaterial.ingotSteel));

        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotCopper", ItemMaterial.ingotCopper));
        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotSilver", ItemMaterial.ingotSilver));
        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotLead", ItemMaterial.ingotLead));
        updateActions.add(new ReplaceArcFurnaceOutputAction("ingotAluminum", ItemMaterial.ingotAluminum));
    }
}
