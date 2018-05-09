package com.mods.combatzak.mojo.alchemism.actions.ic2.thermalcentrifuge;

import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Adds a new Thermal Centrifuge recipe or replaces an existing one
 *
 * Created by CombatZAK on 5/4/2018.
 */
public class AddOrReplaceCentrifugeRecipeAction extends CentrifugeAction {
    public AddOrReplaceCentrifugeRecipeAction(short heat, IRecipeInput input, ItemStack... outputs) {
        super(heat, input, outputs);
    }

    public AddOrReplaceCentrifugeRecipeAction(short heat, ItemStack input, ItemStack... outputs) {
        super(heat, input, outputs);
    }

    public AddOrReplaceCentrifugeRecipeAction(short heat, String input, int amount, ItemStack... outputs) {
        super(heat, input, amount, outputs);
    }

    public AddOrReplaceCentrifugeRecipeAction(short heat, String input, ItemStack... outputs) {
        super(heat, input, outputs);
    }

    @Override
    public boolean apply() {
        if (heat <= 0 || heat >= 5000) throw new IllegalStateException("AddOrReplaceCentrifugeRecipeAction requires valid heat value");
        if (input == null) throw new IllegalStateException("AddOrReplaceCentrifugeRecipeAction requires valid recipe input");
        if (outputs == null || outputs.size() == 0 || outputs.size() > 3) throw new IllegalStateException("AddOrReplaceCentrifugeRecipeAction requires between one and three output stacks");

        NBTTagCompound heatTag = new NBTTagCompound();
        heatTag.setShort("minHeat", heat);

        Recipes.centrifuge.addRecipe(input, outputs, heatTag, true);
        setApplied();
        return true;
    }
}
