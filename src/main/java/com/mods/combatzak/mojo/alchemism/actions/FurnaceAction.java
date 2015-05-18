package com.mods.combatzak.mojo.alchemism.actions;

import net.minecraft.item.ItemStack;

import com.mods.combatzak.mojo.MojoAction;
import com.mods.combatzak.mojo.alchemism.recipes.IIngredient;
import com.mods.combatzak.mojo.alchemism.recipes.ItemIngredient;

/**
 * Handles an operation related to furnace recipes
 * 
 * @author CombatZAK
 *
 */
public abstract class FurnaceAction extends MojoAction {
	/**
	 * Internal-use representation of the input/output pair of a furnace recipe
	 * @author CombatZAK
	 *
	 */
	protected class FurnaceRecipe {
		/**
		 * furnace input
		 */
		public ItemStack input;
		
		/**
		 * furnace output
		 */
		public ItemStack output;
		
		/**
		 * Creates a new FurnaceRecipe instance
		 * @param input furnace input
		 * @param output furnace output
		 */
		public FurnaceRecipe(ItemStack input, ItemStack output) {
			this.input = input;
			this.output = output;
		}
		
		/**
		 * Default constructor
		 */
		public FurnaceRecipe() {
			this(null, null);
		}
		
		/**
		 * Determines whether a furnace recipe matches specified input and output filter; ignores null arguments in testing
		 * 
		 * @param input input to match
		 * @param output output to match
		 * @return true if the furnace recipe matches the input and output; false otherwise
		 */
		public boolean isMatch(IIngredient input, IIngredient output) {
			boolean inputMatch = input == null || input.matches(this.input);
			boolean outputMatch = output == null || output.matches(this.output);
			
			return inputMatch && outputMatch;
		}
		
		/**
		 * Determines whether a furnace recipe matches specified input and output filter; ignores null arguments in testing
		 * 
		 * @param input input to match
		 * @param output output to match
		 * @return true if the furnace recipe matches the input and output; false otherwise
		 */
		public boolean isMatch(IIngredient input, ItemStack output) {
			return isMatch(input, new ItemIngredient(output));
		}
	}
	
	/**
	 * Furnace input
	 */
	protected IIngredient input;
	
	/**
	 * Furnace output
	 */
	protected ItemStack output;
	
	/**
	 * Experience reward for operation
	 */
	protected float experience;
	
	/**
	 * Gets the furnace input
	 * 
	 * @return furnace input
	 */
	public IIngredient getInput() {
		return this.input;
	}
	
	/**
	 * Sets the furnace input
	 * @param value new furnace input
	 */
	public void setInput(IIngredient value) {
		this.input = value;
	}
	
	/**
	 * Gets the furnace output
	 * @return furnace output
	 */
	public ItemStack getOutput() {
		return this.output;
	}
	
	/**
	 * Sets the furnace output
	 * @param value new furnace output
	 */
	public void setOutput(ItemStack value) {
		this.output = value;
	}
	
	/**
	 * Gets the operation experience
	 * @return operation experience
	 */
	public float getExperience() {
		return this.experience;
	}
	
	/**
	 * Sets the operation experience
	 * @param value new operation experience
	 */
	public void setExperience(float value) {
		this.experience = value;
	}
	
	/**
	 * Self-referentially sets input
	 * 
	 * @param value new input
	 * @return self-reference
	 */
	public FurnaceAction withInput(IIngredient value) {
		this.setInput(value);
		return this;
	}
	
	/**
	 * Self-referentially sets output
	 * 
	 * @param value new output
	 * @return self-reference
	 */
	public FurnaceAction withOutput(ItemStack value) {
		this.setOutput(value);
		return this;
	}
	
	/**
	 * Self-referentially sets experience
	 * 
	 * @param value new experience
	 * @return self-reference
	 */
	public FurnaceAction withExperience(float value) {
		this.setExperience(value);
		return this;
	}
	
	/**
	 * Creates a new FurnaceAction instance
	 * 
	 * @param input furnace input
	 * @param output furnace output
	 * @param experience operation experience
	 */
	public FurnaceAction(IIngredient input, ItemStack output, float experience) {
		this.input = input;
		this.output = output;
		this.experience = experience;
	}
	
	/**
	 * Creates a new Furnace Action instance
	 * 
	 * @param input furnace input
	 * @param output furnace output
	 */
	public FurnaceAction(IIngredient input, ItemStack output) {
		this(input, output, 0f);
	}
	
	/**
	 * Default constructor
	 */
	public FurnaceAction() {
		this(null, null, 0f);
	}
}
