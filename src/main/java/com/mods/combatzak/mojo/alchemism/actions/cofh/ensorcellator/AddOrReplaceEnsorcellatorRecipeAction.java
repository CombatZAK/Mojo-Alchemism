package com.mods.combatzak.mojo.alchemism.actions.cofh.ensorcellator;

import cofh.thermalexpansion.util.managers.machine.EnchanterManager;
import cofh.thermalexpansion.util.managers.machine.EnchanterManager.EnchanterRecipe;
import com.mods.combatzak.mojo.alchemism.actions.cofh.furnace.AddOrReplaceRedstoneFurnaceRecipeAction;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Adds or replaces a recipe for the Arcane Ensorcellator
 * Created by CombatZAK on 5/24/2018.
 */
public class AddOrReplaceEnsorcellatorRecipeAction extends EnsorcellatorAction {
    private ItemStack input;
    String enchantment;
    private int tier;

    public AddOrReplaceEnsorcellatorRecipeAction(ItemStack input, String enchantment, int tier) {
        this.input = input;
        this.enchantment = enchantment;
        this.tier = tier;
    }

    @Override
    public boolean apply() {
        List<EnchanterRecipe> matches = new ArrayList<>();
        for (EnchanterRecipe recipe : EnchanterManager.getRecipeList()) {
            if (enchantment.equals(recipe.getEnchantName())) {
                matches.add(recipe);
            }
        }

        for (EnchanterRecipe oldRecipe : matches) {
            EnchanterManager.removeRecipe(oldRecipe.getPrimaryInput(), oldRecipe.getSecondaryInput());
        }

        EnchanterManager.addDefaultEnchantmentRecipe(input, enchantment, tier);

        setApplied();
        return true;
    }
}
