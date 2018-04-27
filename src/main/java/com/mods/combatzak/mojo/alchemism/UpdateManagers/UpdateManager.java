package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import com.mods.combatzak.mojo.GroupAction;

/**
 * Base class for update collections to be applied at loadtime
 *
 * Created by CombatZAK on 4/22/2018.
 */
public abstract class UpdateManager {
    protected GroupAction updateActions = new GroupAction();

    protected UpdateManager() { }

    public void applyUpdates() {
        if (!updateActions.isApplied()) {
            updateActions.apply();
        }
    }
}
