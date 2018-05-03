package com.mods.combatzak.mojo.alchemism.actions.cofh.furnace;

import cofh.thermalexpansion.util.managers.machine.FurnaceManager;
import net.minecraft.item.ItemStack;

/**
 * Adds or replaces a Redstone Furnace recipe
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class AddOrReplaceRedstoneFurnaceRecipeAction extends RedstoneFurnaceAction {
    private int creosote;

    public AddOrReplaceRedstoneFurnaceRecipeAction(int energy, ItemStack input, ItemStack output, boolean pyrolysis, int creosote) {
        super(energy, input, output, pyrolysis);
        this.creosote = creosote;
    }

    public AddOrReplaceRedstoneFurnaceRecipeAction(int energy, ItemStack input, ItemStack output) {
        this(energy, input, output, false, 0);
    }

    public AddOrReplaceRedstoneFurnaceRecipeAction(int energy, ItemStack input, ItemStack output, int creosote) {
        this(energy, input, output, true, creosote);
    }

    public AddOrReplaceRedstoneFurnaceRecipeAction() {
        this(0, null, null, false, 0);
    }

    public int getCreosote() {
        return creosote;
    }

    public void setCreosote(int creosote) {
        this.creosote = creosote;
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("AddOrReplaceRedstoneFurnaceRecipeAction requires valid input stack");
        if (output == null) throw new IllegalStateException("AddOrReplaceRedstoneFurnaceRecipeAction requires valid output stack");
        if (energy <= 0) throw new IllegalStateException("AddOrReplaceRedstoneFurnaceRecipeAction requires valid energy cost");
        if (pyrolysis && creosote < 0) throw new IllegalStateException("AddOrReplaceRedstoneFurnaceRecipeAction requires valid creosote value for pyrolysis recipe");

        if (pyrolysis) {
            FurnaceManager.removeRecipePyrolysis(input);
            FurnaceManager.addRecipePyrolysis(energy, input, output, creosote);
        }
        else {
            FurnaceManager.removeRecipe(input);
            FurnaceManager.addRecipe(energy, input, output);
        }

        setApplied();
        return true;
    }
}
