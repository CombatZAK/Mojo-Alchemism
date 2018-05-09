package com.mods.combatzak.mojo.alchemism.actions.ic2.thermalcentrifuge;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Replaces any output matching an ore dict entry with a specific type of item
 *
 * Created by CombatZAK on 5/4/2018.
 */
public class ReplaceCentrifugeOutputAction extends CentrifugeAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceCentrifugeOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    public ReplaceCentrifugeOutputAction() {
        this(null, null);
    }

    @Override
    public boolean apply() {
        if (oreEntry == null || oreEntry.equals("")) throw new IllegalStateException("ReplaceCentrifugeOutputAction requires valid ore dict entry");
        if (output == null) throw new IllegalStateException("ReplaceCentrifugeOutputAction requires valid output stack");

        List<MachineRecipe<IRecipeInput, Collection<ItemStack>>> matches = new ArrayList<>();
        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> recipe : Recipes.centrifuge.getRecipes()) {
            for (ItemStack recipeOutput : recipe.getOutput()) {
                if (ItemStackHelper.isOreDictMatch(recipeOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipeOutput)) {
                    matches.add(recipe);
                    break;
                }
            }
        }

        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> match : matches) {
            List<ItemStack> newOutputs = new ArrayList<>();
            for (ItemStack oldOutput : match.getOutput()) {
                if (ItemStackHelper.isOreDictMatch(oldOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, oldOutput)) {
                    ItemStack newOutput = output.getCount() == oldOutput.getCount()
                            ? output
                            : output.copy();
                    newOutput.setCount(oldOutput.getCount());

                    newOutputs.add(newOutput);
                }
                else {
                    newOutputs.add(oldOutput);
                }
            }
            Recipes.centrifuge.addRecipe(match.getInput(), newOutputs, match.getMetaData(), true);
        }

        setApplied();
        return true;
    }
}
