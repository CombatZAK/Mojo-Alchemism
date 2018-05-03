package com.mods.combatzak.mojo.alchemism.actions.cofh.furnace;

import com.mods.combatzak.mojo.alchemism.actions.cofh.CoFHAction;
import net.minecraft.item.ItemStack;

/**
 * Represents a modification to a Redstone Furnace recipe
 *
 * Created by CombatZAK on 4/30/2018.
 */
public abstract class RedstoneFurnaceAction extends CoFHAction {
    protected ItemStack input;
    protected ItemStack output;
    protected boolean pyrolysis;

    public RedstoneFurnaceAction(int energy, ItemStack input, ItemStack output, boolean pyrolysis) {
        super(energy);
        this.input = input;
        this.output = output;
        this.pyrolysis = pyrolysis;
    }

    public RedstoneFurnaceAction() {
        this(0, null, null, false);
    }

    public ItemStack getInput() {
        return input;
    }

    public void setInput(ItemStack input) {
        this.input = input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    public boolean isPyrolysis() {
        return pyrolysis;
    }

    public void setPyrolysis(boolean pyrolysis) {
        this.pyrolysis = pyrolysis;
    }
}
