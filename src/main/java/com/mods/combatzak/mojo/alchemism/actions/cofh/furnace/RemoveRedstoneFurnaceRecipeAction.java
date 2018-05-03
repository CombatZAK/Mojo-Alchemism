package com.mods.combatzak.mojo.alchemism.actions.cofh.furnace;

import cofh.thermalexpansion.util.managers.machine.FurnaceManager;
import net.minecraft.item.ItemStack;

/**
 * Removes a RedstoneFurnace recipe
 *
 * Created by CombatZAK on 4/30/2018.
 */
public class RemoveRedstoneFurnaceRecipeAction extends RedstoneFurnaceAction {
    public RemoveRedstoneFurnaceRecipeAction(ItemStack input, boolean pyrolysis) {
        super(0, input, null, pyrolysis);
    }

    public RemoveRedstoneFurnaceRecipeAction(ItemStack input) {
        this(input, false);
    }

    public RemoveRedstoneFurnaceRecipeAction() {
        this(null, false);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemoveRedstoneFuranceRecipeAction requires valid input stack");

        if (pyrolysis) {
            FurnaceManager.removeRecipePyrolysis(input);
        }
        else {
            FurnaceManager.removeRecipe(input);
        }

        setApplied();
        return true;
    }
}
