package com.mods.combatzak.mojo.alchemism.actions.cofh.pulverizer;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;
import cofh.thermalexpansion.util.managers.machine.PulverizerManager.PulverizerRecipe;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces all pulverizer outputs matching a particular ore dictionary entry with a specific item
 */
public class ReplacePulverizerOutputAction extends PulverizerAction {
    private String oreEntry;

    public ReplacePulverizerOutputAction(String oreEntry, ItemStack output) {
        super(0, null, output, null, 0);
        this.setOreEntry(oreEntry);
    }

    public ReplacePulverizerOutputAction() {
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
        if (oreEntry == null || oreEntry.equals("")) throw new IllegalStateException("ReplacePulverizerOutputAction requires valid oreDict entry");
        if (primaryOutput == null) throw new IllegalStateException("ReplacePulverizerOutputAction requires valid output stack");

        List<ItemStack> primaryMatches = new ArrayList<>();
        List<ItemStack> secondaryMatches = new ArrayList<>();
        for (PulverizerRecipe recipe : PulverizerManager.getRecipeList()) {
            ItemStack primaryOutput = recipe.getPrimaryOutput();
            ItemStack secondaryOutput = recipe.getSecondaryOutput();

            if (ItemStackHelper.isOreDictMatch(primaryOutput, oreEntry) && !ItemStackHelper.isDirectMatch(primaryOutput, this.primaryOutput)) {
                primaryMatches.add(recipe.getInput());
            }

            if (ItemStackHelper.isOreDictMatch(secondaryOutput, oreEntry) && !ItemStackHelper.isDirectMatch(secondaryOutput, this.primaryOutput)) {
                secondaryMatches.add(recipe.getInput());
            }
        }

        for (ItemStack recipeInput : primaryMatches) {
            PulverizerRecipe oldRecipe = PulverizerManager.removeRecipe(recipeInput);
            ItemStack outputStack = primaryOutput.getCount() == oldRecipe.getPrimaryOutput().getCount()
                    ? primaryOutput
                    : primaryOutput.copy();
            outputStack.setCount(oldRecipe.getPrimaryOutput().getCount());

            PulverizerManager.addRecipe(oldRecipe.getEnergy(), recipeInput, outputStack, oldRecipe.getSecondaryOutput(), oldRecipe.getSecondaryOutputChance());
        }

        for (ItemStack recipeInput: secondaryMatches) {
            PulverizerRecipe oldRecipe = PulverizerManager.removeRecipe(recipeInput);
            ItemStack outputStack = primaryOutput.getCount() == oldRecipe.getSecondaryOutput().getCount()
                    ? primaryOutput
                    : primaryOutput.copy();
            primaryOutput.setCount(oldRecipe.getSecondaryOutput().getCount());

            PulverizerManager.addRecipe(oldRecipe.getEnergy(), recipeInput, oldRecipe.getPrimaryOutput(), primaryOutput, oldRecipe.getSecondaryOutputChance());
        }

        setApplied();
        return true;
    }
}
