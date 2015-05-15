package com.mods.combatzak.mojo.alchemism.actions;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.IShapedIngredient;

import cpw.mods.fml.common.registry.GameRegistry;

public class AddShapedAction extends CraftingAction {
	
	/**
	 * Character pattern for the shaped recipe
	 */
	private String[] pattern;
	
	/**
	 * Gets the shaped recipe pattern
	 * @return
	 */
	public String[] getPattern() {
		return this.pattern;
	}
	
	/**
	 * Sets the shaped recipe pattern
	 *
	 * @param value shaped recipe pattern
	 */
	public void setPattern(String[] value) {
		this.pattern = value;
	}
	
	/**
	 * Validates the action's input ingredients
	 * 
	 * @return false if the inputs are null or empty, or contain any unshaped ingredients; true otherwise
	 */
	private boolean isInputValid() {
		if (inputs == null || inputs.isEmpty()) //check for empty input
			return false;
		
		for (IIngredient input : inputs) { //go through all the input ingredients
			if (!(input instanceof IShapedIngredient)) //if the current ingredient is not shaped...
				return false; //the input is not valid
		}
		
		return true; //if we get here the input is valid
	}
	
	/**
	 * Validates the recipe pattern
	 * @return
	 */
	private boolean isPatternValid() {
		if (pattern == null || pattern.length == 0 || pattern.length > 3) //validate the size of the array
			return false;
		
		int lastLength = -1; //stores the last row's length
		String patternChars = ""; //stores unique characters in the pattern
		for (String row : pattern) { //go through all the rows
			if (row == null || row.isEmpty() || row.length() > 3) //individually validate all rows
				return false;
			
			if (lastLength != -1 && row.length() != lastLength) //if the current row's length is not equal to the previous row's length...
				return false; //not a valid pattern
			else //otherwise...
				lastLength = row.length(); //update last row length
			
			for (char patternChar : row.toCharArray()) { //go through all the characters in the pattern
				if (patternChar != ' ' && !patternChars.contains("" + patternChar)) //if the distinct pattern does not contain the current character...
					patternChars += patternChar; //append it to the list
			}
		}
		
		String inputLabels = ""; //stores unique character labels from inputs
		for (IIngredient input : inputs) {
			if (!(input instanceof IShapedIngredient)) //if the input is not a shaped ingredient
				continue; //skip it, implies inputs are not valid
			
			IShapedIngredient shapedInput = (IShapedIngredient)input; //cast input to shaped ingredient
			if (!inputLabels.contains("" + shapedInput.getLabel())) //if the running list of labels does not contain the current character...
				inputLabels += shapedInput.getLabel(); //append it
		}
		
		if (inputLabels.length() != patternChars.length()) //if the labels and patterns contain different numbers of distinct characters...
			return false; //pattern is not valid
		
		for (char c : inputLabels.toCharArray()) { //go through all the distinct labels
			if (!patternChars.contains("" + c)) //if there is a mismatch between labels and patterns...
				return false; //pattern is not valid
		}
		
		return true; //if we get here, the pattern is valid
	}
	
	/**
	 * Applies the action, adding a shaped recipe to the game
	 * 
	 * @throws IllegalStateException thrown when the input or pattern is valid or there is no output item
	 */
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
		
		GameRegistry.addRecipe(this.output, ingredientObjects.toArray()); //register the recipe
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Creates a new AddShapedAction instance
	 * 
	 * @param inputs input ingredients
	 * @param output output item
	 * @param pattern shape pattern
	 */
	public AddShapedAction(List<IIngredient> inputs, ItemStack output, String[] pattern) {
		super(inputs, output);
		this.setPattern(pattern);
	}
	
	/**
	 * Creates a new AddShapedAction instance
	 * 
	 * @param inputs input ingredients
	 * @param output output item
	 */
	public AddShapedAction(List<IIngredient> inputs, ItemStack output) {
		this(inputs, output, null);
	}
	
	/**
	 * Creates a new AddShapedAction instance
	 * 
	 * @param pattern shape pattern
	 */
	public AddShapedAction(String[] pattern) {
		this(null, null, pattern);
	}
	
	/**
	 * Default constructor
	 */
	public AddShapedAction() {
		this(null, null, null);
	}
	
	/**
	 * Self referentially sets the recipe shape pattern
	 * 
	 * @param pattern shape pattern
	 * @return reference to current object
	 */
	public AddShapedAction withPattern(String[] pattern) {
		this.setPattern(pattern);
		return this;
	}
}
