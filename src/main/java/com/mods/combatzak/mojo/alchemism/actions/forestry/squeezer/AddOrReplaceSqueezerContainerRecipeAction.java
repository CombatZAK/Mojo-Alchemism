package com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer;

import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.ItemStack;

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
        RecipeManagers.squeezerManager.addContainerRecipe(time, inputs.get(0), itemOutput, itemChance / 100f);
        setApplied();
        return true;
    }
}
