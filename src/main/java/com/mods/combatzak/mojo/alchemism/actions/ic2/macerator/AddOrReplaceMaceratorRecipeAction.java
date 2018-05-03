package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import com.mods.combatzak.mojo.alchemism.actions.ic2.compressor.AddOrReplaceCompressorRecipeAction;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

public class AddOrReplaceMaceratorRecipeAction extends MaceratorAction {
    int amount = 1;

    public AddOrReplaceMaceratorRecipeAction(IRecipeInput input, ItemStack output, int amount) {
        super(input, output);
        this.amount = amount;
    }

    public AddOrReplaceMaceratorRecipeAction(IRecipeInput input, ItemStack output) {
        this(input, output, output.getCount());
    }

    public AddOrReplaceMaceratorRecipeAction(ItemStack input, ItemStack output, int amount) {
        super(input, output);
        this.amount = amount;
    }

    public AddOrReplaceMaceratorRecipeAction(ItemStack input, ItemStack output) {
        this(input, output, output.getCount());
    }

    public AddOrReplaceMaceratorRecipeAction(String input, ItemStack output, int amount) {
        super(input, output);
        this.amount = amount;
    }

    public AddOrReplaceMaceratorRecipeAction(String input, ItemStack output) {
        this(input, output, output.getCount());
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("AddOrReplaceMaceratorRecipeAction requires valid input");
        if (output == null) throw new IllegalStateException("AddOrReplaceMaceratorRecipeAction requires valid output");

        ItemStack outputStack = output.getCount() == amount
                ? output
                : output.copy();
        outputStack.setCount(amount);

        Recipes.macerator.addRecipe(input, null, true, outputStack);
        setApplied();
        return true;
    }
}
