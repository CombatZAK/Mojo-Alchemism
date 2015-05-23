package com.mods.combatzak.mojo.alchemism.actions.renaming;

/**
 * Renames a thermal foundation metal in Tinkers' Construct
 * 
 * @author CombatZAK
 *
 */
public class RenameTConstructCompatAction extends RenameAction {
	/**
	 * Stores the metal to be renamed in TConstruct compatibility
	 */
	private String metal;
	
	/**
	 * Gets the metal to be renamed
	 * 
	 * @return target metal
	 */
	public String getMetal() {
		return this.metal;
	}
	
	/**
	 * Sets the metal to be renamed
	 * 
	 * @param value target metal
	 */
	public void setMetal(String value) {
		this.metal = value;
	}
	
	/**
	 * Self-referentially sets the metal to be renamed
	 * 
	 * @param value target metal
	 */
	public RenameTConstructCompatAction withMetal(String value) {
		this.setMetal(value);
		return this;
	}
	
	/**
	 * Creates a new RenameTConstructCompatAction instance
	 * 
	 * @param metal target metal
	 * @param newDisplayName updated display name
	 */
	public RenameTConstructCompatAction(String metal, String newDisplayName) {
		super(newDisplayName);
		this.metal = metal;
	}
	
	/**
	 * Default constructor
	 */
	public RenameTConstructCompatAction() {
		this(null, null);
	}
	
	/**
	 * Gets the localization string to update
	 * 
	 * @return localization string
	 */
	@Override
	public String getUnlocalizedNameField() {
		if (this.metal == null) return null; //null test
		else return "material.thermalfoundation." + metal; //return localization string for the specific metal type
	}
}
