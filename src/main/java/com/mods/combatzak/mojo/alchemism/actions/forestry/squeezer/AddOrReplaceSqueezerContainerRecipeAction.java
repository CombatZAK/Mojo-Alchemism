package com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import forestry.api.recipes.RecipeManagers;
import forestry.factory.recipes.SqueezerRecipeManager;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Adds or replaces a squeezer container recipe
 *
 * Created by CombatZAK on 5/8/2018.
 */
public class AddOrReplaceSqueezerContainerRecipeAction extends AddOrReplaceSqueezerRecipeAction {
    public AddOrReplaceSqueezerContainerRecipeAction(int time, ItemStack input, ItemStack output, int itemChance) {
        super(time, Stream.of(input).collect(Collectors.toList()), output, itemChance, null);
    }

    @Override
    public boolean apply() {
        ItemStack match = null;
        for (ItemStack inputKey : SqueezerRecipeManager.containerRecipes.keySet()) {
            if (ItemStackHelper.isDirectMatch(inputs.get(0), inputKey)) {
                match = inputKey;
                break;
            }
        }

        if (match != null) {
            SqueezerRecipeManager.containerRecipes.remove(match);
        }

        RecipeManagers.squeezerManager.addContainerRecipe(time, inputs.get(0), itemOutput, itemChance / 100f);
        setApplied();
        return true;
    }
}
