package com.mods.combatzak.mojo.alchemism.actions.ic2.thermalcentrifuge;

import com.mods.combatzak.mojo.alchemism.actions.ic2.IC2Action;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Modifies a recipe for the Thermal Centrigue
 *
 * Created by CombatZAK on 5/3/2018.
 */
public abstract class CentrifugeAction extends IC2Action {
    protected short heat;
    protected IRecipeInput input;
    protected Collection<ItemStack> outputs;

    public CentrifugeAction(short heat, IRecipeInput input, ItemStack... outputs) {
        this.heat = heat;
        this.input = input;
        this.outputs = Arrays.stream(outputs).collect(Collectors.toList());
    }

    public CentrifugeAction(short heat, ItemStack input, ItemStack... outputs) {
        this(heat, Recipes.inputFactory.forStack(input), outputs);
    }

    public CentrifugeAction(short heat, String input, int amount, ItemStack... outputs) {
        this(heat, Recipes.inputFactory.forOreDict(input, amount), outputs);
    }

    public CentrifugeAction(short heat, String input, ItemStack... outputs) {
        this(heat, input, 1, outputs);
    }

    public CentrifugeAction() {
        this((short)0, (IRecipeInput)null);
    }

    public short getHeat() {
        return heat;
    }

    public void setHeat(short heat) {
        this.heat = heat;
    }

    public IRecipeInput getInput() {
        return input;
    }

    public void setInput(IRecipeInput input) {
        this.input = input;
    }

    public Collection<ItemStack> getOutputs() {
        return outputs;
    }

    public void setOutputs(Collection<ItemStack> outputs) {
        this.outputs = outputs;
    }
}
