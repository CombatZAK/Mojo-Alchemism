package com.mods.combatzak.mojo.alchemism.updates;

import com.mods.combatzak.mojo.GroupAction;
import com.mods.combatzak.mojo.alchemism.actions.ic2.ReplaceOutputAction;

import cofh.thermalfoundation.item.TFItems;
import ic2.api.recipe.Recipes;

/**
 * Manages updates to the IC2 Thermal Centrifuge
 * 
 * @author comba
 *
 */
public class CentrifugeUpdates {
	/**
	 * Stores updates to the centrifuge
	 */
	private GroupAction centrifugeActions = new GroupAction();
	
	/**
	 * Stores the singleton instance
	 */
	private static CentrifugeUpdates instance = new CentrifugeUpdates();
	
	/**
	 * Gets the singleton instance
	 * 
	 * @return singleton
	 */
	public static CentrifugeUpdates getInstance() {
		return instance;
	}
	
	/**
	 * Applies the updates if not already registered
	 */
	public void register() {
		if (!this.centrifugeActions.getIsApplied())
			this.centrifugeActions.apply();
	}
	
	/**
	 * private constructor initializes singleton
	 */
	private CentrifugeUpdates() {
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustCopper));
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustTin));
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustIron));
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustGold));
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustLead));
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustSilver));
		this.centrifugeActions.add(new ReplaceOutputAction(Recipes.centrifuge, TFItems.dustBronze));
	}
}
