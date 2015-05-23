package com.mods.combatzak.mojo.alchemism.actions.renaming;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import net.minecraft.util.StringTranslate;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Changes the display name of a game component
 * 
 * @author CombatZAK
 *
 */
public abstract class RenameAction extends MojoAction {
	/**
	 * Updated display name
	 */
	protected String newDisplayName;
	
	/**
	 * Gets the updated display name
	 * 
	 * @return updated display name
	 */
	public String getNewDisplayName() {
		return this.newDisplayName;
	}
	
	/**
	 * Sets the updated display name
	 * 
	 * @param value updated display name
	 */
	public void setNewDisplayName(String value) {
		this.newDisplayName = value;
	}
	
	/**
	 * Self-referentially sets updated display name
	 * 
	 * @param value updated display name
	 * @return self-reference
	 */
	public RenameAction withNewDisplayName(String value) {
		this.setNewDisplayName(value);
		return this;
	}
	
	/**
	 * Creates a new RenameAction instance
	 * 
	 * @param newDisplayName updated display name
	 */
	public RenameAction(String newDisplayName) {
		this.newDisplayName = newDisplayName;
	}
	
	/**
	 * Default constructor
	 */
	public RenameAction() {
		this(null);
	}
	
	/**
	 * Gets the unlocalized display name label for the object to modify
	 * 
	 * @return unlocalized display name label
	 */
	public abstract String getUnlocalizedNameField();
	
	/**
	 * Applies the action, renaming a target to the display name
	 */
	public boolean apply() throws IllegalStateException {
		if (this.newDisplayName == null) //test for null name
			throw new IllegalStateException("Cannot rename to null display name");
		
		String nameField = this.getUnlocalizedNameField(); //get the name label to update
		if (nameField == null) //test for null label
			throw new IllegalStateException("Cannot rename null target");
		
		String instruction = nameField + "=" + newDisplayName;
		try {
			StringTranslate.inject(new ByteArrayInputStream(instruction.getBytes("UTF8")));
		}
		catch (UnsupportedEncodingException ex) { //this shouldn't happen since encoding type is hardcoded
			ex.printStackTrace();
			return false; //fail the action on an error
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
}
