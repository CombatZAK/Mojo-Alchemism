package com.mods.combatzak.mojo.alchemism.actions.ie.blastfurnace;

import blusunrize.immersiveengineering.api.crafting.BlastFurnaceRecipe;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces outputs of blast furnace recipes matching ore dictionary entry
 * Created by CombatZAK on 5/24/2018.
 */
public class ReplaceBlastFurnaceOutputAction extends BlastFurnaceAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceBlastFurnaceOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    @Override
    public boolean apply() {
        List<BlastFurnaceRecipe> matches = new ArrayList<>();
        for (BlastFurnaceRecipe recipe : BlastFurnaceRecipe.recipeList) {
            if (ItemStackHelper.isOreDictMatch(recipe.output, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipe.output)) {
                matches.add(recipe);
            }
        }

        for (BlastFurnaceRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.output.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldRecipe.output.getCount());

            BlastFurnaceRecipe.recipeList.remove(oldRecipe);
            BlastFurnaceRecipe.addRecipe(newOutput, oldRecipe.input, oldRecipe.time, oldRecipe.slag);
        }

        setApplied();
        return true;
    }
}
