package com.mods.combatzak.mojo.alchemism.actions.cofh.pulverizer;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;
import net.minecraft.item.ItemStack;

/**
 * Removes a pulverizer recipe based on its input
 */
public class RemovePulverizerRecipeAction extends PulverizerAction {
    public RemovePulverizerRecipeAction(ItemStack input) {
        super(0, input, null, null, 0);
    }

    public RemovePulverizerRecipeAction() {
        this(null);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemovePulverizerRecipeAction requires valid input object");

        PulverizerManager.removeRecipe(input);
        setApplied();
        return true;
    }
}
