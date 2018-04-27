package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.alchemism.helpers.VanillaRecipeHelper;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Adds a shapeless vanilla crafting recipe
 *
 * Created by CombatZAK on 4/22/2018.
 */
public class AddShapelessRecipeAction extends CraftingAction {

    public AddShapelessRecipeAction(String key, List<IIngredient> inputs, ItemStack output) {
        super(key, inputs, output);
    }

    public AddShapelessRecipeAction(String key, List<IIngredient> inputs, ItemStack output, int amount) {
        this(key, inputs, output.copy());
        this.output.setCount(amount);
    }

    public AddShapelessRecipeAction() {
        this(null, null, null);
    }

    public boolean apply() {
        if (key == null || key.equals("")) throw new IllegalStateException("AddShapelessRecipeAction requires a valid recipe key");
        if (getInputs() == null) throw new IllegalStateException("AddShapelessRecipeAction requires initialized inputs");
        if (getOutput() == null) throw new IllegalStateException("AddShapelessRecipeAction requires initialized output");

        if (hasOreIngredient()) {
            VanillaRecipeHelper.AddShapelessOreRecipe(key, output, inputs);
        }
        else {
            VanillaRecipeHelper.AddShapelessRecipe(key, output, inputs);
        }

        setApplied();
        return true;
    }
}
