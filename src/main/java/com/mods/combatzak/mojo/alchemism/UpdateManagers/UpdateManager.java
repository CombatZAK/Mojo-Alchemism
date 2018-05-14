package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.Alchemism;

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
        else {
            System.err.println(getClass().getSimpleName() + " updates already applied.");
        }
    }
}
