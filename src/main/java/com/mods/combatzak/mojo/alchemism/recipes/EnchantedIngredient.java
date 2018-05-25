package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

/**
 * Created by CombatZAK on 5/24/2018.
 */
public class EnchantedIngredient extends ItemIngredient {
    public EnchantedIngredient(ItemStack item) {
        super(item);
    }

    @Override
    public Ingredient getForgeIngredient() {
        return new EnchantmentForgeIngredient(this.getIngredient());
    }
}
