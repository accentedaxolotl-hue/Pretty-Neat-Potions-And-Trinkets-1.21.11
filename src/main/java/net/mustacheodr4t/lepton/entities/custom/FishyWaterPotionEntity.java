package net.mustacheodr4t.lepton.entities.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.mustacheodr4t.lepton.effects.ModEffects;
import net.mustacheodr4t.lepton.entities.ModEntities;
import net.mustacheodr4t.lepton.entities.base.ThrowableEntityBase;
import net.mustacheodr4t.lepton.items.ModItems;

public class FishyWaterPotionEntity extends ThrowableEntityBase {
    public FishyWaterPotionEntity(Level level, LivingEntity owner) {
        super(ModEntities.fishyWaterPotion.get(), owner, level);
    }

    public FishyWaterPotionEntity(EntityType<? extends FishyWaterPotionEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.splashBottleOfFishyWater.get();
    }

    @Override
    protected void applyEffect(AABB area) {
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
            if (living instanceof Player player) {
                player.addEffect(new MobEffectInstance(
                        ModEffects.fishyEffect.getHolder().get(), 120
                ));
            }
        }
    }

    @Override
    protected int potionColor() {
        return 0x3FA7D6;
    }
}