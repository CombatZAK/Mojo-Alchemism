package com.mods.combatzak.mojo.alchemism.actions.cofh.pulverizer;

import com.mods.combatzak.mojo.alchemism.actions.cofh.CoFHAction;
import net.minecraft.item.ItemStack;

/**
 * Manipulation of a ThermalExpansion Pulverizer recipe
 *
 * Created by CombatZAK on 4/19/2018.
 */
public abstract class PulverizerAction extends CoFHAction {
    protected ItemStack input;
    protected ItemStack primaryOutput;
    protected ItemStack secondaryOutput;
    protected int secondaryChance;

    public PulverizerAction(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {
        super(energy);

        this.input = input;
        this.primaryOutput = primaryOutput;
        this.secondaryOutput = secondaryOutput;
        this.secondaryChance = secondaryChance;
    }

    public PulverizerAction(int energy, ItemStack input, ItemStack primaryOutput) {
        this(energy, input, primaryOutput, null, 0);
    }

    public PulverizerAction() {
        this(0, null, null, null, 0);
    }
}
