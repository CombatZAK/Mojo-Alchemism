package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Manages a modification to the ore dictionary
 *
 * Created by CombatZAK on 5/1/2018.
 */
public abstract class OreDictAction extends MojoAction {
    protected String oreEntry;

    public OreDictAction(String oreEntry) {
        this.oreEntry = oreEntry;
    }

    public OreDictAction() {
        this(null);
    }
}
