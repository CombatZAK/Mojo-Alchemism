package com.mods.combatzak.mojo.alchemism.actions.cofh.furnace;

import cofh.thermalexpansion.util.managers.machine.FurnaceManager;
import cofh.thermalexpansion.util.managers.machine.FurnaceManager.FurnaceRecipe;
import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces all ore dict instances in redstone furnace output with a particular item
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class ReplaceRedstoneFurnaceOutputAction extends RedstoneFurnaceAction {
    private String oreEntry;

    public ReplaceRedstoneFurnaceOutputAction(String oreEntry, ItemStack output) {
        super(0, null, output, false);
        this.oreEntry = oreEntry;
    }

    public ReplaceRedstoneFurnaceOutputAction() {
        this(null, null);
    }

    @Override
    public boolean apply() {
        if (oreEntry == null || oreEntry.equals("")) throw new IllegalStateException("ReplaceRedstoneFurnaceOutputAction requires valid ore dict entry");
        if (output == null) throw new IllegalStateException("ReplaceRedstoneFurnaceAction requires valid output stack");

        List<ItemStack> matches = new ArrayList<>();
        for (FurnaceRecipe recipe : FurnaceManager.getRecipeList(false)) {
            if (ItemStackHelper.isOreDictMatch(recipe.getOutput(), oreEntry) && !ItemStackHelper.isDirectMatch(output, recipe.getOutput())) {
                matches.add(recipe.getInput());
            }
        }

        List<ItemStack> pyroMatches = new ArrayList<>();
        for (FurnaceRecipe recipe : FurnaceManager.getRecipeList(true)) {
            if (ItemStackHelper.isOreDictMatch(recipe.getOutput(), oreEntry) && !ItemStackHelper.isDirectMatch(output, recipe.getOutput())) {
                matches.add(recipe.getInput());
            }
        }

        for (ItemStack match : matches) {
            FurnaceRecipe oldRecipe = FurnaceManager.removeRecipe(match);
            ItemStack outputStack = output.getCount() == oldRecipe.getOutput().getCount()
                    ? output
                    : output.copy();
            outputStack.setCount(oldRecipe.getOutput().getCount());
            FurnaceManager.addRecipe(oldRecipe.getEnergy(), oldRecipe.getInput(), outputStack);
        }

        for (ItemStack match : pyroMatches) {
            FurnaceRecipe oldRecipe = FurnaceManager.removeRecipePyrolysis(match);
            ItemStack outputStack = output.getCount() == oldRecipe.getOutput().getCount()
                    ? output
                    : output.copy();
            outputStack.setCount(oldRecipe.getOutput().getCount());
            FurnaceManager.addRecipePyrolysis(oldRecipe.getEnergy(), oldRecipe.getInput(), outputStack, oldRecipe.getCreosote());
        }

        setApplied();
        return true;
    }
}
