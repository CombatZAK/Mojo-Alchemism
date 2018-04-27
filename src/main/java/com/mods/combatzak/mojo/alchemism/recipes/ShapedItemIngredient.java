package com.mods.combatzak.mojo.alchemism.recipes;

import net.minecraft.item.ItemStack;

/**
 * Item stack input for a shaped recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public class ShapedItemIngredient extends ItemIngredient implements IShapedIngredient {
    private char label;

    public ShapedItemIngredient(ItemStack ingredient, char label) {
        super(ingredient);
        this.label = label;
    }

    public ShapedItemIngredient() {
        this(null, '\0');
    }

    @Override
    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }
}
