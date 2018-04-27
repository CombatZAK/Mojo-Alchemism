package com.mods.combatzak.mojo;

/**
 * Created by CombatZAK on 4/19/2018.
 */
public abstract class MojoAction {
    /**
     * Set to true when the action is applied to avoid duplicating non-repeatable code
     */
    protected boolean isApplied = false;

    public boolean isApplied() {
        return isApplied;
    }

    /**
     * Update applied value
     */
    protected void setApplied(boolean applied) {
        isApplied = applied;
    }

    /**
     * Sets the applied indicator to true
     */
    public void setApplied() {
        setApplied(true);
    }

    /**
     * Applies the action
     *
     * @return true if the action was successfully applied; false otherwise
     */
    public abstract boolean apply();
}