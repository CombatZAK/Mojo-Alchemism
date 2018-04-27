package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;

/**
 * An input for a recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public interface IIngredient {
    /**
     * Retrieves the forge ingredient for the recipe
     */
    Object getIngredient();

    /**
     * Indicates whether an item is a match to the ingredient; ignores count
     *
     * @param target Item to compare for a match
     * @return true if the item is a match; false otherwise
     */
    boolean isMatch(ItemStack target);
}
