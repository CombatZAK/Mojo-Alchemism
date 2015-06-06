package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.alloy;

import java.util.ArrayList;
import java.util.List;

import tconstruct.library.crafting.AlloyMix;
import tconstruct.library.crafting.Smeltery;
import net.minecraftforge.fluids.FluidStack;

/**
 * Removes mixing recipes for TConstruct smeltery
 * 
 * @author CombatZAK
 *
 */
public class RemoveAlloyAction extends AlloyAction {
	/**
	 * Creates a new RemoveAlloyAction instance
	 * 
	 * @param output output fluid
	 */
	public RemoveAlloyAction(FluidStack output) {
		super(output, (List)null);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveAlloyAction() {
		this(null);
	}
	
	/**
	 * Applies the action, removing any mixing recipe for the output fluid
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (output == null) throw new IllegalStateException("Cannot remove alloys without output fluid"); //null test
		
		List<AlloyMix> registry = Smeltery.getAlloyList(); //get the list of alloys in the smeltery
		List<AlloyMix> matches = new ArrayList<AlloyMix>(); //stores matches to output
		for (AlloyMix recipe : registry) { //go through each mix recipe
			if (isFluidMatch(recipe.result, output)) //check it for a match
				matches.add(recipe);
		}
		
		for (AlloyMix match : matches) { //go through all the matches
			registry.remove(match); //remove each one
		}
		
		this.setIsApplied(true);
		return true;
	}
}
