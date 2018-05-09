package com.mods.combatzak.mojo.alchemism.actions.ic2.thermalcentrifuge;

import com.mods.combatzak.mojo.alchemism.helpers.IRecipeInputHelper;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.Iterator;

/**
 * Removes a Thermal Centrifuge recipe
 *
 * Created by CombatZAK on 5/4/2018.
 */
public class RemoveCentrifugeRecipeAction extends CentrifugeAction {
    public RemoveCentrifugeRecipeAction(IRecipeInput input) {
        super((short)0, input);
    }

    public RemoveCentrifugeRecipeAction(ItemStack input) {
        super((short)0, input);
    }

    public RemoveCentrifugeRecipeAction(String input) {
        super((short)0, input);
    }

    public RemoveCentrifugeRecipeAction() {
        this((IRecipeInput)null);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemoveCentrifugeRecipeAction requires valid recipe input");

        Iterator<? extends MachineRecipe<IRecipeInput, Collection<ItemStack>>> iterator = Recipes.centrifuge.getRecipes().iterator();
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
