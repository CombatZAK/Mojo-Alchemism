package com.mods.combatzak.mojo.alchemism.actions.vanilla;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import net.minecraft.item.ItemStack;

public abstract class FurnaceAction extends MojoAction {
    protected IIngredient input;
    protected ItemStack output;
    protected float experience;

    public FurnaceAction(IIngredient input, ItemStack output, float experience) {
        this.input = input;
        this.output = output;
        this.experience = experience;
    }

    public FurnaceAction() {
        this(null, null, 0f);
    }

    public IIngredient getInput() {
        return input;
    }

    public void setInput(IIngredient input) {
        this.input = input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }
}
