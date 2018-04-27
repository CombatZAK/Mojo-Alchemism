package com.mods.combatzak.mojo.alchemism.recipes;

/**
 * Ore dictionary input for a shaped recipe
 *
 * Created by CombatZAK on 4/21/2018.
 */
public class ShapedOreIngredient extends OreIngredient implements IShapedIngredient{
    private char label;

    public ShapedOreIngredient(String ingredient, char label) {
        super(ingredient);
        this.label = label;
    }

    public ShapedOreIngredient() {
        this(null, '\0');
    }

    @Override
    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }
}
