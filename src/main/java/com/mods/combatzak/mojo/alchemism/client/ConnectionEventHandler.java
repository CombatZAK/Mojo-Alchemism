package com.mods.combatzak.mojo.alchemism.client;

import com.mods.combatzak.mojo.alchemism.updates.NeiItemUpdates;
import com.mods.combatzak.mojo.alchemism.updates.RenameUpdates;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;

/**
 * Handles connection events ont he client side
 * 
 * @author CombatZAK
 *
 */
public class ConnectionEventHandler {
	@SubscribeEvent
	public void clientConnected(ClientConnectedToServerEvent args) {
		RenameUpdates.getInstance().register();
		NeiItemUpdates.getInstance().register();
	}
}
