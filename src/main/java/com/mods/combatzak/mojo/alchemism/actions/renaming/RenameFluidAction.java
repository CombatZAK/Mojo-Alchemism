package com.mods.combatzak.mojo.alchemism.actions.renaming;

/**
 * Renames a registered fluid
 * 
 * @author CombatZAK
 *
 */
public class RenameFluidAction extends RenameAction {
	/**
	 * Registered fluid name
	 */
	private String fluid;
	
	/**
	 * Gets the registered fluid name
	 * 
	 * @return target fluid
	 */
	public String getFluid() {
		return this.fluid;
	}
	
	/**
	 * Sets the registered fluid
	 * 
	 * @param value target fluid
	 */
	public void setFluid(String value) {
		this.fluid = value;
	}
	
	/**
	 * Self-referentially sets the fluid name
	 * 
	 * @param value target fluid
	 * @return self-reference
	 */
	public RenameFluidAction withFluid(String value) {
		this.setFluid(value);
		return this;
	}
	
	/**
	 * Creates a new RenameFluidAction instance
	 * 
	 * @param fluid target fluid
	 * @param newDisplayName updated display name
	 */
	public RenameFluidAction(String fluid, String newDisplayName) {
		super(newDisplayName);
		this.fluid = fluid;
	}
	
	/**
	 * Default constructor
	 */
	public RenameFluidAction() {
		this(null, null);
	}
	
	/**
	 * Gets localization tag for the fluid
	 */
	@Override
	public String getUnlocalizedNameField() {
		if (this.fluid == null) return null;
		else return "fluid." + this.fluid; //fluid names are pretty simple
	}

}
