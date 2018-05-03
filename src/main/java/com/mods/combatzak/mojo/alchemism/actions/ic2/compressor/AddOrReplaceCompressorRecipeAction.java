package com.mods.combatzak.mojo.alchemism.actions.ic2.compressor;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

/**
 * Adds or replaces a compressor recipe
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class AddOrReplaceCompressorRecipeAction extends CompressorAction {
    private int amount;

    public AddOrReplaceCompressorRecipeAction(IRecipeInput input, ItemStack output, int amount) {
        super(input, output);
        this.amount = amount;
    }

    public AddOrReplaceCompressorRecipeAction(IRecipeInput input, ItemStack output) {
        this(input, output, output.getCount());
    }

    public AddOrReplaceCompressorRecipeAction(ItemStack input, ItemStack output, int amount) {
        super(input, output);
        this.amount = amount;
    }

    public AddOrReplaceCompressorRecipeAction(ItemStack input, ItemStack output) {
        this(input, output, output.getCount());
    }

    public AddOrReplaceCompressorRecipeAction(String input, ItemStack output, int amount) {
        super(input, output);
        this.amount = amount;
    }

    public AddOrReplaceCompressorRecipeAction(String input, ItemStack output) {
        this(input, output, output.getCount());
    }

    public AddOrReplaceCompressorRecipeAction() {
        this((IRecipeInput)null, null, 0);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("AddOrReplaceCompressorRecipeAction requires valid recipe input");
        if (output == null) throw new IllegalStateException("AddOrReplaceCompressorRecipeAction requires valid output stack");

        Recipes.compressor.addRecipe(input, null, true, output);
        setApplied();
        return true;
    }
}
