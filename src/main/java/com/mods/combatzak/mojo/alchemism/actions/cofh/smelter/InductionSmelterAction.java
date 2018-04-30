package com.mods.combatzak.mojo.alchemism.actions.cofh.smelter;

import com.mods.combatzak.mojo.alchemism.actions.cofh.CoFHAction;
import net.minecraft.item.ItemStack;

public abstract class InductionSmelterAction extends CoFHAction {
    protected ItemStack primaryInput;
    protected ItemStack secondaryInput;
    protected ItemStack primaryOutput;
    protected ItemStack secondaryOutput;
    protected int secondaryOutputChance;

    public InductionSmelterAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryOutputChance) {
        super(energy);
        this.primaryInput = primaryInput;
        this.secondaryInput = secondaryInput;
        this.primaryOutput = primaryOutput;
        this.secondaryOutput = secondaryOutput;
        this.secondaryOutputChance = secondaryOutputChance;
    }

    public InductionSmelterAction() {
        this(0, null, null, null, null, 0);
    }

    public ItemStack getPrimaryInput() {
        return primaryInput;
    }

    public void setPrimaryInput(ItemStack primaryInput) {
        this.primaryInput = primaryInput;
    }

    public ItemStack getSecondaryInput() {
        return secondaryInput;
    }

    public void setSecondaryInput(ItemStack secondaryInput) {
        this.secondaryInput = secondaryInput;
    }

    public ItemStack getPrimaryOutput() {
        return primaryOutput;
    }

    public void setPrimaryOutput(ItemStack primaryOutput) {
        this.primaryOutput = primaryOutput;
    }

    public ItemStack getSecondaryOutput() {
        return secondaryOutput;
    }

    public void setSecondaryOutput(ItemStack secondaryOutput) {
        this.secondaryOutput = secondaryOutput;
    }

    public int getSecondaryOutputChance() {
        return secondaryOutputChance;
    }

    public void setSecondaryOutputChance(int secondaryOutputChance) {
        this.secondaryOutputChance = secondaryOutputChance;
    }
}
