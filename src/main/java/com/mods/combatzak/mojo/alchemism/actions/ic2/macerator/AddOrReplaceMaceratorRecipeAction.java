package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

public class AddOrReplaceMaceratorRecipeAction extends MaceratorAction {
    public AddOrReplaceMaceratorRecipeAction(IRecipeInput input, ItemStack output) {
        super(input, output);
    }

    public AddOrReplaceMaceratorRecipeAction(ItemStack input, ItemStack output) {
        super(input, output);
    }

    public AddOrReplaceMaceratorRecipeAction(String input, ItemStack output) {
        super(input, output);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("AddOrReplaceMaceratorRecipeAction requires valid input");
        if (output == null) throw new IllegalStateException("AddOrReplaceMaceratorRecipeAction requires valid output");

        Recipes.macerator.addRecipe(input, null, true, output);
        setApplied();
        return true;
    }
}
