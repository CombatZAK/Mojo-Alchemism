package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class AddOrReplaceFurnaceRecipeAction extends FurnaceAction {
    public AddOrReplaceFurnaceRecipeAction(IIngredient input, ItemStack output, float experience) {
        super(input, output, experience);
    }

    public AddOrReplaceFurnaceRecipeAction() {
        this(null, null, 0f);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("AddOrReplaceFurnaceRecipeAction requires valid input stack");
        if (output == null) throw new IllegalStateException("AddOrReplaceFurnaceRecipeAction requires valid output stack");
        if (experience < 0f) throw new IllegalStateException("AddOrReplaceFurnaceRecipeAction requires valid experience amount");

        if (input instanceof ItemIngredient) {
            FurnaceRecipes.instance().getSmeltingList().remove(input.getIngredient());
            FurnaceRecipes.instance().addSmeltingRecipe(((ItemIngredient)input).getIngredient(), output, experience);
        }
        else if (input instanceof OreIngredient) {
            NonNullList<ItemStack> oreItems = OreDictionary.getOres(((OreIngredient)input).getIngredient(), false);

            for (ItemStack inputItem : oreItems) {
                FurnaceRecipes.instance().getSmeltingList().remove(inputItem);
                FurnaceRecipes.instance().addSmeltingRecipe(inputItem, output, experience);
            }
        }

        setApplied();
        return true;
    }
}
