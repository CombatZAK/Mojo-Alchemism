package com.mods.combatzak.mojo.alchemism;

import com.mods.combatzak.mojo.alchemism.updates.CraftingUpdates;
import com.mods.combatzak.mojo.alchemism.updates.FurnaceUpdates;
import com.mods.combatzak.mojo.alchemism.updates.PulverizerUpdates;
import com.mods.combatzak.mojo.alchemism.updates.RenameUpdates;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;

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
	public static final String DEPENDENCIES = "required-after:ThermalFoundation;required-after:ThermalExpansion;required-after:Forestry;required-after:GalacticraftCore;required-after:IC2;required-after:Thaumcraft;required-after:Botania;required-after:Railcraft;required-after:TConstruct"; //mod dependencies
	
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
	
	/**
	 * Handles load-complete event
	 * 
	 * @param event args
	 */
	@EventHandler
	public void postLoad(FMLLoadCompleteEvent event) {
		CraftingUpdates.getInstance().register();
		FurnaceUpdates.getInstance().register();
		PulverizerUpdates.getInstance().register();
	}
	
	/**
	 * Handles the server started event
	 * @param event args
	 */
	@EventHandler
	public void serverStarted(FMLServerStartedEvent event) {
		RenameUpdates.getInstance().register();
	}
}
