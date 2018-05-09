package com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer;

import com.mods.combatzak.mojo.alchemism.helpers.ItemStackHelper;
import forestry.api.recipes.ISqueezerRecipe;
import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

/**
 * Adds or replaces a Forestry Squeezer recipe
 *
 * Created by CombatZAK on 5/6/2018.
 */
public class AddOrReplaceSqueezerRecipeAction extends SqueezerAction {
    protected int time;
    protected List<ItemStack> inputs;
    protected ItemStack itemOutput;
    protected int itemChance;
    protected FluidStack fluidOutput;

    public AddOrReplaceSqueezerRecipeAction(int time, List<ItemStack> inputs, ItemStack itemOutput, int itemChance, FluidStack fluidOutput) {
        this.time = time;
        this.inputs = inputs;
        this.itemOutput = itemOutput;
        this.itemChance = itemChance;
        this.fluidOutput = fluidOutput;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<ItemStack> getInputs() {
        return inputs;
    }

    public void setInputs(List<ItemStack> inputs) {
        this.inputs = inputs;
    }

    public ItemStack getItemOutput() {
        return itemOutput;
    }

    public void setItemOutput(ItemStack itemOutput) {
        this.itemOutput = itemOutput;
    }

    public int getItemChance() {
        return itemChance;
    }

    public void setItemChance(int itemChance) {
        this.itemChance = itemChance;
    }

    public FluidStack getFluidOutput() {
        return fluidOutput;
    }

    public void setFluidOutput(FluidStack fluidOutput) {
        this.fluidOutput = fluidOutput;
    }

    @Override
    public boolean apply() {
        ISqueezerRecipe match = null;
        for (ISqueezerRecipe recipe : RecipeManagers.squeezerManager.recipes()) {
            boolean isMatch = true;
            for (ItemStack resource : recipe.getResources()) {
                if (!inputs.stream().anyMatch(input -> ItemStackHelper.isDirectMatch(input, resource))) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                match = recipe;
                break;
            }
        }

        if (match != null) {
            RecipeManagers.squeezerManager.removeRecipe(match);
        }

        RecipeManagers.squeezerManager.addRecipe(time, NonNullList.from(ItemStack.EMPTY, inputs.toArray(new ItemStack[]{})), fluidOutput, itemOutput, itemChance);
        setApplied();
        return true;
    }
}
