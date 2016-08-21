package com.mods.combatzak.mojo.alchemism;

import com.mods.combatzak.mojo.alchemism.updates.CastingUpdates;
import com.mods.combatzak.mojo.alchemism.updates.CentrifugeUpdates;
import com.mods.combatzak.mojo.alchemism.updates.CompressorUpdates;
import com.mods.combatzak.mojo.alchemism.updates.CraftingUpdates;
import com.mods.combatzak.mojo.alchemism.updates.FurnaceUpdates;
import com.mods.combatzak.mojo.alchemism.updates.GrinderUpdates;
import com.mods.combatzak.mojo.alchemism.updates.InductionSmelterUpdates;
import com.mods.combatzak.mojo.alchemism.updates.InfernalBlastFurnaceUpdates;
import com.mods.combatzak.mojo.alchemism.updates.IngotCompressorUpdates;
import com.mods.combatzak.mojo.alchemism.updates.LootUpdates;
import com.mods.combatzak.mojo.alchemism.updates.MaceratorUpdates;
import com.mods.combatzak.mojo.alchemism.updates.MeltingUpdates;
import com.mods.combatzak.mojo.alchemism.updates.NeiItemUpdates;
import com.mods.combatzak.mojo.alchemism.updates.PulverizerUpdates;
import com.mods.combatzak.mojo.alchemism.updates.RedstoneFurnaceUpdates;
import com.mods.combatzak.mojo.alchemism.updates.RenameUpdates;
import com.mods.combatzak.mojo.alchemism.updates.TransposerUpdates;

/**
 * Server-side proxy for Alchemism
 * 
 * @author CombatZAK
 *
 */
public class CommonProxy {

	public void preInit() {
		
	}
	
	/**
	 * initializer method, currently a stub
	 */
	public void registerRenderers() {
		//stub
	}

	/**
	 * Actions to take after mods have been loaded
	 */
	public void postLoad() {
		CraftingUpdates.getInstance().register();
		FurnaceUpdates.getInstance().register();
		PulverizerUpdates.getInstance().register();
		MaceratorUpdates.getInstance().register();
		RedstoneFurnaceUpdates.getInstance().register();
		InductionSmelterUpdates.getInstance().register();
		TransposerUpdates.getInstance().register();
		IngotCompressorUpdates.getInstance().register();
		GrinderUpdates.getInstance().register();
		MeltingUpdates.getInstance().register();
		CastingUpdates.getInstance().register();
		LootUpdates.getInstance().register();
		CompressorUpdates.getInstance().register();
		CentrifugeUpdates.getInstance().register();
		InfernalBlastFurnaceUpdates.getInstance().register();
	}

	/**
	 * Actions to take after server is started up
	 */
	public void serverStarted() {
		
	}
}
