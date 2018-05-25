package com.mods.combatzak.mojo.alchemism.actions.ie.cokeoven;

import blusunrize.immersiveengineering.api.crafting.CokeOvenRecipe;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces all coke oven outputs that match an ore dictionary entry
 * Created by CombatZAK on 5/23/2018.
 */
public class ReplaceCokeOvenOutputAction extends CokeOvenAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceCokeOvenOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    @Override
    public boolean apply() {
        List<CokeOvenRecipe> matches = new ArrayList<>();
        for (CokeOvenRecipe recipe : CokeOvenRecipe.recipeList) {
            if (ItemStackHelper.isOreDictMatch(recipe.output, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipe.output)) {
                matches.add(recipe);
            }
        }

        for (CokeOvenRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.output.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldRecipe.output.getCount());

            CokeOvenRecipe.recipeList.remove(oldRecipe);
            CokeOvenRecipe.addRecipe(newOutput, oldRecipe.input, oldRecipe.time, oldRecipe.creosoteOutput);
        }

        setApplied();
        return true;
    }
}
