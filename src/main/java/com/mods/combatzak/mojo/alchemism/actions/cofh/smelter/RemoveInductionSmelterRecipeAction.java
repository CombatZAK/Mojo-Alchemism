package com.mods.combatzak.mojo.alchemism.actions.cofh.smelter;

import cofh.thermalexpansion.util.managers.machine.SmelterManager;
import net.minecraft.item.ItemStack;

public class RemoveInductionSmelterRecipeAction extends InductionSmelterAction {
    public RemoveInductionSmelterRecipeAction(ItemStack primaryInput, ItemStack secondaryInput) {
        super(0, primaryInput, secondaryInput, null, null, 0);
    }

    public RemoveInductionSmelterRecipeAction() {
        this(null, null);
    }

    @Override
    public boolean apply() {
        if (primaryInput == null) throw new IllegalStateException("RemoveInductionSmelterRecipeAction requires valid primary input stack");
        if (secondaryInput == null) throw new IllegalStateException("RemoveInductionSmelterRecipeAction requires valid secondary input stack");

        SmelterManager.removeRecipe(primaryInput, secondaryInput);
        setApplied();
        return true;
    }
}
