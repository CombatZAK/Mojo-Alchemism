package com.mods.combatzak.mojo.alchemism;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Alchemism mod class registers mod information with FML
 * 
 * @author CombatZAK
 *
 */
@Mod(modid=Alchemism.MODID, name=Alchemism.MOD_NAME, version=Alchemism.MOD_VERSION, dependencies=Alchemism.DEPENDENCIES)
public class Alchemism {
	
	public static final String MODID = "mojo-alchemism"; //Unique mod id
	public static final String MOD_NAME = "Mojo-Alchemism"; //Mod friendly name
	public static final String MOD_VERSION = "3.0.0"; //Mod version
	public static final String DEPENDENCIES = "required-after:ThermalFoundation"; //mod dependencies
	
	@Instance
	public static Alchemism instance; //Mod singleton instance
	
	@SidedProxy(clientSide="com.mods.combatzak.mojo.alchemism.client.ClientProxy", serverSide="com.mods.combatzak.mojo.alchemism.CommonProxy")
	public static CommonProxy proxy; //proxy handle
	
	/**
	 * Handles the pre-init event
	 * 
	 * @param event args
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	/**
	 * Handles the init event
	 * 
	 * @param event args
	 */
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers(); //proxy stub
	}
	
	/**
	 * Handles the post-init event
	 * 
	 * @param event args
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
