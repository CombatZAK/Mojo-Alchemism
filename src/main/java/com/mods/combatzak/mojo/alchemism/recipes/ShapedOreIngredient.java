package com.mods.combatzak.mojo.alchemism.recipes;

/**
 * Ore dictionary input for shaped recipe
 * 
 * @author CombatZAK
 *
 */
public class ShapedOreIngredient extends OreIngredient implements IShapedIngredient {
	/**
	 * character label for shaped recipe input
	 */
	private char label;
	
	/**
	 * Gets the character label for the ingredient in the shaped recipe
	 */
	@Override
	public char getLabel() {
		return this.label;
	}
	
	/**
	 * Sets the character label for the ingredient int he shaped recipe
	 * @param value
	 */
	public void setLabel(char value) {
		this.label = value;
	}
	
	/**
	 * Creates a new ShapedOreIngredient instance
	 * 
	 * @param oreEntry ore dictionary entry
	 * @param label recipe character label
	 */
	public ShapedOreIngredient(String oreEntry, char label) {
		super(oreEntry); //set the ore dictionary entry
		this.label = label; //set the character label
	}
	
	/**
	 * Creates a new ShapedOreIngredient instance
	 * 
	 * @param label recipe character label
	 */
	public ShapedOreIngredient(char label) {
		this(null, label);
	}
	
	/**
	 * Default constructor
	 */
	public ShapedOreIngredient() {
		this(null, '\0');
	}
}
