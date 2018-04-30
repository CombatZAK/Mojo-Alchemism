package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import ic2.core.recipe.BasicMachineRecipeManager;
import net.minecraft.item.ItemStack;

public class RemoveMaceratorRecipeAction extends MaceratorAction {
    public RemoveMaceratorRecipeAction(IRecipeInput input) {
        super(input, null);
    }

    public RemoveMaceratorRecipeAction(ItemStack input) {
        super(input, null);
    }

    public RemoveMaceratorRecipeAction(String input, null) {
        super(input, null);
    }

    public RemoveMaceratorRecipeAction() {
        this((IRecipeInput)null);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemoveMaceratorRecipeAction required valid input");

        ((BasicMachineRecipeManager)Recipes.macerator).get
    }
}
