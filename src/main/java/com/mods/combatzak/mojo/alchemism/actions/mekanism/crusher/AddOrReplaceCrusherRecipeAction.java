package com.mods.combatzak.mojo.alchemism.actions.mekanism.crusher;

import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

/**
 * Adds or replaces a Crusher recipe
 * Created by CombatZAK on 5/9/2018.
 */
public class AddOrReplaceCrusherRecipeAction extends CrusherAction {
    private ItemStack input;
    private ItemStack output;

    public AddOrReplaceCrusherRecipeAction(ItemStack input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    public ItemStack getInput() {
        return input;
    }

    public void setInput(ItemStack input) {
        this.input = input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    @Override
    public boolean apply() {
        RecipeHandler.addCrusherRecipe(input, output);
        setApplied();
        return true;
    }
}
