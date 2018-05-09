package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.forestry.centrifuge.ReplaceCentrifugeOutputAction;

/**
 * Manages the updates to Forestry Centrifuge recipes
 *
 * Created by CombatZAK on 5/6/2018.
 */
public class ForestryCentrifugeUpdateManager extends UpdateManager {
    private static ForestryCentrifugeUpdateManager ourInstance = new ForestryCentrifugeUpdateManager();

    public static ForestryCentrifugeUpdateManager getInstance() {
        return ourInstance;
    }

    private ForestryCentrifugeUpdateManager() {
        updateActions.add(new ReplaceCentrifugeOutputAction("dustSulfur", ItemMaterial.dustSulfur));
        updateActions.add(new ReplaceCentrifugeOutputAction("dustObsidian", ItemMaterial.dustObsidian));
    }
}
