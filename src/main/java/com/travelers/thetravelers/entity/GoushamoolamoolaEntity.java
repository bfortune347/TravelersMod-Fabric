package com.travelers.thetravelers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

/**
 * Goushamoolamoola is the hostile brother in the Gousha family.
 * It's always hostile unless calmed with a donut.
 */
public class GoushamoolamoolaEntity extends AbstractGoushaEntity {
    
    public GoushamoolamoolaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        // We'll implement custom sounds later
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        // We'll implement custom sounds later
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        // We'll implement custom sounds later
        return null;
    }

    @Override
    protected SoundEvent getFartSound() {
        // We'll implement custom sounds later
        return null;
    }

    @Override
    public boolean isNaturallyHostile() {
        // Goushamoolamoola is naturally hostile
        return true;
    }
    
    @Override
    protected void initGoals() {
        // Call the parent's initGoals method to get basic goals
        super.initGoals();
        
        // Add more aggressive tracking behaviors
        // We'll add these in the future as we develop the AI
    }
}
