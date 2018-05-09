package com.mods.combatzak.mojo.alchemism.actions.cofh.separator;

import com.mods.combatzak.mojo.alchemism.actions.cofh.CoFHAction;

/**
 * Modifies a recipe for the centrifugal separator
 *
 * Created by CombatZAK on 5/6/2018.
 */
public abstract class SeparatorAction extends CoFHAction {
    public SeparatorAction(int energy) {
        super(energy);
    }

    public SeparatorAction() {
        this(0);
    }
}
