package com.travelers.thetravelers.registry;

import com.travelers.thetravelers.TheTravelersMod;
import com.travelers.thetravelers.entity.GoushamalamalaEntity;
import com.travelers.thetravelers.entity.GoushamoolamoolaEntity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

/**
 * Centralized registry handler for all Travelers mod content
 */
public class ModRegistries {
    // Entity types will be registered during initialization
    // This approach allows for more compatibility with newer Minecraft versions
    public static EntityType<GoushamalamalaEntity> GOUSHAMALAMALA;
    public static EntityType<GoushamoolamoolaEntity> GOUSHAMOOLAMOOLA;
    
    // Items
    public static Item DONUT;
    
    // Blocks
    public static Block DONUT_OVEN;
    
    public static void registerAll() {
        TheTravelersMod.LOGGER.info("Registering mod content for The Travelers");
        registerEntities();
        registerItems();
        registerBlocks();
        registerSounds();
    }
    
    private static void registerEntities() {
        TheTravelersMod.LOGGER.info("Registering entities for The Travelers");
        
        // We'll need to implement proper entity registration in a future update
        // For now, this is a placeholder to establish the structure of our mod
        
        // When we have proper entity registration, we'll add the attributes like this:
        // FabricDefaultAttributeRegistry.register(GOUSHAMALAMALA, AbstractGoushaEntity.createGoushaAttributes());
        // FabricDefaultAttributeRegistry.register(GOUSHAMOOLAMOOLA, AbstractGoushaEntity.createGoushaAttributes());
    }
    
    private static void registerItems() {
        TheTravelersMod.LOGGER.info("Registering items for The Travelers");
        
        // When we have proper item registration, we'll register items like this:
        // DONUT = Registry.register(
        //     Registries.ITEM, 
        //     id("donut"), 
        //     new DonutItem(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build()))
        // );
    }
    
    private static void registerBlocks() {
        TheTravelersMod.LOGGER.info("Registering blocks for The Travelers");
        
        // When we have proper block registration, we'll register blocks like this:
        // DONUT_OVEN = Registry.register(
        //     Registries.BLOCK,
        //     id("donut_oven"),
        //     new DonutOvenBlock(FabricBlockSettings.of(Material.STONE).strength(3.5f).requiresTool())
        // );
    }
    
    private static void registerSounds() {
        // We'll register our sounds (grumbling and farting) here
    }
    
    // Helper method to create identifiers
    public static Identifier id(String path) {
        return Identifier.of(TheTravelersMod.MOD_ID, path);
    }
}
