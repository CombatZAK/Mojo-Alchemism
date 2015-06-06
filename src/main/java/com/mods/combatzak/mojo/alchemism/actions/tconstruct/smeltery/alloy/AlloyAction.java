package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.alloy;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidStack;

import com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.SmelteryAction;

/**
 * Handles actions related to alloying metals in a TConstruct smeltery
 * 
 * @author CombatZAK
 *
 */
public abstract class AlloyAction extends SmelteryAction {
	/**
	 * Set of fluids and ratios to make alloy
	 */
	protected List<FluidStack> components;
	
	/**
	 * Resulting fluid
	 */
	protected FluidStack output;
	
	/**
	 * Gets the set of fluids in alloy
	 * 
	 * @return input fluids
	 */
	public List<FluidStack> getComponents() {
		return this.components;
	}
	
	/**
	 * Sets the set of fluids in alloy
	 * 
	 * @param value input fluids
	 */
	public void setComponents(List<FluidStack> value) {
		this.components = value;
	}
	
	/**
	 * Self-referentially sets the set of fluids in alloy
	 * 
	 * @param value input fluids
	 * @return self-reference
	 */
	public AlloyAction withComponents(List<FluidStack> value) {
		this.setComponents(value);
		return this;
	}
	
	/**
	 * Gets the resulting alloy
	 * 
	 * @return output fluid
	 */
	public FluidStack getOutput() {
		return this.output;
	}
	
	/**
	 * Sets the resulting alloy
	 * 
	 * @param value output fluid
	 */
	public void setOutput(FluidStack value) {
		this.output = value;
	}
	
	/**
	 * Self-referentially sets the resulting alloy
	 * 
	 * @param value output fluid
	 * @return self-reference
	 */
	public AlloyAction withOutput(FluidStack value) {
		this.setOutput(value);
		return this;
	}
	
	/**
	 * Creates a new AlloyAction instance
	 * 
	 * @param output output fluid
	 * @param components input fluids
	 */
	public AlloyAction(FluidStack output, List<FluidStack> components) {
		this.output = output;
		this.components = components;
	}
	
	/**
	 * Creates a new AlloyAction instance
	 * 
	 * @param output output fluid
	 * @param components input fluids
	 */
	public AlloyAction(FluidStack output, FluidStack... components) {
		this(output, Arrays.asList(components));
	}
	
	/**
	 * Default constructor
	 */
	public AlloyAction() {
		this(null, (List)null);
	}
}
