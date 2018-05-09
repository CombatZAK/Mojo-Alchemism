package com.mods.combatzak.mojo.alchemism.actions.ic2.compressor;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Replaces any outputs for compressor recipes matching an ore dictionary entry
 *
 * Created by CombatZAK on 5/3/2018.
 */
public class ReplaceCompressorOutputAction extends CompressorAction {
    private String oreEntry;

    public ReplaceCompressorOutputAction(String oreEntry, ItemStack output) {
        super((IRecipeInput)null, output);
        this.oreEntry = oreEntry;
    }

    public ReplaceCompressorOutputAction() {
        this(null, null);
    }

    public String getOreEntry() {
        return oreEntry;
    }

    public void setOreEntry(String oreEntry) {
        this.oreEntry = oreEntry;
    }

    @Override
    public boolean apply() {
        if (oreEntry == null || oreEntry.equals("")) throw new IllegalStateException("ReplaceCompressorOutputAction requires valid ore dict entry");
        if (output == null) throw new IllegalStateException("ReplaceCompressorOutputAction requires valid output stack");

        List<MachineRecipe<IRecipeInput, Collection<ItemStack>>> matches = new ArrayList<>();
        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> recipe : Recipes.compressor.getRecipes()) {
            ItemStack recipeOutput = recipe.getOutput().stream().findFirst().get();
            if (ItemStackHelper.isOreDictMatch(recipeOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipeOutput)) {
                matches.add(recipe);
            }
        }

        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> match : matches) {
            ItemStack oldOuput = match.getOutput().stream().findFirst().get();
            ItemStack newOutput = output.getCount() == oldOuput.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldOuput.getCount());

            Recipes.compressor.addRecipe(match.getInput(), null, true, newOutput);
        }

        setApplied();
        return true;
    }
}
