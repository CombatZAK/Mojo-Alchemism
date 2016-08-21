package com.mods.combatzak.mojo.alchemism.actions.tconstruct.smeltery.melting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tconstruct.library.crafting.Smeltery;
import mantle.utils.ItemMetaWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * Removes a melting recipe from the smeltery
 *  
 * @author CombatZAK
 *
 */
public class RemoveMeltingAction extends MeltingAction {
	/**
	 * Creates a new RemoveMeltingAction instance
	 * 
	 * @param input input filter
	 * @param output output filter
	 */
	public RemoveMeltingAction(ItemStack input, FluidStack output) {
		super(input, output, 0);
	}
	
	/**
	 * Creates a new RemoveMeltingAction instance
	 * 
	 * @param input input filter
	 */
	public RemoveMeltingAction(ItemStack input) {
		this(input, null);
	}
	
	/**
	 * Creates a new RemoveMeltingAction instance
	 * 
	 * @param output output filter
	 */
	public RemoveMeltingAction(FluidStack output) {
		this(null, output);
	}
	
	/**
	 * Default constructor
	 */
	public RemoveMeltingAction() {
		this(null, null);
	}
	
	/**
	 * Applies the action, removing any melting recipes that match the filter
	 */
	@Override
	public boolean apply() throws IllegalStateException {
		if (input == null && output == null) throw new IllegalStateException("Cannot remove melting recipes without filter"); //null test
		
		Map<ItemMetaWrapper, FluidStack> meltList = Smeltery.getSmeltingList(); //get the list of i/o
		Map<ItemMetaWrapper, Integer> temperatureList = Smeltery.getTemperatureList(); //get the list of temperatures
		Map<ItemMetaWrapper, ItemStack> renderList = Smeltery.getRenderIndex(); //get the list of renders
		
		List<ItemMetaWrapper> matchKeys = new ArrayList<ItemMetaWrapper>();
		for (Map.Entry<ItemMetaWrapper, FluidStack> entry : Smeltery.getSmeltingList().entrySet()) { //go through all the IO recipes
			if (isPatternMatch(entry)) //match to the i/o pattern
				matchKeys.add(entry.getKey());
		}
		
		for (ItemMetaWrapper match : matchKeys) { //go through all the matches
			//remove from all three lists
			meltList.remove(match);
			temperatureList.remove(match);
			renderList.remove(match);
		}
		
		setIsApplied(true); //set the applied flag
		return true;
	}
	
	/**
	 * Checks if a particular melting recipe matches the i/o pattern
	 * 
	 * @param recipe melting recipe to check
	 * @return true if the recipe matches the pattern; false otherwise
	 */
	private boolean isPatternMatch(Map.Entry<ItemMetaWrapper, FluidStack> recipe) {
		if (recipe == null) return false;
		
		boolean inputMatches = input == null || isDirectMatch(recipe.getKey(), input);
		boolean outputMatches = output == null || isFluidMatch(recipe.getValue(), output);
		
		return inputMatches && outputMatches;
	}
}
