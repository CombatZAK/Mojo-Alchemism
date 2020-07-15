package com.mods.combatzak.mojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by CombatZAK on 4/19/2018.
 */
public class GroupAction extends MojoAction {
    private List<MojoAction> actions = new ArrayList<>();

    public boolean add(MojoAction action) {
        return actions.add(action);
    }

    public boolean addAll(Collection<? extends MojoAction> actions) {
        return this.actions.addAll(actions);
    }

    public List<MojoAction> getActions() {
        return actions;
    }

    @Override
    public boolean apply() {
        boolean success = true;
        for (MojoAction action : actions) {
            success &= action.apply(); //we are successful iff ALL owned actions are successful
        }

        setApplied();
        return success;
    }
}
