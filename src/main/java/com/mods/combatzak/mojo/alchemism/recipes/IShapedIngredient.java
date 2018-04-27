package com.mods.combatzak.mojo.alchemism.recipes;

/**
 * Extension of ingredient that has a relative position in a recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public interface IShapedIngredient extends IIngredient {
    /**
     * The character flag for the ingredient in a shaped recipe
     */
    char getLabel();
}
