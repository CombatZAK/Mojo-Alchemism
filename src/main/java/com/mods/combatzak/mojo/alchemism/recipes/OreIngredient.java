package com.mods.combatzak.mojo.alchemism.recipes;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Ore dictionary input for a recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public class OreIngredient implements IIngredient {
    private String ingredient;

    public OreIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public OreIngredient() {
        this(null);
    }

    @Override
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean isMatch(ItemStack target) {
        if (target == null) return false; //let's not worry about non-initialized ingredients right now

        return ItemStackHelper.isOreDictMatch(target, ingredient);
    }
}
