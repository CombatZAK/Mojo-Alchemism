package com.mods.combatzak.mojo.alchemism.actions.cofh.smelter;

import cofh.thermalexpansion.util.managers.machine.SmelterManager;
import cofh.thermalexpansion.util.managers.machine.SmelterManager.SmelterRecipe;
import com.mods.combatzak.mojo.alchemism.actions.cofh.smelter.InductionSmelterAction;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;

import java.util.ArrayList;
import java.util.List;

public class ReplaceInductionSmelterOutputAction extends InductionSmelterAction {
    private String oreEntry;

    public ReplaceInductionSmelterOutputAction(String oreEntry, ItemStack output) {
        super(0, null, null, output, null, 0);
        this.oreEntry = oreEntry;
    }

    public ReplaceInductionSmelterOutputAction() {
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
        if (oreEntry == null) throw new IllegalStateException("ReplaceInductionSmelterOutputAction requires valid ore dict entry");
        if (primaryOutput == null) throw new IllegalStateException("ReplaceInductionSmelterOutputAction requires valid output stack");

        List<Tuple<ItemStack, ItemStack>> primaryMatches = new ArrayList<>();
        List<Tuple<ItemStack, ItemStack>> secondaryMatches = new ArrayList<>();
        for (SmelterRecipe recipe : SmelterManager.getRecipeList()) {
            ItemStack primaryOutput = recipe.getPrimaryOutput();
            ItemStack secondaryOutput = recipe.getSecondaryOutput();

            if (ItemStackHelper.isOreDictMatch(primaryOutput, oreEntry) && !ItemStackHelper.isDirectMatch(primaryOutput, this.primaryOutput)) {
                primaryMatches.add(new Tuple<>(recipe.getPrimaryInput(), recipe.getSecondaryInput()));
            }

            if (ItemStackHelper.isOreDictMatch(secondaryOutput, oreEntry) && !ItemStackHelper.isDirectMatch(secondaryOutput, this.primaryOutput)) {
                secondaryMatches.add(new Tuple<>(recipe.getPrimaryInput(), recipe.getSecondaryInput()));
            }
        }

        for (Tuple<ItemStack, ItemStack> inputs : primaryMatches) {
            SmelterRecipe oldRecipe = SmelterManager.removeRecipe(inputs.getFirst(), inputs.getSecond());
            ItemStack outputStack = primaryOutput.getCount() == oldRecipe.getPrimaryOutput().getCount()
                    ? primaryOutput
                    : primaryOutput.copy();
            outputStack.setCount(oldRecipe.getPrimaryOutput().getCount());

            SmelterManager.addRecipe(oldRecipe.getEnergy(), oldRecipe.getPrimaryInput(), oldRecipe.getSecondaryInput(), outputStack, oldRecipe.getSecondaryOutput(), oldRecipe.getSecondaryOutputChance());
        }

        for (Tuple<ItemStack, ItemStack> inputs : secondaryMatches) {
            SmelterRecipe oldRecipe = SmelterManager.removeRecipe(inputs.getFirst(), inputs.getSecond());
            ItemStack outputStack = primaryOutput.getCount() == oldRecipe.getSecondaryOutput().getCount()
                    ? primaryOutput
                    : primaryOutput.copy();
            outputStack.setCount(oldRecipe.getSecondaryOutput().getCount());

            SmelterManager.addRecipe(oldRecipe.getEnergy(), oldRecipe.getPrimaryInput(), oldRecipe.getSecondaryInput(), oldRecipe.getPrimaryOutput(), oldRecipe.getSecondaryOutput(), oldRecipe.getSecondaryOutputChance());
        }

        setApplied();
        return true;
    }
}
