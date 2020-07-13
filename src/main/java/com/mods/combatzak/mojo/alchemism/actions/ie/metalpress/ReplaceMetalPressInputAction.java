package com.mods.combatzak.mojo.alchemism.actions.ie.metalpress;

import binnie.core.util.collect.ListMultiMap;
import blusunrize.immersiveengineering.api.ComparableItemStack;
import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by CombatZAK on 7/12/2020.
 */
public class ReplaceMetalPressInputAction extends MetalPressAction{
    ItemStack mold;
    ItemStack input;
    ItemStack output;

    public ReplaceMetalPressInputAction(ItemStack mold, ItemStack input, ItemStack output) {
        this.mold = mold;
        this.input = input;
        this.output = output;
    }

    @Override
    public boolean apply() {
        List<Map.Entry<ComparableItemStack, MetalPressRecipe>> matches = new ArrayList<>();
        for (Map.Entry<ComparableItemStack, MetalPressRecipe> entry : MetalPressRecipe.recipeList.entries()) {
            MetalPressRecipe recipe = entry.getValue();
            if (ItemStackHelper.isDirectMatch(output, recipe.output) && ItemStackHelper.isDirectMatch(mold, recipe.mold.stack)) {
                matches.add(entry);
            }
        }

        for (Map.Entry<ComparableItemStack, MetalPressRecipe> entry : matches) {
            MetalPressRecipe.recipeList.remove(entry.getKey(), entry.getValue());

            MetalPressRecipe recipe = entry.getValue();
            MetalPressRecipe.addRecipe(recipe.output, input, mold, recipe.getTotalProcessEnergy());
        }

        setApplied();
        return true;
    }
}
