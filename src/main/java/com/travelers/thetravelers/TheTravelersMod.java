package com.travelers.thetravelers;

import com.travelers.thetravelers.registry.ModRegistries;
import com.travelers.thetravelers.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheTravelersMod implements ModInitializer {
	public static final String MOD_ID = "thetravelers";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.

		LOGGER.info("The Travelers Mod is initializing!");
		
		// Register all our mod content
		ModRegistries.registerAll();
		
		// Register sounds
		ModSounds.register();
	}
}
