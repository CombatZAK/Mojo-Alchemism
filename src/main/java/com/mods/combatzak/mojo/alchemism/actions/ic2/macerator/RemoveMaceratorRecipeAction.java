package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import ic2.core.recipe.BasicMachineRecipeManager;
import ic2.core.recipe.RecipeInputItemStack;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.Iterator;

public class RemoveMaceratorRecipeAction extends MaceratorAction {
    public RemoveMaceratorRecipeAction(IRecipeInput input) {
        super(input, null);
    }

    public RemoveMaceratorRecipeAction(ItemStack input) {
        super(input, null);
    }

    public RemoveMaceratorRecipeAction(String input) {
        super(input, null);
    }

    public RemoveMaceratorRecipeAction() {
        this((IRecipeInput)null);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemoveMaceratorRecipeAction required valid input");

        Iterator<? extends MachineRecipe<IRecipeInput, Collection<ItemStack>>> iterator = Recipes.macerator.getRecipes().iterator();
        while (iterator.hasNext()) {
            MachineRecipe<IRecipeInput, Collection<ItemStack>> curRecipe = iterator.next();
            IRecipeInput curInput = curRecipe.getInput();
            if (curInput.equals(input)) {
                iterator.remove();
            }
        }

        setApplied();
        return true;
    }
}
