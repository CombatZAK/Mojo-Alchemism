package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import com.mods.combatzak.mojo.alchemism.actions.ic2.IC2Action;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;

import net.minecraft.item.ItemStack;

public abstract class MaceratorAction extends IC2Action {
    protected IRecipeInput input;
    protected ItemStack output;

    public MaceratorAction(IRecipeInput input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public MaceratorAction(ItemStack input, ItemStack output) {
        this(Recipes.inputFactory.forStack(input), output);
    }

    public MaceratorAction(String input, ItemStack output) {
        this(Recipes.inputFactory.forOreDict(input), output);
    }

    public MaceratorAction() {
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
