package com.mods.combatzak.mojo.alchemism;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Main Mod Class - does the recipe resolutions
 * Created by CombatZAK on 4/19/2018.
 */
@Mod(modid = Alchemism.MODID, useMetadata = true)
public class Alchemism {
    public static final String MODID = "mojo-alchemism";

    public static Logger logger;

    @SidedProxy(serverSide = "com.mods.combatzak.mojo.alchemism.CommonProxy", clientSide = "com.mods.combatzak.mojo.alchemism.client.ClientProxy")
    public static CommonProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerInitActions();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @EventHandler
    public void postLoad(FMLLoadCompleteEvent event) {
        proxy.registerActions();
    }
}
