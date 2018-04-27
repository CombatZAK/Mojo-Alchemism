package com.mods.combatzak.mojo.alchemism.recipes;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

/**
 * An ItemStack ingredient for a recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public class ItemIngredient implements IIngredient {
    private ItemStack ingredient;

    public ItemIngredient(ItemStack ingredient) {
        this.ingredient = ingredient;
    }

    public ItemIngredient() {
        this(null);
    }

    @Override
    public ItemStack getIngredient() {
        return ingredient;
    }

    @Override
    public Ingredient getForgeIngredient() {
        return ingredient == null ? Ingredient.EMPTY : Ingredient.fromStacks(ingredient);
    }

    public void setIngredient(ItemStack ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean isMatch(ItemStack target) {
        if (target == null) return false; //let's not worry about non-initialized ingredients right now
        return ItemStackHelper.isDirectMatch(target, ingredient);
    }
}
