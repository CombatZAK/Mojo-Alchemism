package com.mods.combatzak.mojo.alchemism.actions.ic2.compressor;

import com.mods.combatzak.mojo.alchemism.helpers.IRecipeInputHelper;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.Iterator;

/**
 * Removes a Compressor recipe
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class RemoveCompressorRecipeAction extends CompressorAction {
    public RemoveCompressorRecipeAction(IRecipeInput input) {
        super(input, null);
    }

    public RemoveCompressorRecipeAction(ItemStack input) {
        super(input, null);
    }

    public RemoveCompressorRecipeAction(String input) {
        super(input, null);
    }

    public RemoveCompressorRecipeAction() {
        this((IRecipeInput)null);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemoveCompressorRecipeAction requires valid recipe input");

        Iterator<? extends MachineRecipe<IRecipeInput, Collection<ItemStack>>> iterator = Recipes.compressor.getRecipes().iterator();
        while (iterator.hasNext()) {
            MachineRecipe<IRecipeInput, Collection<ItemStack>> curRecipe = iterator.next();
            IRecipeInput curInput = curRecipe.getInput();
            if (IRecipeInputHelper.isMatch(input, curInput)) {
                iterator.remove();
            }
        }

        setApplied();
        return true;
    }
}
