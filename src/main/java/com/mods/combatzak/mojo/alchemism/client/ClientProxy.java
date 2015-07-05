package com.mods.combatzak.mojo.alchemism.client;

import com.mods.combatzak.mojo.alchemism.CommonProxy;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.DurabilityTooltipHandler;
import com.mods.combatzak.mojo.alchemism.nei.tooltip.FuelTooltipHandler;
import com.mods.combatzak.mojo.alchemism.updates.NeiItemUpdates;
import com.mods.combatzak.mojo.alchemism.updates.RenameUpdates;

import cpw.mods.fml.common.FMLCommonHandler;

/**
 * Client-side proxy for the Alchemism mod
 * 
 * @author CombatZAK
 *
 */
public class ClientProxy extends CommonProxy {
	/**
	 * 
	 */
	public void preInit() {
		FMLCommonHandler.instance().bus().register(new ConnectionEventHandler());
	}
	
	/**
	 * initializer method; currently a stub
	 */
	@Override
	public void registerRenderers() {
		//stub
	}
	
	/**
	 * client actions to take when server is started 
	 */
	@Override
	public void postLoad() {
		super.postLoad();
		
		DurabilityTooltipHandler.getInstance().register();
		FuelTooltipHandler.getInstance().register();
	}
	
	@Override
	public void serverStarted() {
		
	}
}
