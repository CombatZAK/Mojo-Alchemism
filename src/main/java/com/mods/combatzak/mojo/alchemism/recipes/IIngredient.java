package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

/**
 * An input for a recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public interface IIngredient {
    /**
     * Retrieves the ingredient object for the recipe
     */
    Object getIngredient();

    /**
     * Retrives forge ingredient for the recipe
     */
    Ingredient getForgeIngredient();

    /**
     * Indicates whether an item is a match to the ingredient; ignores count
     *
     * @param target Item to compare for a match
     * @return true if the item is a match; false otherwise
     */
    boolean isMatch(ItemStack target);
}
