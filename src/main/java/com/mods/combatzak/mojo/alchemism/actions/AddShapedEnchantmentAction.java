package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.IShapedIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ShapedEnchantmentRecipe;
import com.mods.combatzak.mojo.alchemism.recipes.ShapedOreEnchantmentRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * @author CombatZAK
 *
 */
public class AddShapedEnchantmentAction extends AddShapedAction{
	
	/**
	 * Creates a new AddSHapedEnchantmentAction instance
	 * 
	 * @param inputs input ingredients
	 * @param output recipe product
	 */
	public AddShapedEnchantmentAction(List<IIngredient> inputs, ItemStack output, String[] pattern) {
		super(inputs, output, pattern);
	}
	
	@Override
	public boolean apply() throws IllegalStateException {
		if (!this.isInputValid()) //validate the input
			throw new IllegalStateException("Cannot add recipe with invalid input");
		if (!this.isPatternValid()) //validate the recipe pattern
			throw new IllegalStateException("Cannot add recipe with invalid pattern");
		if (this.output == null) //validate the output
			throw new IllegalStateException("Cannot add recipe with empty output");
		
		ArrayList ingredientObjects = new ArrayList(); //stores the ingredients and their labels
		ingredientObjects.add(this.pattern); //insert pattern first
		for (IIngredient input : inputs) {
			IShapedIngredient shapedInput = (IShapedIngredient)input; //cast the element to a shaped ingredient
			ingredientObjects.add(shapedInput.getLabel());
			ingredientObjects.add(shapedInput.getIngredient());
		}
		
		if (this.hasOreIngredient()) {
			GameRegistry.addRecipe(new ShapedOreEnchantmentRecipe(this.output, ingredientObjects.toArray()));
		}
		else {
			GameRegistry.addRecipe(ShapedEnchantmentRecipe.createRecipe(this.output, ingredientObjects.toArray()));
		}
		
		this.setIsApplied(true);
		return true;
	}
}
