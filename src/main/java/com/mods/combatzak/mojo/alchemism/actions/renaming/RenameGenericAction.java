package com.mods.combatzak.mojo.alchemism.actions.renaming;

/**
 * General rename class for dealing with difficult to find objects
 * @author CombatZAK
 *
 */
public class RenameGenericAction extends RenameAction {
	
	/**
	 * localization label
	 */
	private String label;
	
	/**
	 * Gets the localization label
	 * 
	 * @return target label
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Sets the localization label
	 * 
	 * @param value target label
	 */
	public void setLabel(String value) {
		this.label = value;
	}
	
	/**
	 * Self-referentially sets the localization label
	 * 
	 * @param value target label
	 * @return self-reference
	 */
	public RenameGenericAction withLabel(String value) {
		this.setLabel(value);
		return this;
	}
	
	/**
	 * Creates a new RenameGenericAction instance
	 * @param label target label
	 * @param newDisplayName updated display name
	 */
	public RenameGenericAction(String label, String newDisplayName) {
		super(newDisplayName);
		this.label = label;
	}
	
	/**
	 * Default constructor
	 */
	public RenameGenericAction() {
		this(null, null);
	}
	
	/**
	 * returns the localization label
	 */
	@Override
	public String getUnlocalizedNameField() {
		return label;
	}

}
