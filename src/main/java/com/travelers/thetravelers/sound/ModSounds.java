package com.travelers.thetravelers.sound;

import com.travelers.thetravelers.TheTravelersMod;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

/**
 * Registry for all sound events in the mod
 */
public class ModSounds {
    // Gousha ambient sounds (grumbling)
    public static final SoundEvent GOUSHA_GRUMBLE = registerSoundEvent("gousha_grumble");
    
    // Gousha fart sounds
    public static final SoundEvent GOUSHA_FART = registerSoundEvent("gousha_fart");
    
    // Gousha hurt sounds
    public static final SoundEvent GOUSHA_HURT = registerSoundEvent("gousha_hurt");
    
    // Gousha death sounds
    public static final SoundEvent GOUSHA_DEATH = registerSoundEvent("gousha_death");
    
    /**
     * Registers a sound event with the given name
     */
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(TheTravelersMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    
    /**
     * Registers all sound events
     */
    public static void register() {
        TheTravelersMod.LOGGER.info("Registering sounds for " + TheTravelersMod.MOD_ID);
    }
}
