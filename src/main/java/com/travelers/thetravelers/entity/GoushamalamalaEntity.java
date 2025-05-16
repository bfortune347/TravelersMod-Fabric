package com.travelers.thetravelers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

/**
 * Goushamalamala is the neutral member of the Gousha family.
 * It'll only become hostile if provoked.
 */
public class GoushamalamalaEntity extends AbstractGoushaEntity {
    
    public GoushamalamalaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
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
        // Goushamalamala is neutral by default
        return false;
    }
}
