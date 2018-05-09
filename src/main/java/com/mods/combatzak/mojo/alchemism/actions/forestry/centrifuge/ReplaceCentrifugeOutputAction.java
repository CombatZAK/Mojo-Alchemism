package com.mods.combatzak.mojo.alchemism.actions.forestry.centrifuge;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import forestry.api.recipes.ICentrifugeRecipe;
import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Replaces all the outputs of a forestry centrifuge recipe matching an ore dictionary entry
 *
 * Created by CombatZAK on 5/6/2018.
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
        List<ICentrifugeRecipe> matches = new ArrayList<>();
        for (ICentrifugeRecipe recipe : RecipeManagers.centrifugeManager.recipes()) {
            if (recipe.getAllProducts()
                    .keySet().stream()
                    .anyMatch(outputStack -> ItemStackHelper.isOreDictMatch(outputStack, oreEntry) && !ItemStackHelper.isDirectMatch(output, outputStack))) {
                matches.add(recipe);
            }
        }

        for (ICentrifugeRecipe recipe : matches) {
            RecipeManagers.centrifugeManager.removeRecipe(recipe);
            Map<ItemStack, Float> newOutputs = new HashMap<>();
            for (Entry<ItemStack, Float> oldOutput : recipe.getAllProducts().entrySet()) {
                ItemStack oldOutputStack = oldOutput.getKey();
                if (ItemStackHelper.isOreDictMatch(oldOutputStack, oreEntry) && !ItemStackHelper.isDirectMatch(output, oldOutputStack)) {
                    ItemStack newOutputStack = output.getCount() == oldOutputStack.getCount()
                            ? output
                            : output.copy();
                    newOutputStack.setCount(oldOutputStack.getCount());
                    newOutputs.put(newOutputStack, oldOutput.getValue());
                }
                else {
                    newOutputs.put(oldOutput.getKey(), oldOutput.getValue());
                }
            }

            RecipeManagers.centrifugeManager.addRecipe(recipe.getProcessingTime(), recipe.getInput(), newOutputs);
        }

        setApplied();
        return true;
    }
}
