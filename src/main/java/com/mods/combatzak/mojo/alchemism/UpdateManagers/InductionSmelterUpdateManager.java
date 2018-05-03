package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.cofh.smelter.ReplaceInductionSmelterOutputAction;

/**
 * Manages modifications to induction smelter recipes
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class InductionSmelterUpdateManager extends UpdateManager{
    private static InductionSmelterUpdateManager ourInstance = new InductionSmelterUpdateManager();

    public static InductionSmelterUpdateManager getInstance() {
        return ourInstance;
    }

    private InductionSmelterUpdateManager() {
        //INGOTS
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotCopper", ItemMaterial.ingotCopper));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotTin", ItemMaterial.ingotTin ));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotBronze", ItemMaterial.ingotBronze));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotLead", ItemMaterial.ingotLead));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotSilver", ItemMaterial.ingotSilver));
        updateActions.add(new ReplaceInductionSmelterOutputAction("ingotSteel", ItemMaterial.ingotSteel));
    }
}
