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
public abstract class CraftingAction extends MojoAction {
    protected static final String c_defaultDomain = "mojo-alchemism";

    protected String domain; //recipe domain
    protected String key; //location key
    protected List<IIngredient> inputs; //crafting ingrediends
    protected ItemStack output; //crafting result

    public CraftingAction(String domain, String key, List<IIngredient> inputs, ItemStack output) {
        super();
        this.setDomain(domain);
        this.setKey(key);
        this.inputs = inputs;
        this.output = output;
    }

    public CraftingAction(String key, List<IIngredient> inputs, ItemStack output) {
        this(c_defaultDomain, key, inputs, output);
    }

    public CraftingAction(List<IIngredient> inputs, ItemStack output) {
        this(null, null, inputs, output);
    }

    public CraftingAction(String domain, String key) {
        this(domain, key, null, null);
    }

    public CraftingAction() {
        this(null, null,null, null);
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
