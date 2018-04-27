package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.OreIngredient;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Manipulates vanilla crafting recipes
 *
 * Created by CombatZAK on 4/21/2018.
 */
public abstract class CraftingAction extends MojoAction{
    protected List<IIngredient> inputs; //crafting ingrediends
    protected ItemStack output; //crafting result

    public CraftingAction(List<IIngredient> inputs, ItemStack output) {
        super();
        this.inputs = inputs;
        this.output = output;
    }

    public CraftingAction() {
        this(null, null);
    }

    /**
     * Scans inputs for ore dictionary ingredients
     *
     * @return true if the recipe contains an ore ingredient; false otherwise
     */
    public boolean hasOreIngredient() {
        return inputs.stream().anyMatch(ingredient -> ingredient instanceof OreIngredient);
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    public List<IIngredient> getInputs() {
        return inputs;
    }

    public void setInputs(List<IIngredient> inputs) {
        this.inputs = inputs;
    }
}
