package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.helpers.VanillaRecipeHelper;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.Arrays;
import java.util.List;

/**
 * Adds a shaped vanilla crafting recipe
 */
public class AddShapedRecipeAction extends CraftingAction {
    int width;
    int height;
    boolean mirrored;

    public AddShapedRecipeAction(String key, int width, int height, boolean mirrored, List<IIngredient> inputs, ItemStack output) {
        super(key, inputs, output);
        this.width = width;
        this.height = height;
        this.mirrored = mirrored;
    }

    public AddShapedRecipeAction(String key, int width, int height, List<IIngredient> inputs, ItemStack output) {
        this(key, width, height, true, inputs, output);
    }

    public AddShapedRecipeAction() {
        this(null, 0, 0, true, null, null);
    }

    public boolean apply() {
        if (key == null || key.equals("")) throw new IllegalStateException("AddShapedRecipeAction requires valid recipe key");
        if (width < 1 || width > 3) throw new IllegalStateException("AddShapedRecipeAction requires valid width (1..3)");
        if (height < 1 || height > 3) throw new IllegalStateException("AddShapedRecipeAction requires valid height (1..3)");
        if (inputs == null || inputs.size() != width * height) throw new IllegalStateException("AddShapedRecipeAction requires valid input ingredient list");
        if (output == null) throw new IllegalStateException("AddShapedRecipeAction requires valid output");

        if (hasOreIngredient()) {
            VanillaRecipeHelper.AddShapedOreRecipe(key, width, height, mirrored, output, inputs);
        }
        else {
            VanillaRecipeHelper.AddShapedRecipe(key, width, height, output, inputs);
        }

        setApplied();
        return true;
    }
}
