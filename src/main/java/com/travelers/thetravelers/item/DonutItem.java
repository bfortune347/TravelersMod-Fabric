package com.travelers.thetravelers.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import com.travelers.thetravelers.entity.AbstractGoushaEntity;

/**
 * An item that can be used to calm hostile Gousha entities.
 * Right-clicking on a Gousha with this item will calm it.
 */
public class DonutItem extends Item {
    
    public DonutItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        // Check if the entity is a Gousha
        if (entity instanceof AbstractGoushaEntity gousha) {
            // If the Gousha is hostile, calm it
            if (gousha.isNaturallyHostile() && !gousha.isCalmed()) {
                gousha.calmWithDonut();
                
                // Only consume the item if not in creative mode
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
                
                return ActionResult.SUCCESS;
            }
        }
        
        return ActionResult.PASS;
    }
}
