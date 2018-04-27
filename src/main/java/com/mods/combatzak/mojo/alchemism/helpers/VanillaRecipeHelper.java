package com.mods.combatzak.mojo.alchemism.helpers;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.RegistryManager;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Assist methods for dealing with Crafting Recipes
 *
 * Created by CombatZAK on 4/22/2018.
 */
public class VanillaRecipeHelper {
    private static final String c_modContainer = "mojo-alchemism";

    public static ForgeRegistry<IRecipe> getCraftingRecipes() {
        return RegistryManager.ACTIVE.getRegistry(GameData.RECIPES);
    }

    public static void AddShapelessRecipe(String recipeName, ItemStack output, Collection<IIngredient> inputs) {
        ResourceLocation location = new ResourceLocation(c_modContainer, recipeName);
        Ingredient[] inputArray = inputs.stream().map(i -> Ingredient.fromStacks((ItemStack)i.getIngredient())).toArray(size -> new Ingredient[size]);
        NonNullList<Ingredient> inputList = NonNullList.from(null, inputArray);
        ShapelessRecipes recipe = new ShapelessRecipes(location.getResourceDomain(), output, inputList);
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }

    public static void AddShapelessOreRecipe(String recipeName, ItemStack output, Collection<IIngredient> inputs) {
        ResourceLocation location = new ResourceLocation(c_modContainer, recipeName);
        Object[] inputArray = inputs.stream().map(i -> i.getIngredient()).toArray();
        ShapelessOreRecipe recipe = new ShapelessOreRecipe(location, output, inputArray);
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }
}
