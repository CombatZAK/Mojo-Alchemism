package com.mods.combatzak.mojo.alchemism.actions.mekanism.enrichmentchamber;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import mekanism.common.recipe.RecipeHandler;
import mekanism.common.recipe.inputs.ItemStackInput;
import mekanism.common.recipe.machines.EnrichmentRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Replaces the output of Enrichment Chamber recipes matching an ore dictionary entry
 * Created by CombatZAK on 5/9/2018.
 */
public class ReplaceEnrichmentChamberOutputAction extends EnrichmentChamberAction {
    private String oreEntry;
    private ItemStack output;

    public ReplaceEnrichmentChamberOutputAction(String oreEntry, ItemStack output) {
        this.oreEntry = oreEntry;
        this.output = output;
    }

    public String getOreEntry() {
        return oreEntry;
    }

    public void setInput(String oreEntry) {
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
        List<EnrichmentRecipe> matches = new ArrayList<>();
        for (Entry<ItemStackInput, EnrichmentRecipe> recipe : ((Map<ItemStackInput, EnrichmentRecipe>)RecipeHandler.Recipe.ENRICHMENT_CHAMBER.get()).entrySet()) {
            ItemStack outputStack = recipe.getValue().getOutput().output;
            if (ItemStackHelper.isOreDictMatch(outputStack, oreEntry) && !ItemStackHelper.isDirectMatch(output, outputStack)) {
                matches.add(recipe.getValue());
            }
        }

        for (EnrichmentRecipe oldRecipe : matches) {
            ItemStack newOutput = output.getCount() == oldRecipe.getOutput().output.getCount()
                    ? output
                    : output.copy();
            newOutput.setCount(oldRecipe.getOutput().output.getCount());

            RecipeHandler.addEnrichmentChamberRecipe(oldRecipe.getInput().ingredient, newOutput);
        }

        setApplied();
        return true;
    }
}
