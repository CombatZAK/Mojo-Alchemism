package com.mods.combatzak.mojo.alchemism.updates;

import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import cofh.thermalfoundation.item.TFItems;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer.ReplacePulverizerAction;
import com.mods.combatzak.mojo.alchemism.actions.te4.pulverizer.SubstitutePulverizerAction;

/**
 * Updates pulverizer recipes
 * 
 * @author CombatZAK
 *
 */
public class PulverizerUpdates {
	/**
	 * List of pulverizer actions to update
	 */
	private GroupAction pulverizerActions = new GroupAction();
	
	/**
	 * Singleton instance
	 */
	private static PulverizerUpdates instance = new PulverizerUpdates();
	
	/**
	 * Gets the singleton instance of the class
	 */
	public static PulverizerUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Registers the updates with the game
	 */
	public void register() {
		this.pulverizerActions.apply();
	}
	
	/**
	 * Private constructor initializes the singleton
	 */
	private PulverizerUpdates() {
		//unify ore dictionary outputs
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustCopper, TFItems.dustCopper));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustTin, TFItems.dustTin));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustIron, TFItems.dustIron));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustGold, TFItems.dustGold));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustSilver, TFItems.dustSilver));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustLead, TFItems.dustLead));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustCoal, TFItems.dustCoal));
		this.pulverizerActions.add(new SubstitutePulverizerAction(TFItems.dustCharcoal, TFItems.dustCharcoal));
		
		//replace ore cluster recipes
		this.pulverizerActions.add(new ReplacePulverizerAction(4800, ItemApi.getItem("itemNugget", 16), newStackQuantity(TFItems.dustIron, 3), TFItems.dustIron, 25));
		this.pulverizerActions.add(new ReplacePulverizerAction(4800, ItemApi.getItem("itemNugget", 17), newStackQuantity(TFItems.dustCopper, 3), TFItems.dustCopper, 25));
		this.pulverizerActions.add(new ReplacePulverizerAction(4800, ItemApi.getItem("itemNugget", 18), newStackQuantity(TFItems.dustTin, 3), TFItems.dustTin, 25));
		this.pulverizerActions.add(new ReplacePulverizerAction(4800, ItemApi.getItem("itemNugget", 19), newStackQuantity(TFItems.dustSilver, 3), TFItems.dustSilver, 25));
		this.pulverizerActions.add(new ReplacePulverizerAction(4800, ItemApi.getItem("itemNugget", 20), newStackQuantity(TFItems.dustLead, 3), TFItems.dustLead, 25));
		this.pulverizerActions.add(new ReplacePulverizerAction(4800, ItemApi.getItem("itemNugget", 31), newStackQuantity(TFItems.dustGold, 3), TFItems.dustGold, 25));
	}
	
	/**
	 * Gets a copy of an ItemStack with specified quantity
	 * 
	 * @param target stack to be copied
	 * @param quantity amount in stack
	 * @return copy of item stack (or same reference if argument quantity is equal) with specified quantity (clipped to max stack size)
	 */
	private static ItemStack newStackQuantity(ItemStack target, int quantity) {
		if (target == null || quantity <= 0) return null;
		if (quantity > target.getMaxStackSize()) quantity = target.getMaxStackSize();
		if (quantity == target.getMaxStackSize()) return target;
		
		ItemStack result = target.copy();
		result.stackSize = quantity;
		
		return result;
	}
}
