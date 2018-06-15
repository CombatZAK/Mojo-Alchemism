package com.mods.combatzak.mojo.alchemism.actions.ie.alloykiln;

import blusunrize.immersiveengineering.api.crafting.AlloyRecipe;
import blusunrize.immersiveengineering.common.crafting.RecipeSpeeloader;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces the output of Alloy Kiln recipes matching an ore dictionary entry
 * Created by CombatZAK on 5/23/2018.
 */
public class ReplaceAlloyKilnOutputAction extends AlloyKilnAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceAlloyKilnOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    @Override
    public boolean apply() {
        List<AlloyRecipe> matches = new ArrayList<>();
        for (AlloyRecipe recipe : AlloyRecipe.recipeList) {
            if (ItemStackHelper.isOreDictMatch(recipe.output, oreEntry) && !(ItemStackHelper.isDirectMatch(output, recipe.output))) {
                matches.add(recipe);
            }
        }

        for (AlloyRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.output.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldRecipe.output.getCount());

            AlloyRecipe.recipeList.remove(oldRecipe);
            AlloyRecipe.addRecipe(newOutput, oldRecipe.input0, oldRecipe.input1, oldRecipe.time);
        }

        setApplied();
        return true;
    }
}
