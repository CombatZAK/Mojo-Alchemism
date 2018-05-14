package com.mods.combatzak.mojo.alchemism.actions.mekanism.metallurgicinfuser;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import forestry.api.recipes.RecipeManagers;
import mekanism.api.infuse.InfuseType;
import mekanism.common.recipe.RecipeHandler;
import mekanism.common.recipe.inputs.InfusionInput;
import mekanism.common.recipe.machines.MetallurgicInfuserRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Replaces all outputs for Metallurgic Infuser recipes matching an ore dictionary entry
 * Created by CombatZAK on 5/11/2018.
 */
public class ReplaceMetallurgicInfuserOutputAction extends MetallurgicInfuserAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceMetallurgicInfuserOutputAction(String oreEntry, ItemStack output) {
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
        List<MetallurgicInfuserRecipe> matches = new ArrayList<>();
        for (Entry<InfusionInput, MetallurgicInfuserRecipe> recipeEntry : ((Map<InfusionInput, MetallurgicInfuserRecipe>)RecipeHandler.Recipe.METALLURGIC_INFUSER.get()).entrySet()) {
            ItemStack outputStack = recipeEntry.getValue().getOutput().output;
            if (ItemStackHelper.isOreDictMatch(outputStack, oreEntry) && !ItemStackHelper.isDirectMatch(output, outputStack)) {
                matches.add(recipeEntry.getValue());
            }
        }

        for (MetallurgicInfuserRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.getOutput().output.getCount()
                    ? output
                    : output.copy();
            output.setCount(oldRecipe.getOutput().output.getCount());

            RecipeHandler.addMetallurgicInfuserRecipe(oldRecipe.getInput().infuse.type, oldRecipe.getInput().infuse.amount, oldRecipe.getInput().inputStack, newOutput);
        }

        setApplied();
        return true;
    }
}
