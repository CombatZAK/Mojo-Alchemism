package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class RemoveFurnaceRecipeAction extends FurnaceAction {
    public RemoveFurnaceRecipeAction(IIngredient input) {
        super(input,null, 0f);
    }

    public RemoveFurnaceRecipeAction() {
        this(null);
    }

    @Override
    public boolean apply() {
        if (input == null) throw new IllegalStateException("RemoveVurnaceRecipeAction requires valid input ingredient");

        if (input instanceof ItemIngredient) {
            FurnaceRecipes.instance().getSmeltingList().remove(((ItemIngredient)input).getIngredient());
        }
        else if (input instanceof OreIngredient) {
            NonNullList<ItemStack> oreItems = OreDictionary.getOres(((OreIngredient)input).getIngredient());
            for (ItemStack inputItem : oreItems) {
                FurnaceRecipes.instance().getSmeltingList().remove(inputItem);
            }
        }

        setApplied();
        return true;
    }
}
