package com.mods.combatzak.mojo.alchemism.nei;

import java.util.ArrayList;
import java.util.List;

import scala.actors.threadpool.Arrays;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import codechicken.nei.api.API;

import com.mods.combatzak.mojo.MojoAction;

/**
 * Hides items in NEI
 * @author CombatZAK
 *
 */
public class HideNeiAction extends MojoAction {
	/**
	 * Ore Dictionary entry key to hide
	 */
	private String dictEntry;
	
	/**
	 * Exceptions to hiding rule
	 */
	private List<ItemStack> exceptions;
	
	/**
	 * Gets the dictionary key
	 * 
	 * @return ore dictionary key
	 */
	public String getDictEntry() {
		return this.dictEntry;
	}
	
	/**
	 * Sets the dictionary key
	 * 
	 * @param value ore dictionary key
	 */
	public void setDictEntry(String value) {
		this.dictEntry = value;
	}
	
	/**
	 * Self-referentially sets dictionary key
	 * 
	 * @param value ore dictionary key
	 * @return self-reference
	 */
	public HideNeiAction withDictEntry(String value) {
		this.setDictEntry(value);
		return this;
	}
	
	/**
	 * Gets exceptions to hiding rule
	 * 
	 * @return exception list
	 */
	public List<ItemStack> getExceptions() {
		return this.exceptions;
	}
	
	/**
	 * Sets the exceptions to hiding rule
	 * 
	 * @param value list of exceptions
	 */
	public void setExceptions(ItemStack... value) {
		this.exceptions = new ArrayList<ItemStack>();
		this.exceptions.addAll(Arrays.asList(value));
	}
	
	/**
	 * Sets the exceptions to the hiding rule
	 * 
	 * @param value exception list
	 */
	public void setExceptions(List<ItemStack> value) {
		this.exceptions = value;
	}
	
	/**
	 * Self-referentially sets the exceptions to hiding rule
	 * 
	 * @param value list of exceptions
	 * @return self-reference
	 */
	public HideNeiAction withExceptions(ItemStack... value) {
		this.setExceptions(value);
		return this;
	}
	
	/**
	 * Self-referentially sets the exceptions to hiding rule
	 * 
	 * @param value exception list
	 * @return self-reference
	 */
	public HideNeiAction withExceptions(List<ItemStack> value) {
		this.setExceptions(value);
		return this;
	}
	
	/**
	 * Creates a new HideNeiAction instance
	 * 
	 * @param dictEntry ore dictionary key
	 * @param exceptions exception list
	 */
	public HideNeiAction(String dictEntry, List<ItemStack> exceptions) {
		this.dictEntry = dictEntry;
		this.exceptions = exceptions;
	}
	
	/**
	 * Creates a new HideNeiAction instance
	 * 
	 * @param dictEntry ore dictionary key
	 * @param exceptions list of exceptions
	 */
	public HideNeiAction(String dictEntry, ItemStack... exceptions) {
		this(dictEntry, Arrays.asList(exceptions));
	}
	
	/**
	 * Creates a new HideNeiAction instance
	 * 
	 * @param dictEntry ore dictionary key
	 */
	public HideNeiAction(String dictEntry) {
		this(dictEntry, (List<ItemStack>)null);
	}
	
	/**
	 * Default constructor
	 */
	public HideNeiAction() {
		this(null, (List<ItemStack>)null);
	}
	
	/**
	 * Applies the action, hiding all matching ore dictionary entries in NEI with exceptions
	 */
	@Override
	public boolean apply() throws IllegalStateException{
		if (dictEntry == null) throw new IllegalStateException("Cannot hide null dictionary entry"); //null test for dictEntry
		
		List<ItemStack> entryItems = OreDictionary.getOres(dictEntry, false); //get all the items matching the ore dictionary
		for (ItemStack item : entryItems) { //go through all the entries
			if (hasException(item)) continue; //skip the item if it's on the exception list
			
			API.hideItem(item); //hide the item in NEI
		}
		
		this.setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Tests if an item falls into the exceptions list
	 * 
	 * @param testItem item to check against exception list
	 * @return true if item falls within eception list; false otherwise
	 */
	private boolean hasException(ItemStack testItem) {
		if (testItem == null) return true; //null items get a pass
		if (exceptions == null || exceptions.isEmpty()) return false; //empty/null lists don't get checked
		
		for (ItemStack exception : exceptions) {
			if (exception.getItem() == testItem.getItem() //check the item and exit if there is a match
					&& (!exception.getHasSubtypes() || exception.getItemDamage() == testItem.getItemDamage()))
				return true;
		}
		
		return false; //if we get here, there isn't a match
	}
}
