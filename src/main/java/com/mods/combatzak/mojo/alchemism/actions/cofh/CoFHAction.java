package com.mods.combatzak.mojo.alchemism.actions.cofh;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Manipulation of a CoFH recipe
 *
 * Created by CombatZAK on 4/19/2018.
 */
public abstract class CoFHAction extends MojoAction {
    protected int energy;

    public CoFHAction(int energy) {
        this.energy = energy;
    }

    public CoFHAction() {
        this(0);
    }

    /**
     * Amount of energy associated with the recipe
     */
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
