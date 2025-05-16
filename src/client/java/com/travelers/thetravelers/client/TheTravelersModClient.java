package com.travelers.thetravelers.client;

import net.fabricmc.api.ClientModInitializer;
import com.travelers.thetravelers.TheTravelersMod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheTravelersModClient implements ClientModInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(TheTravelersMod.MOD_ID);
	
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LOGGER.info("The Travelers Mod Client is initializing!");
		
		// In future commits, we'll register our entity renderers and models here
	}
}
