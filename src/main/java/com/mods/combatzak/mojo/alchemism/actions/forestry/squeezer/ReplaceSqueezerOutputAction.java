package com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import forestry.api.recipes.ISqueezerRecipe;
import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces all item outputs from the squeezer matching an ore dictionary entry
 * Created by CombatZAK on 5/7/2018.
 */
public class ReplaceSqueezerOutputAction extends SqueezerAction {
    protected String oreEntry;
    protected ItemStack output;

    public ReplaceSqueezerOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
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
        List<ISqueezerRecipe> matches = new ArrayList<>();
        for (ISqueezerRecipe recipe : RecipeManagers.squeezerManager.recipes()) {
            ItemStack outputStack = recipe.getRemnants();
            if (ItemStackHelper.isOreDictMatch(outputStack, oreEntry) && !ItemStackHelper.isDirectMatch(output, outputStack)) {
                matches.add(recipe);
            }
        }

        for (ISqueezerRecipe recipe : matches) {
            RecipeManagers.squeezerManager.removeRecipe(recipe);
            ItemStack newOutput = output.getCount() == recipe.getRemnants().getCount()
                    ? output
                    : output.copy();
            output.setCount(recipe.getRemnants().getCount());

            RecipeManagers.squeezerManager.addRecipe(recipe.getProcessingTime(), recipe.getResources(), recipe.getFluidOutput(), recipe.getRemnants(), (int)(100 * recipe.getRemnantsChance()));
        }

        setApplied();
        return true;
    }
}
