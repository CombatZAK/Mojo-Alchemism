package com.mods.combatzak.mojo.alchemism.actions.ic2.compressor;

import com.mods.combatzak.mojo.alchemism.actions.ic2.IC2Action;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

/**
 * Modifies a Compressor recipe
 *
 * Created by CombatZAK on 5/2/2018.
 */
public abstract class CompressorAction extends IC2Action {
    protected IRecipeInput input;
    protected ItemStack output;

    public CompressorAction(IRecipeInput input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public CompressorAction(ItemStack input, ItemStack output) {
        this(Recipes.inputFactory.forStack(input), output);
    }

    public CompressorAction(String input, ItemStack output) {
        this(Recipes.inputFactory.forOreDict(input), output);
    }

    public CompressorAction() {
        this((IRecipeInput)null, null);
    }

    public IRecipeInput getInput() {
        return input;
    }

    public void setInput(IRecipeInput input) {
        this.input = input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }
}
