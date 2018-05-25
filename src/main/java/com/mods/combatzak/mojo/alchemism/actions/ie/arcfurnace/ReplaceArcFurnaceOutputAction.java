package com.mods.combatzak.mojo.alchemism.actions.ie.arcfurnace;

import blusunrize.immersiveengineering.api.crafting.ArcFurnaceRecipe;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces all Arc Furnace recipe outputs matching an ore dictionary entry
 * Created by CombatZAK on 5/23/2018.
 */
public class ReplaceArcFurnaceOutputAction extends ArcFurnaceAction {
    String oreEntry;
    ItemStack output;

    public ReplaceArcFurnaceOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    @Override
    public boolean apply() {
        List<ArcFurnaceRecipe> matches = new ArrayList<>();
        for (ArcFurnaceRecipe recipe : ArcFurnaceRecipe.recipeList) {
            if (ItemStackHelper.isOreDictMatch(recipe.output, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipe.output)) {
                matches.add(recipe);
            }
        }

        for (ArcFurnaceRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.output.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldRecipe.output.getCount());

            ArcFurnaceRecipe.recipeList.remove(oldRecipe);
            ArcFurnaceRecipe.addRecipe(newOutput, oldRecipe.input, oldRecipe.slag,
                    (int)Math.ceil(oldRecipe.getTotalProcessTime() / ArcFurnaceRecipe.timeModifier),
                    (int)Math.ceil(oldRecipe.getTotalProcessEnergy() / ArcFurnaceRecipe.timeModifier / oldRecipe.getTotalProcessEnergy()),
                    oldRecipe.additives);
        }

        setApplied();
        return true;
    }
}
