package com.mods.combatzak.mojo.alchemism.actions.ic2.macerator;

import ic2.api.recipe.IRecipeInput;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.alchemism.actions.ic2.Ic2Action;

/**
 * An action for managing an IC2 Macerator recipe
 * 
 * @author CombatZAK
 *
 */
public abstract class MaceratorAction extends Ic2Action {
	/**
	 * Gets the macerator output
	 * 
	 * @return grinding output
	 */
	public ItemStack getOutput() {
		if (this.outputs == null || this.outputs.isEmpty()) return null;
		return this.outputs.get(0);
	}
	
	/**
	 * Sets the macerator output
	 * 
	 * @param value grinding output
	 */
	public void setOutput(ItemStack value) {
		if (this.outputs == null) this.outputs = new ArrayList<ItemStack>();
		if (this.outputs.isEmpty()) this.outputs.add(value);
		else this.outputs.set(0, value);
	}
	
	/**
	 * Self-referentially sets the macerator output
	 * 
	 * @param value grinding output
	 * @return self-reference
	 */
	public MaceratorAction withOutput(ItemStack value) {
		this.setOutput(value);
		return this;
	}
	
	/**
	 * Creates a new MaceratorAction instance
	 * 
	 * @param input item to grind
	 * @param output grinding output
	 */
	public MaceratorAction(IRecipeInput input, ItemStack output) {
		super(input, Arrays.asList(new ItemStack[] { output }), null);
	}
	
	/**
	 * Default constructor
	 */
	public MaceratorAction() {
		this(null, null);
	}
}
