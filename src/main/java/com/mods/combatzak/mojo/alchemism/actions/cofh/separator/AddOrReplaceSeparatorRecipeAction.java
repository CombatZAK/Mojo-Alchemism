package com.mods.combatzak.mojo.alchemism.actions.cofh.separator;

import cofh.thermalexpansion.util.managers.machine.CentrifugeManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.fluids.FluidStack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Adds or replaces a Centrifugal Separator recipe
 *
 * Created by CombatZAK on 5/6/2018.
 */
public class AddOrReplaceSeparatorRecipeAction extends SeparatorAction {
    ItemStack input;
    List<Tuple<ItemStack, Integer>> outputs;
    FluidStack fluidOutput;

    public AddOrReplaceSeparatorRecipeAction(int energy, ItemStack input, FluidStack fluidOutput, Tuple<ItemStack, Integer>... outputs) {
        super(energy);
        this.input = input;
        this.outputs = Arrays.asList(outputs);
    }

    public AddOrReplaceSeparatorRecipeAction() {
        this(0, null, null);
    }

    @Override
    public boolean apply() {
        CentrifugeManager.addRecipe(energy, input, outputs.stream().map(output -> output.getFirst()).collect(Collectors.toList()), outputs.stream().map(output -> output.getSecond()).collect(Collectors.toList()), fluidOutput);
        setApplied();
        return true;
    }
}
