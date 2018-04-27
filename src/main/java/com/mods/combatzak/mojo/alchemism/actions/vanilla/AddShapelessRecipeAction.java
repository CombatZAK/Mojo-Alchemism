package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.helpers.VanillaRecipeHelper;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Adds a vanilla crafting recipe
 *
 * Created by CombatZAK on 4/22/2018.
 */
public class AddShapelessRecipeAction extends CraftingAction {
    private String recipeKey;

    public AddShapelessRecipeAction(String recipeKey, List<IIngredient> inputs, ItemStack output) {
        super(inputs, output);
        this.setRecipeKey(recipeKey);
    }

    public AddShapelessRecipeAction(String recipeKey, List<IIngredient> inputs, ItemStack output, int amount) {
        this(recipeKey, inputs, output.copy());
        this.output.setCount(amount);
    }

    public AddShapelessRecipeAction() {
        this(null, null, null);
    }

    public String getRecipeKey() {
        return recipeKey;
    }

    public void setRecipeKey(String recipeKey) {
        this.recipeKey = recipeKey;
    }

    public boolean apply() {
        if (getRecipeKey() == null || getRecipeKey().equals("")) throw new IllegalStateException("AddShapelessRecipeAction requires a valid recipe key");
        if (getInputs() == null) throw new IllegalStateException("AddShapelessRecipeAction requires initialized inputs");
        if (getOutput() == null) throw new IllegalStateException("AddShapelessRecipeAction requires initialized output");

        if (hasOreIngredient()) {
            VanillaRecipeHelper.AddShapelessOreRecipe(getRecipeKey(), output, inputs);
        }
        else {
            VanillaRecipeHelper.AddShapelessRecipe(getRecipeKey(), output, inputs);
        }

        setApplied();
        return true;
    }
}
