package com.mods.combatzak.mojo.alchemism.helpers;

import cofh.core.util.helpers.RecipeHelper;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper.ShapedPrimer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapedOreRecipe;
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

    public static void AddShapedRecipe(String recipeName, int width, int height, ItemStack output, Collection<IIngredient> inputs) {
        ResourceLocation location = new ResourceLocation(c_modContainer, recipeName);
        Ingredient[] ingredients = inputs.stream().map(i -> i.getForgeIngredient()).toArray(Ingredient[]::new);
        NonNullList<Ingredient> inputList = NonNullList.from(Ingredient.EMPTY, ingredients);

        ShapedRecipes recipe = new ShapedRecipes(c_modContainer, width, height, inputList, output);
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }

    public static void AddShapedOreRecipe(String recipeName, int width, int height, boolean mirrored, ItemStack output, Collection<IIngredient> inputs) {
        ResourceLocation location = new ResourceLocation(c_modContainer, recipeName);
        Ingredient[] ingredients = inputs.stream().map(i -> getForgeIngredient(i)).toArray(Ingredient[]::new);

        ShapedPrimer primer = new ShapedPrimer();
        primer.width = width;
        primer.height = height;
        primer.mirrored = mirrored;
        primer.input = NonNullList.from(Ingredient.EMPTY, ingredients);

        ShapedOreRecipe recipe = new ShapedOreRecipe(location, output, primer);
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
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

    private static Ingredient getForgeIngredient(IIngredient ingredient) {
        if (ingredient == null) return Ingredient.EMPTY;
        else return ingredient.getForgeIngredient();
    }
}
