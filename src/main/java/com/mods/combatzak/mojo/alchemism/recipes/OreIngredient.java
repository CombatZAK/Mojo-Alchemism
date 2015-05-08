package com.mods.combatzak.mojo.alchemism.recipes;

/**
 * Ore Dictionary recipe ingredient
 * 
 * @author CombatZAK
 *
 */
public class OreIngredient implements IIngredient {

	/**
	 * Ore dictionary entry
	 */
	private String oreEntry;
	
	/**
	 * Gets the recipe ingredient
	 */
	@Override
	public Object getIngredient() {
		return this.oreEntry;
	}
	
	/**
	 * Sets the ingredient value
	 * 
	 * @param value ore dictionary entry
	 */
	public void setIngredient(String value) {
		this.oreEntry = value;
	}
	
	/**
	 * Creates a new OreIngredient instance
	 * 
	 * @param oreEntry ore dictionary entry
	 */
	public OreIngredient(String oreEntry) {
		this.oreEntry = oreEntry; //set ingredient value
	}
	
	/**
	 * Default constructor
	 */
	public OreIngredient() {
		this(null);
	}

}
