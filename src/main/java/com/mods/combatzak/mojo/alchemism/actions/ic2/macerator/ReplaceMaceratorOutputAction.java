package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Replaces the output of a Macerator recipe by ore dict entry
 *
 * Created by CombatZAK on 5/2/2018.
 */
public class ReplaceMaceratorOutputAction extends MaceratorAction {
    private String oreEntry;

    public ReplaceMaceratorOutputAction(String oreEntry, ItemStack output) {
        super((IRecipeInput)null, output);
        this.oreEntry = oreEntry;
    }

    public ReplaceMaceratorOutputAction() {
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
        if (oreEntry == null || oreEntry.equals("")) throw new IllegalStateException("ReplaceMaceratorOutputAction requires valid ore dict entry");
        if (output == null) throw new IllegalStateException("ReplaceMaceratorOutputAction requires valid output stack");

        List<MachineRecipe<IRecipeInput, Collection<ItemStack>>> matches = new ArrayList<>();
        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> recipe : Recipes.macerator.getRecipes()) {
            ItemStack recipeOutput = recipe.getOutput().stream().findFirst().get();
            if (ItemStackHelper.isOreDictMatch(recipeOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipeOutput)) {
                matches.add(recipe);
            }
        }

        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> match : matches) {
            ItemStack oldOutput = match.getOutput().stream().findFirst().get();
            ItemStack newOutput = output.getCount() == oldOutput.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldOutput.getCount());

            Recipes.macerator.addRecipe(match.getInput(), null, true, newOutput);
        }

        setApplied();
        return true;
    }
}
