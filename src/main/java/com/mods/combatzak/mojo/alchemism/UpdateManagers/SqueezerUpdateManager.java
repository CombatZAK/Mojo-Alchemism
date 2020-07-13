package com.mods.combatzak.mojo.alchemism.UpdateManagers;

import binnie.extrabees.items.types.EnumHoneyDrop;
import binnie.extrabees.items.types.EnumPropolis;
import cofh.thermalfoundation.init.TFFluids;
import cofh.thermalfoundation.item.ItemMaterial;
import com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer.AddOrReplaceSqueezerContainerRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer.AddOrReplaceSqueezerRecipeAction;
import com.mods.combatzak.mojo.alchemism.actions.forestry.squeezer.ReplaceSqueezerOutputAction;
import forestry.arboriculture.FruitProviderPod;
import forestry.core.ModuleCore;
import forestry.core.ModuleFluids;
import forestry.core.fluids.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains the modifications to the Forestry Squeezer
 *
 * Created by CombatZAK on 5/7/2018.
 */
public class SqueezerUpdateManager extends UpdateManager {
    private static SqueezerUpdateManager ourInstance = new SqueezerUpdateManager();

    public static SqueezerUpdateManager getInstance() {
        return ourInstance;
    }

    private SqueezerUpdateManager() {
        updateActions.add(new AddOrReplaceSqueezerRecipeAction(10, Stream.of(EnumHoneyDrop.SEED.get(1)).collect(Collectors.toList()), ItemStack.EMPTY, 0, Fluids.SEED_OIL.getFluid(200)));
        updateActions.add(new AddOrReplaceSqueezerRecipeAction(10, Stream.of(EnumHoneyDrop.ICE.get(1)).collect(Collectors.toList()), ItemStack.EMPTY, 0, Fluids.ICE.getFluid(200)));
        updateActions.add(new AddOrReplaceSqueezerRecipeAction(20, Stream.of(EnumPropolis.FUEL.get(1)).collect(Collectors.toList()), ItemStack.EMPTY, 0, new FluidStack(TFFluids.fluidFuel, 500)));
        updateActions.add(new AddOrReplaceSqueezerContainerRecipeAction(20, ModuleFluids.getItems().canEmpty.getItemStack(), ItemMaterial.ingotTin, 5));
    }
}
