package com.mods.combatzak.mojo.alchemism.actions.cofh.smelter;

import cofh.thermalexpansion.util.managers.machine.SmelterManager;
import net.minecraft.item.ItemStack;

public class AddOrReplaceInductionSmelterRecipeAction extends InductionSmelterAction {
    public AddOrReplaceInductionSmelterRecipeAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryOutputChance) {
        super(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, secondaryOutputChance);
    }

    public AddOrReplaceInductionSmelterRecipeAction(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, int primaryCount, ItemStack secondaryOutput, int secondaryCount, int secondaryOutputChance) {
        super(energy,
                primaryInput,
                secondaryInput,
                primaryOutput.getCount() == primaryCount ? primaryOutput : primaryOutput.copy(),
                secondaryOutput == null || secondaryOutput.getCount() == secondaryCount ? secondaryOutput : secondaryOutput.copy(),
                secondaryOutputChance);

        this.primaryOutput.setCount(primaryCount);
        if (secondaryOutput != null) {
            this.secondaryOutput.setCount(secondaryCount);
        }
    }

    public AddOrReplaceInductionSmelterRecipeAction() {
        this(0, null, null, null, null, 0);
    }

    @Override
    public boolean apply() {
        if (primaryInput == null)
            throw new IllegalStateException("AddOrReplaceInductionSmelterRecipeAction requires valid primary input stack");
        if (secondaryInput == null)
            throw new IllegalStateException("AddOrReplaceInductionSmelterRecipeAction requires valid secondary input stack");
        if (primaryOutput == null)
            throw new IllegalStateException("AddOrReplaceInductionSmelterRecipeAction requires valid primary output stack");
        if (energy <= 0)
            throw new IllegalStateException("AddOrReplaceInductionSmelterRecipeAction requires valid energy amount");
        if (secondaryOutput != null && secondaryOutputChance <= 0)
            throw new IllegalStateException("AddOrReplaceInductionSmelterRecipeAction with secondary output requires valid secondary output chance");

        SmelterManager.removeRecipe(primaryInput, secondaryInput);
        if (secondaryOutput != null) {
            SmelterManager.addRecipe(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, secondaryOutputChance);
        } else {
            SmelterManager.addRecipe(energy, primaryInput, secondaryInput, primaryOutput);
        }

        setApplied();
        return true;
    }
}
