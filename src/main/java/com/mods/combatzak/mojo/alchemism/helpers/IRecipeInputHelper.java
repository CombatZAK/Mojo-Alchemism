package com.mods.combatzak.mojo.alchemism.helpers;

import ic2.api.recipe.IRecipeInput;
import ic2.core.recipe.RecipeInputItemStack;
import ic2.core.recipe.RecipeInputOreDict;

/**
 * Helps match IC2 IRecipeInputs
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class IRecipeInputHelper {
    /**
     * Compares two IC2 IRecipeInput objects for varying degrees of equality
     *
     * @param first comparand one
     * @param second comparand two
     * @param ignoreCount require precise amount match
     * @return true if the inputs match
     */
    public static boolean isMatch(IRecipeInput first, IRecipeInput second, boolean ignoreCount) {
        if (first == null ^ second == null) return false; //single-null test
        if (first == null) return true; //double null test
        if (!first.getClass().equals(second.getClass())) return false; //not same type
        if (first instanceof RecipeInputItemStack) return isMatch((RecipeInputItemStack)first, (RecipeInputItemStack)second, ignoreCount);
        if (first instanceof RecipeInputOreDict) return isMatch((RecipeInputOreDict)first, (RecipeInputOreDict)second, ignoreCount);

        return false;
    }

    public static boolean isMatch(IRecipeInput first, IRecipeInput second) {
        return isMatch(first, second, true);
    }

    public static boolean isMatch(RecipeInputItemStack first, RecipeInputItemStack second, boolean ignoreCount) {
        return ItemStackHelper.isDirectMatch(first.input, second.input) && (ignoreCount || first.amount == second.amount);
    }

    public static boolean isMatch(RecipeInputOreDict first, RecipeInputOreDict second, boolean ignoreCount) {
        return first.input.equals(second.input) && (ignoreCount || first.amount == second.amount);
    }
}
