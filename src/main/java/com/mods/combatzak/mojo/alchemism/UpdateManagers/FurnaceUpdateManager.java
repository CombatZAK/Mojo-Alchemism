package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.vanilla.ReplaceFurnaceOutputAction;

/**
 * Manages the updates to furnace recipes
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class FurnaceUpdateManager extends UpdateManager {
    private static FurnaceUpdateManager ourInstance = new FurnaceUpdateManager();

    public static FurnaceUpdateManager getInstance() {
        return ourInstance;
    }

    private FurnaceUpdateManager() {
        //INGOTS
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotCopper, "ingotCopper"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotTin, "ingotTin"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotBronze, "ingotBronze"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotLead, "ingotLead"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotSilver, "ingotSilver"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotAluminum, "ingotAluminum"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.ingotSteel, "ingotSteel"));

        //NUGGETS
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.nuggetBronze, "nuggetBronze"));
        updateActions.add(new ReplaceFurnaceOutputAction(ItemMaterial.nuggetSteel, "nuggetSteel"));
    }
}
