package com.mods.combatzak.mojo.alchemism.actions.ic2.blastfurnace;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.MachineRecipe;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Replaces the output of all blast furnace recipes matching an ore dictionary entry
 *
 * Created by CombatZAK on 5/6/2018.
 */
public class ReplaceBlastFurnaceOutputAction extends BlastFurnaceAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceBlastFurnaceOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    public ReplaceBlastFurnaceOutputAction() {
        this(null, null);
    }

    public String getOreEntry() {
        return oreEntry;
    }

    public void setOreEntry(String oreEntry) {
        this.oreEntry = oreEntry;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    @Override
    public boolean apply() {
        List<MachineRecipe<IRecipeInput, Collection<ItemStack>>> matches = new ArrayList<>();
        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> recipe : Recipes.blastfurnace.getRecipes()) {
            for (ItemStack outputStack : recipe.getOutput()) {
                if (ItemStackHelper.isOreDictMatch(outputStack, oreEntry) && !ItemStackHelper.isDirectMatch(output, outputStack)) {
                    matches.add(recipe);
                    break;
                }
            }
        }

        for (MachineRecipe<IRecipeInput, Collection<ItemStack>> recipe : matches) {
            List<ItemStack> newOutputs = new ArrayList<>();
            for (ItemStack oldOutput : recipe.getOutput()) {
                if (ItemStackHelper.isOreDictMatch(oldOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, oldOutput)) {
                    ItemStack newOutputStack = output.getCount() == oldOutput.getCount()
                            ? output
                            : output.copy();
                    newOutputStack.setCount(oldOutput.getCount());
                    newOutputs.add(newOutputStack);
                }
                else {
                    newOutputs.add(oldOutput);
                }
            }

            Recipes.blastfurnace.addRecipe(recipe.getInput(), newOutputs, recipe.getMetaData(), true);
        }

        setApplied();
        return true;
    }
}
