package com.travelers.thetravelers.entity;

import java.util.Optional;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

/**
 * Base class for all Gousha entities.
 * Provides common functionality and behaviors shared by all Gousha variants.
 */
public abstract class AbstractGoushaEntity extends PathAwareEntity {
    
    // Tracks if this Gousha is currently calmed by a donut
    private boolean isCalmed = false;
    
    // Tracks how long this Gousha has been wandering without finding ingredients
    private int wanderTime = 0;
    
    // Tracks if this Gousha is currently building a shop
    private boolean isBuildingShop = false;
    
    protected AbstractGoushaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    
    public static DefaultAttributeContainer.Builder createGoushaAttributes() {
        // Use the default PathAwareEntity attributes as a base
        // In newer Minecraft versions, entity attributes are handled differently
        return PathAwareEntity.createMobAttributes();
    }
    
    @Override
    protected void initGoals() {
        // Basic goals all Goushas have
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        
        // Specific goals will be added by subclasses
    }
    
    // Abstract methods to be implemented by concrete Gousha subclasses
    
    /**
     * Gets the ambient sound (grumbling) this Gousha makes
     */
    @Override
    protected abstract SoundEvent getAmbientSound();
    
    /**
     * Gets the hurt sound this Gousha makes
     */
    @Override
    protected abstract SoundEvent getHurtSound(DamageSource source);
    
    /**
     * Gets the death sound this Gousha makes
     */
    @Override
    protected abstract SoundEvent getDeathSound();
    
    /**
     * Gets the fart sound this Gousha makes when hitting a player
     */
    protected abstract SoundEvent getFartSound();
    
    /**
     * Whether this Gousha is naturally hostile
     */
    public abstract boolean isNaturallyHostile();
    
    // Donut calming mechanics
    
    /**
     * Calms this Gousha with a donut if it's hostile
     */
    public void calmWithDonut() {
        if (this.isNaturallyHostile() && !this.isCalmed) {
            this.isCalmed = true;
            // We'll add sound and particle effects here in the future
        }
    }
    
    /**
     * Checks if this Gousha is currently calmed by a donut
     */
    public boolean isCalmed() {
        return this.isCalmed;
    }
    
    // Shop building mechanics
    
    /**
     * Gets the time this Gousha has been wandering without finding ingredients
     */
    public int getWanderTime() {
        return this.wanderTime;
    }
    
    /**
     * Sets the wander time for this Gousha
     */
    public void setWanderTime(int time) {
        this.wanderTime = time;
    }
    
    /**
     * Checks if this Gousha is currently building a shop
     */
    public boolean isBuildingShop() {
        return this.isBuildingShop;
    }
    
    /**
     * Sets whether this Gousha is currently building a shop
     */
    public void setBuildingShop(boolean building) {
        this.isBuildingShop = building;
    }
    
    @Override
    public void tick() {
        super.tick();
        
        // Only execute logic on the server side
        if (!this.getWorld().isClient()) {
            // Increment wander time if not building a shop and not calmed
            if (!this.isBuildingShop() && !this.isCalmed()) {
                this.wanderTime++;
                
                // Start building a donut shop after 60 seconds (1200 ticks) of wandering
                if (this.wanderTime >= 1200 && !this.isBuildingShop()) {
                    this.setBuildingShop(true);
                    // We'll implement shop building in the future
                }
            }
        }
    }
    
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("IsCalmed", this.isCalmed);
        nbt.putInt("WanderTime", this.wanderTime);
        nbt.putBoolean("IsBuildingShop", this.isBuildingShop);
    }
    
    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        
        // In Minecraft 1.21.5, NBT methods return Optional types instead of primitives
        if (nbt.contains("IsCalmed")) {
            Optional<Boolean> isCalmedOpt = nbt.getBoolean("IsCalmed");
            if (isCalmedOpt.isPresent()) {
                this.isCalmed = isCalmedOpt.get();
            }
        }
        
        if (nbt.contains("WanderTime")) {
            Optional<Integer> wanderTimeOpt = nbt.getInt("WanderTime");
            if (wanderTimeOpt.isPresent()) {
                this.wanderTime = wanderTimeOpt.get();
            }
        }
        
        if (nbt.contains("IsBuildingShop")) {
            Optional<Boolean> isBuildingShopOpt = nbt.getBoolean("IsBuildingShop");
            if (isBuildingShopOpt.isPresent()) {
                this.isBuildingShop = isBuildingShopOpt.get();
            }
        }
    }
}
