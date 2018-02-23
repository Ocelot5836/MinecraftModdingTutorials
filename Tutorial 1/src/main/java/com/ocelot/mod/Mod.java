package com.ocelot.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ocelot.mod.registry.Registry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * <em><b>Copyright (c) 2018 The Starcraft Minecraft (SCMC) Mod Team.</b></em>
 * 
 * <br>
 * </br>
 * 
 * The main mod class. Handles very basic things and the start of the registry system.
 * 
 * @author Ocelot5836
 */
@net.minecraftforge.fml.common.Mod(modid = Mod.MOD_ID, name = Mod.NAME, useMetadata = true)
public class Mod {

	/** The id of the mod */
	public static final String MOD_ID = "otutm";
	/** The name of the mod */
	public static final String NAME = "Tutorial Mod";

	/** The instance of this mod */
	@Instance(MOD_ID)
	public static Mod instance;

	/** The logger for this mod */
	private static Logger logger;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		MinecraftForge.EVENT_BUS.register(new Registry());
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
	}

	/**
	 * @return The logger for the mod
	 */
	public static Logger logger() {
		return logger;
	}
}