package com.mods.combatzak.mojo.alchemism.actions.mekanism.crusher;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import forestry.api.recipes.RecipeManagers;
import mekanism.common.recipe.RecipeHandler;
import mekanism.common.recipe.inputs.ItemStackInput;
import mekanism.common.recipe.machines.CrusherRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Replaces crusher outputs matching an ore dictionary entry
 * Created by CombatZAK on 5/9/2018.
 */
public class ReplaceCrusherOutputAction extends CrusherAction{
    private String oreEntry;
    private ItemStack output;

    public ReplaceCrusherOutputAction(String oreEntry, ItemStack output) {
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
        List<CrusherRecipe> matches = new ArrayList<>();
        for (Entry<ItemStackInput, CrusherRecipe> recipeEntry : ((Map<ItemStackInput, CrusherRecipe>)RecipeHandler.Recipe.CRUSHER.get()).entrySet()) {
            ItemStack recipeOutput = recipeEntry.getValue().getOutput().output;
            if (ItemStackHelper.isOreDictMatch(recipeOutput, oreEntry) && !ItemStackHelper.isDirectMatch(output, recipeOutput)) {
                matches.add(recipeEntry.getValue());
            }
        }

        for (CrusherRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.getOutput().output.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldRecipe.recipeOutput.output.getCount());

            RecipeHandler.addCrusherRecipe(oldRecipe.getInput().ingredient, newOutput);
        }

        setApplied();
        return true;
    }
}
